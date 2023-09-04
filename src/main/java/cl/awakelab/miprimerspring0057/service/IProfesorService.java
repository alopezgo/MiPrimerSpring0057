package cl.awakelab.miprimerspring0057.service;

import cl.awakelab.miprimerspring0057.entity.Profesor;

import java.util.List;

public interface IProfesorService {
    public Profesor crearProfesor(Profesor profesor);
    public Profesor actualizarProfesor(Profesor profesor);
    public List<Profesor> listarProfesor();
    public Profesor listarProfesorID(int id);
    public void eliminarProfesor(int id);
    public void eliminarProfesor2(Profesor profesor);

}
