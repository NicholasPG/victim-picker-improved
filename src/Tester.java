import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {

        //Creating list of victims
        ArrayList<Victim> victims = new ArrayList<Victim>();
        victims.add(new Victim("Michael", 1));
        victims.add(new Victim("Nicholas", 1));
        victims.add(new Victim("Lawton", 1));
        victims.add(new Victim("Payton", 1));
        victims.add(new Victim("Luke", 1));
        victims.add(new Victim("Jace", 1));
        victims.add(new Victim("Tucker", 1));
        victims.add(new Victim("John", 1));
        victims.add(new Victim("Heather", 1));
        victims.add(new Victim("Davis", 1));
        victims.add(new Victim("Henry", 1));
        victims.add(new Victim("Alfred", 1));
        victims.add(new Victim("Sam", 1));


        //creating picker object and loading in victims
        Picker picker = new Picker();
        picker.loadList(victims);


        //Creating Frame for GUI
        JFrame pickerFrame = new JFrame("Victim Picker");
        pickerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pickerFrame.setPreferredSize(new Dimension(1000, 500));
        pickerFrame.setLayout(null);


        //Create and Add victim Picker Panel
        VictimPickerPanel victimPickerPanel = new VictimPickerPanel(picker);
        victimPickerPanel.setBounds(25, 25, 1000, 250);
        pickerFrame.add(victimPickerPanel);


        //Create and Add volunteer Panel
        Volunteer volunteer = new Volunteer(picker, victimPickerPanel);
        volunteer.setBounds(25, 300, 600, 300);
        pickerFrame.add(volunteer);


        //Final formatting of the frame
        pickerFrame.pack();
        pickerFrame.setVisible(true);

    }
}
