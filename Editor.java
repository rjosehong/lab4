public class Editor extends Usuario implements Publicador {
    public Editor(String user, String password) {
        super(user, password);
    }

    @Override
    public void mostrarBienvenida() {
        System.out.println("Bienvenido editor " + user);
    }

    @Override
    public void crearContenido() {
        System.out.println("El editor puede crear contenido.");
    }

    @Override
    public void editarContenido() {
        System.out.println("El editor puede editar contenido.");
    }
}

