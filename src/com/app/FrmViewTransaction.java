package com.app;

import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrmViewTransaction extends javax.swing.JFrame {

    public FrmViewTransaction() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.viewTable();
        
        GenerateID();
        Staff();
        Client();
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String date = f.format(new Date());
        
        this.txtDate.setText(date);
    }
    
    public void viewTable(){
        if (SQLite.openDB()) {
            String[][] data = SQLite.read("tblTransaction1");
            String[] column = {"Transaction ID", "Date", "Staff ID", "Client ID"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblTransaction.setModel(model);
            SQLite.closeDB();
        }
    }
    
    private void GenerateID(){
        try{
            SQLite.conn = getConnection(SQLite.url);
            SQLite.stmt = SQLite.conn.createStatement();
            String query = "select * from tblTransaction1";

            ResultSet rs = SQLite.stmt.executeQuery(query);
            int genID = 1;
            while(rs.next()){
                int id= Integer.parseInt(rs.getString("id"));
                
                genID = id+1;
//                this.txtID.setText(String.valueOf(genID));
            }
            if(genID == 1){
                this.txtID.setText(String.valueOf(genID));
            }else{
                this.txtID.setText(String.valueOf(genID));
            }
       }
       catch(Exception e){
           System.out.println("error: " + e.getMessage());
       }
    }
    
    private void Staff(){
       try{
            SQLite.conn = getConnection(SQLite.url);
            SQLite.stmt = SQLite.conn.createStatement();
            String query = "select * from tblstaff";

            ResultSet rs = SQLite.stmt.executeQuery(query);
            while(rs.next()){
                String name= rs.getString("fname");
                this.cbStaff.addItem(name);
            }
       }
       catch(Exception e){
           System.out.println("error: " + e.getMessage());
       }
    }
    
//    private void Customer(){
//       String search = cbCustomer.getSelectedItem().toString();
//       try{
//            SQLite.conn = getConnection(SQLite.url);
//            SQLite.stmt = SQLite.conn.createStatement();
//            String query = "select * from customer where id=" + search;
//
//            ResultSet rs = SQLite.stmt.executeQuery(query);
//            while(rs.next()){
//                String CusFname= rs.getString("CusFname");
//                String CusLname = rs.getString("CusLname");
//                txtCusFname.setText(CusFname);
//                txtCusLname.setText(CusLname);
//            }
//       }
//       catch(Exception e){
//           System.out.println("ComboBox Error Customer: " + e.getMessage());
//       }
//    }
//    
//    private void Cashier(){
//       String search = cbCashier.getSelectedItem().toString();
//       try{
//            SQLite.conn = getConnection(SQLite.url);
//            SQLite.stmt = SQLite.conn.createStatement();
//            String query = "select * from cashier where id=" + search;
//
//            ResultSet rs = SQLite.stmt.executeQuery(query);
//            while(rs.next()){
//                String CFname= rs.getString("CFname");
//                String CLname = rs.getString("CLname");
//                txtCFname.setText(CFname);
//                txtCLname.setText(CLname);
//            }
//       }
//       catch(Exception e){
//           System.out.println("ComboBox Error Cashier: " + e.getMessage());
//       }
//    }
    
    private void Client(){
       try{
            SQLite.conn = getConnection(SQLite.url);
            SQLite.stmt = SQLite.conn.createStatement();
            String query = "select * from tblClient";

            ResultSet rs = SQLite.stmt.executeQuery(query);
            while(rs.next()){
                String name= rs.getString("fname");
                this.cbClient.addItem(name);
            }
       }
       catch(Exception e){
           System.out.println("error: " + e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        txtID_delete = new javax.swing.JTextField();
        btnViewCars = new javax.swing.JButton();
        txtID_view = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        cbStaff = new javax.swing.JComboBox<>();
        cbClient = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTransaction.setEnabled(false);
        jScrollPane1.setViewportView(tblTransaction);

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setForeground(new java.awt.Color(204, 204, 204));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnViewCars.setBackground(new java.awt.Color(0, 255, 102));
        btnViewCars.setText("View");
        btnViewCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCarsActionPerformed(evt);
            }
        });

        txtID_view.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaction ID");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Transaction ID");

        jLabel5.setText("Staff ID");

        cbStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStaffActionPerformed(evt);
            }
        });

        cbClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        jLabel4.setText("Date");

        jLabel6.setText("Client ID");

        txtDate.setEnabled(false);

        btnSubmit.setBackground(new java.awt.Color(153, 255, 255));
        btnSubmit.setText("Add Transaction");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        txtID.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("New Transaction");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID_delete)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnViewCars, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID_view, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbClient, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDate)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSubmit)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID_view, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewCars, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(txtID_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try{
           if(SQLite.openDB()){
               String[][] r = SQLite.read1("tblTransaction1", "id =" + this.txtID_delete.getText());
               if(r.length > 0){
                   
                if(SQLite.delete("tblTransaction1", Integer.parseInt(this.txtID_delete.getText()))){
                    SQLite.delete1("tblTransactionDetails1", "transactionno = " + Integer.parseInt(this.txtID_delete.getText()));
                 javax.swing.JOptionPane.showMessageDialog(null, "Transaction has been deleted!");
                 
                 }
                 else{
                     javax.swing.JOptionPane.showMessageDialog(null, "Delete Error!");
                 }
               }
               else{
                   javax.swing.JOptionPane.showMessageDialog(null, "Cannot find Transaction ID");
               }
            }
           viewTable();
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Cannot find Transaction ID");
        }
        this.txtID_delete.setText("");
         SQLite.closeDB();
    }//GEN-LAST:event_btnDeleteActionPerformed
