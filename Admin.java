public class Admin extends Usuario implements Administrador {
    public Admin(String user, String password){
        super(user, password);
    }

    public void Admin(){
        System.out.println("Bienvenido admin");
    }
}
