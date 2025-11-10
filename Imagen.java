public class Imagen extends Contenido {
    private String rutaArchivo;

    public Imagen(String nombre, String categoria, String autor, String rutaArchivo) {
        super(nombre, categoria, autor);
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando imagen: " + nombre + " (" + rutaArchivo + ")");
    }

    public String getRutaArchivo() { return rutaArchivo; }
}

