
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author charl
 */
public abstract class Vehiculo implements Serializable{
    protected int id = 0;
    protected String marca;
    protected String modelo;

    public Vehiculo(int id, String mar, String mod) {
        id = generarId();
        marca = mar;
        modelo = mod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    private int generarId() {
        id = id + 1;
        return id;
    }
    
    public boolean estaDisponible() {
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + '}';
    }

    

    
    
    
    
    
}
