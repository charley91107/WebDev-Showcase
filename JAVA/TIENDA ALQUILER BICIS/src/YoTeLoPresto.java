
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;




 
public class YoTeLoPresto {
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static final String FICHERO = "fichero.bin";
    
    
    public static int menuPrincipal()
    {
        int op = 0;
        while (op<1 ||  op>4)
        {
            if (op==5){
                return op;
            }
            System.out.println("1. Añadir vehiculo");
            System.out.println("2. Generar listado de vehiculos");
            System.out.println("3. Alquilar vehiculo");
            System.out.println("4. Devolver vehiculo");
            System.out.println("5. Salir");
            op = leerInt();
        }
        return op;
    }  
    
    public static int leerInt()
    {
        Scanner scann = new Scanner(System.in);
        while (true)
        {
            try
            {
                return scann.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Número no válido");
                scann.nextLine();
            }
        }
    }
    
    public static void añadirVehiculo(){
        Scanner scann = new Scanner(System.in);
        int id = 0;
        int tipo = 0;
        while(tipo!=1 && tipo!=2){
            System.out.println("¿Qué vehículo quiere añadir?\n1. Patinete\n2. Bicicleta");
            tipo=leerInt();
        }
        System.out.println("marca: ");
        String marca = scann.nextLine();
        System.out.println("Modelo");
        String modelo = scann.nextLine();   
        
        if(tipo==1){
            double velocidad_Max = 0;
            vehiculos.add(new Patinete(velocidad_Max, id, marca,modelo));
        }
        else{
            
            vehiculos.add(new Bicicleta(id,marca,modelo));
        }
    }
    
     public static Vehiculo buscarVehiculo(int id)
    {
        Iterator <Vehiculo> it = vehiculos.iterator();
        while (it.hasNext())
        {
            Vehiculo v = it.next();
            if (v.getId() == id)
                return v;
        }
        return null;
    }
    
    public static void generarListadoVehiculos(){
        String fichero = "listado.txt";
        BufferedWriter bw = null;
        try
        {
            bw = new BufferedWriter(new FileWriter(fichero));
            Iterator <Vehiculo> it = vehiculos.iterator();
            while (it.hasNext())
            {
                bw.write(it.next().toString());
                bw.newLine();                
            }
        }
        catch (IOException e)
        {
            System.out.println("Error escribiendo en el fichero de texto");
        }
        finally
        {
            try
            {
                if (bw!=null)
                    bw.close();
            }
            catch (IOException e)
            {
                System.out.println("Error cerrando el fichero");
            }
        }
        
    }
    
    public static void alquilarVehiculo(){
        
        int tipo = 0;
        while(tipo!=1 && tipo!=2){
            System.out.println("¿Qué vehículo quiere alquilar?\n1. Patinete\n2. Bicicleta");
            tipo=leerInt();
        }
        Iterator <Vehiculo> it = vehiculos.iterator();
        while (it.hasNext())
        {
            Vehiculo p = it.next();
            if (p instanceof Patinete)
                System.out.println(p);
        }
        while (it.hasNext()) {
            Vehiculo b = it.next();
            if (b instanceof Bicicleta)
                System.out.println(b);
        }
        System.out.print("Identificador: ");
        int id = leerInt();
        Vehiculo v = buscarVehiculo(id);
        if (v == null)
            System.out.println("vehiculo con "+id +" no encontrado");
        else if (v.estaDisponible()) //campo
        {
            vehiculos.remove(v);
            System.out.println("el vehiculo " + id + " ha sido alquilado correctamente");
        }
        else
            System.out.println("el vehiculo " + id + " no esta disponible");
        

    }
    
    
    public static void devolverVehiculo(){
        int tipo = 0;
        while(tipo!=1 && tipo!=2){
            System.out.println("¿Qué vehículo quiere alquilar?\n1. Patinete\n2. Bicicleta");
            tipo=leerInt();
        }
        Iterator <Vehiculo> it = vehiculos.iterator();
        while (it.hasNext())
        {
            Vehiculo p = it.next();
            if (p instanceof Patinete)
                System.out.println(p);
        }
        while (it.hasNext()) {
            Vehiculo b = it.next();
            if (b instanceof Bicicleta)
                System.out.println(b);
        }
        System.out.print("Identificador: ");
        int id = leerInt();
        Vehiculo v = buscarVehiculo(id);
        if (v == null)
            System.out.println("vehiculo con "+id +" no encontrado");
        else if (v.estaDisponible()) //campo
        {
            vehiculos.add(v);
            System.out.println("el vehiculo " + id + " ha sido devuelto correctamente");
        }
        else
            System.out.println("el vehiculo " + id + " no esta alquilado");
    }
    
    public static void main(String[] args) {        
        recuperarDatos();
        int op = menuPrincipal();
        
        while (op!=5)
        {
            switch (op)
            {
                
                case 1: añadirVehiculo(); break;
                case 2: generarListadoVehiculos(); break;
                case 3: alquilarVehiculo(); break;
                case 4: devolverVehiculo(); break;
        
            }
            
            op = menuPrincipal();
        }
        
        guardarDAtos();
    }
    
    public static void recuperarDatos()
    {
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(new FileInputStream(FICHERO));
            vehiculos = (ArrayList<Vehiculo>) ois.readObject();
           // Vehiculo.setContador(ois.readInt());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error en los datos");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Ejecutando por primera vez el programa");
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo los datos");
        }
        catch (Exception e)
        {
            System.out.println("Error en los datos");
        }
        finally
        {
            try
            {
                if (ois!=null)
                    ois.close();
            }
            catch (IOException e)
            {
                System.out.println("Error cerrando el fichero");
            }
        }
    }
       
    
        public static void guardarDAtos()
    {
        ObjectOutputStream oos = null;
        try
        {
            oos = new ObjectOutputStream(new FileOutputStream(FICHERO));
            oos.writeObject(vehiculos);
            
        }
        catch (IOException e)
        {
            System.out.println("Error guardando los datos");
        }
        finally
        {
            try
            {
                if (oos!=null)
                    oos.close();
            }
            catch (IOException e)
            {
                System.out.println("Error cerrando el fichero");
            }
        }
    }
}
