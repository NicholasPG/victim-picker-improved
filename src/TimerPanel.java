import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerPanel extends  JPanel{


    int mintues;

    JTextField textField;
    Timer t;


    public TimerPanel (int m) {

        this.mintues = m;





        int FIELD_WIDTH = 7;
        Font font1 = new Font("SansSerif", Font.PLAIN, 20);
        textField = new JTextField(FIELD_WIDTH);
        this.add(textField);
        //textField.setSize(new Dimension(15, 40));
        textField.setEditable(false);




        long startTime = System.currentTimeMillis();
        final long[] elapsedTime = {System.currentTimeMillis() - startTime};
        long fm = m * 60;


        ActionListener listener = new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {

                        elapsedTime[0] = System.currentTimeMillis() - startTime;
                        long elapsedSeconds = elapsedTime[0] / 1000;



                        textField.setText(String.valueOf((fm - elapsedSeconds)));
                        textField.setFont(font1);

                        if((fm - elapsedSeconds) == 0) {
                            t.stop();
                        }







                    }
                };

        final int DELAY = 1000;
        // Milliseconds between timer ticks
        this.t = new Timer(DELAY, listener);
        t.start();




    }






}
