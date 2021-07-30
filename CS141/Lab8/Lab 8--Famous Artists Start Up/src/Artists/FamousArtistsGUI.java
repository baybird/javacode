package Artists;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class        FamousArtistsGUI.java
 * Description  A class representing the GUI used in a famous artists quiz
 *              application.
 * Project      FamousArtistsGUI Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 141
 * Hourse       8 hours and 45 minutes
 * Date         5/27/2021
 * History Log  4/4/2016, 11/21/2017
 * @author	<i>Niko Culevski</i>
 * @version %1% %2%
 * @see javax.swing.JFrame
 * @see java.awt.Toolkit
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class FamousArtistsGUI extends javax.swing.JFrame {

    //class instance variables
    private final int MAX_QUESTIONS = 10;
    private String fileName = "src/Artists/Artists.txt";
    private String[] artists;	//artists names

    // parallel boolean array tracks displayed artists
    private boolean[] artistsUsed;
    private int[] numbers;
    private int currentIndex;
    private int countCorrect = 0;
    private int numberOfArtists = 0;
    private int count = 0;

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor  FamousArtistsGUI()-default constructor
     * Description  Create an instance of the GUI form, set the default
     *              JButton to be submitJButton, set icon image, center form,
     *              read artists from external file.
     * Date         5/27/2021
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public FamousArtistsGUI() {
        initComponents();
        this.getRootPane().setDefaultButton(submitJButton);
        // set icon
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/Artists_small.png"));
        this.setLocationRelativeTo(null);
        readArtistsFromFile(fileName);
        Arrays.sort(artists);
        fillComboBox(artists);

        displayArtist();
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       readArtistsFromFile
     * Description  Reads artists from a file Artists.txt and fill artistsJComboBox.
     * Date         5/27/2021
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     * @param fileName String
     * @see java.io.File
     * @see java.util.Scanner
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void readArtistsFromFile(String fileName) {
        numberOfArtists = 0;
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                numberOfArtists++;
            }

            fileScanner.close();

            // create parallel arrays
            artists = new String[numberOfArtists];
            artistsUsed = new boolean[numberOfArtists];
            numbers = new int[numberOfArtists];

            // populate arrays
            // and reset fileScanner
            fileScanner = new Scanner(file);
            for (int i = 0; i < numberOfArtists; i++) {
                artists[i] = fileScanner.nextLine();
                artistsUsed[i] = false;
                numbers[i] = i;
            }
            fillComboBox(artists);
        } catch (FileNotFoundException exp) {
            JOptionPane.showMessageDialog(null, fileName + " does not exist",
                    "File Input Error", JOptionPane.WARNING_MESSAGE
            );

            //Bring up JFileChooser to select file in current directory
            JFileChooser chooser = new JFileChooser("src/Artists");
            //Filter only txt files

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Txt Files", "txt");

            chooser.setFileFilter(filter);

            int choice = chooser.showOpenDialog(null);

            if (choice == JFileChooser.APPROVE_OPTION) {

                File chosenFile = chooser.getSelectedFile();

                fileName = "src/Artists/" + chosenFile.getName();
                System.out.println("file = " + fileName);

                readArtistsFromFile(fileName);

            } else {
                //exp.printStackTrace();
                System.exit(0);
            }

        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       fillComboBox
     * Description  Fill artistsJComboBox with sign descriptions
     * Date         5/27/2021
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     * @param artists String[]
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @SuppressWarnings("unchecked")
    private void fillComboBox(String[] artists) {
        artistsJComboBox.removeAllItems();
        for (String sign : artists) {
            artistsJComboBox.addItem(sign);
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       displayArtist
     * Description  Choose a random and unused sign and display it in the
     *              artistJLabel.
     * Date         5/27/2021
     * History Log  7/18/2018
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void displayArtist() {
        currentIndex = getUniqueRandomNumber();
        // create the path for file
        String art = artistsJComboBox.getItemAt(currentIndex).toString();
        String artPath = "src/Images/" + art + ".png";
        // change pictures
        artistJLabel.setIcon(new ImageIcon(artPath));
        artistJLabel.setToolTipText(art);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       getUniqueRandomNumber
     * Description  Return an unused random number by a blind repetition of
     *              random generation and checking for unused artist
     * Date         5/27/2021
     * History Log  7/18/2018
     * @return      random int
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private int getUniqueRandomNumber() {
        Random generator = new Random();
        int randomNumber = 0;
        do {
            randomNumber = generator.nextInt(artists.length);
        } while (artistsUsed[randomNumber]);

        artistsUsed[randomNumber] = true;
        return randomNumber;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        artistJLabel = new javax.swing.JLabel();
        controlJPanel = new javax.swing.JPanel();
        submitJButton = new javax.swing.JButton();
        nextJButton = new javax.swing.JButton();
        playJButton = new javax.swing.JButton();
        selectJPanel = new javax.swing.JPanel();
        selectJLabel = new javax.swing.JLabel();
        artistsJComboBox = new javax.swing.JComboBox();
        resultJLabel = new javax.swing.JLabel();
        quizJLabel = new javax.swing.JLabel();
        artistsJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        exitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Famous Artists Quiz");
        setResizable(false);

        artistJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edouard Manet.png"))); // NOI18N
        artistJLabel.setFocusable(false);

        controlJPanel.setLayout(new java.awt.GridLayout(3, 1, 3, 5));

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitJButton.setMnemonic('S');
        submitJButton.setText("Submit");
        submitJButton.setToolTipText("Click to submit your answer");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(submitJButton);

        nextJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextJButton.setMnemonic('N');
        nextJButton.setText("Next Artist");
        nextJButton.setToolTipText("Click to see next sign");
        nextJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(nextJButton);

        playJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        playJButton.setMnemonic('P');
        playJButton.setText("Play Again");
        playJButton.setToolTipText("Play all over again!");
        playJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(playJButton);

        selectJPanel.setLayout(new java.awt.GridLayout(3, 1, 3, 5));

        selectJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        selectJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectJLabel.setText("Select Artists:");
        selectJLabel.setToolTipText("");
        selectJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectJPanel.add(selectJLabel);

        artistsJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        artistsJComboBox.setToolTipText("Select sign description to match road sign");
        selectJPanel.add(artistsJComboBox);

        resultJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        resultJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        selectJPanel.add(resultJLabel);

        quizJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 24)); // NOI18N
        quizJLabel.setForeground(new java.awt.Color(0, 102, 102));
        quizJLabel.setText("Famous Artist Quiz");

        fileJMenu.setText("File");

        openJMenuItem.setMnemonic('O');
        openJMenuItem.setText("Open");
        openJMenuItem.setToolTipText("Open a new set of signs");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openJMenuItem);

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print Form as GUI");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(fileJSeparator);

        exitJMenuItem.setMnemonic('X');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.setToolTipText("End application");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        artistsJMenuBar.add(fileJMenu);

        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        artistsJMenuBar.add(helpJMenu);

        setJMenuBar(artistsJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(artistJLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quizJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quizJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(artistJLabel))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       submitJButtonActionPerformed
     * Description  Event handler to check if the user's answer is correct. The
     *              correct answer is held in class instance variable
     *              currentIndex.
     * Date         5/27/2021
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        count++;

        if (artistsJComboBox.getSelectedIndex() == currentIndex) {
            countCorrect++;
            resultJLabel.setText("Correct! " + countCorrect + "/" + count);
        } else {
            resultJLabel.setText("Incorrect " + countCorrect + "/" + count);
        }

        if (count == MAX_QUESTIONS) {
            resultJLabel.setText(countCorrect + "/" + MAX_QUESTIONS + " Correct!");
            nextJButton.setEnabled(false);
            submitJButton.setEnabled(false);
            playJButton.setEnabled(true);
            artistsJComboBox.setEnabled(false);
        } else {
            submitJButton.setEnabled(false);
            nextJButton.setEnabled(true);
            playJButton.setEnabled(false);
        }
    }//GEN-LAST:event_submitJButtonActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       nextJButtonActionPerformed
     * Description  Event handler to select next unused sign randomly by
     *              calling the displayArtist() method.
     * Date         5/27/2021
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void nextJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJButtonActionPerformed
        displayArtist();

        // reset GUI components to initial states
        resultJLabel.setText("");
        artistsJComboBox.setSelectedIndex(0);
        submitJButton.setEnabled(true);
        nextJButton.setEnabled(false);
    }//GEN-LAST:event_nextJButtonActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       playJButtonActionPerformed
     * Description  Event handler to start the game all over again.
     * Date         5/27/2021
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void playJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playJButtonActionPerformed
        // Start game all over
        countCorrect = 0;
        count = 0;
        resultJLabel.setText("");
        submitJButton.setEnabled(true);
        nextJButton.setEnabled(false);
        playJButton.setEnabled(false);
        artistsJComboBox.setEnabled(true);
        artistsJComboBox.setSelectedIndex(0);
        for (int i = 0; i < artists.length; i++) {
            artistsUsed[i] = false;
            numbers[0] = 0;
        }
        displayArtist();
    }//GEN-LAST:event_playJButtonActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       openJMenuItemActionPerformed
     * Description  Event handler to chose a separate file of artists.
     * Date         5/27/2021
     * History Log  7/18/2018
     * @param       evt ActionEvent
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void openJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJMenuItemActionPerformed
        JFileChooser fileJFileChooser = new JFileChooser("src/Artists");
        int returnVal = fileJFileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileJFileChooser.getSelectedFile();
            //System.out.println("File = " + file.getName());
            readArtistsFromFile("src/Artists/" + file.getName());
        } else {
            //System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_openJMenuItemActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       aboutJMenuItemActionPerformed()
     * Description  Create an About form and show it.
     * Date         5/3/2020
     * History Log  7/18/2018
     * </pre>
     *
     * @param evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aboutJMenuItemActionPerformed
    {//GEN-HEADEREND:event_aboutJMenuItemActionPerformed
        About aboutWindow = new About(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       exitJMenuItemActionPerformed()
     * Description  Close application.
     * Date         5/3/2020
     * History Log  7/18/2018
     * </pre>
     *
     * @param evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJMenuItemActionPerformed
    {//GEN-HEADEREND:event_exitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitJMenuItemActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       clearJMenuItemActionPerformed()
     * Description  Event handler to reset the form and start the game all over
     *              again.
     * Date         5/3/2020
     * History Log  7/18/2018
     * </pre>
     *
     * @param evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        playJButtonActionPerformed(evt);
    }//GEN-LAST:event_clearJMenuItemActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       printJMenuItemActionPerformed()
     * Description  Event handler to print the form.
     * Date         5/3/2020
     * History Log  7/18/2018
     * </pre>
     *
     * @param evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       main()
     * Description  Displays splash screen and the main RoadSign GUI form.
     * Date         5/27/2021
     * History log
     * @param       args are the command line strings
     * @author      <i>Niko Culevski</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static void main(String args[]) {
        // Show splash screen
        Splash mySplash = new Splash(5000);     // duration = 4 seconds
        mySplash.showSplash();                  // show splash screen
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FamousArtistsGUI flagQuiz = new FamousArtistsGUI();
                flagQuiz.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JLabel artistJLabel;
    private javax.swing.JComboBox artistsJComboBox;
    private javax.swing.JMenuBar artistsJMenuBar;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JButton nextJButton;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JButton playJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JLabel quizJLabel;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JLabel selectJLabel;
    private javax.swing.JPanel selectJPanel;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
