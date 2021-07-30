package Project3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.media.*;
import java.net.URL;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 File         MediaPlayerR.java
 Project      At the Movies
 Description  This class provides the media player application that to plays 
              movie trailers.
 Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 Date         6/9/2021
 History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class MediaPlayerR extends JFrame {
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           MediaPlayer()
     * Description      Default constructor
     * @author          <i>Robert Tang</i>
     * Date 6/9/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    MediaPlayerR() {
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           MediaPlayer()
     * Description      Overloadded constructor - it renders a media player to 
     *                  plays user selected movie trailer.
     * @param movieName-string 
     * @author          <i>Robert Tang</i>
     * Date 6/9/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */ 
    MediaPlayerR(String movieName) {
        this.setLayout(new BorderLayout());
        this.setTitle("Movie Trailer - " + movieName);
        this.setSize(352, 288);
        
        // Centers the from at start
        this.setLocationRelativeTo(null);
        
        // Makes the mediaplyer is not resizable.
        this.setResizable(false);
        
        // set this form always on the top to provents multiple instances of MediaPlayerR.
        this.setAlwaysOnTop(true);

        //file you want to play
        try {
            // Play only one video file, if too many video files will make the program too big.
            //URL mediaURL = new File("src/movies/" + movieName + " Trailer.avi").toURI().toURL();
            URL mediaURL = new File("src/movies/Forrest Gump Trailer.avi").toURI().toURL();
            
            Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
            //get components for video and playback controls
            Component video = mediaPlayer.getVisualComponent();
            Component controls = mediaPlayer.getControlPanelComponent();
            this.add(video, BorderLayout.CENTER);
            this.add(controls, BorderLayout.SOUTH);
            mediaPlayer.start();
            
            // close mediaplayer when jframe closes.
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    mediaPlayer.close();
                }
            });
        } catch (IOException | CannotRealizeException | NoPlayerException ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getStackTrace(),
                    "Missing Information", JOptionPane.WARNING_MESSAGE);
        }
    }
}
