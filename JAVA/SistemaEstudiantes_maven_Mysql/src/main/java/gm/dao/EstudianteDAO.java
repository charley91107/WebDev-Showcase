package gm.dao;

import gm.modelo.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static gm.conexion.Conexion.getConexion;

public class EstudianteDAO {
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * from estudiante ORDER BY id_estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al seleccionar datos; " +e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion; " +e.getMessage());
            }
        }
        return estudiantes;
    }

    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * from estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al seleccionar datos; " +e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion; " +e.getMessage());
            }
        }
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante (nombre, apellido, telefono, email) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al insertar datos; " +e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion; " +e.getMessage());
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al modificar datos; " +e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion; " +e.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un error al eliminar datos; " +e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion; " +e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var estudianteDAO = new EstudianteDAO();

        //Agregar estudiante
//        var estudiante = new Estudiante("Carlos", "Lara", "12345678", "carlos@mail.com");
//        var agregado = estudianteDAO.agregarEstudiante(estudiante);
//        if (agregado){
//            System.out.println("Estudiante agregado: " + estudiante);
//        }else{
//            System.out.println("No se pudo agregar el estudiante: " + estudiante);
//        }

        //Modificar estudiante
//        var estudianteModificar = new Estudiante(1, "Juan Carlos", "Juarez", "66443322", "juan@mail.com");
//        var modificado = estudianteDAO.modificarEstudiante(estudianteModificar);
//        if (modificado){
//            System.out.println("Estudiante modificado: " + estudianteModificar);
//        }else{
//            System.out.println("No se pudo modificar el estudiante: " + estudianteModificar);
//        }

        //Eliminar estudiante
        var estudianteEliminar = new Estudiante(3);
        var eliminado = estudianteDAO.eliminarEstudiante(estudianteEliminar);
        if (eliminado){
            System.out.println("Estudiante eliminado: " + estudianteEliminar);
        }else{
            System.out.println("No se pudo eliminar el estudiante: " + estudianteEliminar);
        }

        //Listar estudiantes
        System.out.println("Listado estudiantes:");
        List<Estudiante> estudiantes = new EstudianteDAO().listarEstudiantes();
        estudiantes.forEach(System.out::println);

        //Buscar estudiante por id
//        var estudiante1 = new Estudiante(3);
//        System.out.println("EStudiante antes de la busqueda" + estudiante1);
//        var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
//        if(encontrado){
//            System.out.println("Estudiante encontrado: " + estudiante1);
//        }else{
//            System.out.println("No se encontro el estudiante: " + estudiante1.getIdEstudiante());
//        }


    }
}
