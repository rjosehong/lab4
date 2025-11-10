public class Articulo extends Contenido {
    private String texto;

    public Articulo(String nombre, String categoria, String autor, String texto) {
        super(nombre, categoria, autor);
        this.texto = texto;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando artículo: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Autor: " + autor);
        System.out.println("Contenido: " + texto);
    }

    public String getTexto() { return texto; }
}

