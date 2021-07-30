package Lab6;
import java.awt.Color;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        About
 * File         About.java
 * Description  About form for LAb 3--Geometries
 * Environment  PC, Windows 10, NetBeans IDE 11.3, jdk 1.8.0_241
 * Date         5/4/2020
 * History Log  4/6/2009, 11/6/2013, 7/18/2018
 * @author      <i>Niko Culevski</i>
 * @version     1.4.2
 * @see         javax.swing.JDialog
*</pre>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class About extends javax.swing.JDialog
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre> 
     * Constructor  JDialog to allow to select modal or modeless form
     * Description  Create the form as designed, center it, set background 
     *              color, okJButton as default.
     * Date         5/4/2020
     * History Log  4/6/2009, 11/6/2013, 7/18/2018
     * @author      <i>Niko Culevski</i>
     * @param       parent java.awt.Frame
     * @param       modal boolean
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public About(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        //set as default the okJButton
        this.getRootPane().setDefaultButton(okJButton);      
        //set background color
        this.getContentPane().setBackground(new Color(255,255,204));
        infoJTextArea.setCaretPosition(0);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoJLabel = new javax.swing.JLabel();
        infoJScrollPane = new javax.swing.JScrollPane();
        infoJTextArea = new javax.swing.JTextArea();
        okJButton = new javax.swing.JButton();
        authorJLabel = new javax.swing.JLabel();
        versionJLabel = new javax.swing.JLabel();
        copyJLabel = new javax.swing.JLabel();
        dateJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Geometries About Form");
        setBackground(new java.awt.Color(255, 255, 204));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        logoJLabel.setFont(new java.awt.Font("Tahoma", 2, 28)); // NOI18N
        logoJLabel.setForeground(new java.awt.Color(153, 0, 51));
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Scalene.png"))); // NOI18N
        logoJLabel.setText("Geometries About Form");

        infoJTextArea.setEditable(false);
        infoJTextArea.setColumns(20);
        infoJTextArea.setLineWrap(true);
        infoJTextArea.setRows(5);
        infoJTextArea.setText("This program solves four separate problems; the first three related to calculations with triangles.\n\nThe first  problem  prompts the user to enter the three vertices of a triangle and then calculates the perimeter and area of the triangle. It uses the distance formula to calculate each edge of the triangle and verifies that the triangle is valid (the sum of any two sides is greater than the third).  Heron’s formula is used for calculating the area of the triangle.\n\nA second problem in a sepate JPanel determines if user-given point in the plane is inside or outside the triangle with vertices (0,0), where the right angle is located, (0, b), and (c, 0), for y-intercept b and x-intercept c.\n\nA third problem in a separate JPanel determines if a given test point in the plane is inside or outside any triangle with given vertices.\n\nThe final problem uses summation in a loop to approximate the natural log function for a given value. It is known as the Mercater series.");
        infoJTextArea.setWrapStyleWord(true);
        infoJScrollPane.setViewportView(infoJTextArea);

        okJButton.setBackground(new java.awt.Color(255, 255, 204));
        okJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        okJButton.setMnemonic('O');
        okJButton.setText("OK");
        okJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJButtonActionPerformed(evt);
            }
        });

        authorJLabel.setText("Author:  Robert Tang");

        versionJLabel.setText("Version 1.4.0");

        copyJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyJLabel.setText("Copyright: Freeware");

        dateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateJLabel.setText("Date:  5/14/2021");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(versionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(authorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(okJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copyJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(infoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logoJLabel)
                .addGap(18, 18, 18)
                .addComponent(infoJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(copyJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateJLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(authorJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(versionJLabel))
                    .addComponent(okJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       okJButtonActionPerformed
     * Description  Closes the About form only
     * Date         3/31/2020
     * History log  4/4/2016, 1/4/2019
     * @author      <i>Niko Culevski</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void okJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okJButtonActionPerformed
    {//GEN-HEADEREND:event_okJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okJButtonActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorJLabel;
    private javax.swing.JLabel copyJLabel;
    private javax.swing.JLabel dateJLabel;
    private javax.swing.JScrollPane infoJScrollPane;
    private javax.swing.JTextArea infoJTextArea;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JButton okJButton;
    private javax.swing.JLabel versionJLabel;
    // End of variables declaration//GEN-END:variables
}
