package InterfazGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarCliente {
    private JButton atrasButton;
    private JTextField textNombre;
    private JTextField textPrecioTotal;
    private JTextField textApellido;
    private JTextField textDni;
    private JTextField textTelefono;
    private JTextField textCorreoelectronico;
    private JCheckBox checkBox_CarpaVIP;
    private JCheckBox checkBox_CarpaStandard;
    private JCheckBox checkBox_EstacionamientoTechado;
    private JCheckBox checkBoxEstacionamientoStandard;
    private JCheckBox checkBox_SINestacionamiento;
    private JCheckBox checkBox_Spa;
    private JCheckBox checkBox_Guarderia;
    private JButton registrarButton;
    private JPanel panel;
private double precioTotal;

    public RegistrarCliente(){
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IniciarSesion iniciarSesion = new IniciarSesion();
                iniciarSesion.setVisible(true);
                JFrame frame = (JFrame) SwingUtilities.getRoot(atrasButton);
                frame.dispose();
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            String nombre, apellido, dni, telefono, correoelectronico;
            double precioTotal;

            nombre = textNombre.getText();
            apellido = textApellido.getText();
            dni = textDni.getText();
            telefono = textTelefono.getText();
            correoelectronico = textCorreoelectronico.getText();
            precioTotal = Double.parseDouble(textPrecioTotal.getText());

            if(!nombre.isEmpty() && !apellido.isEmpty() && !dni.isEmpty() && !telefono.isEmpty() && !correoelectronico.isEmpty() && precioTotal <= 0){

                //METODO para guardar los clientes

                limpiarCampos();
                JOptionPane.showMessageDialog(panel, "Cliente registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                IniciarSesion iniciarSesion = new IniciarSesion();
                iniciarSesion.setVisible(true);
                JFrame frame = (JFrame) SwingUtilities.getRoot(registrarButton);
                frame.dispose();

            }else {
                JOptionPane.showMessageDialog(panel, "Error al registrar sus datos. Campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);

            }



            }
        });

        checkBox_CarpaVIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecioTotal();
            }
        });

        checkBox_CarpaStandard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecioTotal();
            }
        });

        checkBox_EstacionamientoTechado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecioTotal();
            }
        });

        checkBoxEstacionamientoStandard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecioTotal();
            }
        });

        checkBox_SINestacionamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecioTotal();
            }
        });

        checkBox_Spa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecioTotal();

            }
        });

        checkBox_Guarderia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrecioTotal();
            }

        });


    }


    private void actualizarPrecioTotal() {
        precioTotal = 0;  // Reinicia el precio total antes de recalcularlo

        if (checkBox_CarpaVIP.isSelected()) {
            precioTotal += 1000000;
        }

        if (checkBox_CarpaStandard.isSelected()) {
            precioTotal += 750000;
        }

        if (checkBox_EstacionamientoTechado.isSelected()) {
            precioTotal += 500000;
        }

        if (checkBoxEstacionamientoStandard.isSelected()) {
            precioTotal += 250000;
        }

        if (checkBox_SINestacionamiento.isSelected()) {
            precioTotal += 0;
        }

        if (checkBox_Spa.isSelected()) {
            precioTotal += 300000;
        }

        if (checkBox_Guarderia.isSelected()) {
            precioTotal += 400000;
        }


        // Actualiza el JTextField con el precio total
        textPrecioTotal.setText(String.format("%.2f", precioTotal));
    }

    private void limpiarCampos(){
        textNombre.setText("");
        textApellido.setText("");
        textDni.setText("");
        textTelefono.setText("");
        textCorreoelectronico.setText("");
        textPrecioTotal.setText("");
    }


    public void setVisible(boolean visible){
        JFrame frame = new JFrame("Registrar Clientes");
        frame.setContentPane(panel); //Asigna el contenido a la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra la ventana, pero no para el programa
        frame.pack(); //Ajusta el tamaño del JFrame para que encaje con el contenido
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Muestra la ventana en pantalla completa
        frame.requestFocusInWindow(); //Hace foco a la ventana
        frame.setLocationRelativeTo(null); //Coloca el JFrame en el centro de la pantalla
        frame.setVisible(visible); //Muestra la ventana si "visible" es true
    }

}