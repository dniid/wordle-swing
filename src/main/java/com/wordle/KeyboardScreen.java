package com.wordle;

import java.awt.Color;
import javax.swing.JTextPane;


/**
 *
 * @author nid
 */
public class KeyboardScreen extends javax.swing.JFrame {
    
    /**
     * Creates new form Keyboard
     */
    public KeyboardScreen() {
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
            java.util.logging.Logger.getLogger(KeyboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeyboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeyboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeyboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        extraInitArgs();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        keyboardRowA = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        keyboardRowB = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        keyboardRowC = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Letras em Jogo");

        keyboardRowA.setEditable(false);
        keyboardRowA.setBorder(null);
        keyboardRowA.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        keyboardRowA.setText("Q - W - E - R - T - Y - U - I - O - P ");
        keyboardRowA.setFocusable(false);
        keyboardRowA.setMargin(new java.awt.Insets(0, 2, 0, 2));
        keyboardRowA.setOpaque(false);
        jScrollPane1.setViewportView(keyboardRowA);

        keyboardRowB.setEditable(false);
        keyboardRowB.setBorder(null);
        keyboardRowB.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        keyboardRowB.setText("A - S - D - F - G - H - J - K - L ");
        keyboardRowB.setFocusable(false);
        keyboardRowB.setMargin(new java.awt.Insets(0, 2, 0, 2));
        keyboardRowB.setOpaque(false);
        jScrollPane2.setViewportView(keyboardRowB);

        keyboardRowC.setEditable(false);
        keyboardRowC.setBorder(null);
        keyboardRowC.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        keyboardRowC.setText("Z - X - C - V - B - N - M ");
        keyboardRowC.setFocusable(false);
        keyboardRowC.setMargin(new java.awt.Insets(0, 2, 0, 2));
        keyboardRowC.setOpaque(false);
        jScrollPane3.setViewportView(keyboardRowC);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane keyboardRowA;
    private javax.swing.JTextPane keyboardRowB;
    private javax.swing.JTextPane keyboardRowC;
    // End of variables declaration//GEN-END:variables

    private void extraInitArgs(){
        keyboardRowA.setBackground(new java.awt.Color(0, 0, 0, 0));
        keyboardRowB.setBackground(new java.awt.Color(0, 0, 0, 0));
        keyboardRowC.setBackground(new java.awt.Color(0, 0, 0, 0));
        
        keyboardRowA.setForeground(Color.GRAY);
        keyboardRowB.setForeground(Color.GRAY);
        keyboardRowC.setForeground(Color.GRAY);
        
        jScrollPane1.setViewportBorder(null);
        jScrollPane2.setViewportBorder(null);
        jScrollPane3.setViewportBorder(null);
        jScrollPane1.setBorder(null);
        jScrollPane2.setBorder(null);
        jScrollPane3.setBorder(null);
        
    }

    public JTextPane getKeyboardRowA() {
        return keyboardRowA;
    }

    public void setKeyboardRowA(JTextPane keyboardRowA) {
        this.keyboardRowA = keyboardRowA;
    }

    public JTextPane getKeyboardRowB() {
        return keyboardRowB;
    }

    public void setKeyboardRowB(JTextPane keyboardRowB) {
        this.keyboardRowB = keyboardRowB;
    }

    public JTextPane getKeyboardRowC() {
        return keyboardRowC;
    }

    public void setKeyboardRowC(JTextPane keyboardRowC) {
        this.keyboardRowC = keyboardRowC;
    }

}
