
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;


public class FrmHome extends javax.swing.JFrame {
    DefaultTableModel tabling = new DefaultTableModel();
    
    
    public FrmHome() {
        initComponents();
        
        tabling.addColumn("ID");
        tabling.addColumn("DESCRIPCION");
        tabling.addColumn("PRECIO");
        tabling.addColumn("EXISTENCIAS");
        
        setLocationRelativeTo(null);
        
        jTable1.setModel(tabling);
        consulta("");
        
        setBackground(new Color(0,0,0,0));
    }
    
    private void mensaje(String a){
        showMessageDialog(this, a);
    }
    
    public void consulta(String where){
        try{
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.105:3306/practica1", "DESKTOP-6HGS2H6", "");
            
            Statement S = conexion.createStatement();
            
            String SQL = "SELECT * FROM `PRODUCTOS`";
            
            if(!where.isEmpty()){
                SQL += "" + where;
            }
            
            
            ResultSet resultadoConsulta = S.executeQuery(SQL);
            
            if(tabling.getRowCount() != 0){
                int total = tabling.getRowCount();
                for(int i = 1; i <= total; i++){
                    tabling.removeRow(0);
                }
            }
            
            while(resultadoConsulta.next()){
                String[] data = new String[4];
                data[0] = "" + resultadoConsulta.getInt(1);
                data[1] = resultadoConsulta.getString(2);
                data[2] = resultadoConsulta.getString(3);
                data[3] = resultadoConsulta.getString(4);
                
                tabling.addRow(data);
            }
            
            conexion.close();
        }catch(Exception e){
            mensaje("Excepción: " + e.getMessage());
        }
    }
    
    private boolean estaSeleccionada(){
        if(jTable1.getSelectedRow() >= 0){
            return true;
        }
        return false;
    }
    
    private void eliminar(String ID){
        try{
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.105:3306/practica1", "DESKTOP-6HGS2H6", "");
            
            Statement S = conexion.createStatement();
            
            String SQL = "DELETE FROM `PRODUCTOS` WHERE ID = " + ID;
            
            int resultado = S.executeUpdate(SQL);
            
            if(resultado == 0){
                mensaje("Advertencia: No se elimino el ID" + ID);
            }else{
                mensaje("Se borro con exito el ID" + ID);
            }
            
            conexion.close();
        }catch(Exception e){
            mensaje("Excepción: " + e.getMessage());
        }
        
        
        consulta("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbColumna = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        ckbMostrar = new javax.swing.JCheckBox();
        pHeader = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        lSalir = new javax.swing.JLabel();
        pOptions = new javax.swing.JPanel();
        btnDelete = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnModify = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnRefresh = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        pBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 911, 425));

        jLabel1.setText("Clave:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 165, -1));

        jLabel2.setText("Buscar en:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        cmbColumna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "DESCRIPCION", "PRECIO", "EXISTENCIAS" }));
        getContentPane().add(cmbColumna, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 145, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 105, 62));

        ckbMostrar.setText("Mostrar todos");
        ckbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(ckbMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        pHeader.setBackground(new java.awt.Color(25, 25, 25));

        lTitulo.setFont(new java.awt.Font("Comfortaa", 0, 24)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo.setText("Productos");

        lSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/icons8_exit_50px.png"))); // NOI18N
        lSalir.setToolTipText("");
        lSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pHeaderLayout = new javax.swing.GroupLayout(pHeader);
        pHeader.setLayout(pHeaderLayout);
        pHeaderLayout.setHorizontalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 723, Short.MAX_VALUE)
                .addComponent(lSalir)
                .addGap(19, 19, 19))
        );
        pHeaderLayout.setVerticalGroup(
            pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lSalir)
                    .addComponent(lTitulo))
                .addGap(20, 20, 20))
        );

        getContentPane().add(pHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 70));

        pOptions.setBackground(new java.awt.Color(25, 25, 25));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/icons8_delete_document_50px.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/icons8_add_50px.png"))); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/icons8_edit_property_50px.png"))); // NOI18N
        btnModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModifyMouseClicked(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfx/icons8_refresh_50px.png"))); // NOI18N
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pOptionsLayout = new javax.swing.GroupLayout(pOptions);
        pOptions.setLayout(pOptionsLayout);
        pOptionsLayout.setHorizontalGroup(
            pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pOptionsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pOptionsLayout.createSequentialGroup()
                                .addGroup(pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77))))
                    .addGroup(pOptionsLayout.createSequentialGroup()
                        .addGroup(pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addGroup(pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pOptionsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnModify)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pOptionsLayout.setVerticalGroup(
            pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pOptionsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pOptionsLayout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(btnModify)
                    .addContainerGap(200, Short.MAX_VALUE)))
        );

        getContentPane().add(pOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 70, 360));

        pBody.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pBodyLayout = new javax.swing.GroupLayout(pBody);
        pBody.setLayout(pBodyLayout);
        pBodyLayout.setHorizontalGroup(
            pBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        pBodyLayout.setVerticalGroup(
            pBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        getContentPane().add(pBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 930, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String where = "";
        
        ckbMostrar.setSelected(false);
        switch(cmbColumna.getSelectedIndex()){
            case 0:
                where = " WHERE ID = " + txtClave.getText();
                break;
            default:
                where = " WHERE `" + cmbColumna.getSelectedItem().toString().toUpperCase() + "` LIKE '%" + txtClave.getText() + "%'";
        }
        
        consulta(where);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void ckbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbMostrarActionPerformed
        ckbMostrar.setSelected(true);
        txtClave.setText("");
        consulta("");
    }//GEN-LAST:event_ckbMostrarActionPerformed

    private void lSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lSalirMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        if(!estaSeleccionada()){
            mensaje("Error\nDebes seleccionar una fila antes para borrar.");
            return;
        }
        
        String ID = tabling.getValueAt(jTable1.getSelectedRow(), 0).toString();
        int resp = showConfirmDialog(this, "¿Estas seguro que deseas borrar el ID: " + ID + "?");
        if(resp == JOptionPane.OK_OPTION){
            eliminar(ID);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        FrmInsertar fm = new FrmInsertar(this, true);
        fm.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnModifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModifyMouseClicked
        if(!estaSeleccionada()){
            mensaje("Error\nDebes seleccionar una fila antes para actualizar.");
            return;
        }
        
        
        String ID = tabling.getValueAt(jTable1.getSelectedRow(), 0).toString();
        FrmModificar fm = new FrmModificar(this, true, ID);
        fm.setVisible(true);
    }//GEN-LAST:event_btnModifyMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        ckbMostrar.setSelected(true);
        txtClave.setText("");
        consulta("");
    }//GEN-LAST:event_btnRefreshMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnModify;
    private javax.swing.JLabel btnRefresh;
    private javax.swing.JCheckBox ckbMostrar;
    private javax.swing.JComboBox<String> cmbColumna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lSalir;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel pBody;
    private javax.swing.JPanel pHeader;
    private javax.swing.JPanel pOptions;
    private javax.swing.JTextField txtClave;
    // End of variables declaration//GEN-END:variables
}
