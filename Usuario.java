public abstract class Usuario {
    protected String user;
    protected String password;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    // Polimorfismo: cada tipo de usuario tendrá su propio comportamiento
    public abstract void mostrarBienvenida();
}

