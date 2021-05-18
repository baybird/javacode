package Project2;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         WaterBillDriver.java
 * Project      Alderwood Water and Waterwater District
 * Description  This class provides the main GUI application.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         5/8/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class WaterBillDriver extends javax.swing.JFrame {
    // Declare application constant and var.
    private final String FILE_LOCATION = "./src/Project2/customer.txt";
    ArrayList<ArrayList<String>> customerData;

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           WaterBillDriver()
     * Description      Creates new form of water bill.
     * Date 4/30/2021
     * @throws IOException if thing goes wrong.
     * @author          <i>Robert Tang</i>
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public WaterBillDriver() throws IOException {
        initComponents();

        // centers the form at start
        this.setLocationRelativeTo(null);

        // set default button on calculate
        this.getRootPane().setDefaultButton(displayBillJButton);

        // change background color
        this.getContentPane().setBackground(new Color(156, 200, 255));

        // set date on title bar
        this.setDate();

        // import names of customers.
        this.importCustomerData(FILE_LOCATION);

        stateJComboBox.insertItemAt("", 0);
        stateJComboBox.setSelectedIndex(0);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setDate()
     * Description      Set current date the title bar.
     * @author          <i>Robert Tang</i>
     * Date 5/9/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void setDate() {

        Date now = new Date();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.setTitle("Alderwood W&W District - " + dateFormat.format(now));

        DateFormat dateFormat2 = new SimpleDateFormat("MMM d, yyyy");
        invoiceDateJTextField.setText(dateFormat2.format(now));
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           importCustomers()
     * Description      Import customer data from an external file.
     * @param filePath
     * @author          <i>Robert Tang</i>
     * Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void importCustomerData(String filePath) {
        try {
            nameJComboBox.setSelectedIndex(0);
            Integer count = nameJComboBox.getItemCount();
            // remove old items
            for (int i = 1; i < count; i++) {
                nameJComboBox.removeItemAt(1);
            }
            
            BufferedReader bufferedReder = new BufferedReader(new FileReader(filePath));
            String customerLine;
            customerData = new ArrayList<>();

            while ((customerLine = bufferedReder.readLine()) != null) {
                // add data to the arrayList customerData.
                List<String> item = Arrays.asList(customerLine.split(","));
                customerData.add(new ArrayList<>(item));

                // add customer name to the combobox
                nameJComboBox.addItem(this.getCustomerName(item));
            }
        } catch (FileNotFoundException ex) {
            System.out.print("File Open Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.print("File IO Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.print("Invalid input: " + ex.getMessage());
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getCustomerName()
     * Description      Get customer name from List customer data.
     * @param item - List<String>
     * @author          <i>Robert Tang</i>
     * Date 5/7/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private String getCustomerName(List<String> item) {
        return item.get(0);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getCustomerAddress()
     * Description      Get customer name from List customer data.
     * @param item - List<String>
     * @author          <i>Robert Tang</i>
     * Date 5/7/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private String getCustomerAddress(List<String> item) {
        return item.get(1);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getCustomerCity()
     * Description      Get customer name from List customer data.
     * @param item - List<String>
     * @author          <i>Robert Tang</i>
     * Date 5/7/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private String getCustomerCity(List<String> item) {
        return item.get(2);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getCustomerState()
     * Description      Get customer name from List customer data.
     * @param item - List<String>
     * @author          <i>Robert Tang</i>
     * Date 5/7/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private String getCustomerState(List<String> item) {
        return item.get(3);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getCustomerZip()
     * Description      Get customer name from List customer data.
     * @param item - List<String>
     * @author          <i>Robert Tang</i>
     * Date 5/7/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private String getCustomerZip(List<String> item) {
        return item.get(4);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getCustomerAccountNumber()
     * Description      Get customer account # from List customer data.
     * @param item - List<String>
     * @author          <i>Robert Tang</i>
     * Date 5/7/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void fillCustmoerData(String name) {
        Boolean dataFound = false;
        String searchTerm = name.trim();

        // Fill data for selected customer
        if (searchTerm.length() > 0) {
            for (int i = 0; i < customerData.size(); i++) {
                List item = customerData.get(i);
                if (getCustomerName(item).equals(searchTerm)) {
                    dataFound = true;
                    addressJTextField.setText(getCustomerAddress(item));
                    cityJTextField.setText(getCustomerCity(item));
                    stateJComboBox.setSelectedItem(getCustomerState(item));
                    zipJFormattedTextField.setText(getCustomerZip(item));
                }
            }
        }

        // Clear data if no customer is selected
        if (dataFound != true) {
            addressJTextField.setText("");
            cityJTextField.setText("");
            stateJComboBox.setSelectedIndex(0);
            zipJFormattedTextField.setText("");
        }
        
        // Clear the out textarea.
        outJTextArea.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottomJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        displayJPanel = new javax.swing.JPanel();
        infoNameJLabel = new javax.swing.JLabel();
        infoAddressJLabel = new javax.swing.JLabel();
        infoCityJLabel = new javax.swing.JLabel();
        infoURLJLabel = new javax.swing.JLabel();
        infoPhoneJLabel = new javax.swing.JLabel();
        infoEmailJLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        meterReadingJLabel = new javax.swing.JLabel();
        presentJLabel = new javax.swing.JLabel();
        previousJLabel = new javax.swing.JLabel();
        totalUnitJLabel = new javax.swing.JLabel();
        totalUnitJTextField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        invoiceDateJLabel = new javax.swing.JLabel();
        invoiceDateJTextField = new javax.swing.JTextField();
        accountJLabel = new javax.swing.JLabel();
        accountJFormattedTextField = new javax.swing.JFormattedTextField();
        presentReadingJFormattedTextField = new javax.swing.JFormattedTextField();
        previousReadingJFormattedTextField = new javax.swing.JFormattedTextField();
        controlJPanel = new javax.swing.JPanel();
        displayBillJButton = new javax.swing.JButton();
        printInvoiceJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        outJScrollPane = new javax.swing.JScrollPane();
        outJTextArea = new javax.swing.JTextArea();
        customerJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJComboBox = new javax.swing.JComboBox<>();
        addressJLabel = new javax.swing.JLabel();
        addressJTextField = new javax.swing.JTextField();
        cityJLabel = new javax.swing.JLabel();
        cityJTextField = new javax.swing.JTextField();
        stateJComboBox = new javax.swing.JComboBox<>();
        stateJLabel = new javax.swing.JLabel();
        zipJLabel = new javax.swing.JLabel();
        logoJLabel = new javax.swing.JLabel();
        zipJFormattedTextField = new javax.swing.JFormattedTextField();
        awwdJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        displayBillJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        jSeparatorBeforeQuit1 = new javax.swing.JPopupMenu.Separator();
        printformJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        importJMenuItem = new javax.swing.JMenuItem();
        jSeparatorBeforeQuit = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Project2/icon.png")).getImage());
        setResizable(false);
        setSize(new java.awt.Dimension(300, 500));

        bottomJPanel.setBackground(new java.awt.Color(156, 200, 255));
        bottomJPanel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(49, 101, 255));
        jLabel1.setText("Thank you for being our customer!");

        javax.swing.GroupLayout bottomJPanelLayout = new javax.swing.GroupLayout(bottomJPanel);
        bottomJPanel.setLayout(bottomJPanelLayout);
        bottomJPanelLayout.setHorizontalGroup(
            bottomJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomJPanelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomJPanelLayout.setVerticalGroup(
            bottomJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        displayJPanel.setBackground(new java.awt.Color(156, 200, 255));

        infoNameJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        infoNameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoNameJLabel.setText("Alderwood W&W District");
        infoNameJLabel.setToolTipText("");

        infoAddressJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        infoAddressJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoAddressJLabel.setText("3526 156th Street SW");
        infoAddressJLabel.setToolTipText("");

        infoCityJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        infoCityJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoCityJLabel.setText("Lynwood, WA 98087-5021");
        infoCityJLabel.setToolTipText("");

        infoURLJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        infoURLJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoURLJLabel.setText("www.awwd.com");
        infoURLJLabel.setToolTipText("");

        infoPhoneJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        infoPhoneJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoPhoneJLabel.setText("866-899-1313");
        infoPhoneJLabel.setToolTipText("");

        infoEmailJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        infoEmailJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infoEmailJLabel.setText("help@awwd.com");
        infoEmailJLabel.setToolTipText("");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        meterReadingJLabel.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        meterReadingJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        meterReadingJLabel.setText("Meter Readings");
        meterReadingJLabel.setToolTipText("");

        presentJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        presentJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        presentJLabel.setText("Present");

        previousJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        previousJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        previousJLabel.setText("Previous");

        totalUnitJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        totalUnitJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalUnitJLabel.setText("Total Units");

        totalUnitJTextField.setEditable(false);
        totalUnitJTextField.setBackground(new java.awt.Color(238, 238, 238));
        totalUnitJTextField.setColumns(8);
        totalUnitJTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        totalUnitJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalUnitJTextField.setFocusable(false);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        invoiceDateJLabel.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        invoiceDateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invoiceDateJLabel.setText("Invoice Date");
        invoiceDateJLabel.setToolTipText("");

        invoiceDateJTextField.setEditable(false);
        invoiceDateJTextField.setBackground(new java.awt.Color(238, 238, 238));
        invoiceDateJTextField.setColumns(8);
        invoiceDateJTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        invoiceDateJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceDateJTextField.setFocusable(false);

        accountJLabel.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        accountJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        accountJLabel.setText("Account #");
        accountJLabel.setToolTipText("");

        try {
            accountJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        accountJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        accountJFormattedTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        presentReadingJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        presentReadingJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        presentReadingJFormattedTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        presentReadingJFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                presentReadingJFormattedTextFieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                presentReadingJFormattedTextFieldKeyReleased(evt);
            }
        });

        previousReadingJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        previousReadingJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        previousReadingJFormattedTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        previousReadingJFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                previousReadingJFormattedTextFieldKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                previousReadingJFormattedTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout displayJPanelLayout = new javax.swing.GroupLayout(displayJPanel);
        displayJPanel.setLayout(displayJPanelLayout);
        displayJPanelLayout.setHorizontalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(infoPhoneJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoURLJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoAddressJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoCityJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addComponent(infoNameJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(infoEmailJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(displayJPanelLayout.createSequentialGroup()
                        .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(presentJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(displayJPanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(previousJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(totalUnitJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(totalUnitJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(presentReadingJFormattedTextField)
                            .addComponent(previousReadingJFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                    .addComponent(meterReadingJLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(accountJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(invoiceDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invoiceDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(accountJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displayJPanelLayout.setVerticalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(displayJPanelLayout.createSequentialGroup()
                        .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoNameJLabel)
                            .addComponent(meterReadingJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(displayJPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoAddressJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoCityJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoURLJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoPhoneJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoEmailJLabel))
                            .addGroup(displayJPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(presentJLabel)
                                    .addComponent(presentReadingJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(previousJLabel)
                                    .addComponent(previousReadingJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalUnitJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalUnitJLabel)))))
                    .addGroup(displayJPanelLayout.createSequentialGroup()
                        .addComponent(invoiceDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoiceDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(accountJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        controlJPanel.setBackground(new java.awt.Color(156, 200, 255));
        controlJPanel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        displayBillJButton.setBackground(new java.awt.Color(255, 255, 204));
        displayBillJButton.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        displayBillJButton.setMnemonic('D');
        displayBillJButton.setText("Display Bill");
        displayBillJButton.setToolTipText("Calculate and display bill.");
        displayBillJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBillJButtonActionPerformed(evt);
            }
        });

        printInvoiceJButton.setBackground(new java.awt.Color(255, 255, 204));
        printInvoiceJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        printInvoiceJButton.setMnemonic('P');
        printInvoiceJButton.setText("Print Invoice");
        printInvoiceJButton.setToolTipText("Print invoice");
        printInvoiceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printInvoiceJButtonActionPerformed(evt);
            }
        });

        quitJButton.setBackground(new java.awt.Color(255, 255, 204));
        quitJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.setToolTipText("Quit program.");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        clearJButton.setBackground(new java.awt.Color(255, 255, 204));
        clearJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        clearJButton.setMnemonic('C');
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Clear all content.");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });

        saveJButton.setBackground(new java.awt.Color(255, 255, 204));
        saveJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveJButton.setMnemonic('S');
        saveJButton.setText("Save");
        saveJButton.setToolTipText("Save to external file.");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlJPanelLayout = new javax.swing.GroupLayout(controlJPanel);
        controlJPanel.setLayout(controlJPanelLayout);
        controlJPanelLayout.setHorizontalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayBillJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printInvoiceJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(controlJPanelLayout.createSequentialGroup()
                        .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        controlJPanelLayout.setVerticalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayBillJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printInvoiceJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        outJTextArea.setEditable(false);
        outJTextArea.setColumns(1);
        outJTextArea.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        outJTextArea.setRows(5);
        outJTextArea.setTabSize(4);
        outJTextArea.setAutoscrolls(false);
        outJScrollPane.setViewportView(outJTextArea);

        customerJPanel.setBackground(new java.awt.Color(156, 200, 255));

        nameJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameJLabel.setText("Name");

        nameJComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nameJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        nameJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJComboBoxActionPerformed(evt);
            }
        });

        addressJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        addressJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressJLabel.setText("Address");

        addressJTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        addressJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressJTextFieldKeyTyped(evt);
            }
        });

        cityJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        cityJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cityJLabel.setText("City");

        cityJTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cityJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cityJTextFieldKeyTyped(evt);
            }
        });

        stateJComboBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stateJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "AS", "DC", "GU", "MH", "MP", "PR", "VI", "AE", "AA", "AE", "AE", "AE", "AP" }));
        stateJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateJComboBoxActionPerformed(evt);
            }
        });

        stateJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        stateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stateJLabel.setText("State");

        zipJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        zipJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        zipJLabel.setText("Zip");

        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project2/icon.png"))); // NOI18N

        try {
            zipJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        zipJFormattedTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        zipJFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zipJFormattedTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout customerJPanelLayout = new javax.swing.GroupLayout(customerJPanel);
        customerJPanel.setLayout(customerJPanelLayout);
        customerJPanelLayout.setHorizontalGroup(
            customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerJPanelLayout.createSequentialGroup()
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerJPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cityJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(zipJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(customerJPanelLayout.createSequentialGroup()
                                .addComponent(cityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stateJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(logoJLabel))
                    .addComponent(zipJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(202, 202, 202))
        );
        customerJPanelLayout.setVerticalGroup(
            customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerJPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoJLabel)
                    .addGroup(customerJPanelLayout.createSequentialGroup()
                        .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameJLabel)
                            .addComponent(nameJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressJLabel)
                            .addComponent(addressJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityJLabel)
                            .addComponent(cityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stateJLabel)
                            .addComponent(stateJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipJLabel)
                    .addComponent(zipJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        displayBillJMenuItem.setMnemonic('r');
        displayBillJMenuItem.setText("Display Bill");
        displayBillJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBillJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(displayBillJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print Invoice");
        printJMenuItem.setToolTipText("Print Customer Bill");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        clearJMenuItem.setMnemonic('r');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);
        fileJMenu.add(jSeparatorBeforeQuit1);

        printformJMenuItem.setMnemonic('F');
        printformJMenuItem.setText("Print Form");
        printformJMenuItem.setToolTipText("Print form as GUI");
        printformJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printformJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printformJMenuItem);

        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);

        importJMenuItem.setMnemonic('I');
        importJMenuItem.setText("Import");
        importJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(importJMenuItem);
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
            .addComponent(displayJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bottomJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(customerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outJScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           clearJMenuItemActionPerformed()
     * Description      Button action to clear all fields.
     * @author          <i>Robert Tang</i>
     * @param evt Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        clearJButton.doClick();
    }//GEN-LAST:event_clearJMenuItemActionPerformed
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           printJMenuItemActionPerformed()
     * Description      Button action to print form.
     * @author          <i>Robert Tang</i>
     * @param evt Date 4/30/2021
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
     * @param evt Date 4/30/2021
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
     * @param evt Date 4/30/2021
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
     * Description      Menu action to save a bill.
     * @author          <i>Robert Tang</i>
     * @param evt Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        saveJButton.doClick();
    }//GEN-LAST:event_saveJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           printJMenuItemActionPerformed()
     * Description      Menu action to print invoice.
     * @author          <i>Robert Tang</i>
     * @param evt Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        printInvoiceJButton.doClick();
    }//GEN-LAST:event_printJMenuItemActionPerformed
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           displayBillJButtonActionPerformed()
     * Description      Calculate and display bill.
     * @author          <i>Robert Tang</i>
     * @param evt Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void displayBillJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBillJButtonActionPerformed
        try {
            String presentReading = presentReadingJFormattedTextField.getText().trim();
            String previousReading = previousReadingJFormattedTextField.getText().trim();
            String name = nameJComboBox.getSelectedItem().toString().trim();
            String account = accountJFormattedTextField.getText().trim();
            String address = addressJTextField.getText().trim();
            String city = cityJTextField.getText().trim();
            String state = stateJComboBox.getSelectedItem().toString().trim();
            String zip = zipJFormattedTextField.getText().trim();

            if (presentReading.length() < 1) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a present reading.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                presentReadingJFormattedTextField.requestFocus();
            } else if (Integer.parseInt(presentReading) < 0) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid present reading that cannot less than 0.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                presentReadingJFormattedTextField.requestFocus();
            } else if (previousReading.length() < 1) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a previous reading.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                previousReadingJFormattedTextField.requestFocus();
            } else if (Integer.parseInt(previousReading) < 0) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid previous reading that cannot less than 0.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                previousReadingJFormattedTextField.requestFocus();
            } else if (Integer.parseInt(presentReading) < Integer.parseInt(previousReading)) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input. The presend reading cannot less than the previous reading.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                presentReadingJFormattedTextField.requestFocus();
            } else if ("".equals(name.trim()) || 1 >= name.length()) {
                JOptionPane.showMessageDialog(null,
                        "Please select a customer",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                nameJComboBox.requestFocus();
            } else if (account.length() < 5) {
                JOptionPane.showMessageDialog(null,
                        "Please enter account number.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                accountJFormattedTextField.requestFocus();
            } else if (address.length() < 1) {
                JOptionPane.showMessageDialog(null,
                        "Please enter an address",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                addressJTextField.requestFocus();
            } else if (!Validation.validateAddress(address)) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid address.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                addressJTextField.requestFocus();
            } else if ("".equals(city.trim()) || city.length() < 1) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a city name.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                cityJTextField.requestFocus();
            } else if (!Validation.validateCity(city)) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid city name.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                cityJTextField.requestFocus();
            } else if (state.length() < 1) {
                JOptionPane.showMessageDialog(null,
                        "Please select a state.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                stateJComboBox.requestFocus();
            } else if (zip.length() < 1) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a zip.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                zipJFormattedTextField.requestFocus();
            } else if (!Validation.validateZip(zip)) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid zip.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                zipJFormattedTextField.requestFocus();
            } else {
                Integer totalUnits = Integer.parseInt(totalUnitJTextField.getText());
                Invoice myInvoice = new Invoice(name, totalUnits);
                myInvoice.calculateBill();
                outJTextArea.setText(myInvoice.dispaly().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_displayBillJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           quitJButtonActionPerformed()
     * Description      Quit the application.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           printInvoiceJButtonActionPerformed()
     * Description      Print cusotmer's invoice.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void printInvoiceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printInvoiceJButtonActionPerformed
        try {
            if (outJTextArea.getText().trim().length() > 0) {
                outJTextArea.print();
            } else {
                JOptionPane.showMessageDialog(null,
                        "You have nothing to print now, please make a invoice first.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException ex) {
            Logger.getLogger(WaterBillDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printInvoiceJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           clearJButtonActionPerformed()
     * Description      Clear all content.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        presentReadingJFormattedTextField.setText("");
        previousReadingJFormattedTextField.setText("");
        accountJFormattedTextField.setText("");
        nameJComboBox.setSelectedIndex(0);
        outJTextArea.setText("");
        totalUnitJTextField.setText("");
        addressJTextField.setText("");
        cityJTextField.setText("");
        zipJFormattedTextField.setText("");
        stateJComboBox.setSelectedItem("");
        presentReadingJFormattedTextField.requestFocus();
    }//GEN-LAST:event_clearJButtonActionPerformed
    
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           saveJButtonActionPerformed()
     * Description      Save current invoice to an external file.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        String name = nameJComboBox.getSelectedItem().toString().trim();
        if(name.length() <1){
            // display error message
            JOptionPane.showMessageDialog(null,
                "Please select a valid customer name.",
                "Missing Information", JOptionPane.WARNING_MESSAGE);
                nameJComboBox.requestFocus();
        }    
        else if (outJTextArea.getText().trim().isEmpty()) {
            // display error message
            JOptionPane.showMessageDialog(null,
                "There is no invoice to save.",
                "Missing Information", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)", "txt"));
                fileChooser.setSelectedFile(new File(name+".txt")); // Save to an external file named by customer name.
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
                            "Invoice has saved to file.",
                            "Invoice saved", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (HeadlessException | IOException ex) {
                // display error message
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveJButtonActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           nameJComboBoxActionPerformed()
     * Description      When customer changed form the combobox that it would 
     *                  fill the rest data (address, city, state, and zip code)
     *                  automatically.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void nameJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJComboBoxActionPerformed

        fillCustmoerData(nameJComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_nameJComboBoxActionPerformed
    
   
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           stateJComboBoxActionPerformed()
     * Description      When the state list is changed, then clear up the textarea 
     *                  of invoice. 
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void stateJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateJComboBoxActionPerformed
        outJTextArea.setText("");
    }//GEN-LAST:event_stateJComboBoxActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           addressJTextFieldKeyTyped()
     * Description      Clear the invoice textarea when address changed. 
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void addressJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressJTextFieldKeyTyped
        outJTextArea.setText("");
    }//GEN-LAST:event_addressJTextFieldKeyTyped

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           cityJTextFieldKeyTyped()
     * Description      Clear the invoice textarea when city changed. 
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void cityJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityJTextFieldKeyTyped
        outJTextArea.setText("");
    }//GEN-LAST:event_cityJTextFieldKeyTyped

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           zipJFormattedTextFieldKeyTyped()
     * Description      Clear the invoice textarea when zip changed. 
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void zipJFormattedTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zipJFormattedTextFieldKeyTyped
        outJTextArea.setText("");
    }//GEN-LAST:event_zipJFormattedTextFieldKeyTyped

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           presentReadingJFormattedTextFieldKeyReleased()
     * Description      Calculate the total of reading while customer typing in
     *                  readings.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void presentReadingJFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_presentReadingJFormattedTextFieldKeyReleased
        String presentString = presentReadingJFormattedTextField.getText().trim();
        String previousString = previousReadingJFormattedTextField.getText().trim();
        
        if(presentString.length()>0 && previousString.length()>0){
            Integer presentReading = Integer.parseInt(presentString );
            Integer previousReading = Integer.parseInt(previousString );
            totalUnitJTextField.setText(String.valueOf(presentReading - previousReading));
        }
        else{
            totalUnitJTextField.setText("");
        }
    }//GEN-LAST:event_presentReadingJFormattedTextFieldKeyReleased
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           previousReadingJFormattedTextFieldKeyReleased()
     * Description      Calculate the total of reading while customer typing in
     *                  readings.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void previousReadingJFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_previousReadingJFormattedTextFieldKeyReleased
        presentReadingJFormattedTextFieldKeyReleased(evt);
    }//GEN-LAST:event_previousReadingJFormattedTextFieldKeyReleased

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           presentReadingJFormattedTextFieldKeyTyped()
     * Description      Check the maximum length of the present reading.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void presentReadingJFormattedTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_presentReadingJFormattedTextFieldKeyTyped
        if(presentReadingJFormattedTextField.getText().trim().length() > 6){
            getToolkit().beep();
            evt.consume();
        }
        
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_presentReadingJFormattedTextFieldKeyTyped

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           previousReadingJFormattedTextFieldKeyTyped()
     * Description      Check the maximum length of the previous reading.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void previousReadingJFormattedTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_previousReadingJFormattedTextFieldKeyTyped
        if(previousReadingJFormattedTextField.getText().trim().length() > 6){
            getToolkit().beep();
            evt.consume();
        }
        
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_previousReadingJFormattedTextFieldKeyTyped

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           importJMenuItemActionPerformed()
     * Description      Input menu action that allow to input the customer data from 
     *                  an external file.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void importJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importJMenuItemActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files(*.txt)", "txt"));
            fileChooser.setCurrentDirectory(new File("./src/Project2/"));
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {  
                presentReadingJFormattedTextField.setText("");
                previousReadingJFormattedTextField.setText("");
                totalUnitJTextField.setText("");
                accountJFormattedTextField.setText("");
                presentReadingJFormattedTextField.requestFocus();                
                final File selectedFile = fileChooser.getSelectedFile();
                // import names of customers.
                this.importCustomerData(selectedFile.toString());
                
                // display confirmation message
                JOptionPane.showMessageDialog(null,
                    "Customer data has imported",
                    "Inforamtion Message", JOptionPane.INFORMATION_MESSAGE);
                nameJComboBox.requestFocus();
            }
        } catch (HeadlessException ex) {
            System.out.print(ex.getMessage());
        }
    }//GEN-LAST:event_importJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           displayBillJMenuItemActionPerformed()
     * Description      Calculate and display bill.
     * @author          <i>Robert Tang</i>
     * @param evt Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void displayBillJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBillJMenuItemActionPerformed
        displayBillJButtonActionPerformed(evt);
    }//GEN-LAST:event_displayBillJMenuItemActionPerformed

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           main()
     * Description      main GUI method of Alderwood Water and Waterwater District.
     * @author          <i>Robert Tang</i>
     * @param args the command line arguments Date 4/30/2021
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
            java.util.logging.Logger.getLogger(WaterBillDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaterBillDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaterBillDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaterBillDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        Splash instanceOfSplash = new Splash(2000);
        instanceOfSplash.showSplash();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new WaterBillDriver().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(WaterBillDriver.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JFormattedTextField accountJFormattedTextField;
    private javax.swing.JLabel accountJLabel;
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JTextField addressJTextField;
    private javax.swing.JMenuBar awwdJMenuBar;
    private javax.swing.JPanel bottomJPanel;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JTextField cityJTextField;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JPanel customerJPanel;
    private javax.swing.JButton displayBillJButton;
    private javax.swing.JMenuItem displayBillJMenuItem;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JMenuItem importJMenuItem;
    private javax.swing.JLabel infoAddressJLabel;
    private javax.swing.JLabel infoCityJLabel;
    private javax.swing.JLabel infoEmailJLabel;
    private javax.swing.JLabel infoNameJLabel;
    private javax.swing.JLabel infoPhoneJLabel;
    private javax.swing.JLabel infoURLJLabel;
    private javax.swing.JLabel invoiceDateJLabel;
    private javax.swing.JTextField invoiceDateJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparatorBeforeQuit;
    private javax.swing.JPopupMenu.Separator jSeparatorBeforeQuit1;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel meterReadingJLabel;
    private javax.swing.JComboBox<String> nameJComboBox;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JScrollPane outJScrollPane;
    private javax.swing.JTextArea outJTextArea;
    private javax.swing.JLabel presentJLabel;
    private javax.swing.JFormattedTextField presentReadingJFormattedTextField;
    private javax.swing.JLabel previousJLabel;
    private javax.swing.JFormattedTextField previousReadingJFormattedTextField;
    private javax.swing.JButton printInvoiceJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem printformJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JButton saveJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JComboBox<String> stateJComboBox;
    private javax.swing.JLabel stateJLabel;
    private javax.swing.JLabel totalUnitJLabel;
    private javax.swing.JTextField totalUnitJTextField;
    private javax.swing.JFormattedTextField zipJFormattedTextField;
    private javax.swing.JLabel zipJLabel;
    // End of variables declaration//GEN-END:variables
}
