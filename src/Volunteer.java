import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Volunteer extends JPanel
{

    private JTextField volunteer;
    private JButton submit;
    static JLabel sample;
    //private ArrayList<Victim> victims;
    private Victim vitm;

    Volunteer()
    {

    }

    public Volunteer(Picker victimPicker, VictimPickerPanel vpp)
    {
        Picker swag = victimPicker;
        ArrayList<Victim> victims = swag.getVictims();



        volunteer = new JTextField(16);
        submit = new JButton("Submit");
        sample = new JLabel("Enter name of volunteer");

        Volunteer vol = new Volunteer();

        //submit.addActionListener(vol);

        JPanel voluntold = new JPanel();

        voluntold.add(volunteer);
        voluntold.add(submit);
        voluntold.add(sample);

        this.add(voluntold);

        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Boolean present = false;
                String john = volunteer.getText();
                //String s = e.getActionCommand();
                for (Victim n : victims)
                {
                    if (Objects.equals(n.getName(), john))
                    {
                        vitm = n;
                        present = true;
                        break;
                    }
                }

                if(present)
                {
                    //Resets Picked Victims for logic purposes
                    victimPicker.resetPickedVictims();
                    vpp.setVictim(vitm);
                    victimPicker.PickVolunteerVictim(vitm);

                    //Picks a random victim and displays their name on screen
                    vpp.getPickedVictim().setText(vitm.getName());
                    vpp.getPickedVictimScore().setText("Current score: " + vitm.getScore());

                    //set buttons to correct visibility
                    //vpp.getAbsentButton().setVisible(true);
                    sample.setText("Enter name of volunteer");
                    vpp.getPlusPointsButton().setVisible(true);
                    vpp.getRemovePointsButton().setVisible(true);
                }
                else
                {
                    sample.setText("Invalid Person");
                }
            }
        });
    }
}



