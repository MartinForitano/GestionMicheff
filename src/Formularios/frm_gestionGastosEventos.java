/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import VerificacionDeCadenas.*;
import java.awt.Font;
/**
 *
 * @author Martin
 */
public class frm_gestionGastosEventos extends javax.swing.JFrame {

    public static Integer codigoEvento;
    DefaultTableModel Modelo;
    public static frm_cambioDatosGastos cambioGastos = null;
    public final String user = "root";
    public final String password = "root";

    public frm_gestionGastosEventos(int cod) {
        initComponents();
        codigoEvento = cod;
        setLocationRelativeTo(null);
        cargarComboConceptos();
        CargarInterfaz();
        MostrarDatos();
        calcularGastos(1);
    }

    @Deprecated
    private frm_gestionGastosEventos() {
        initComponents();
        setLocationRelativeTo(null);
        cargarComboConceptos();
        CargarInterfaz();
        MostrarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();

        setTitle("Administracion de gastos");
        setIconImage(getIconImage());
        setResizable(false);

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar, eliminar, actualizar listado de conceptos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton2.setText("Eliminar concepto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton3.setText("Editar concepto");
        jButton3.setPreferredSize(new java.awt.Dimension(125, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton4.setText("Actualizar tabla");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton5.setText("Calcular Gastos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(123, 123, 123)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar nuevo concepto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Gasto");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton1.setText("Agregar concepto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un concepto" }));
        jComboBox1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Concepto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gestion de gastos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Concepto", "Gastos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
        cerrarVentanas();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int pos = jTable1.getSelectedRow(); //empieza en 0
        if (pos != -1) {
            String nom = jTable1.getValueAt(pos, 0).toString();
            float gasto = Float.parseFloat(jTable1.getValueAt(pos, 1).toString());
            int opc = JOptionPane.showConfirmDialog(null, "??Eliminar gasto?");    //0- si 1- no 2- cancelar
            switch (opc) {
                case 0:
                    EliminarDatos(nom, gasto);
                    JOptionPane.showMessageDialog(null, "Gasto eliminado");
                    LimpliarTabla();
                    MostrarDatos();
                    calcularGastos(1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono un elemento a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int pos = jTable1.getSelectedRow(); //empieza en 0
        if (pos != -1) {
            String nom = jTable1.getValueAt(pos, 0).toString();
            if (cambioGastos == null) {
                cambioGastos = new frm_cambioDatosGastos(codigoEvento, traerCodigoConcepto(nom));
            }
            cambioGastos.setVisible(true);
            LimpliarTabla();
            MostrarDatos();
            calcularGastos(1);
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono un elemento a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LimpliarTabla();
        calcularGastos(1);
        MostrarDatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (verificacionDeCadenas.esVacia(jTextField2.getText())) {
            if (jComboBox1.getSelectedIndex() != 0) {
                int opc = JOptionPane.showConfirmDialog(null, "??Desea agregar el concepto?");
                if (opc == 0) {
                    agregarGastoConcepto();
                    limpiarAgregado();
                    LimpliarTabla();
                    calcularGastos(1);
                    MostrarDatos();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escoja un concepto valido", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        calcularGastos(2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        Character tecla = evt.getKeyChar();
        if (!(Character.isDigit(tecla) || tecla.equals('.'))) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

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
            java.util.logging.Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_gestionGastosEventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public void cargarComboConceptos() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from conceptos");
            int i = 1;
            String nom;
            while (rs.next()) {
                nom = rs.getString(2);
                jComboBox1.insertItemAt(nom, i);
                i++;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void CargarInterfaz() {
        String Filas[][] = {};
        String Columnas[] = {"Concepto", "Gastos"};
        Modelo = new DefaultTableModel(Filas, Columnas) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                //columna = cantidad total de columnas
                if (columna == 2) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        jTable1.setFont(Font.getFont("Segoe UI"));
        jTable1.setModel(Modelo);
    }

    public void MostrarDatos() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Object[] datos = new Object[2];
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from costoconcepto where eventos_ideventos = " + codigoEvento);
            while (rs.next()) {
                datos[0] = traerNombreConcepto(rs.getInt(1));
                datos[1] = rs.getFloat(3);
                Modelo.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private String traerNombreConcepto(int codConcepto) {
        Connection con = null;
        Statement st = null;
        String concepto = "";
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from conceptos where idconceptos = " + codConcepto);
            while (rs.next()) {
                concepto = rs.getString(2);
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return concepto;
    }

    private void agregarGastoConcepto() {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            pst = con.prepareStatement("insert into costoconcepto(conceptos_idconceptos,eventos_ideventos,costo) values(?,?,?)");
            pst.setInt(1, traerCodigoConcepto(jComboBox1.getSelectedItem().toString()));
            pst.setInt(2, codigoEvento);
            pst.setFloat(3, Float.parseFloat(jTextField2.getText()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Gasto agregado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ya existe el gasto indicado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un monto valido");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private int traerCodigoConcepto(String nombre) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int retorno = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from conceptos where descripcion = '" + nombre + "'");
            while (rs.next()) {
                retorno = rs.getInt(1);
            }

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }

    public void LimpliarTabla() {
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    private void EliminarDatos(String nom, float gasto) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            pst = con.prepareStatement("delete from costoconcepto where conceptos_idconceptos  = ? && eventos_ideventos = ?");
            pst.setInt(1, traerCodigoConcepto(nom));
            pst.setInt(2, codigoEvento);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void limpiarAgregado() {
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
    }

    public void calcularGastos(int opc) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        float sumatoria = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            st = con.createStatement();
            rs = st.executeQuery("select * from costoconcepto where eventos_ideventos = " + codigoEvento);
            while (rs.next()) {
                sumatoria = sumatoria + rs.getFloat(3);
            }
            cargarGastos(sumatoria);
            if (opc == 2) {
                JOptionPane.showMessageDialog(null, "Los gastos del evento son $" + sumatoria);
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void cargarGastos(float gasto) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_michef", user, password);
            st = con.prepareStatement("update eventos set costo = ? where ideventos = ?");
            st.setFloat(1, gasto);
            st.setInt(2, codigoEvento);
            st.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frm_cambioDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frm_cambioDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(frm_gestionGastosEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void cerrarVentanas() {
        if (cambioGastos != null) {
            cambioGastos.dispose();
            cambioGastos = null;
        }
    }

    public Image getIconImage() {
        Image setValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Recorte.png"));
        return setValue;
    }
}
