/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Usuario;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import modelo.ConexionBD;

/**
 *
 * @author acerpc
 */
public class FRM_Login extends javax.swing.JFrame {
    Controlador_FRM_Usuario  controlador;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    FRM_Usuario frm_Usuarios;
    ConexionBD conexion;
    String almacenamiento = "";
    
    public FRM_Login(FRM_VentanaPrincipal frm_VentanaPrincipal, FRM_Usuario frm_Usuario, ConexionBD conexion) {
        initComponents();
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        controlador = new Controlador_FRM_Usuario( frm_Usuario, this,conexion);
        agregarEvento();
        
        buttonGroup1.add(jrb_BaseDatos);
        buttonGroup1.add(jrb_ArchivosPlanos);
        buttonGroup1.add(jrb_ArchivosXml);
        
        ManejadorRB manejador = new ManejadorRB();
        this.jrb_BaseDatos.addItemListener(manejador);
        this.jrb_ArchivosPlanos.addItemListener(manejador);
        this.jrb_ArchivosXml.addItemListener(manejador);
        
        
    }
    public void agregarEvento()
    {
        this.jb_Aceptar.addActionListener(controlador);
    }
    
    public void abrirPrincipal()
    {
        frm_VentanaPrincipal.setVisible(true);
    }
    
    public String[] devolverInformacion()
    {
        String[] arreglo =new String [2];
        arreglo[0]=this.jt_NombreUsuario.getText();
        arreglo[1]=this.jpf_Contraseña.getText();
        
        return arreglo;
    }
    
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
   public class  ManejadorRB implements ItemListener{
    
       public void itemStateChanged(ItemEvent e)
       {
        
            if(e.getSource()== jrb_BaseDatos)
            {
                almacenamiento = "Base de datos";
                
            }
            if(e.getSource()== jrb_ArchivosPlanos)
            {
                almacenamiento = "Archivos Planos";
               
            }
            if(e.getSource()== jrb_ArchivosXml)
            {
                almacenamiento = "Archivos XML";
                
            }    
        }  
    
    }
   public String devolverAlmacenamiento()
   {
            return almacenamiento;
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jl_NombreUsuario = new javax.swing.JLabel();
        jl_Contraseña = new javax.swing.JLabel();
        jt_NombreUsuario = new javax.swing.JTextField();
        jb_Aceptar = new javax.swing.JButton();
        jpf_Contraseña = new javax.swing.JPasswordField();
        jrb_BaseDatos = new javax.swing.JRadioButton();
        jrb_ArchivosPlanos = new javax.swing.JRadioButton();
        jrb_ArchivosXml = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_NombreUsuario.setText("Nombre Usuario");

        jl_Contraseña.setText("Contraseña");

        jb_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jb_Aceptar.setActionCommand("Aceptar");

        jrb_BaseDatos.setText("Base de Datos");
        jrb_BaseDatos.setActionCommand("BaseDatos");

        jrb_ArchivosPlanos.setText("Archivos Planos");
        jrb_ArchivosPlanos.setActionCommand("ArchivosPlanos");

        jrb_ArchivosXml.setText("Archivos XML");
        jrb_ArchivosXml.setActionCommand("ArchivosXml");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jrb_BaseDatos)
                    .addComponent(jl_Contraseña)
                    .addComponent(jl_NombreUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jpf_Contraseña))
                        .addGap(18, 18, 18)
                        .addComponent(jb_Aceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrb_ArchivosPlanos)
                        .addGap(18, 18, 18)
                        .addComponent(jrb_ArchivosXml)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreUsuario)
                            .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_Contraseña)
                            .addComponent(jpf_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jb_Aceptar)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_BaseDatos)
                    .addComponent(jrb_ArchivosPlanos)
                    .addComponent(jrb_ArchivosXml))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jb_Aceptar;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_NombreUsuario;
    private javax.swing.JPasswordField jpf_Contraseña;
    private javax.swing.JRadioButton jrb_ArchivosPlanos;
    private javax.swing.JRadioButton jrb_ArchivosXml;
    private javax.swing.JRadioButton jrb_BaseDatos;
    private javax.swing.JTextField jt_NombreUsuario;
    // End of variables declaration//GEN-END:variables
}
