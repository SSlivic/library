/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagementsystem;

import java.awt.event.KeyEvent;
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * @author Sanja
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form Member
     */
    public ReturnBook() {
        initComponents();
        Connect();
        
        ReturnBook_Load();
       
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root","");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void ReturnBook_Load(){
        
        
    int rb;
        try {
            pst=con.prepareStatement("select*from returnbook");
            rs=pst.executeQuery();
            ResultSetMetaData rsd=rs.getMetaData();
            rb=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)ReturnBookTable.getModel();
            d.setRowCount(0);
            
            
            while(rs.next()){
            Vector v2=new Vector();
            
            for (int i=1;i<=rb;i++){
            v2.add(rs.getString("id"));
             v2.add(rs.getString("mmbrid"));
            v2.add(rs.getString("mmbrname"));
            v2.add(rs.getString("bookname"));
            v2.add(rs.getString("returndate"));
            v2.add(rs.getString("dayselapsed"));
            v2.add(rs.getString("fine"));

            }
            d.addRow(v2);
        
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
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

        inputRtrnDate = new javax.swing.JPanel();
        txtIssueBook = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JLabel();
        txtMemberName = new javax.swing.JLabel();
        txtBookName = new javax.swing.JLabel();
        inputmmbrID = new javax.swing.JTextField();
        inputmmbrName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReturnBookTable = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        inputDaysElapsed = new javax.swing.JTextField();
        inputFine = new javax.swing.JTextField();
        txtDaysElapsed = new javax.swing.JLabel();
        txtFine = new javax.swing.JLabel();
        txtReturnDate = new javax.swing.JLabel();
        inputbName = new javax.swing.JTextField();
        inputReturnDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtIssueBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIssueBook.setText("Return Book");

        txtMemberID.setText("Member ID");

        txtMemberName.setText("Member name");

        txtBookName.setText("Book name");

        inputmmbrID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputmmbrIDKeyPressed(evt);
            }
        });

        ReturnBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Member ID", "Member name", "Book  name", "Return date", "Days elapsed", "fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ReturnBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnBookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ReturnBookTable);

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
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

        txtDaysElapsed.setText("Days elapsed");

        txtFine.setText("Fine");

        txtReturnDate.setText("Return date");

        inputbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputbNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputRtrnDateLayout = new javax.swing.GroupLayout(inputRtrnDate);
        inputRtrnDate.setLayout(inputRtrnDateLayout);
        inputRtrnDateLayout.setHorizontalGroup(
            inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputRtrnDateLayout.createSequentialGroup()
                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputRtrnDateLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(inputRtrnDateLayout.createSequentialGroup()
                                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMemberID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMemberName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonAdd)
                                    .addComponent(buttonDelete)
                                    .addComponent(txtReturnDate))
                                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(inputRtrnDateLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inputmmbrName, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                            .addComponent(inputmmbrID, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                            .addComponent(inputbName)))
                                    .addGroup(inputRtrnDateLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(buttonCancel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputRtrnDateLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(inputReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(inputRtrnDateLayout.createSequentialGroup()
                                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFine)
                                    .addComponent(txtDaysElapsed))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputDaysElapsed, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(inputFine))))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputRtrnDateLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(txtIssueBook)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        inputRtrnDateLayout.setVerticalGroup(
            inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputRtrnDateLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtIssueBook)
                .addGap(18, 18, 18)
                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inputRtrnDateLayout.createSequentialGroup()
                        .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputRtrnDateLayout.createSequentialGroup()
                                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMemberID)
                                    .addComponent(inputmmbrID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputmmbrName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBookName)
                                    .addComponent(inputbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                            .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtReturnDate)
                                .addComponent(inputReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDaysElapsed)
                            .addComponent(inputDaysElapsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFine))
                        .addGap(18, 18, 18)
                        .addComponent(buttonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputRtrnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonDelete)
                            .addComponent(buttonCancel))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputRtrnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputRtrnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
     try{  
       String mmbrid =inputmmbrID.getText();
       int mmbridn=Integer.parseInt(mmbrid);
       String mmbrname=inputmmbrName.getText();
       String bookname=inputbName.getText();
       String returndate=inputReturnDate.getText();
       String daysElap=inputDaysElapsed.getText();
       String fn=inputFine.getText();
        
        
      
            pst=con.prepareStatement("insert into returnbook(mmbrid,mmbrname,bookname,returndate,dayselapsed,fine)values(?,?,?,?,?,?)");
            
            pst.setString(1, mmbrid);
            pst.setString(2,mmbrname);
            pst.setString(3,bookname);
            pst.setString(4,returndate);
            pst.setString(5,daysElap);
            pst.setString(6,fn);


           
           int k= pst.executeUpdate();
           pst=con.prepareStatement("delete from issuebook where memberid=?");
           
            pst.setString(1, mmbrid);
            pst.executeUpdate();

           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Book is returned!");
           inputmmbrID.setText("");
           inputmmbrName.setText("");
           inputbName.setText("");
           inputReturnDate.setText("");
            inputDaysElapsed.setText("");
            inputFine.setText("");
           
           inputmmbrID.requestFocus();
           ReturnBook_Load();
         
           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
      catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Wrong input!");
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void ReturnBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBookTableMouseClicked
        // TODO add your handling code here:
        
                    DefaultTableModel d1=(DefaultTableModel)ReturnBookTable.getModel();
                    int selectindex=ReturnBookTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
                    inputmmbrID.setText(d1.getValueAt(selectindex,1).toString());
                    inputmmbrName.setText(d1.getValueAt(selectindex,2).toString());
                  inputbName.setText(d1.getValueAt(selectindex,3).toString());
                  
         



//ReturnBookTable.setEnabled(false);

    }//GEN-LAST:event_ReturnBookTableMouseClicked