public static int Tid;public static int transactionid;
    private void btnViewCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCarsActionPerformed
        try{
           if(SQLite.openDB()){
               String[][] r = SQLite.read1("tblTransaction1", "id =" + this.txtID_view.getText());
               if(r.length > 0){
               transactionid = Integer.parseInt(this.txtID_view.getText());
        
               FrmViewCars m = new FrmViewCars();
               m.setVisible(true);
               dispose();
               }
               else{
                   javax.swing.JOptionPane.showMessageDialog(null, "Cannot find Transaction ID");
               }
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Cannot find Transaction ID");
        }
        this.txtID_view.setText("");
         SQLite.closeDB();
    }//GEN-LAST:event_btnViewCarsActionPerformed

    private void cbStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStaffActionPerformed

    private void cbClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClientActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if(SQLite.openDB()){
            try{
                SQLite.conn = getConnection(SQLite.url);
                SQLite.stmt = SQLite.conn.createStatement();
                String query = "select id from tblstaff where fname='" + this.cbStaff.getSelectedItem() + "'";

                int Staffid = 0;
                int Clientid = 0;
                ResultSet rs = SQLite.stmt.executeQuery(query);
                while(rs.next()){
                    String name= rs.getString("id");
                    Staffid = Integer.parseInt(name);
                }

                String q = "select id from tblclient where fname='" + this.cbClient.getSelectedItem() + "'";

                ResultSet rss = SQLite.stmt.executeQuery(q);
                while(rss.next()){
                    String name= rss.getString("id");
                    Clientid = Integer.parseInt(name);
                }

                String date = this.txtDate.getText();
                int staff = Staffid;
                int client = Clientid;

                String values = "'" + date + "','"+ staff + "','" + client + "'";
                String set = "date, staffid, clientid";

                SQLite.create("tblTransaction1", set, values);
                javax.swing.JOptionPane.showMessageDialog(null, "New Transaction has been created!");
                GenerateID();
                this.viewTable();
            }
            catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null, "Create Error: " + e.getMessage());
            }

            SQLite.closeDB();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(FrmViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmViewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmViewTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewCars;
    private javax.swing.JComboBox<String> cbClient;
    private javax.swing.JComboBox<String> cbStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID_delete;
    private javax.swing.JTextField txtID_view;
    // End of variables declaration//GEN-END:variables
}
