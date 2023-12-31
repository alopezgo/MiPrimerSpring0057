package cl.awakelab.miprimerspring0057.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name="nombre_curso", nullable = false, length = 100)
    private String nombreCurso;

    @ManyToMany(mappedBy = "listaCursos")
    private List<Profesor> listaProfesores;

    @OneToMany(mappedBy = "cursoAsignado")
    private List<Alumno> listaAlumnos;

}
