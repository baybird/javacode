package Lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.ImageIcon;

public class Splash extends JWindow {

    // class instance variables
    private JProgressBar loading = new JProgressBar(); // progress bar
    private int duration = 2500;
    private int progress;

    public Splash(int time) {
        duration = time;
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();

        content.setBackground(Color.lightGray);

        // Set the window's bounds, centering the window
        int width = 300;
        int height = 240;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon("src/Lab4/Parrot.jpg"));
        JLabel copyrt = new JLabel("Copyright 2021, Dental Bill", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(loading, BorderLayout.SOUTH);
        //content.add(copyrt, BorderLayout.SOUTH);

        Color border = new Color(50, 20, 20, 55);

        content.setBorder(BorderFactory.createLineBorder(border, 10));
        // Display it

        setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            increment(25);
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.dispose();
    }

    private void increment(int milliseconds) {
        IncementProgress up = new IncementProgress(milliseconds);
        up.thread.start();
    }


    class IncementProgress {

        private int incProgress;

        public IncementProgress(int time) {
            this.incProgress = time;
        }

        private Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                {
                    while (progress < (progress + incProgress)) {
                        progress++;
                        try {
                            Thread.sleep(19);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        loading.setValue(progress);
                    }

                }
            }
        });
    }

}
