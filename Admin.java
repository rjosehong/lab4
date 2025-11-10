public class Admin extends Usuario implements Administrador {
    public Admin(String user, String password) {
        super(user, password);
    }

    @Override
    public void mostrarBienvenida() {
        System.out.println("Bienvenido administrador " + user);
    }

    @Override
    public void crearContenido() {
        System.out.println("El admin puede crear contenido.");
    }

    @Override
    public void editarContenido() {
        System.out.println("El admin puede editar contenido.");
    }

    @Override
    public void eliminarContenido() {
        System.out.println("El admin puede eliminar contenido.");
    }
}
