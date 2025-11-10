import java.util.*;

public class ControladorUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();

    public ControladorUsuarios() {
        usuarios.add(new Admin("admin", "123"));
        usuarios.add(new Editor("editor", "456"));
    }

    public Usuario login(String user, String password) {
        for (Usuario u : usuarios) {
            if (u.getUser().equalsIgnoreCase(user) && u.getPassword().equals(password)) {
                u.mostrarBienvenida();
                return u;
            }
        }
        return null;
    }

    public void registrarUsuario(String user, String password, boolean esAdmin) {
        if (esAdmin) usuarios.add(new Admin(user, password));
        else usuarios.add(new Editor(user, password));
    }

    public List<Usuario> getUsuarios() { return usuarios; }
}
