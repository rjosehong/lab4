import java.util.*;
import model.*;

public class ControladorContenido {
    private List<Contenido> contenidos = new ArrayList<>();

    public void agregarContenido(Contenido c) {
        contenidos.add(c);
    }

    public void eliminarContenido(String nombre) {
        contenidos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
    }

    public void listarContenidos() {
        System.out.println("\n=== CONTENIDOS PUBLICADOS ===");
        for (Contenido c : contenidos) {
            System.out.println("- " + c.getNombre() + " [" + c.getCategoria() + "] por " + c.getAutor());
        }
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }
}

