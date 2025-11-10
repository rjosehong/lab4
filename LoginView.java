import javax.swing.*;
import java.awt.*;


public class LoginView extends JFrame {
    private ControladorUsuarios controladorUsuarios;
    private ControladorContenido controladorContenido;

    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin, btnRegistrar;

    public LoginView() {
        controladorUsuarios = new ControladorUsuarios();
        controladorContenido = new ControladorContenido();
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("CMS - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblUser = new JLabel("Usuario:");
        JLabel lblPass = new JLabel("Contraseña:");
        txtUser = new JTextField();
        txtPass = new JPasswordField();

        btnLogin = new JButton("Iniciar sesión");
        btnRegistrar = new JButton("Registrar usuario");

        btnLogin.addActionListener(e -> login());
        btnRegistrar.addActionListener(e -> registrar());

        add(lblUser);
        add(txtUser);
        add(lblPass);
        add(txtPass);
        add(btnLogin);
        add(btnRegistrar);
    }

    private void login() {
        String user = txtUser.getText();
        String pass = new String(txtPass.getPassword());

        Usuario u = controladorUsuarios.login(user, pass);
        if (u != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + u.getUser());
            dispose();
            new PrincipalView(u, controladorUsuarios, controladorContenido).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas.");
        }
    }

    private void registrar() {
        JTextField userField = new JTextField();
        JTextField passField = new JTextField();
        JCheckBox adminCheck = new JCheckBox("¿Es administrador?");

        Object[] inputs = {
            "Usuario:", userField,
            "Contraseña:", passField,
            adminCheck
        };

        int option = JOptionPane.showConfirmDialog(this, inputs, "Registrar usuario", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            controladorUsuarios.registrarUsuario(
                userField.getText(),
                passField.getText(),
                adminCheck.isSelected()
            );
            JOptionPane.showMessageDialog(this, "Usuario registrado con éxito.");
        }
    }
}

