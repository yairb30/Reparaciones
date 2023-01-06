package controlador;

import java.awt.event.*;
import javax.swing.JOptionPane;
import modelo.Celular;
import modelo.ConsultaCelular;
import vista.VistaCelular;

public class CtrlCelular implements ActionListener {

    private final Celular cel;
    private final ConsultaCelular celC;
    private final VistaCelular celV;

    public CtrlCelular(Celular cel, ConsultaCelular celC, VistaCelular celV) {
        this.cel = cel;
        this.celC = celC;
        this.celV = celV;

        this.celV.btnGuardar.addActionListener(this);
        this.celV.btnModificar.addActionListener(this);
        this.celV.btnEliminar.addActionListener(this);
        this.celV.btnLimpiar.addActionListener(this);
        this.celV.btnBuscar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == celV.btnGuardar) {

            cel.setImei(Long.parseLong(celV.txtImei.getText()));
            cel.setMarca(celV.txtMarca.getText());
            cel.setModelo(celV.txtModelo.getText());
            cel.setFalla(celV.txtFalla.getText());
            cel.setCliente(celV.txtCliente.getText());
            cel.setFecha(new java.sql.Date(celV.jdcFecha.getDate().getTime()));

            if (celC.guardar(cel)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();

            }

        }
        if (e.getSource() == celV.btnModificar) {

            cel.setImei(Long.parseLong(celV.txtImei.getText()));
            cel.setMarca(celV.txtMarca.getText());
            cel.setModelo(celV.txtModelo.getText());
            cel.setFalla(celV.txtFalla.getText());
            cel.setCliente(celV.txtCliente.getText());
            cel.setFecha(new java.sql.Date(celV.jdcFecha.getDate().getTime()));

            if (celC.modificar(cel)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();

            }
        }
        if (e.getSource() == celV.btnEliminar) {
            cel.setId(Integer.parseInt(celV.txtId.getText()));

            if (celC.eliminar(cel)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();

            }

        }
        if (e.getSource() == celV.btnBuscar) {
            cel.setImei(Long.parseLong(celV.txtImei.getText()));

            if (celC.buscar(cel)) {
                celV.txtId.setText(String.valueOf(cel.getId()));
                celV.txtImei.setText(String.valueOf(cel.getImei()));
                celV.txtMarca.setText(cel.getMarca());
                celV.txtModelo.setText(cel.getModelo());
                celV.txtFalla.setText(cel.getFalla());
                celV.txtCliente.setText(cel.getCliente());
                celV.jdcFecha.setDate(cel.getFecha());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();

            }

        }
        if (e.getSource() == celV.btnLimpiar) {
            limpiar();
        }

    }

    public void iniciar() {
        celV.setTitle("Reparacion de celulares");

        celV.txtId.setVisible(false);
        celV.setLocationRelativeTo(null);
//        celV.setBackground(Color.yellow);
    }

    public void limpiar() {
        celV.txtId.setText("");
        celV.txtImei.setText("");
        celV.txtMarca.setText("");
        celV.txtModelo.setText("");
        celV.txtFalla.setText("");
        celV.txtCliente.setText("");
        celV.jdcFecha.setDate(null);
    }

}
