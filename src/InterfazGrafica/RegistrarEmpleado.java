package InterfazGrafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegistrarEmpleado {
    private JPanel panel1;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textDni;
    private JTextField textHorario;
    private JTextField textSalario;
    private JTextField textPuesto;
    private JButton confirmarButton;
    private JButton atrasButton;


    public RegistrarEmpleado() {
    //Menu boton
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleados empleados = new Empleados();
                empleados.setVisible(true);
                JFrame frame = (JFrame) SwingUtilities.getRoot(atrasButton);
                frame.dispose();
            }
        });



        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String nombre, apellido, dni, horario, puesto;
                    double salario;

                    nombre = textNombre.getText();
                    apellido = textApellido.getText();
                    dni = textDni.getText();
                    horario = textHorario.getText();
                    puesto = textPuesto.getText();
                    salario = Double.parseDouble(textSalario.getText());

                    if (!nombre.isEmpty() && !apellido.isEmpty() && !dni.isEmpty() && !horario.isEmpty() && !puesto.isEmpty() && salario <= 0){

                        //METODO guardar empleado

                        limpiar();
                        JOptionPane.showMessageDialog(panel1, "Empleado registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                        Empleados empleados = new Empleados();
                        empleados.setVisible(true);
                        JFrame frame = (JFrame) SwingUtilities.getRoot(atrasButton);
                        frame.dispose();



                    }else {// Si algun Text esta vacio
                        JOptionPane.showMessageDialog(panel1, "Error al registrar el empleado. Campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);

                    }



            }
        });

    }

        public void limpiar(){
            textNombre.setText("");
            textApellido.setText("");
            textDni.setText("");
            textHorario.setText("");
            textPuesto.setText("");
            textSalario.setText("");
        }


        public void setVisible(boolean visible){
            JFrame frame = new JFrame("Registrar Empleado");
            frame.setContentPane(panel1); //Asigna el contenido a la ventana
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra la ventana, pero no para el programa
            frame.pack(); //Ajusta el tamaño del JFrame para que encaje con el contenido
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Muestra la ventana en pantalla completa
            frame.requestFocusInWindow(); //Hace foco a la ventana
            frame.setLocationRelativeTo(null); //Coloca el JFrame en el centro de la pantalla
            frame.setVisible(visible); //Muestra la ventana si "visible" es true
        }
    }


