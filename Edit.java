public class Edit extends Usuario implements Editor{
    public Edit(String user, String password){
        super(user, password);
    }
    public void Editor(){
        System.out.println("Bievenido editor");
    }
}
