package gm.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;


@Entity
// boilerplate code - repetitivo
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String email;
}
