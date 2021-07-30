package Dice;
import java.awt.*;
import javax.swing.*;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * File         Splash.java
 * Description  A class representing the Splash screen used by the 
 *              SortingGUI application
 * Project      Sorting and Searching
 * Platform     jdk 1.8.0_241, NetBeans IDE 11.3, Windows 10
 * Course       CS 142
 * Hours        1 hours and 45 minutes
 * Date         4/17/2020
 * History Log  5/172012, 7/18/2018, 1/19/2019
 *</pre>
 *
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %4%
 * @see     	java.awt.Color
 * @see     	java.awt.Toolkit
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Splash extends JWindow
{
    // duration is integer value in milliseconds for how long the Splash screen is visible
    private final int duration;
    private JProgressBar loading = null;  //progress bar
    private int progress;
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Splash()-default constructor
     * Description  Sets duration to provided parameter.
     * @param       dur int
     * @author      <i>Niko Culevski</i>
     * Date         4/17/2020
     * History Log  7/18/2018  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public Splash(int dur)
    {
        UIManager.put("ProgressBar.selectionForeground", Color.gray.darker());
        duration = dur;
        loading = new JProgressBar(0, 100);
        loading.setStringPainted(true);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  showSplash()
     * Description  A method to show a title screen in the center of the screen
     *              for the amount of time given in the constructor
     * @author      <i>Niko Culevski</i>
     * Date         4/17/2020
     * History Log  7/18/2018  
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    public void showSplash()
    {

        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.lightGray);

        // Set the window's bounds, centering the window
        int width = 280;
        int height = 280;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon("src/Images/dice.jpg"));
        JLabel copyrt = new JLabel
                ("Copyright Megapolis Inc., 2011, USA Cities Database", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        //content.add(copyrt, BorderLayout.SOUTH);
        content.add(loading, BorderLayout.SOUTH);
        Color border = new Color(50, 20, 20,  55);
        content.setBorder(BorderFactory.createLineBorder(border, 2));

        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try 
        {
            //Increment the progress bar's value to 100 starting from 0
            incProgress(20);
            Thread.sleep(duration);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setVisible(false);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       incProgress()
     * Description  Create inner class ProgressThread object, up, and start the
     *              thread
     * @param       amount int
     * @author      <i>Niko Culevski</i>
     * Date         4/17/2020
     * History Log  7/18/2018
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/     
    public void incProgress(int amount) 
    {
        //Instantiate and start new thread
        ProgressThread up = new ProgressThread(amount);
        up.thread.start();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Class        ProgressThread
     * Description  Nested class that handles the progress bar
     * @author      <i>Niko Culevski</i>
     * Date         4/17/2020
     * History Log  7/18/2018
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    class ProgressThread 
    {
        private int amount;
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        *<pre>
        * Constructor  ProgressThread()
        * Description  Sets amount to provided parameter.
        * @param       amount int
        * @author      <i>Niko Culevski</i>
        * Date         4/3/2020
        * History Log  7/18/2018  
       *</pre>
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
        public ProgressThread(int amount)
        {
            this.amount = amount;
        }

        private Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                {
                    //Increment the progress bar until it's value hits 100
                    while (progress < 100) 
                    {
                        progress++;
                        loading.setString(String.valueOf(progress + "%"));
                        try 
                        {
                            Thread.sleep(30);
                        } 
                        catch (InterruptedException ex) 
                        {

                        }
                        loading.setValue(progress);
                    }
                }
            }
        });
    }

}