package servicio;

import dominio.Pelicula;

import java.io.*;
import java.sql.SQLOutput;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Si ya existe el archivo no se vuelve a crear
            if (archivo.exists()){
                System.out.println("el archivo ya existe");
            } else {
                var salida =  new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo: " +e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        // volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de peliculas");
            //abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            // leemos todas las lineas disponibles
            while(linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                // Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            //cerrar el archivo
            entrada.close();
        } catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo" + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //agregamos la pelicula(toString)
            salida.println(pelicula);
            //cerrar el archivo
            salida.close();
            System.out.println("Se agrego al archivo: " + pelicula);
        } catch (Exception e){
            System.out.println("Ocurrio un error al agregar pelicula" + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null){
                //Buscamos sin importar mayusculas/minusculas
                if (peliculaBuscar != null &&  peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                // Leemos la siguiente linea antes de la siguiente iteraccion
                lineaTexto = entrada.readLine();
                indice++;
            } //end while
            //imprimimos resultados de la busqueda
            if(encontrada){
                System.out.println("Pelicula " + lineaTexto + " encontrada - linea " + indice);
            } else {
                System.out.println("no se encontro la pelicula " + pelicula.getNombre());
            }
            //cerrar el archivo
            entrada.close();
        } catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo" + e.getMessage());
        }
    }
}
