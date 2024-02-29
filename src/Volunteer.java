import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Volunteer extends JPanel implements ActionListener {

    static JTextField volunteer;
    static JButton submit;
    static JLabel sample;

    Volunteer()
    {

    }

    public Volunteer(Picker victimPicker)
    {
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
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            sample.setText(volunteer.getText());

            // set the text of field to blank
            volunteer.setText("  ");
        }

    }
}
