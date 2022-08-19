/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package swingcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author Caiao O Brabo-PC
 */
public class cadastrar extends javax.swing.JFrame {

    /**
     * Creates new form Crud
     */
    Connection con;
    Statement st;
    ArrayList<User> students = new ArrayList<>();

    public cadastrar() {
        initComponents();
        fetch();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JToggleButton();
        Sair = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setText("Cadastrar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 250, 60));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Nome");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 60, 20));

        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 300, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Sobrenome");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 110, 20));
        getContentPane().add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 300, 30));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 300, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("RGM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 110, 20));

        Cadastrar.setBackground(new java.awt.Color(0, 204, 204));
        Cadastrar.setText("Cadastrar ➕");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(Cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 370, 310, 30));

        Sair.setBackground(new java.awt.Color(204, 0, 0));
        Sair.setText("Sair ↪");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        getContentPane().add(Sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 80, 30));

        jToggleButton1.setBackground(new java.awt.Color(0, 51, 255));
        jToggleButton1.setText("Voltar ↩");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swingcrud/imagem/funddo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sobrenome", "RGM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 250, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_SairActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
       // TODO add your handling code here:
        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String id = txtId.getText().trim();
        
        if (!fname.isEmpty() && !lname.isEmpty() && !id.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
                String sql = "select * from student where id_number='" + id + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (!rs.next()) {
                  saveUser(fname, lname, id);
                    DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
                    Object[] row = new Object[4];
                    row[0] = fname;
                    row[1] = lname;
                    row[2] = id;
                    model.addRow(row); 
                    alert("Cadastrado com sucesso");
                } else {
                    alert("Erro ao cadastrar, Id Parecido", "Id parecido");
                }

                clear();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //        else if (!id.matches("^[0-9]{8}$")) {
        //            alert("please provide a valid id number", "Wrong id");
        //        } 
        else {
            alert("por favor preencha todos os detalhes");
        }
                   
    }//GEN-LAST:event_CadastrarActionPerformed

    private void txtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameActionPerformed

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
        // TODO add your handling code here:
        int i = tblStudents.getSelectedRow();
        TableModel model = tblStudents.getModel();
        txtFname.setText(model.getValueAt(i, 0).toString());
        txtLname.setText(model.getValueAt(i, 1).toString());
        txtId.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_tblStudentsMouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        login pacesso = new login();
        pacesso.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Cadastrar;
    private javax.swing.JToggleButton Sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLname;
    // End of variables declaration//GEN-END:variables

    private void fetch() {
         students.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            String sql = "select * from student";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                User user = new User(rs.getString("fname"), rs.getString("lname"), rs.getString("id_number"));
                students.add(user);
            }
            DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
            students.stream().map(user -> {
                Object[] row = new Object[4];
                row[0] = user.getFname();
                row[1] = user.getLname();
                row[2] = user.getId();
                return row;
            }).forEachOrdered(row -> {
                model.addRow(row);
            });

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveUser(String fname, String lname, String id) {
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            String sql = "INSERT INTO `student`(`fname`, `lname`, `id_number`) "
                    + "VALUES ('" + fname + "','" + lname + "','" + id + "')";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }
    
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    private void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
