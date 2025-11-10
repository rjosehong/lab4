public abstract class Contenido {
    protected String nombre;
    protected String categoria;
    protected String autor;

    public Contenido(String nombre, String categoria, String autor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getAutor() { return autor; }

    public abstract void publicar();  // método polimórfico
}

