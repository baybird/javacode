package Project2;

import java.awt.Color;


/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         About.java
 * Project      Alderwood Water and Waterwater District
 * Description  This class shows the about form.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         5/10/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * @see javax.swing.JDialog
 * @see java.awt.Toolkit
 * @see java.awt.Color
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class About extends javax.swing.JDialog {
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Default constructor
     * Description      Creates new form About
     * @author          <i>Robert Tang</i>
     * @param parent-awt.Frame
     * @param modal-boolean
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // centers the form at start
        this.setLocationRelativeTo(null);
        
        // change background color
        this.getContentPane().setBackground(new Color(156,200,255));
        
        // set default botton
        this.getRootPane().setDefaultButton(closeJButton);
        
        // move cursor to first row
        aboutJTextArea.setCaretPosition(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJPanel = new javax.swing.JPanel();
        titleJLabel = new javax.swing.JLabel();
        aboutJScrollPane = new javax.swing.JScrollPane();
        aboutJTextArea = new javax.swing.JTextArea();
        closeJButton = new javax.swing.JButton();
        warningJLabel = new javax.swing.JLabel();
        copyrightJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AWWD Invoice About");
        setBackground(new java.awt.Color(156, 200, 255));
        setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(300, 200));
        setType(java.awt.Window.Type.UTILITY);

        titleJPanel.setBackground(new java.awt.Color(156, 200, 255));
        titleJPanel.setForeground(new java.awt.Color(255, 255, 255));

        titleJLabel.setFont(new java.awt.Font("Lucida Grande", 2, 28)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project2/icon.png"))); // NOI18N
        titleJLabel.setText("AWWD Invoice About");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        aboutJScrollPane.setBackground(new java.awt.Color(156, 200, 255));
        aboutJScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        aboutJTextArea.setEditable(false);
        aboutJTextArea.setColumns(20);
        aboutJTextArea.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        aboutJTextArea.setLineWrap(true);
        aboutJTextArea.setRows(5);
        aboutJTextArea.setText("A simple application that displays Alderwood Water and Wasterwater District utility bill. The calculation of the bill is based upon the following:\n\n• Meter Size—for this application we will assume our house has a 3/4\"x5/8\" meter.\n\n• Bi-monthly Base Charge—$33 flat fee.\n\n• CCF Consumption Rate—$0 for the first 4 CCF (None: 1 CCF = 100 cubic feet of water which is approximately 748 gallons), $2.61 for Tier 1: 5—14 CCF, $3.16 for Tier 2 (15-30 CCF) and $3.81 for Tier 3 (over 30 CCF).\n\n• Wastewater (Sewer) Charges—$106.28 for Tier 1 (0-4 CCF), $138.18 for Tier 2 (5-18 CCF), and $167.70 for Tier 3 (>18 CCF).\n\n• Mukiteo Franchise Fee—$6.44 flat fee.");
        aboutJTextArea.setWrapStyleWord(true);
        aboutJScrollPane.setViewportView(aboutJTextArea);

        closeJButton.setBackground(new java.awt.Color(255, 255, 204));
        closeJButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        closeJButton.setMnemonic('C');
        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        warningJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        warningJLabel.setText("Author: Robert Tang");
        warningJLabel.setToolTipText("");
        warningJLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        copyrightJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        copyrightJLabel.setText("Copyright © Freeware");
        copyrightJLabel.setToolTipText("");
        copyrightJLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aboutJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(warningJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(copyrightJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aboutJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(copyrightJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warningJLabel))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method        closeJButtonActionPerformed()
     * Description   Close the about form
     * @param        java.awt.event.ActionEvent evt
     * @author       <i>Robert Tang</i>
     * @see         java.awt.event.ActionEvent
     * Date         5/3/2021  
     * </pre>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeJButtonActionPerformed
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                About dialog = new About(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane aboutJScrollPane;
    private javax.swing.JTextArea aboutJTextArea;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JLabel warningJLabel;
    // End of variables declaration//GEN-END:variables
}
