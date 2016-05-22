/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Matricula;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.MetodosMatricula;
import modelo.Metodos_XML_Matricula;


/**
 *
 * @author tecnologiamultimedia
 */
public class FRM_Matricula extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Matricula
     */
    DefaultTableModel modelo;
    public Controlador_FRM_Matricula controlador;
    ConexionBD conexion;
    FRM_Login frm_Login;
    MetodosMatricula metodosMatricula;
    Metodos_XML_Matricula metodos_XML_Matricula;
    
    public FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos frm_MantenimientoCursos, ConexionBD conexion, FRM_Login frm_Login) {
        initComponents();
        setLocation(200,200);
        controlador= new Controlador_FRM_Matricula(frm_MantenimientoEstufiantes,frm_MantenimientoCursos,this, conexion, frm_Login);
        agregarEventos();
        modelo=new DefaultTableModel();
        colocarTitulosTabla();
        this.frm_Login=frm_Login;
        this.conexion = conexion;
        metodosMatricula=controlador.metodosMatricula;
        metodos_XML_Matricula=controlador.metodos_XML_Matricula;
    }
    public void agregarInformacionTabla()
    {
        String arreglo[]=new String[4];
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=this.jt_Cedula.getText();
        arreglo[2]=this.jt_NombreEstudiante.getText();
        arreglo[3]=this.jt_Sigla.getText();
        modelo.addRow(arreglo);
        
    }
    public void agregarInformacionTablaConsulta(String arreglo[])
    {
        modelo.addRow(arreglo);
    }
    public void agregarEventos()
    {
        this.btn_ConsultaRapidaCedula.addActionListener(controlador);
        this.btn_ConsultaRapidaSigla.addActionListener(controlador);
        this.btn_Finalizar.addActionListener(controlador);
        this.panel_Botones1.agregarEventos(controlador);
        
    }
    public void resetearVentana()
    {
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
        
        int tamaño = modelo.getRowCount();
        for(int contador=0;contador<tamaño;contador++)
        {
            modelo.removeRow(0);
           
        }
    }
    
    public void resetearVentanaConsultar()
    {
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
        
            modelo.removeRow(this.tbl_Tabla.getSelectedRow());
           
        
    }
    public void limpiarSigla()
    {
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
    }
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    public String devolverCodigo()
    {
        return this.jt_CodigoMatricula.getText();
    }
    public void colocarNombreEstudiante(String nombre)
    {
        this.jt_NombreEstudiante.setText(nombre);
    }
    public String devolverDato(int fila, int columna)
    {
        return ""+modelo.getValueAt(fila, columna);
    }
    public void colocarNombreCurso(String nombre)
    {
        this.jt_NombreCurso.setText(nombre);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void colocarTitulosTabla()
    {
        this.tbl_Tabla.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre Est.");
        modelo.addColumn("Sigla");
    }
    public void habilitarAgregar()
    {
        this.panel_Botones1.habilitarAgregar();
    }
    public void colocarCodigo()
    {
        if(frm_Login.devolverAlmacenamiento().equals("Base de datos"))
            this.jt_CodigoMatricula.setText(conexion.generarCodigoMatricula());
        else if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
            this.jt_CodigoMatricula.setText(metodosMatricula.devolverCodigo());
        else
            this.jt_CodigoMatricula.setText(metodos_XML_Matricula.generarCodigo());
            
    }
    public int getCantidadFilas()
    {
        return modelo.getRowCount();
       
    }
    
     public String devolverCodigoSelecionado()
    {
        return ""+this.modelo.getValueAt(tbl_Tabla.getSelectedRow(),0);
    }
    
    public String devolverSiglaSelecionda()
    {
        return ""+this.modelo.getValueAt(tbl_Tabla.getSelectedRow(), 3);
    }
    
    public void habilitarEliminar()
    {
        panel_Botones1.habilitarEliminar();
    }
    public void eliminarFilaTabla()
    {
        modelo.removeRow(tbl_Tabla.getSelectedRow());
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
        tbl_Tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        btn_ConsultaRapidaCedula = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jt_NombreEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jt_NombreCurso = new javax.swing.JTextField();
        btn_ConsultaRapidaSigla = new javax.swing.JButton();
        panel_Botones1 = new vista.Panel_Botones();
        jl_codigoMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();
        btn_Finalizar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_Tabla);

        jLabel1.setText("Cédula");

        btn_ConsultaRapidaCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaCedula.setActionCommand("ConsultaRapidaCedula");

        jLabel2.setText("Nombre Estudiante");

        jt_NombreEstudiante.setEnabled(false);

        jLabel3.setText("Sigla");

        jLabel4.setText("Nombre Curso");

        jt_NombreCurso.setEnabled(false);

        btn_ConsultaRapidaSigla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaSigla.setActionCommand("ConsultaRapidaSigla");

        jl_codigoMatricula.setText("Código Matrícula");

        btn_Finalizar.setText("Finalizar Matrícula");
        btn_Finalizar.setActionCommand("Finalizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Finalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jt_Cedula)
                                    .addComponent(jt_NombreEstudiante)
                                    .addComponent(jt_Sigla)
                                    .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_ConsultaRapidaCedula)
                                    .addComponent(btn_ConsultaRapidaSigla)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_codigoMatricula)
                                .addGap(37, 37, 37)
                                .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_codigoMatricula)
                    .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ConsultaRapidaCedula))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ConsultaRapidaSigla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Finalizar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        if(frm_Login.devolverAlmacenamiento().equals("Archivos Planos"))
        {
            this.controlador.guardarArchivo();
        }
        this.resetearVentana();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapidaCedula;
    private javax.swing.JButton btn_ConsultaRapidaSigla;
    private javax.swing.JButton btn_Finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_codigoMatricula;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private vista.Panel_Botones panel_Botones1;
    private javax.swing.JTable tbl_Tabla;
    // End of variables declaration//GEN-END:variables
}
