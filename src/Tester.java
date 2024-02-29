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

        //creating picker object and loading in victims
        Picker picker = new Picker();
        picker.loadList(victims);

        //Creating Frame for GUI
        JFrame pickerFrame = new JFrame("Victim Picker");
        pickerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pickerFrame.setPreferredSize(new Dimension(1000, 500));

        //Create and Add victim Picker Panel
        VictimPickerPanel victimPickerPanel = new VictimPickerPanel(picker);
        pickerFrame.add(victimPickerPanel);




        pickerFrame.pack();
        pickerFrame.setVisible(true);


        //picking two victims
        picker.chooseTwo();
        //display names of those picked
        for (Victim victim : picker.getPickedToday()) {
            System.out.println(victim.getName());
        }
        picker.score(2);
        picker.resetPickedVictims();

        System.out.println("---------------------------------");

        picker.chooseOne();
        for (Victim victim : picker.getPickedToday()) {
            System.out.println(victim.getName());
        }
        picker.chooseOne();
        for (Victim victim : picker.getPickedToday()) {
            System.out.println(victim.getName());
        }

        picker.score(2);
        picker.resetPickedVictims();

        System.out.println("---------------------------------");

        picker.chooseTwo();
        for (Victim victim : picker.getPickedToday()) {
            System.out.println(victim.getName());
        }

        picker.score(2);
        picker.resetPickedVictims();


        System.out.println("---------------------------------");


        //picking two victims
        picker.chooseTwo();
        //display names of those picked
        for (Victim victim : picker.getPickedToday()) {
            System.out.println(victim.getName());
        }
        picker.score(2);
        picker.resetPickedVictims();

        System.out.println("---------------------------------");

        //picking two victims
        picker.chooseTwo();
        //display names of those picked
        for (Victim victim : picker.getPickedToday()) {
            System.out.println(victim.getName());
        }
        picker.score(2);
        picker.resetPickedVictims();

        System.out.println("---------------------------------");

        System.out.println("Absenses");
        for (Victim victim : picker.getAbsentToday()) {
            System.out.println(victim.getName());
        }

        System.out.println("---------------------------------");

        for (Victim victim : victims) {
            System.out.println(victim.getName() + ": " + victim.getNumberOfPicks() + " on " + victim.getLastPicked());
        }


    }
}
