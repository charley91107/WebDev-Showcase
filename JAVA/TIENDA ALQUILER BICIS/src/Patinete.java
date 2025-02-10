/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author charl
 */
public class Patinete extends Vehiculo {
    public double velocidad_Max;

    public Patinete(double velocidad_Max, int id, String mar, String mod) {
        super(id, mar, mod);
        this.velocidad_Max = velocidad_Max;
    }

    

    public double getVelocidad_Max() {
        return velocidad_Max;
    }

    public void setVelocidad_Max(double velocidad_Max) {
        this.velocidad_Max = velocidad_Max;
    }

    @Override
    public String toString() {
        return "Patinete{" + "velocidad_Max=" + velocidad_Max + '}';
    }

    
    
}
