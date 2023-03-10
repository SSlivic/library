/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagementsystem;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * @author Sanja
 */
public class Member extends javax.swing.JFrame {

    /**
     * Creates new form Member
     */
    public Member() {
        initComponents();
        Connect();
        Member_Load();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root","");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void Member_Load(){
    int m;
        try {
            pst=con.prepareStatement("select * from member");
            rs=pst.executeQuery();
            ResultSetMetaData rsd=rs.getMetaData();
            m=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)MemberTable.getModel();
            d.setRowCount(0);
            
            while(rs.next()){
            Vector v2=new Vector();
            
            for (int i=1;i<=m;i++){
            v2.add(rs.getString("id"));
            v2.add(rs.getString("memberID"));
            v2.add(rs.getString("memberName"));
            v2.add(rs.getString("memberPhone"));
            v2.add(rs.getString("memberEmail"));
            }
            d.addRow(v2);
        
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txtMember = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JLabel();
        txtMemberName = new javax.swing.JLabel();
        txtMemberEmail = new javax.swing.JLabel();
        txtMemberPhone = new javax.swing.JLabel();
        inputMemberID = new javax.swing.JTextField();
        inputMemberName = new javax.swing.JTextField();
        inputMemberPhone = new javax.swing.JTextField();
        inputMemberEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MemberTable = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMember.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMember.setText("Member");

        txtMemberID.setText("Member ID");

        txtMemberName.setText("Member name");

        txtMemberEmail.setText("Member e-mail");

        txtMemberPhone.setText("Member phone ");

        MemberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Member ID", "Member name", "Member phone", "Member e-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        MemberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MemberTable);

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMemberPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMemberID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMemberName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtMemberEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAdd)
                            .addComponent(buttonDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCancel)
                            .addComponent(buttonUpdate)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputMemberEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(inputMemberID)
                                .addComponent(inputMemberName)
                                .addComponent(inputMemberPhone)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(txtMember)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemberID)
                    .addComponent(inputMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMemberPhone)
                    .addComponent(inputMemberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemberEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMemberEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonUpdate))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDelete)
                    .addComponent(buttonCancel)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtMember)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
      try{ 
        String mID=inputMemberID.getText();
        int mIDn=Integer.parseInt(mID);
        String mName=inputMemberName.getText();
        
        String mPhone=inputMemberPhone.getText();
           int mPhonen=Integer.parseInt(mPhone);

        String mEmail=inputMemberEmail.getText();

        if(("".equals(mID) )|| ("".equals(mName) ) || ("".equals(mPhone) ) || ("".equals(mEmail) )){
                       JOptionPane.showMessageDialog(this, "Input all fields!");

        }
        
     
        
            pst=con.prepareStatement("insert into member(memberID,memberName,memberPhone,memberEmail)values(?,?,?,?)");
            
            pst.setString(1, mID);
            pst.setString(2,mName);
            pst.setString(3,mPhone);
            pst.setString(4,mEmail);
           int k= pst.executeUpdate();
           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Member Added!");
           inputMemberID.setText("");
           inputMemberName.setText("");
           inputMemberPhone.setText("");
           inputMemberEmail.setText("");
           inputMemberID.requestFocus();
           
           Member_Load();
         
           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
                          JOptionPane.showMessageDialog(this, "Wrong input!");

        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void MemberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberTableMouseClicked
        // TODO add your handling code here:
        
                    DefaultTableModel d1=(DefaultTableModel)MemberTable.getModel();
                    int selectindex=MemberTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
                    inputMemberID.setText(d1.getValueAt(selectindex,1).toString());
                    inputMemberName.setText(d1.getValueAt(selectindex,2).toString());

                    inputMemberPhone.setText(d1.getValueAt(selectindex,3).toString());

                    inputMemberEmail.setText(d1.getValueAt(selectindex,4).toString());

//MemberTable.setEnabled(false);

    }//GEN-LAST:event_MemberTableMouseClicked

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
         DefaultTableModel d1=(DefaultTableModel)MemberTable.getModel();
                    int selectindex=MemberTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
        
        String mID=inputMemberID.getText();
        String mName=inputMemberName.getText();
        String mPhone=inputMemberPhone.getText();
        String mEmail=inputMemberEmail.getText();
        
        try {
            pst=con.prepareStatement("update member set memberID=?,memberName=?,memberPhone=?,memberEmail=? where id=?");
            pst.setString(1,mID);
            pst.setString(2,mName);
            pst.setString(3,mPhone);
            pst.setString(4, mEmail);
            pst.setInt(5, id);

           int k= pst.executeUpdate();
           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Member Updated!");
           inputMemberID.setText("");
           inputMemberName.setText("");
           inputMemberPhone.setText("");
           inputMemberEmail.setText("");
           inputMemberID.requestFocus();
           MemberTable.setEnabled(true);
           
           Member_Load();
           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
    
         DefaultTableModel d1=(DefaultTableModel)MemberTable.getModel();
                    int selectindex=MemberTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
        try {
            pst=con.prepareStatement("delete from member where id=?");
            
            pst.setInt(1,id);
            
           int k= pst.executeUpdate();
           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Member Deleted");
           inputMemberID.setText("");
           inputMemberName.setText("");
           inputMemberPhone.setText("");
           inputMemberEmail.setText("");
           inputMemberID.requestFocus();
           
           Member_Load();
                    MemberTable.setEnabled(true);

           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MemberTable;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JTextField inputMemberEmail;
    private javax.swing.JTextField inputMemberID;
    private javax.swing.JTextField inputMemberName;
    private javax.swing.JTextField inputMemberPhone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtMember;
    private javax.swing.JLabel txtMemberEmail;
    private javax.swing.JLabel txtMemberID;
    private javax.swing.JLabel txtMemberName;
    private javax.swing.JLabel txtMemberPhone;
    // End of variables declaration//GEN-END:variables
}
