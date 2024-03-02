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
    private Victim kys;

    Volunteer()
    {

    }

    public Volunteer(Picker victimPicker, VictimPickerPanel vpp)
    {
        Picker swag = victimPicker;
        ArrayList<Victim> victims = swag.getVictims();



        volunteer = new JTextField(16);
        submit = new JButton("Submit");
        sample = new JLabel("This does nothing right now");

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
                Boolean barbaque = false;
                String john = volunteer.getText();
                //String s = e.getActionCommand();
                for (Victim n : victims)
                {
                    if (Objects.equals(n.getName(), john))
                    {
                        System.out.println("KILL YOURSELF");
                        kys = n;
                        barbaque = true;
                        break;
                    }
                    System.out.println(n.getName());
                }

                if(barbaque)
                {
                    //Resets Picked Victims for logic purposes
                    victimPicker.resetPickedVictims();
                    vpp.setVictim(kys);
                    victimPicker.PickVolunteerVictim(kys);

                    //Picks a random victim and displays their name on screen
                    vpp.getPickedVictim().setText(kys.getName());
                    vpp.getPickedVictimScore().setText("Current score: " + kys.getScore());

                    //set buttons to correct visibility
                    //vpp.getAbsentButton().setVisible(true);
                    vpp.getPlusPointsButton().setVisible(true);
                    vpp.getRemovePointsButton().setVisible(true);
                }
            }
        });
    }
}



