/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class accountbalance extends javax.swing.JFrame {

    /**
     * Creates new form accountbalance
     */
    public accountbalance() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        account = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD ACCOUNT BALANCE");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 60, 310, 29);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("<Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 30, 50, 20);
        jPanel1.add(account);
        account.setBounds(110, 140, 188, 22);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Account Number");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 110, 130, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Amount");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 170, 100, 20);
        jPanel1.add(amount);
        amount.setBounds(110, 190, 188, 22);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(160, 230, 90, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Show Balance");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 280, 100, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PKR/=");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(180, 280, 60, 20);

        balance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 255, 255));
        balance.setText("0000");
        jPanel1.add(balance);
        balance.setBounds(300, 280, 50, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\bankingSystem-master\\src\\bg2.jpg")); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, -10, 430, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Amount = amount.getText();
        int AmountInt= Integer.parseInt(Amount);
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
        
        //to get the data in jTextfield from Mysql
        String sql ="select accountnumber from account";
        String sql1="select accountbalance from account";
        
        PreparedStatement ptstmt=conn.prepareStatement(sql);
        PreparedStatement ptst=conn.prepareStatement(sql1);
        ResultSet rs= ptstmt.executeQuery(sql);
        
        if(rs.next()){
        account.setText(rs.getString("accountnumber"));
        }else{
        account.setText("");
        }
        ResultSet rs1= ptst.executeQuery(sql1);
        
        if(rs1.next()){
        String accountblc= rs1.getString("accountbalance");
        int totalaccountblc= Integer.parseInt(accountblc) + AmountInt;
        String sql2="update `account` SET `accountbalance`='"+totalaccountblc+"'";
        PreparedStatement ptmt = conn.prepareStatement(sql2);
        ptmt.execute();
        }
        
        conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "error");
        
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
        //to get the data from the account table of balance
        
        String sql= "select accountbalance from account where ID =1";
        
        PreparedStatement ptst= conn.prepareStatement(sql);
        ResultSet rs= ptst.executeQuery(sql);
        if(rs.next()){
        balance.setText(rs.getString("accountbalance"));
        }
        else
        {
            balance.setText("");
        }
        
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "error while establishing connection");
        }
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        
        dashboard obj =new dashboard();
        obj.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(accountbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accountbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accountbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accountbalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accountbalance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account;
    private javax.swing.JTextField amount;
    private javax.swing.JLabel balance;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
