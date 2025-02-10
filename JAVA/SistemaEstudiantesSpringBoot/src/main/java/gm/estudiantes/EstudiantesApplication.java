package gm.estudiantes;

import gm.estudiantes.modelo.Estudiante;
import gm.estudiantes.servicio.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;
import java.util.Scanner;


@SpringBootApplication(scanBasePackages = "gm.estudiantes")
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		//Levantar la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicación finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando metodo run de spring..." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//fin while
	}

	private void mostrarMenu(){
		//logger.info(nl);
		logger.info("""
                ***Sistema de Estudiantes***
                1. Listar estudiantes
                2. Buscar estudiante
                3. Agregarestudiante
                4. Modificar estudiante
                5. Eliminar estudiante
                6. Salir
                Ingrese una opción:""");
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch(opcion){
			case 1 -> {// listar estudiantes
				logger.info(nl + "Listado de estudiantes:" + nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach(estudiante -> logger.info(estudiante.toString() + nl));
			}
			case 2 -> {// buscar estudiante
				logger.info("Ingrese el id del estudiante a buscar:");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if (estudiante != null){
					logger.info("Estudiante encontrado: " + estudiante + nl);
				}else{
					logger.info("Estudiante no encontrado" + nl);
				}
			}
			case 3 -> {// agregar estudiante
				logger.info("Agregar Estudiante: " + nl);
				logger.info("Ingrese el nombre del estudiante:");
				var nombre = consola.nextLine();
				logger.info("Ingrese el apellido del estudiante:");
				var apellido = consola.nextLine();
				logger.info("Ingrese el telefono del estudiante:");
				var telefono = Integer.parseInt(consola.nextLine());
				logger.info("Ingrese el email del estudiante:");
				var email = consola.nextLine();
				//Crear el objeto estudiante sin el id
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				//Guardar el estudiante
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante guardado con exito!" + estudiante + nl);
			}
			case 4 -> { //modificar estudiante
				logger.info("Modificar Estudiante: " + nl);
				logger.info("Ingrese el id del estudiante a modificar:");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscar el estudiante a modificar
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Estudiante encontrado: " + estudiante + nl);
					logger.info("Ingrese el nuevo nombre del estudiante:");
					var nombre = consola.nextLine();
					logger.info("Ingrese el nuevo apellido del estudiante:");
					var apellido = consola.nextLine();
					logger.info("Ingrese el nuevo telefono del estudiante:");
					var telefono = Integer.parseInt(consola.nextLine());
					logger.info("Ingrese el nuevo email del estudiante:");
					var email = consola.nextLine();
					//Modificar el estudiante
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: " + estudiante + nl);
				} else {
					logger.info("Estudiante no encontrado con id: " + idEstudiante + nl);
				}
			}
			case 5 -> { //eliminar estudiante
				logger.info("Eliminar Estudiante: " + nl);
				logger.info("Ingrese el id del estudiante a eliminar:");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscar el estudiante a eliminar
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Estudiante encontrado: " + estudiante + nl);
					//Eliminar el estudiante
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado con exito!" + nl);
				} else {
					logger.info("Estudiante no encontrado con id: " + idEstudiante + nl);
				}
			}
			case 6 -> { //salir
				logger.info("Saliendo del sistema..." + nl);
				salir = true;
			}
			default -> logger.info("Opción no valida" + nl);
		}//fin switch
		return salir;
	}
}
