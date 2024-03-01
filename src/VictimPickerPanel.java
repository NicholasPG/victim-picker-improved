import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VictimPickerPanel extends JPanel {

    private Victim victim;
    private JLabel pickedVictim;
    private JLabel pickedVictimScore;
    private JTextField textField;
    private ImageIcon khaled;

    private Picker victimPicker;

    public VictimPickerPanel(Picker victimPicker) {

        //set up victim picker for logic
        this.victimPicker = victimPicker;

        //Create the Victim to be Displayed as JLabel
        pickedVictim= new JLabel("Victim Will Appear Here");
        JPanel victimPanel = new JPanel();
        victimPanel.add(pickedVictim);
        this.add(victimPanel);








        pickedVictimScore= new JLabel(" ");
        JPanel scorePanel = new JPanel();
        scorePanel.add(pickedVictimScore);
        this.add(scorePanel);


        JButton pickButton = new JButton("PICK A VICTIM");
        JButton absentButton = new JButton("Mark Absent");
        JButton plusPointsButton = new JButton("Add Points");
        JButton removePointsButton = new JButton("Remove Points");

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


        pickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                victimPicker.resetPickedVictims();

                victim = victimPicker.chooseOne();
                pickedVictim.setText(victim.getName());
                pickedVictimScore.setText("Current score: " + victim.getScore());

                //set buttons to correct visibility
                absentButton.setVisible(true);
                plusPointsButton.setVisible(true);
                removePointsButton.setVisible(true);
                /*pickButton.setVisible(false);*/
            }
        });
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
        plusPointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //add points to the selcted victim
                victimPicker.score(1);
                pickedVictimScore.setText("Current score: " + victim.getScore());
            }
        });
        removePointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove points from the selected victim
                victimPicker.score(-10);
                pickedVictimScore.setText("Current score: " + victim.getScore());
            }
        });

        this.add(pickButton);
        this.add(absentButton);
        this.add(plusPointsButton);
        this.add(removePointsButton);

        plusPointsButton.setVisible(false);
        removePointsButton.setVisible(false);
        absentButton.setVisible(false);

    }


}
