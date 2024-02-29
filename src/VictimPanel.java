import javax.swing.*;
import java.awt.*;

public class VictimPanel extends JPanel {

    Picker victimPicker;
    Victim victim;
    VictimPickerPanel panel;

    JLabel label;
    public VictimPanel(Picker victimPicker, Victim victim) {
        this.victimPicker = victimPicker;
        this.victim = victim;
        this.panel = panel;

        label = new JLabel(new ImageIcon("Dancing Khaled.gif"));

    }

    public JLabel getLabel() {
        return label;
    }
}
