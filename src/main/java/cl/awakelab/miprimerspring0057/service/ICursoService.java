package cl.awakelab.miprimerspring0057.service;

import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.entity.Profesor;

import java.util.List;

public interface ICursoService {
    public Curso crearCurso(Curso curso);
    public Curso actualizarCurso(Curso curso);
    public List<Curso> listarCurso();
    public Curso listarCursoID(int id);
    public void eliminarCurso(int id);
    public void eliminarCurso2(Curso curso);
}
