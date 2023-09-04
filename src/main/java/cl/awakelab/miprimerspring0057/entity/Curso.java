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

    @Column(nullable = false, length = 1)
    private String nombre;

    @ManyToMany(mappedBy = "cursos")
    private List<Profesor> profesores;

    @OneToMany
    private List<Alumno> alumnos;
}
