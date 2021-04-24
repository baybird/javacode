package FutureAnnuity;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         AnnuityCalculatorGUI.java
 * Project      Future Annuity
 * Description  This class provides the main GUI form for computing the future
 *              annuity with user entered numbers.
 *
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         4/23/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * @see javax.swing.JDialog
 * @see java.awt.Toolkit
 * @see java.awt.Color
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class AnnuityCalculatorGUI extends javax.swing.JFrame {

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           AnnuityCalculatorGUI()
     * Description      Creates new form AnnuityCalculatorGUI
     * @author          <i>Robert Tang</i>
     * Date 4/23/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public AnnuityCalculatorGUI() {
        initComponents();// build the from

        // centers the form at start
        this.setLocationRelativeTo(null);

        // set course on periodicPaymentJFormattedTextField
        this.periodicPaymentJFormattedTextField.requestFocus();

        // make jSpinners read-only 
        ((JSpinner.DefaultEditor) interestJSpinner.getEditor()).getTextField().setEditable(false);

        // set default button on calculate
        this.getRootPane().setDefaultButton(calculateJButton);

        // set date on title bar
        this.setDate();
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setDate()
     * Description      Set current date the title bar.
     * @author          <i>Robert Tang</i>
     * Date 4/23/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void setDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        this.setTitle("Future Annuity " + dateFormat.format(now));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputJPanel = new javax.swing.JPanel();
        imageJLabel = new javax.swing.JLabel();
        periodicPaymentJLabel = new javax.swing.JLabel();
        periodicPaymentJFormattedTextField = new javax.swing.JFormattedTextField();
        interestJLabel = new javax.swing.JLabel();
        interestJSpinner = new javax.swing.JSpinner();
        compoundsPerYearJLabel = new javax.swing.JLabel();
        compoundsPerYearJFormattedTextField = new javax.swing.JFormattedTextField();
        yearsJLabel = new javax.swing.JLabel();
        yearsJFormattedTextField = new javax.swing.JFormattedTextField();
        outputJPanel = new javax.swing.JPanel();
        futureAnnuityBalanceJLabel = new javax.swing.JLabel();
        futureAnnuityBalanceJTextField = new javax.swing.JTextField();
        totalOfPaymentJLabel = new javax.swing.JLabel();
        totalOfPaymentJTextField = new javax.swing.JTextField();
        totalOfInterestEarnedJLabel = new javax.swing.JLabel();
        totalOfInterestEarnedJTextField = new javax.swing.JTextField();
        calculateJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        importJButton = new javax.swing.JButton();
        annuityJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        quitJMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Future Annuity");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/FutureAnnuity/icon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 520));

        inputJPanel.setBackground(new java.awt.Color(153, 153, 255));

        imageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FutureAnnuity/icon.png"))); // NOI18N

        periodicPaymentJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        periodicPaymentJLabel.setText("Periodic Payment:");

        periodicPaymentJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        periodicPaymentJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        periodicPaymentJFormattedTextField.setToolTipText("Payment must greater than 0.");
        periodicPaymentJFormattedTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        interestJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        interestJLabel.setText("Interest (as a %):");

        interestJSpinner.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        interestJSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.5f)));
        interestJSpinner.setToolTipText("Interest rate");
        interestJSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(interestJSpinner, ""));

        compoundsPerYearJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        compoundsPerYearJLabel.setText("Compounds Per Year:");

        compoundsPerYearJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        compoundsPerYearJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        compoundsPerYearJFormattedTextField.setToolTipText("Number of compoundings");
        compoundsPerYearJFormattedTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        yearsJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        yearsJLabel.setText("Years:");

        yearsJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        yearsJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        yearsJFormattedTextField.setToolTipText("Years");
        yearsJFormattedTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        javax.swing.GroupLayout inputJPanelLayout = new javax.swing.GroupLayout(inputJPanel);
        inputJPanel.setLayout(inputJPanelLayout);
        inputJPanelLayout.setHorizontalGroup(
            inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputJPanelLayout.createSequentialGroup()
                .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(inputJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearsJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(compoundsPerYearJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(yearsJFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(compoundsPerYearJFormattedTextField)))
                    .addGroup(inputJPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(interestJLabel)
                            .addComponent(periodicPaymentJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(periodicPaymentJFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(interestJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        inputJPanelLayout.setVerticalGroup(
            inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputJPanelLayout.createSequentialGroup()
                .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputJPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(periodicPaymentJLabel)
                            .addComponent(periodicPaymentJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(interestJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(interestJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compoundsPerYearJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compoundsPerYearJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearsJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearsJLabel)))
                    .addGroup(inputJPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(imageJLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        futureAnnuityBalanceJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        futureAnnuityBalanceJLabel.setText("Future Annuity Balance:");

        futureAnnuityBalanceJTextField.setEditable(false);
        futureAnnuityBalanceJTextField.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        futureAnnuityBalanceJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        futureAnnuityBalanceJTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        totalOfPaymentJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        totalOfPaymentJLabel.setText("Total of Payment:");

        totalOfPaymentJTextField.setEditable(false);
        totalOfPaymentJTextField.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        totalOfPaymentJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalOfPaymentJTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        totalOfInterestEarnedJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        totalOfInterestEarnedJLabel.setText("Total of Interest Earned:");

        totalOfInterestEarnedJTextField.setEditable(false);
        totalOfInterestEarnedJTextField.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        totalOfInterestEarnedJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalOfInterestEarnedJTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        calculateJButton.setBackground(new java.awt.Color(102, 153, 255));
        calculateJButton.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        calculateJButton.setMnemonic('C');
        calculateJButton.setText("Calculate");
        calculateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateJButtonActionPerformed(evt);
            }
        });

        clearJButton.setBackground(new java.awt.Color(255, 255, 255));
        clearJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        clearJButton.setMnemonic('r');
        clearJButton.setText("Clear");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });

        printJButton.setBackground(new java.awt.Color(255, 255, 255));
        printJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        printJButton.setMnemonic('P');
        printJButton.setText("Print form");
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });

        quitJButton.setBackground(new java.awt.Color(255, 255, 255));
        quitJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        importJButton.setBackground(new java.awt.Color(255, 255, 255));
        importJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        importJButton.setMnemonic('I');
        importJButton.setText("Import");
        importJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout outputJPanelLayout = new javax.swing.GroupLayout(outputJPanel);
        outputJPanel.setLayout(outputJPanelLayout);
        outputJPanelLayout.setHorizontalGroup(
            outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputJPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outputJPanelLayout.createSequentialGroup()
                        .addComponent(importJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(calculateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(outputJPanelLayout.createSequentialGroup()
                            .addComponent(totalOfPaymentJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(totalOfPaymentJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(outputJPanelLayout.createSequentialGroup()
                            .addComponent(futureAnnuityBalanceJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(futureAnnuityBalanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(outputJPanelLayout.createSequentialGroup()
                            .addComponent(totalOfInterestEarnedJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(totalOfInterestEarnedJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        outputJPanelLayout.setVerticalGroup(
            outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputJPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(futureAnnuityBalanceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(futureAnnuityBalanceJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalOfPaymentJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalOfPaymentJLabel))
                .addGap(18, 18, 18)
                .addGroup(outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalOfInterestEarnedJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalOfInterestEarnedJLabel))
                .addGap(18, 18, 18)
                .addComponent(calculateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        clearJMenuItem.setMnemonic('r');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print Form");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        annuityJMenuBar.add(fileJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        quitJMenuItem1.setMnemonic('A');
        quitJMenuItem1.setText("About");
        quitJMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItem1ActionPerformed(evt);
            }
        });
        helpJMenu.add(quitJMenuItem1);

        annuityJMenuBar.add(helpJMenu);

        setJMenuBar(annuityJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outputJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(inputJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method        quitJButtonActionPerformed()
     * Description   End the application
     * @param        java.awt.event.ActionEvent evt
     * @see java.awt.event.ActionEvent
     * @author       <i>Robert Tang</i>
     * Date 4/17/2021 History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method        calculateJButtonActionPerformed()
     * Description   Calculate future annuity balance, total of payment, and
     *               total of interest earned.
     * @param        java.awt.event.ActionEvent evt
     * @see java.awt.event.ActionEvent
     * @author       <i>Robert Tang</i>
     * Date 4/17/2021 History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void calculateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateJButtonActionPerformed

        // initinated vars for user entered data
        double periodicPayment = 0.0;
        double interest = 0.0;
        int compoundsPerYear = 0;
        int years = 0;

        try {
            // Getting user entered data
            interest = Double.parseDouble(interestJSpinner.getValue().toString()) / 100.0;
            String periodicPaymentString = periodicPaymentJFormattedTextField.getText();
            String compoundsPerYearString = compoundsPerYearJFormattedTextField.getText();
            String yearsString = yearsJFormattedTextField.getText();

            // Validate user input and error handling
            Validation instanceValidation = new Validation(periodicPaymentString, compoundsPerYearString, yearsString);
            if (instanceValidation.isGood() != true) {
                throw new NumberFormatException(instanceValidation.getErrorMsg());
            }

            periodicPayment = Double.parseDouble(periodicPaymentString);
            compoundsPerYear = Integer.parseInt(compoundsPerYearString);
            years = Integer.parseInt(yearsString);

            // Instanitiated an instance of Annuity object.
            Annuity instanceAnnuity = new Annuity(periodicPayment, interest, compoundsPerYear, years);

            // formatted output
            DecimalFormat dollars = new DecimalFormat("$#,##0.00");

            // Calculate future annuity 
            double resultOfFutureAnnuity = instanceAnnuity.calculateFutureAnnuity();
            futureAnnuityBalanceJTextField.setText(String.valueOf(dollars.format(resultOfFutureAnnuity)));

            // Calculate total payment
            double resultOfTotalPayment = instanceAnnuity.calculateTotalPayment();
            totalOfPaymentJTextField.setText(String.valueOf(dollars.format(resultOfTotalPayment)));

            // Calculate total interst
            double resultOfTotalInterest = instanceAnnuity.calculateInterest();
            totalOfInterestEarnedJTextField.setText(String.valueOf(dollars.format(resultOfTotalInterest)));

        } catch (NumberFormatException numException) {// Error handling
            if ("PERIODIC_PAYMENT_IS_WRONG".equals(numException.getMessage())) {
                JOptionPane.showMessageDialog(this, "Periodic payment must greater than 0.");
                periodicPaymentJFormattedTextField.requestFocus();
            } else if ("COMPOUNDINGS_IS_WRONG".equals(numException.getMessage())) {
                JOptionPane.showMessageDialog(this, "Compunds per year must greater than 0.");
                compoundsPerYearJFormattedTextField.requestFocus();
            } else if ("YEARS_IS_WRONG".equals(numException.getMessage())) {
                JOptionPane.showMessageDialog(this, "Years must greater than 0.");
                yearsJFormattedTextField.requestFocus();
            }
        }


    }//GEN-LAST:event_calculateJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method        clearJMenuItemActionPerformed()
     * Description   Clear menu.
     * @param        java.awt.event.ActionEvent evt
     * @see java.awt.event.ActionEvent
     * @author       <i>Robert Tang</i>
     * Date 4/23/2021 History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        clearJButton.doClick();
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method        printJMenuItemActionPerformed()
     * Description   Print menu.
     * @param        java.awt.event.ActionEvent evt
     * @see java.awt.event.ActionEvent
     * @author       <i>Robert Tang</i>
     * Date 4/23/2021 History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        printJButton.doClick();
    }//GEN-LAST:event_printJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method        quitJMenuItemActionPerformed()
     * Description   Quit menu.
     * @param        java.awt.event.ActionEvent evt
     * @see java.awt.event.ActionEvent
     * @author       <i>Robert Tang</i>
     * Date 4/23/2021 History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        quitJButton.doClick();
    }//GEN-LAST:event_quitJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method        quitJMenuItem1ActionPerformed()
     * Description   Quit menu.
     * @param        java.awt.event.ActionEvent evt
     * @see java.awt.event.ActionEvent
     * @author       <i>Robert Tang</i>
     * Date 4/23/2021 History Log
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void quitJMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItem1ActionPerformed
        About instanceAbout = new About(this, true);
        instanceAbout.setVisible(true);
    }//GEN-LAST:event_quitJMenuItem1ActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        periodicPaymentJFormattedTextField.setText("");
        interestJSpinner.setValue(0);
        compoundsPerYearJFormattedTextField.setText("");
        yearsJFormattedTextField.setText("");
        futureAnnuityBalanceJTextField.setText("");
        totalOfPaymentJTextField.setText("");
        totalOfInterestEarnedJTextField.setText("");
        
        // set focust to payment text field.
        periodicPaymentJFormattedTextField.requestFocus();
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJButtonActionPerformed

    private void importJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importJButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)", "txt"));
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedReader bufferedReder = new BufferedReader(new FileReader(selectedFile));
                String line;
                
                // Just a simple code to import data from a user selected text file.
                Integer index = 0;
                while((line = bufferedReder.readLine())!= null){
                    index += 1;
                    if(index == 1){
                        periodicPaymentJFormattedTextField.setText(line.toString());
                    }
                    else if(index == 2){
                        interestJSpinner.setValue(Integer.parseInt(line));
                    }
                    else if(index == 3){
                        compoundsPerYearJFormattedTextField.setText(line);
                    }
                    else if(index == 4){
                        yearsJFormattedTextField.setText(line);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_importJButtonActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(AnnuityCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnnuityCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnnuityCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnnuityCalculatorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnnuityCalculatorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar annuityJMenuBar;
    private javax.swing.JButton calculateJButton;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JFormattedTextField compoundsPerYearJFormattedTextField;
    private javax.swing.JLabel compoundsPerYearJLabel;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JLabel futureAnnuityBalanceJLabel;
    private javax.swing.JTextField futureAnnuityBalanceJTextField;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JButton importJButton;
    private javax.swing.JPanel inputJPanel;
    private javax.swing.JLabel interestJLabel;
    private javax.swing.JSpinner interestJSpinner;
    private javax.swing.JPanel outputJPanel;
    private javax.swing.JFormattedTextField periodicPaymentJFormattedTextField;
    private javax.swing.JLabel periodicPaymentJLabel;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JMenuItem quitJMenuItem1;
    private javax.swing.JLabel totalOfInterestEarnedJLabel;
    private javax.swing.JTextField totalOfInterestEarnedJTextField;
    private javax.swing.JLabel totalOfPaymentJLabel;
    private javax.swing.JTextField totalOfPaymentJTextField;
    private javax.swing.JFormattedTextField yearsJFormattedTextField;
    private javax.swing.JLabel yearsJLabel;
    // End of variables declaration//GEN-END:variables
}
