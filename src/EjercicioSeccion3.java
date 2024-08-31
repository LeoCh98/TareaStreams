import java.util.*;
import java.util.stream.Collectors;

class Pelicula
{
    private String titulo;
    private String director;
    private int estreno;
    
    public Pelicula(String titulo, String director, int estreno)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public int getEstreno()
    {
        return estreno;
    }
    
    @Override
    public String toString()
    {
        return titulo + " (" + director + ", " + estreno + ")";
    }
}

public class EjercicioSeccion3
{    
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        System.out.println("\nObtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive)");
        List<Pelicula> XXIfilms = peliculas.stream()
                .filter (p -> p.getEstreno() >= 2000)
                .collect(Collectors.toList());
        for(Pelicula p : XXIfilms){
            System.out.println(p);
        }

        System.out.println("\nMostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg");
        peliculas.stream()
                .filter (p -> p.getDirector() == "Steven Spielberg")
                .forEach(p -> System.out.println(p.getTitulo() + ", "));

        System.out.println("\nObtener un sublistado con los nombres de las películas, ordenados alfabéticamente");
        Comparator<Pelicula> cNombre = (p1, p2) -> p1.getTitulo().compareTo(p2.getTitulo());
        List<Pelicula> sortedFilms = peliculas.stream()
                .sorted(cNombre)
                .collect(Collectors.toList());
        for(Pelicula p : sortedFilms){
            System.out.println(p);
        }
    }
}
