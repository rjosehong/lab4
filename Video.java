public class Video extends Contenido {
    private String url;

    public Video(String nombre, String categoria, String autor, String url) {
        super(nombre, categoria, autor);
        this.url = url;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando video: " + nombre + " [" + url + "]");
    }

    public String getUrl() { return url; }
}

