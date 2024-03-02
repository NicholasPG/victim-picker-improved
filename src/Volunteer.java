import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Volunteer extends JPanel implements ActionListener {

    private JTextField volunteer;
    private JButton submit;
    static JLabel sample;

    Volunteer()
    {

    }

    public Volunteer(Picker victimPicker)
    {
        Picker swag = new Picker();
        ArrayList<Victim> victims = swag.getVictims();
        int size = victims.size();
        int sizes = swag.getVictims().size();
        System.out.println(size);
        System.out.println(sizes);
        for (Victim n : victims)
        {
            System.out.println(n);
        }

        volunteer = new JTextField(16);
        submit = new JButton("Submit");
        sample = new JLabel("This does nothing right now");

        Volunteer vol = new Volunteer();

        submit.addActionListener(vol);

        JPanel voluntold = new JPanel();

        voluntold.add(volunteer);
        voluntold.add(submit);
        voluntold.add(sample);

        this.add(voluntold);
    }

    public void actionPerformed(ActionEvent e) {
        /*String s = e.getActionCommand();
            if (Objects.equals(volunteer.getText(), n.toString())) {
                // set the text of the label to the text of the field
                this.setBackground(Color.BLUE);

                // set the text of field to blank
                //volunteer.setText("  ");
            }*/

    }
}
