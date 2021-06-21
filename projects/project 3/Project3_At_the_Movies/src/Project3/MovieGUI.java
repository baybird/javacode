package Project3;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         MovieGUI.java
 * Project      At the Movies
 * Description  This class provides the main GUI application.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         6/3/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class MovieGUI extends javax.swing.JFrame {

    // Declare application constants and vars.
    private final DecimalFormat dollarFormat = new DecimalFormat("$#,##0.00");
    private final String FILE_LOCATION = "./src/Project3/Movies.txt";

    // Instance of MovieHelper
    MovieHelper myMovie = new MovieHelper();

    // Instance of MovieInvoice
    MovieInvoice myInvoice = new MovieInvoice();

    // Instance of Transaction
    Transaction myTransactionHistory = new Transaction();

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           MovieGUI()
     * Description      Creates new form of water bill.
     * Date 6/6/2021
     * @throws IOException if thing goes wrong.
     * @author          <i>Robert Tang</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public MovieGUI() throws IOException {
        initComponents();

        // centers the form at start
        this.setLocationRelativeTo(null);

        // make jSpinners read-only 
        ((JSpinner.DefaultEditor) adultTicketsJSpinner.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor) childNSeniorTicketsJSpinner.getEditor()).getTextField().setEditable(false);

        // set default button
        this.getRootPane().setDefaultButton(enterJButton);

        // change background color
        this.getContentPane().setBackground(new Color(230, 180, 1));

        // set date on title bar
        this.setDate();

        // import movie data
        myMovie.importMovieData(FILE_LOCATION);
        updateMovieComboBox();
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setDate()
     * Description      Set current date the title bar.
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void setDate() {
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.setTitle("ANC theaters  - " + dateFormat.format(now));
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           updateMovieComboBox()
     * Description      Update movie data to the movie combobox.
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void updateMovieComboBox() {
        ArrayList<MovieBasic> MovieData = myMovie.getMovieList();

        movieJComboBox.setSelectedIndex(0);
        Integer count = movieJComboBox.getItemCount();
        // remove old items
        for (int i = 1; i < count; i++) {
            movieJComboBox.removeItemAt(1);
        }

        for (MovieBasic nextMovieBasic : MovieData) {
            movieJComboBox.addItem(nextMovieBasic.getMovieName());
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           fillMovieData()
     * Description      Fill in the movie data when user select a movie.
     * @param item - List<String>
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void fillMovieData(String name) {
        ArrayList<MovieBasic> MovieData = myMovie.getMovieList();

        Boolean dataFound = false;
        String searchTerm = name.trim();
        // Fill data for selected movie
        if (!myInvoice.getMovieName().equals(searchTerm)) {
            for (MovieBasic nextMovieBasic : MovieData) {
                if (nextMovieBasic.getMovieName().equals(searchTerm)) {
                    dataFound = true;
                    // Enable input elements
                    movieTimesJComboBox.setEnabled(true);
                    adultTicketsJSpinner.setEnabled(true);
                    childNSeniorTicketsJSpinner.setEnabled(true);

                    try {
                        bgImageJLabel.setIcon(new ImageIcon("src/imgs/" + nextMovieBasic.getMovieName() + ".png"));
                        
                        playTrailerJButton.setEnabled(true);
                    } catch (Exception ex) {
                        Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ratingJTextField.setText(nextMovieBasic.getMovieRating());
                    runtimeJTextField.setText(nextMovieBasic.getMovieRunTime());
                }
            }
        }

        // Clear data if no movie is selected
        if (dataFound != true) {
            // Disable input elements
            playTrailerJButton.setEnabled(false);
            movieTimesJComboBox.setEnabled(false);
            adultTicketsJSpinner.setEnabled(false);
            childNSeniorTicketsJSpinner.setEnabled(false);

            runtimeJTextField.setText("");
            ratingJTextField.setText("");
            try {
                bgImageJLabel.setIcon(new ImageIcon("src/imgs/main_bg.png"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculatePrice()
     * Description      This method calculating movie prices.
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void calculatePrice() throws ParseException {
        myInvoice.setMovieName(movieJComboBox.getSelectedItem().toString().trim());
        myInvoice.setMovieTime(movieTimesJComboBox.getSelectedItem().toString().trim());
        myInvoice.setAdultTickets((Integer) adultTicketsJSpinner.getValue());
        myInvoice.setChildSeniorTickets((Integer) childNSeniorTicketsJSpinner.getValue());
        myInvoice.calculateBill();

        if (myInvoice.getAmountDue() > 0) {
            amountDueJLabel.setText(String.valueOf(dollarFormat.format(myInvoice.getAmountDue())));
        } else {
            amountDueJLabel.setText("$--");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        imgJPanel = new javax.swing.JPanel();
        bgImageJLabel = new javax.swing.JLabel();
        playTrailerJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        customerJPanel = new javax.swing.JPanel();
        movieJComboBox = new javax.swing.JComboBox<>();
        runtimeJTextField = new javax.swing.JTextField();
        runtimeJLabel = new javax.swing.JLabel();
        ratingJLabel = new javax.swing.JLabel();
        ratingJTextField = new javax.swing.JTextField();
        movieTimeJLabel = new javax.swing.JLabel();
        movieTimesJComboBox = new javax.swing.JComboBox<>();
        selectTicketsJPanel = new javax.swing.JPanel();
        adultTicketsJSpinner = new javax.swing.JSpinner();
        adultJLabel = new javax.swing.JLabel();
        childNSeniorTicketsJSpinner = new javax.swing.JSpinner();
        childNSeniorJLabel = new javax.swing.JLabel();
        selectTicketsJPanel1 = new javax.swing.JPanel();
        amountDueJLabel = new javax.swing.JLabel();
        openJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        bottomJPanel = new javax.swing.JPanel();
        controlJPanel = new javax.swing.JPanel();
        resetJButton = new javax.swing.JButton();
        enterJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outJTextArea = new javax.swing.JTextArea();
        historyTextjLabel = new javax.swing.JLabel();
        totalSalesJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        awwdJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        printformJMenuItem = new javax.swing.JMenuItem();
        importJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        resetJMenuItem = new javax.swing.JMenuItem();
        jSeparatorBeforeQuit1 = new javax.swing.JPopupMenu.Separator();
        enterJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        jSeparatorBeforeQuit = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(230, 180, 1));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
        setResizable(false);
        setSize(new java.awt.Dimension(300, 500));

        imgJPanel.setBackground(new java.awt.Color(230, 180, 1));

        bgImageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/main_bg.png"))); // NOI18N

        playTrailerJButton.setMnemonic('P');
        playTrailerJButton.setText("Play Trailer");
        playTrailerJButton.setToolTipText("Click to play the trailer");
        playTrailerJButton.setEnabled(false);
        playTrailerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playTrailerJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imgJPanelLayout = new javax.swing.GroupLayout(imgJPanel);
        imgJPanel.setLayout(imgJPanelLayout);
        imgJPanelLayout.setHorizontalGroup(
            imgJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgJPanelLayout.createSequentialGroup()
                .addGroup(imgJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imgJPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(bgImageJLabel))
                    .addGroup(imgJPanelLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(playTrailerJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imgJPanelLayout.setVerticalGroup(
            imgJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bgImageJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playTrailerJButton))
        );

        jPanel1.setBackground(new java.awt.Color(230, 180, 1));

        customerJPanel.setBackground(new java.awt.Color(230, 180, 1));
        customerJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Movie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        movieJComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        movieJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select A Movie>" }));
        movieJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieJComboBoxActionPerformed(evt);
            }
        });

        runtimeJTextField.setEditable(false);
        runtimeJTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        runtimeJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        runtimeJTextField.setText("116 min");

        runtimeJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        runtimeJLabel.setText("Runtime:");

        ratingJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ratingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ratingJLabel.setText("Rating:");

        ratingJTextField.setEditable(false);
        ratingJTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ratingJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ratingJTextField.setText("PG-13");

        movieTimeJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        movieTimeJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movieTimeJLabel.setText("Movie Times:");

        movieTimesJComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        movieTimesJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time", "08:30 AM", "11:05 AM", "03:00 PM", "04:30 PM", "05:00 PM", "05:30 PM", "07:45 PM", "08:15 PM", "08:45 PM", "10:30 PM", "11:15 PM", "00:00 AM", "01:15 AM" }));
        movieTimesJComboBox.setEnabled(false);
        movieTimesJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieTimesJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerJPanelLayout = new javax.swing.GroupLayout(customerJPanel);
        customerJPanel.setLayout(customerJPanelLayout);
        customerJPanelLayout.setHorizontalGroup(
            customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerJPanelLayout.createSequentialGroup()
                .addComponent(movieJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(runtimeJLabel))
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(runtimeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addComponent(ratingJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(movieTimeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addComponent(ratingJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movieTimesJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        customerJPanelLayout.setVerticalGroup(
            customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runtimeJLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ratingJLabel)
                        .addComponent(movieTimeJLabel)))
                .addGap(1, 1, 1)
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(runtimeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratingJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movieTimesJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        selectTicketsJPanel.setBackground(new java.awt.Color(230, 180, 1));
        selectTicketsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Tickets:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        adultTicketsJSpinner.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        adultTicketsJSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));
        adultTicketsJSpinner.setEnabled(false);
        adultTicketsJSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                adultTicketsJSpinnerStateChanged(evt);
            }
        });

        adultJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        adultJLabel.setText("Adult");

        childNSeniorTicketsJSpinner.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        childNSeniorTicketsJSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));
        childNSeniorTicketsJSpinner.setEnabled(false);
        childNSeniorTicketsJSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                childNSeniorTicketsJSpinnerStateChanged(evt);
            }
        });

        childNSeniorJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        childNSeniorJLabel.setText("Child/Senior");

        javax.swing.GroupLayout selectTicketsJPanelLayout = new javax.swing.GroupLayout(selectTicketsJPanel);
        selectTicketsJPanel.setLayout(selectTicketsJPanelLayout);
        selectTicketsJPanelLayout.setHorizontalGroup(
            selectTicketsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectTicketsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectTicketsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectTicketsJPanelLayout.createSequentialGroup()
                        .addComponent(adultTicketsJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adultJLabel))
                    .addGroup(selectTicketsJPanelLayout.createSequentialGroup()
                        .addComponent(childNSeniorTicketsJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(childNSeniorJLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        selectTicketsJPanelLayout.setVerticalGroup(
            selectTicketsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectTicketsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectTicketsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adultTicketsJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adultJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectTicketsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(childNSeniorTicketsJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(childNSeniorJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        selectTicketsJPanel1.setBackground(new java.awt.Color(230, 180, 1));
        selectTicketsJPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Tickets:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        amountDueJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        amountDueJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amountDueJLabel.setText("$--");
        amountDueJLabel.setToolTipText("");

        javax.swing.GroupLayout selectTicketsJPanel1Layout = new javax.swing.GroupLayout(selectTicketsJPanel1);
        selectTicketsJPanel1.setLayout(selectTicketsJPanel1Layout);
        selectTicketsJPanel1Layout.setHorizontalGroup(
            selectTicketsJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectTicketsJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amountDueJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        selectTicketsJPanel1Layout.setVerticalGroup(
            selectTicketsJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectTicketsJPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(amountDueJLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        openJButton.setBackground(new java.awt.Color(204, 204, 255));
        openJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        openJButton.setMnemonic('O');
        openJButton.setText("Open");
        openJButton.setToolTipText("Open a different file");
        openJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openJButtonActionPerformed(evt);
            }
        });

        clearJButton.setBackground(new java.awt.Color(204, 204, 255));
        clearJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        clearJButton.setMnemonic('C');
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Clear current transaction");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectTicketsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectTicketsJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                        .addGap(20, 20, 20)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(customerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectTicketsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectTicketsJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(openJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );

        bottomJPanel.setBackground(new java.awt.Color(230, 180, 1));

        controlJPanel.setBackground(new java.awt.Color(230, 180, 1));
        controlJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N
        controlJPanel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        resetJButton.setBackground(new java.awt.Color(204, 204, 255));
        resetJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        resetJButton.setForeground(new java.awt.Color(255, 51, 51));
        resetJButton.setMnemonic('R');
        resetJButton.setText("Reset");
        resetJButton.setToolTipText("Reset transaction history");
        resetJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetJButtonActionPerformed(evt);
            }
        });

        enterJButton.setBackground(new java.awt.Color(204, 204, 255));
        enterJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        enterJButton.setMnemonic('E');
        enterJButton.setText("Enter");
        enterJButton.setToolTipText("Log current transaction");
        enterJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterJButtonActionPerformed(evt);
            }
        });

        outJTextArea.setEditable(false);
        outJTextArea.setColumns(20);
        outJTextArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        outJTextArea.setRows(5);
        jScrollPane1.setViewportView(outJTextArea);

        historyTextjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        historyTextjLabel.setText("Transaction History");

        totalSalesJTextField.setEditable(false);
        totalSalesJTextField.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        totalSalesJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalSalesJTextField.setText("$--");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total Sales:");

        javax.swing.GroupLayout controlJPanelLayout = new javax.swing.GroupLayout(controlJPanel);
        controlJPanel.setLayout(controlJPanelLayout);
        controlJPanelLayout.setHorizontalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlJPanelLayout.createSequentialGroup()
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(historyTextjLabel))
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalSalesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        controlJPanelLayout.setVerticalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlJPanelLayout.createSequentialGroup()
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addComponent(historyTextjLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addComponent(totalSalesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout bottomJPanelLayout = new javax.swing.GroupLayout(bottomJPanel);
        bottomJPanel.setLayout(bottomJPanelLayout);
        bottomJPanelLayout.setHorizontalGroup(
            bottomJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomJPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomJPanelLayout.setVerticalGroup(
            bottomJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        printformJMenuItem.setMnemonic('F');
        printformJMenuItem.setText("Print Form");
        printformJMenuItem.setToolTipText("Print form as GUI");
        printformJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printformJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printformJMenuItem);

        importJMenuItem.setMnemonic('I');
        importJMenuItem.setText("Import");
        importJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(importJMenuItem);

        clearJMenuItem.setMnemonic('r');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        resetJMenuItem.setMnemonic('R');
        resetJMenuItem.setText("Reset");
        resetJMenuItem.setToolTipText("Reset form and transaction history");
        resetJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(resetJMenuItem);
        fileJMenu.add(jSeparatorBeforeQuit1);

        enterJMenuItem.setMnemonic('E');
        enterJMenuItem.setText("Enter Transaction");
        enterJMenuItem.setToolTipText("Enter Transaction History");
        enterJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(enterJMenuItem);

        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save Transaction");
        saveJMenuItem.setToolTipText("Save Transaction History");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print Transaction");
        printJMenuItem.setToolTipText("Print Transaction History");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(jSeparatorBeforeQuit);

        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        awwdJMenuBar.add(fileJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        awwdJMenuBar.add(helpJMenu);

        setJMenuBar(awwdJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bottomJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imgJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           clearJMenuItemActionPerformed()
     * Description      Button action to clear user input.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        clearJButtonActionPerformed(evt);
    }//GEN-LAST:event_clearJMenuItemActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           printJMenuItemActionPerformed()
     * Description      Button action to print form.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void printformJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printformJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printformJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           quitJMenuItemActionPerformed()
     * Description      Menu action to exit the program.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           aboutJMenuItemActionPerformed()
     * Description      Menu action to show the about form.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        About instanceAbout = new About(this, true);
        instanceAbout.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           saveJMenuItemActionPerformed()
     * Description      Menu action to save the transaction history.
     * @author          <i>Robert Tang</i>
     * @param evt Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        if (outJTextArea.getText().trim().isEmpty()) {
            // display error message
            JOptionPane.showMessageDialog(null,
                    "There is no transaction to save.",
                    "Missing Information", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)", "txt"));
                fileChooser.setSelectedFile(new File("transaction.txt")); // Save to an external file  
                fileChooser.setDialogTitle("Specify a file to save");

                int userSelection = fileChooser.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(fileToSave.getAbsolutePath())));
                    bwr.write(outJTextArea.getText());
                    bwr.flush();
                    bwr.close();

                    // display confirmation
                    JOptionPane.showMessageDialog(null,
                            "Transaction has saved to file.",
                            "Transaction saved", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (HeadlessException | IOException ex) {
                // display error message
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           printJMenuItemActionPerformed()
     * Description      Menu action to print transaction history.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        if (outJTextArea.getText().trim().length() > 0) {
            try {
                outJTextArea.print();
            } catch (PrinterException ex) {
                Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "You have nothing to print now, please make a transaction first.",
                    "Missing Information", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_printJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           resetJButtonActionPerformed()
     * Description      Reset and clear everything.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void resetJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetJButtonActionPerformed
        try {
            if(outJTextArea.getText().trim().length() > 0){
                // prompt user to save the transaction history
                int reslut = JOptionPane.showConfirmDialog(null,
                        "Do you want to save the transaction history before reset it.",
                        "Save and Reset", JOptionPane.YES_NO_OPTION);
                // save transaction history
                if (reslut == 0) {
                    saveJMenuItemActionPerformed(evt);
                }
            }
            
            // reset form
            totalSalesJTextField.setText("$--");
            clearJButtonActionPerformed(evt);
            outJTextArea.setText("");
            myTransactionHistory.reset();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_resetJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           enterJButtonActionPerformed()
     * Description      This method log a transaction in to the history list.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void enterJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterJButtonActionPerformed
        String movieName = movieJComboBox.getSelectedItem().toString().trim();
        String movieTime = movieTimesJComboBox.getSelectedItem().toString().trim();
        int adultTickets = (Integer) adultTicketsJSpinner.getValue();
        int childNSeniorTickets = (Integer) childNSeniorTicketsJSpinner.getValue();

        if (myInvoice.getMoviePlacehold().equals(movieName)) {
            // display error message
            JOptionPane.showMessageDialog(null,
                    "Please select a movie.",
                    "Missing Information", JOptionPane.WARNING_MESSAGE);
            movieJComboBox.requestFocus();
        } else if (myInvoice.getTimePlacehold().equals(movieTime)) {
            // display error message
            JOptionPane.showMessageDialog(null,
                    "Please select a movie time.",
                    "Missing Information", JOptionPane.WARNING_MESSAGE);
            movieTimesJComboBox.requestFocus();
        } else if (adultTickets < 1 && childNSeniorTickets < 1) {
            JOptionPane.showMessageDialog(null,
                    "You have not entered the number of any movie tickets",
                    "Missing Information", JOptionPane.WARNING_MESSAGE);
            adultTicketsJSpinner.requestFocus();
        } else {
            try {
                calculatePrice();
                myTransactionHistory.add(movieName, movieTime, adultTickets,
                        childNSeniorTickets, myInvoice.getAmount(), myInvoice.getTax(),
                        myInvoice.getAmountDue());
            } catch (ParseException ex) {
                Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            totalSalesJTextField.setText(String.valueOf(dollarFormat.format(myTransactionHistory.getTotalSales())));
            outJTextArea.setText(myTransactionHistory.dispaly().toString());
            clearJButtonActionPerformed(evt);
            myInvoice.clear();

            JOptionPane.showMessageDialog(null,
                    "Transaction has been logged.",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_enterJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           movieJComboBoxActionPerformed()
     * Description      When the movie combobox is changed then it would
     *                  fill the rest data (rating, movie runtime)
     *                  automatically.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void movieJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieJComboBoxActionPerformed
        fillMovieData(movieJComboBox.getSelectedItem().toString());

        // set movie time and tickets to defalut value
        movieTimesJComboBox.setSelectedIndex(0);
        adultTicketsJSpinner.setValue(0);
        childNSeniorTicketsJSpinner.setValue(0);
        try {
            calculatePrice();
        } catch (ParseException ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_movieJComboBoxActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           importJMenuItemActionPerformed()
     * Description      Input menu action that allow to input new movie list from
     *                  an external file.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void importJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importJMenuItemActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)", "txt"));
            fileChooser.setCurrentDirectory(new File("./src/Project3/"));
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                final File selectedFile = fileChooser.getSelectedFile();
                
                // import from new file.
                myMovie.importMovieData(selectedFile.toString());
                updateMovieComboBox();

                // display confirmation message
                JOptionPane.showMessageDialog(null,
                        "Movine data has been imported",
                        "Inforamtion Message", JOptionPane.INFORMATION_MESSAGE);
                movieJComboBox.requestFocus();
            }
        } catch (HeadlessException ex) {
            System.out.print(ex.getMessage());
        }
    }//GEN-LAST:event_importJMenuItemActionPerformed
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           importJMenuItemActionPerformed()
     * Description      Input menu action that allow to input new movie list from
     *                  an external file.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void adultTicketsJSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_adultTicketsJSpinnerStateChanged
        try {
            calculatePrice();
        } catch (ParseException ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adultTicketsJSpinnerStateChanged
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           importJMenuItemActionPerformed()
     * Description      Input menu action that allow to input new movie list from
     *                  an external file.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void childNSeniorTicketsJSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_childNSeniorTicketsJSpinnerStateChanged
        try {
            calculatePrice();
        } catch (ParseException ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_childNSeniorTicketsJSpinnerStateChanged
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           movieTimesJComboBoxActionPerformed()
     * Description      When the movie time combobox is changed this method would
     *                  check wether the movie time is valid and calculate the price.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void movieTimesJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieTimesJComboBoxActionPerformed
        try {
            if (!myInvoice.getTimePlacehold().equals(movieTimesJComboBox.getSelectedItem().toString())) {
                SimpleDateFormat sdf = myInvoice.getMySimpleDateFormat();
                String now = sdf.format(new Date());
                Date selectedMovieTime = sdf.parse(movieTimesJComboBox.getSelectedItem().toString());
                
                // The user cannot select a movie time that has already started
                if (selectedMovieTime.before(sdf.parse(now)) && !selectedMovieTime.before(sdf.parse("06:00 AM")) ) {
                    movieTimesJComboBox.setSelectedIndex(0);

                    JOptionPane.showMessageDialog(null,
                            "You cannot select a time time that has already started.",
                            "Wrong Movie Time", JOptionPane.WARNING_MESSAGE);
                } else {
                    calculatePrice();
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_movieTimesJComboBoxActionPerformed
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           openJButtonActionPerformed()
     * Description      Allow user to input new movie list from
     *                  an external file.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void openJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openJButtonActionPerformed
        importJMenuItemActionPerformed(evt);
    }//GEN-LAST:event_openJButtonActionPerformed
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           clearJButtonActionPerformed()
     * Description      Clear button to clear user input.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        movieJComboBox.setSelectedIndex(0);
        movieTimesJComboBox.setSelectedIndex(0);
        adultTicketsJSpinner.setValue(0);
        childNSeniorTicketsJSpinner.setValue(0);
        amountDueJLabel.setText("$--");
    }//GEN-LAST:event_clearJButtonActionPerformed
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           resetJMenuItemActionPerformed()
     * Description      This method would clear and reset everything.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void resetJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetJMenuItemActionPerformed
        resetJButtonActionPerformed(evt);
    }//GEN-LAST:event_resetJMenuItemActionPerformed
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           enterJMenuItemActionPerformed()
     * Description      Action to logs a transaction.
     * @author          <i>Robert Tang</i>
     * @param evt 
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void enterJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterJMenuItemActionPerformed
        enterJButtonActionPerformed(evt);
    }//GEN-LAST:event_enterJMenuItemActionPerformed

    private void playTrailerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playTrailerJButtonActionPerformed
        String movieName = movieJComboBox.getSelectedItem().toString().trim();      
        MediaPlayerR inMediaPlayer = new MediaPlayerR(movieName);        
        inMediaPlayer.setVisible(true);        
    }//GEN-LAST:event_playTrailerJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           main()
     * Description      main GUI method of Alderwood Water and Waterwater District.
     * @author          <i>Robert Tang</i>
     * @param args the command line arguments Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        Splash instanceOfSplash = new Splash(1000);
        instanceOfSplash.showSplash();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MovieGUI().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JLabel adultJLabel;
    private javax.swing.JSpinner adultTicketsJSpinner;
    private javax.swing.JLabel amountDueJLabel;
    private javax.swing.JMenuBar awwdJMenuBar;
    private javax.swing.JLabel bgImageJLabel;
    private javax.swing.JPanel bottomJPanel;
    private javax.swing.JLabel childNSeniorJLabel;
    private javax.swing.JSpinner childNSeniorTicketsJSpinner;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JPanel customerJPanel;
    private javax.swing.JButton enterJButton;
    private javax.swing.JMenuItem enterJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel historyTextjLabel;
    private javax.swing.JPanel imgJPanel;
    private javax.swing.JMenuItem importJMenuItem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparatorBeforeQuit;
    private javax.swing.JPopupMenu.Separator jSeparatorBeforeQuit1;
    private javax.swing.JComboBox<String> movieJComboBox;
    private javax.swing.JLabel movieTimeJLabel;
    private javax.swing.JComboBox<String> movieTimesJComboBox;
    private javax.swing.JButton openJButton;
    private javax.swing.JTextArea outJTextArea;
    private javax.swing.JButton playTrailerJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem printformJMenuItem;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JLabel ratingJLabel;
    private javax.swing.JTextField ratingJTextField;
    private javax.swing.JButton resetJButton;
    private javax.swing.JMenuItem resetJMenuItem;
    private javax.swing.JLabel runtimeJLabel;
    private javax.swing.JTextField runtimeJTextField;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JPanel selectTicketsJPanel;
    private javax.swing.JPanel selectTicketsJPanel1;
    private javax.swing.JTextField totalSalesJTextField;
    // End of variables declaration//GEN-END:variables
}
