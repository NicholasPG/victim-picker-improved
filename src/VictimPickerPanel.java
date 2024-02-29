import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VictimPickerPanel extends JPanel {

    private ArrayList<VictimPanel> victims;
    private JLabel pickedVictim;
    private JTextField textField;
    private ImageIcon khaled;

    private Picker victimPicker;

    public VictimPickerPanel(Picker victimPicker) {
        //set up victim picker for logic
        this.victimPicker = victimPicker;

        //Create the Victim to be Displayed as JLabel
        pickedVictim= new JLabel("Victim Will Appear Here");
        this.add(pickedVictim);

        Font font1 = new Font("SansSerif", Font.PLAIN, 50);
        pickedVictim.setFont(font1);



        JButton pickButton = new JButton("PICK A VICTIM");
        JButton absentButton = new JButton("Mark Absent");
        JButton plusPointsButton = new JButton("Add Points");
        JButton removePointsButton = new JButton("Remove Points");


        pickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Victim victim = victimPicker.chooseOne();
                pickedVictim.setText(victim.getName());

                //set buttons to correct visibility
                absentButton.setVisible(true);
                plusPointsButton.setVisible(true);
                removePointsButton.setVisible(true);
                pickButton.setVisible(false);
            }
        });
        absentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //mark the selected victim absent
                victimPicker.markAbsent(victimPicker.getPickedToday().getFirst());
                //clear the selected victim from the screen
                victimPicker.resetPickedVictims();
                pickedVictim.setText("Victim Will Appear Here");

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
                //clear the selected victim from the screen
                victimPicker.resetPickedVictims();
                pickedVictim.setText("Victim Will Appear Here");

                //set buttons to correct visibility
                absentButton.setVisible(false);
                plusPointsButton.setVisible(false);
                removePointsButton.setVisible(false);
                pickButton.setVisible(true);
            }
        });
        removePointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove points from the selected victim
                victimPicker.score(-1);
                //clear the selected victim from the screen
                victimPicker.resetPickedVictims();
                pickedVictim.setText("Victim Will Appear Here");

                //set buttons to correct visibility
                absentButton.setVisible(false);
                plusPointsButton.setVisible(false);
                removePointsButton.setVisible(false);
                pickButton.setVisible(true);
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
