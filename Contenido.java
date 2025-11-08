public class Contenido{
    private String tipo_contenido;
    private String contenido;
    private String categoria;
    private String nombre;

    public Contenido(String tipo_contenido, String contenido, String categoria, String nombre){
        this.tipo_contenido=tipo_contenido;
        this.contenido=contenido;
        this.categoria=categoria;
        this.nombre=nombre;
    }

    public String getTipo_contenido() {
        return tipo_contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public String getNombre() {
        return nombre;
    }

    
}
