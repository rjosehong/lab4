import javax.swing.*;
import java.awt.*;


public class PrincipalView extends JFrame {
    private Usuario usuario;
    private ControladorUsuarios controladorUsuarios;
    private ControladorContenido controladorContenido;

    private JTextField txtNombre, txtCategoria, txtDato;
    private JComboBox<String> comboTipo;
    private JTextArea txtLista;
    private JButton btnAgregar, btnEliminar, btnListar;

    public PrincipalView(Usuario u, ControladorUsuarios cu, ControladorContenido cc) {
        this.usuario = u;
        this.controladorUsuarios = cu;
        this.controladorContenido = cc;
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("CMS - Panel de " + usuario.getUser());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior = new JPanel(new GridLayout(5, 2, 5, 5));
        panelSuperior.add(new JLabel("Tipo de contenido:"));
        comboTipo = new JComboBox<>(new String[]{"Artículo", "Video", "Imagen"});
        panelSuperior.add(comboTipo);

        panelSuperior.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelSuperior.add(txtNombre);

        panelSuperior.add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        panelSuperior.add(txtCategoria);

        panelSuperior.add(new JLabel("Texto / URL / Ruta:"));
        txtDato = new JTextField();
        panelSuperior.add(txtDato);

        btnAgregar = new JButton("Publicar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        // Área de lista
        txtLista = new JTextArea();
        txtLista.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtLista);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> agregarContenido());
        btnEliminar.addActionListener(e -> eliminarContenido());
        btnListar.addActionListener(e -> listarContenidos());
    }

    private void agregarContenido() {
        String tipo = (String) comboTipo.getSelectedItem();
        String nombre = txtNombre.getText();
        String cat = txtCategoria.getText();
        String dato = txtDato.getText();

        Contenido nuevo = null;
        if (tipo.equals("Artículo"))
            nuevo = new Articulo(nombre, cat, usuario.getUser(), dato);
        else if (tipo.equals("Video"))
            nuevo = new Video(nombre, cat, usuario.getUser(), dato);
        else
            nuevo = new Imagen(nombre, cat, usuario.getUser(), dato);

        controladorContenido.agregarContenido(nuevo);
        JOptionPane.showMessageDialog(this, "Contenido agregado correctamente.");
        limpiarCampos();
    }

    private void eliminarContenido() {
        if (usuario instanceof Admin) {
            String nombre = JOptionPane.showInputDialog("Nombre del contenido a eliminar:");
            controladorContenido.eliminarContenido(nombre);
            JOptionPane.showMessageDialog(this, "Contenido eliminado (si existía).");
        } else {
            JOptionPane.showMessageDialog(this, "No tienes permisos para eliminar contenido.");
        }
    }

    private void listarContenidos() {
        txtLista.setText("");
        for (Contenido c : controladorContenido.getContenidos()) {
            txtLista.append("- " + c.getNombre() + " [" + c.getCategoria() + "] por " + c.getAutor() + "\n");
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCategoria.setText("");
        txtDato.setText("");
    }
}

