import java.util.*;
public class Controlador {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Contenido> publicaciones = new ArrayList<>();
    private String user_name;
    private String user_password;
    private String decision;
    private int int_decision;

    private String tp_c;
    private String cont;
    private String cate;
    private String nomb;


    Scanner sc = new Scanner(System.in);
    public Controlador(){
        usuarios.add(new Admin("JuanitoPatito", "123"));
        usuarios.add(new Edit("AnaBanana", "456"));
    }

    public void AgregarUsuario(){
        // código para entrar como admin: 727
        System.out.println("Ingrese el cóigo para crear un usuario admin");
        int codigo = sc.nextInt();
        if(codigo==727){
            System.out.print("Ingrese su usuario deseado: ");
            String user_name = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String user_password = sc.nextLine();
            usuarios.add(new Admin(user_name, user_password));
        }
        else {
            System.out.print("Ingrese su usuario deseado: ");
            String user_name = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String user_password = sc.nextLine();
            usuarios.add(new Edit(user_name, user_password));
        }
        
    }

    public void Proceso(){
        for(Usuario user : usuarios){
            if(user instanceof Admin || user instanceof Edit){
                Admin ad = (Admin) user;
                Edit ed = (Edit) user;
                System.out.print("Usuario: ");
                user_name = sc.nextLine();
                System.out.print("Contraseña: ");
                user_password = sc.nextLine();
                
                if (ad.getUser().equalsIgnoreCase(user_name) && ad.getPassword().equalsIgnoreCase(user_password)){
                    System.out.println("Bienvenido admin " + ad.getUser());
                    
                }
                else if (ad.getUser().equalsIgnoreCase(user_name) && ad.getPassword().equalsIgnoreCase(user_password)){
                    System.out.println("Bienvenido admin " + ed.getUser());
                }
                else {
                    System.out.println("Usuario o contraseña incorrectos");
                }
            }
        }
    }

    public void Publicar_contenido(){
        for(Usuario user : usuarios){
            if(user instanceof Admin || user instanceof Edit){
                Admin ad = (Admin) user;
                Edit ed = (Edit) user;
                
                if (ad.getUser().equalsIgnoreCase(user_name) && ad.getPassword().equalsIgnoreCase(user_password)){
                    System.out.print("¿Quiere publicar algo? (si/no): ");
                    decision = sc.nextLine();
                    if (decision.equalsIgnoreCase("si")){
                        int_decision = 1;
                    }
                    else {
                        int_decision = 0;
                    }
                    switch (int_decision) {
                        case 1:
                            System.out.println("Tipos de contenido: podcasts, infografías, charlas, etc... Contenido: árticulo, documento, imágenes, videos, etc...\nCategoría: Mate, Física, Química, etc...");
                            System.out.print("¿Qué tipo de contenido va tener su publicación?");
                            tp_c = sc.nextLine();
                            System.out.print("¿Qué contenido va a ser su publicación?: ");
                            cont = sc.nextLine();
                            System.out.print("¿Qué categoría quiere asignar a su publicación?");
                            cate = sc.nextLine();
                            System.out.print("¿Qué nombre tendrá su publicación?");
                            nomb = sc.nextLine();

                            publicaciones.add(new Contenido(tp_c, cont, cate, nomb));
                            break;

                        default:
                            break;
                    }
                }
                else if (ad.getUser().equalsIgnoreCase(user_name) && ad.getPassword().equalsIgnoreCase(user_password)){
                    System.out.print("¿Quiere publicar algo? (si/no): ");
                    decision = sc.nextLine();
                    if (decision.equalsIgnoreCase("si")){
                        int_decision = 1;
                    }
                    else {
                        int_decision = 0;
                    }
                    switch (int_decision) {
                        case 1:
                            System.out.println("Tipos de contenido: podcasts, infografías, charlas, etc... Contenido: árticulo, documento, imágenes, videos, etc...\nCategoría: Mate, Física, Química, etc...");
                            System.out.print("¿Qué tipo de contenido va tener su publicación?");
                            tp_c = sc.nextLine();
                            System.out.print("¿Qué contenido va a ser su publicación?: ");
                            cont = sc.nextLine();
                            System.out.print("¿Qué categoría quiere asignar a su publicación?");
                            cate = sc.nextLine();
                            System.out.print("¿Qué nombre tendrá su publicación?");
                            nomb = sc.nextLine();

                            publicaciones.add(new Contenido(tp_c, cont, cate, nomb));
                            break;

                        default:
                            break;
                    }
                }
                else {
                    System.out.println("Usuario o contraseña incorrectas.");
                }
            }
        }
    }
}
