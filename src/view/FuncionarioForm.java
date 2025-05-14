package view;

import dao.FuncionarioDAOImpl;
import model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioForm extends JFrame {
    private JTextField txtId;
    private JTextField txtTipoIdentificacion;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEstadoCivil;
    private JTextField txtSexo;
    private JTextField txtDireccion;
    private JTextField txtFechaNacimiento;
    private JTextField txtTelefono;
    private JButton btnGuardar;

    public FuncionarioForm() {
        setTitle("Registro de Funcionarios");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5));

        // Campos
        txtId = new JTextField();
        txtTipoIdentificacion = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtEstadoCivil = new JTextField();
        txtSexo = new JTextField();
        txtDireccion = new JTextField();
        txtFechaNacimiento = new JTextField();
        txtTelefono = new JTextField();
        btnGuardar = new JButton("Guardar");


        // Agregar componentes al formulario
//        add(new JLabel("ID:"));
//        add(txtId);
        add(new JLabel("Tipo Identificación:"));
        add(txtTipoIdentificacion);
        add(new JLabel("Nombre:"));
        add(txtNombre);

        add(new JLabel("Apellido:"));
        add(txtApellido);
        add(new JLabel("Estado Civil:"));
        add(txtEstadoCivil);
        add(new JLabel("Sexo:"));
        add(txtSexo);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Fecha de Nacimiento:"));
        add(txtFechaNacimiento);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel());
        add(btnGuardar);

        // Evento botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarFuncionario();
            }
        });
    }

    private void guardarFuncionario() {
        try {
            Funcionario funcionario = new Funcionario();
            //funcionario.setId(Integer.parseInt(txtId.getText()));
            funcionario.setTipoIdentificacion(txtTipoIdentificacion.getText());
            funcionario.setNombre(txtNombre.getText());
            funcionario.setApellido(txtApellido.getText());
            funcionario.setEstadoCivil(txtEstadoCivil.getText());
            funcionario.setSexo(txtSexo.getText());
            funcionario.setDireccion(txtDireccion.getText());
            funcionario.setFechaNacimiento(txtFechaNacimiento.getText());
            funcionario.setTelefono(txtTelefono.getText());

            FuncionarioDAOImpl dao = new FuncionarioDAOImpl();
            dao.insertar(funcionario);

            JOptionPane.showMessageDialog(this, "Funcionario guardado correctamente.");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar funcionario: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FuncionarioForm().setVisible(true));
    }
}