/**/
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
    
         DefaultTableModel d1=(DefaultTableModel)ReturnBookTable.getModel();
                    int selectindex=ReturnBookTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
        try {
            pst=con.prepareStatement("delete from returnbook where id=?");
            
            pst.setInt(1,id);
            
           int k= pst.executeUpdate();
           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Returned book deleted");
           inputmmbrID.setText("");
           inputmmbrName.setText("");
           inputbName.setText("");
          
           inputmmbrID.requestFocus();
           
           ReturnBook_Load();
                    ReturnBookTable.setEnabled(true);

           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void inputmmbrIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputmmbrIDKeyPressed
        // TODO add your handling code here:
              if(evt.getKeyCode()== KeyEvent.VK_ENTER){

        String id=inputmmbrID.getText();
        
        try {
            pst=con.prepareStatement("select m.memberName,b.bookName,ib.returnDate,DATEDIFF(now(),ib.returnDate) as elap from issuebook ib JOIN member m ON m.memberID=ib.memberid JOIN book b ON ib.bookid=b.id and ib.memberid=?");
            pst.setString(1,id);
            rs=pst.executeQuery();
            
            if(rs.next()==false){
            JOptionPane.showMessageDialog(this,"Member ID not found!");
            
            }
            else{
                String mbName=rs.getString("m.memberName");
                String bkName=rs.getString("b.bookName");
                
                inputmmbrName.setText(mbName.trim());
                inputbName.setText(bkName.trim());
                
                String rdate=rs.getString("ib.returnDate");
                inputReturnDate.setText(rdate);
                
                String elapsed=rs.getString("elap");
                
                int elapsedDays=Integer.parseInt(elapsed);
                
                if(elapsedDays>0){
                    
                inputDaysElapsed.setText(elapsed);
                double fine=0.5*elapsedDays;
                inputFine.setText(String.valueOf(fine));
                
                
                }
                else{
                inputDaysElapsed.setText("0");
                inputFine.setText("0");
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
              }
        
    }//GEN-LAST:event_inputmmbrIDKeyPressed

    private void inputbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputbNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputbNameActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ReturnBookTable;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JTextField inputDaysElapsed;
    private javax.swing.JTextField inputFine;
    private javax.swing.JTextField inputReturnDate;
    private javax.swing.JPanel inputRtrnDate;
    private javax.swing.JTextField inputbName;
    private javax.swing.JTextField inputmmbrID;
    private javax.swing.JTextField inputmmbrName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtBookName;
    private javax.swing.JLabel txtDaysElapsed;
    private javax.swing.JLabel txtFine;
    private javax.swing.JLabel txtIssueBook;
    private javax.swing.JLabel txtMemberID;
    private javax.swing.JLabel txtMemberName;
    private javax.swing.JLabel txtReturnDate;
    // End of variables declaration//GEN-END:variables
}
