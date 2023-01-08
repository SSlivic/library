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
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form Member
     */
    public IssueBook() {
        initComponents();
        Connect();
        book();
        IssueBook_Load();
       
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root","");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public class BookItem {
    int id;
    String name;
    
    public BookItem(int id,String name){
    this.id=id;
    this.name=name;
    
    }
    public String toString(){
    return name;
    }
    
    }
    
    public void book(){
    
        try {
        pst=con.prepareStatement("select * from book");
        rs=pst.executeQuery();
        inputBookName.removeAllItems();
        
        while(rs.next()){
        inputBookName.addItem(new BookItem(rs.getInt(1),rs.getString(2)));
        }
        }
        catch
        (SQLException ex){
        Logger.getLogger(BookItem.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public void IssueBook_Load(){
        
        
                String mmbname=inputmemberName.getText();

    int ib;
        try {
            pst=con.prepareStatement("Select tb1.*, tb2.memberName from issuebook tb1 JOIN member tb2 on tb1.memberId = tb2.memberID");
            rs=pst.executeQuery();
            ResultSetMetaData rsd=rs.getMetaData();
            ib=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)IssueBookTable.getModel();
            d.setRowCount(0);
            
            
            while(rs.next()){
            Vector v2=new Vector();
            
            for (int i=1;i<=ib;i++){
            v2.add(rs.getString("tb1.id"));
             v2.add(rs.getString("tb1.memberid"));
            v2.add(rs.getString("tb2.memberName"));
            v2.add(rs.getString("tb1.bookname"));
            v2.add(rs.getString("tb1.date"));
            v2.add(rs.getString("tb1.returnDate"));
            }
            d.addRow(v2);
        
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
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
        txtIssueBook = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JLabel();
        txtMemberName = new javax.swing.JLabel();
        txtBookName = new javax.swing.JLabel();
        inputmemberID = new javax.swing.JTextField();
        inputmemberName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        IssueBookTable = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        inputIssueDate = new com.toedter.calendar.JDateChooser();
        inputReturnDate = new com.toedter.calendar.JDateChooser();
        inputBookName = new javax.swing.JComboBox();
        txtDate = new javax.swing.JLabel();
        txtReturnDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtIssueBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIssueBook.setText("Issue book");

        txtMemberID.setText("Member ID");

        txtMemberName.setText("Member name");

        txtBookName.setText("Book name");

        inputmemberID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputmemberIDKeyPressed(evt);
            }
        });

        IssueBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Member ID", "Member name", "Book  name", "Date", "Return date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        IssueBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IssueBookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(IssueBookTable);

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

        inputBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBookNameActionPerformed(evt);
            }
        });

        txtDate.setText("Date");

        txtReturnDate.setText("Return date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMemberID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMemberName, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(buttonAdd)
                            .addComponent(buttonDelete)
                            .addComponent(txtReturnDate)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputmemberName, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(inputmemberID, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(inputIssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputReturnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputBookName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonCancel)
                                    .addComponent(buttonUpdate))))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(txtIssueBook)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtIssueBook)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMemberID)
                            .addComponent(inputmemberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputmemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBookName)
                            .addComponent(inputBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtReturnDate))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAdd)
                            .addComponent(buttonUpdate))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonDelete)
                            .addComponent(buttonCancel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
      try{ 
        String mbID=inputmemberID.getText();
        int mbIDn=Integer.parseInt(mbID);

        //String bName=(String)inputBookName.getSelectedItem();
        BookItem  bitem=(BookItem)inputBookName.getSelectedItem();
       
        SimpleDateFormat date_format=new SimpleDateFormat("yyyy-MM-dd");
        String issuedate=date_format.format(inputIssueDate.getDate());
        
         SimpleDateFormat date_format_return=new SimpleDateFormat("yyyy-MM-dd");
        String returndate=date_format_return.format(inputReturnDate.getDate());
        
        
        
        
            pst=con.prepareStatement("insert into issuebook(memberid,bookid,bookname,date,returnDate)values(?,?,?,?,?)");
            
            pst.setString(1, mbID);
            pst.setInt(2,bitem.id);
            pst.setString(3,bitem.name);
            pst.setString(4,issuedate);
            pst.setString(5,returndate);

           
           int k= pst.executeUpdate();
           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Book Issued!");
           inputmemberID.setText("");
           inputmemberName.setText("");
           inputBookName.setSelectedIndex(-1);
           
          // inputIssueDate.setText("");
      //     inputReturnDate.setText("");
           
           inputmemberID.requestFocus();
           
           IssueBook_Load();
         
           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Wrong input!");
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void IssueBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IssueBookTableMouseClicked
        // TODO add your handling code here:
        
                    DefaultTableModel d1=(DefaultTableModel)IssueBookTable.getModel();
                    int selectindex=IssueBookTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
                    inputmemberID.setText(d1.getValueAt(selectindex,1).toString());
                    inputmemberName.setText(d1.getValueAt(selectindex,2).toString());

                    inputBookName.setSelectedItem(d1.getValueAt(selectindex,3).toString());


//IssueBookTable.setEnabled(false);

    }//GEN-LAST:event_IssueBookTableMouseClicked

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
         DefaultTableModel d1=(DefaultTableModel)IssueBookTable.getModel();
                    int selectindex=IssueBookTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
        
        String mbID=inputmemberID.getText();
        String mbname=inputmemberName.getText();
        //String bName=(String)inputBookName.getSelectedItem();
        BookItem  bitem=(BookItem)inputBookName.getSelectedItem();
       
        SimpleDateFormat date_format=new SimpleDateFormat("yyyy-MM-dd");
        String issuedate=date_format.format(inputIssueDate.getDate());
        
         SimpleDateFormat date_format_return=new SimpleDateFormat("yyyy-MM-dd");
        String returndate=date_format_return.format(inputReturnDate.getDate());
        
        try {
            pst=con.prepareStatement("update issuebook set memberid=?,bookid=?,bookname=?,date=?,returndate=? where id=?");
           
            pst.setString(1,mbID);

            pst.setInt(2,bitem.id);
            pst.setString(3,bitem.name);
            pst.setString(4,issuedate);
            pst.setString(5,returndate);
            
            
            pst.setInt(6, id);

           int k= pst.executeUpdate();
           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Issue book Updated!");
           inputmemberID.setText("");
           inputmemberName.setText("");
           inputBookName.setSelectedItem("");
           
           inputmemberID.requestFocus();
           IssueBookTable.setEnabled(true);
           
           IssueBook_Load();
           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
    
         DefaultTableModel d1=(DefaultTableModel)IssueBookTable.getModel();
                    int selectindex=IssueBookTable.getSelectedRow();
                    int id=Integer.parseInt(d1.getValueAt(selectindex,0).toString());
        try {
            pst=con.prepareStatement("delete from issuebook where id=?");
            
            pst.setInt(1,id);
            
           int k= pst.executeUpdate();
           
           if(k==1)
           {
           JOptionPane.showMessageDialog(this, "Member Deleted");
           inputmemberID.setText("");
           inputmemberName.setText("");
           inputBookName.setSelectedItem("");
          
           inputmemberID.requestFocus();
           
           IssueBook_Load();
                    IssueBookTable.setEnabled(true);

           }
           else{
              JOptionPane.showMessageDialog(this, "Error!");

           }
        
        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void inputmemberIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputmemberIDKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
        
        String mid=inputmemberID.getText();
            try {
                pst= con.prepareStatement("select * from member where memberID=?");
                pst.setString(1,mid);
                rs=pst.executeQuery();
                
                if(rs.next()==false){
                
                    JOptionPane.showMessageDialog(this,"Member ID not found!");
                
                }
                else{
                String membername=rs.getString("memberName");
                inputmemberName.setText(membername.trim());
                
                
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }//GEN-LAST:event_inputmemberIDKeyPressed

    private void inputBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputBookNameActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IssueBookTable;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox inputBookName;
    private com.toedter.calendar.JDateChooser inputIssueDate;
    private com.toedter.calendar.JDateChooser inputReturnDate;
    private javax.swing.JTextField inputmemberID;
    private javax.swing.JTextField inputmemberName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtBookName;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtIssueBook;
    private javax.swing.JLabel txtMemberID;
    private javax.swing.JLabel txtMemberName;
    private javax.swing.JLabel txtReturnDate;
    // End of variables declaration//GEN-END:variables
}
