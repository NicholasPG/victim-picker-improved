import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VictimPickerPanel extends JPanel {

    private Victim victim;
    private JLabel pickedVictim;
    private JLabel pickedVictimScore;
    private TimerPanel timer;
    private final int TIMER_MINUTES = 3;
    private JButton plusPointsButton;
    private JButton removePointsButton;
    private Picker victimPicker;

    public JLabel getPickedVictim() {
        return pickedVictim;
    }

    public JLabel getPickedVictimScore() {
        return pickedVictimScore;
    }
    public JButton getPlusPointsButton(){
        return plusPointsButton;
    }
    public JButton getRemovePointsButton(){
        return removePointsButton;
    }

    public void setVictim(Victim victim) {
        this.victim = victim;
    }

    public Victim getVictim() {
        return victim;
    }

    public Picker getVictimPicker() {
        return victimPicker;
    }

    public VictimPickerPanel(Picker victimPicker) {

        //set up victim picker for logic
        this.victimPicker = victimPicker;

        //Create the Victim to be Displayed as JLabel and add it to its own panel
        pickedVictim= new JLabel("Victim Will Appear Here");
        JPanel victimPanel = new JPanel();
        victimPanel.add(pickedVictim);
        this.add(victimPanel);

        //Create the Victim's score to be Displayed as JLabel and add it to its own panel
        pickedVictimScore= new JLabel(" ");
        JPanel scorePanel = new JPanel();
        scorePanel.add(pickedVictimScore);
        this.add(scorePanel);

        //Create all the buttons on the GUI
        JButton pickButton = new JButton("PICK A VICTIM");
        JButton absentButton = new JButton("Mark Absent");
        plusPointsButton = new JButton("Add Points");
        removePointsButton = new JButton("Remove Points");
        JButton timerButton = new JButton("Start Timer");

        //Sets fonts of Text
        Font font1 = new Font("SansSerif", Font.PLAIN, 50);
        pickedVictim.setFont(font1);
        Font font2 = new Font("SansSerif", Font.PLAIN, 20);
        pickedVictimScore.setFont(font2);

        //formatting layout of Panel
        this.setLayout(null);
        victimPanel.setBounds(0, 0, 1000, 75);
        scorePanel.setBounds(0, 75, 1000, 50);
        pickButton.setBounds(225,140, 150, 50);
        absentButton.setBounds(375,140, 125, 50);
        plusPointsButton.setBounds(500,140, 100, 50);
        removePointsButton.setBounds(600,140, 150, 50);
        timerButton.setBounds(100,140, 125, 50);


        //Button to pick a new victim
        pickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Resets Picked Victims for logic purposes
                victimPicker.resetPickedVictims();

                //Picks a random victim and displays their name on screen
                victim = victimPicker.chooseOne();
                pickedVictim.setText(victim.getName());
                pickedVictimScore.setText("Current score: " + victim.getScore());

                //set buttons to correct visibility
                absentButton.setVisible(true);
                plusPointsButton.setVisible(true);
                removePointsButton.setVisible(true);
            }
        });

        //Button to mark the victim absent
        absentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //mark the selected victim absent
                victimPicker.markAbsent(victimPicker.getPickedToday().getFirst());

                //clear the selected victim from the screen
                victimPicker.resetPickedVictims();
                pickedVictim.setText("Victim Will Appear Here");
                pickedVictimScore.setText(" ");

                //set buttons to correct visibility
                absentButton.setVisible(false);
                plusPointsButton.setVisible(false);
                removePointsButton.setVisible(false);
                pickButton.setVisible(true);
            }
        });

        //Button to add points to the selected victim's score
        plusPointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add points to the selected victim
                victimPicker.score(1);
                pickedVictimScore.setText("Current score: " + victim.getScore());
            }
        });

        //Button to remove points from the selected victim's score
        removePointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove points from the selected victim
                victimPicker.score(-1);
                pickedVictimScore.setText("Current score: " + victim.getScore());
            }
        });

        //Button to add Timer to the Screen
        timerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddTimerToPanel();
            }
        });

        //Add all the buttons to the Panel (screen)
        this.add(pickButton);
        this.add(absentButton);
        this.add(plusPointsButton);
        this.add(removePointsButton);
        this.add(timerButton);

        //Set initial visibilities for the buttons
        plusPointsButton.setVisible(false);
        removePointsButton.setVisible(false);
        absentButton.setVisible(false);

    }

    //Method to create a new TimerPanel and add it to the panel
    private void AddTimerToPanel() {
        //delete past timer if it exists
        if(timer != null) {
            this.remove(timer);
        }
        //creates new timer and adds it to screen
        timer = new TimerPanel(TIMER_MINUTES);
        this.add(timer);
        timer.setBounds(750,140, 150, 50);
        this.updateUI();
    }

}
