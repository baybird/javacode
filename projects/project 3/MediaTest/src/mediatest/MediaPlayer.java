/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.media.*;
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;

public class MediaPlayer extends JFrame {

    public MediaPlayer() {
        JFrame f = new JFrame("Video Demo");
        f.setLayout(new BorderLayout());
        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        //file you want to play
        try {
//            String name = "file:///" + new File("output.mp4").getAbsolutePath();
//            URL mediaURL = new URL(name);
            URL mediaURL = new File("./src/mediatest/h263.avi").toURI().toURL();
            Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
            //get components for video and playback controls
            Component video = mediaPlayer.getVisualComponent();
            Component controls = mediaPlayer.getControlPanelComponent();
            f.add(video, BorderLayout.CENTER);
            f.add(controls, BorderLayout.SOUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new MediaPlayer();
    }
}
