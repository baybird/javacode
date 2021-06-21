package Project3;

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


/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Splash.java
 * Project      At the Movies
 * Description  This class provides the splash screen on starting the application.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         6/9/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Splash extends JWindow {

    // class instance variables
    private final JProgressBar loading = new JProgressBar(); // progress bar
    private int duration = 2500;
    private int progress;
   
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Splash()
     * Description      Default constructor
     * @param time-int
     * @author          <i>Robert Tang</i>
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Splash(int time) {
        duration = time;
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           showSplash()
     * Description      Show the splash screen.
     * @author          <i>Robert Tang</i>
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void showSplash() {
        loading.setStringPainted(true);
        loading.setForeground(Color.BLACK);
        
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.LIGHT_GRAY);

        // Set the window's bounds, centering the window
        int width = 552;
        int height = 246;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon("src/imgs/main_bg.png"));
        JLabel copyrt = new JLabel("Copyright 2021, Robert Tang", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(loading, BorderLayout.SOUTH);
        //content.add(copyrt, BorderLayout.SOUTH);

        Color border = new Color(134, 162, 196);
        content.setBorder(BorderFactory.createLineBorder(border, 5));
        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            increment(25);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        this.dispose();
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           increment()
     * Description      Initiated and started an increment class.
     * @author          <i>Robert Tang</i>
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void increment(int milliseconds) {
        IncrementProgress up = new IncrementProgress(milliseconds);
        up.thread.start();
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           IncrementProgress class.
     * Description      Not sure how document a nasted class.
     * @author          <i>Robert Tang</i>
     * Date 513/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    class IncrementProgress {
        private int incProgress;

        /**
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * <pre>
        * Method           IncrementProgress()
        * Description      set the incremnt progress time.
        * @param time-int
        * @author          <i>Robert Tang</i>
        * Date 513/2021
        * </pre>
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        */
        public IncrementProgress(int time) {
            this.incProgress = time;
        }

        /**
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * <pre>
        * Method           Thread()
        * Description      Not sure how to document this.
        * @param time-int
        * @author          <i>Robert Tang</i>
        * Date 513/2021
        * </pre>
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        */
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
