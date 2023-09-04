package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepository objAlumnoRepo;
    @Override
    public Alumno crearAlumno(Alumno alumno) {
        Alumno nuevoUsuario = new Alumno();
        nuevoUsuario = objAlumnoRepo.save(alumno);
        return nuevoUsuario;
    }

    @Override
    public Alumno actualizarAlumno(Alumno alumno) {
        Alumno actualizarAlumno = objAlumnoRepo.findById(alumno.getId()).orElse(null);
        actualizarAlumno.setNombres(alumno.getNombres());
        actualizarAlumno.setApellido1(alumno.getApellido1());
        actualizarAlumno.setApellido2(alumno.getApellido2());
        actualizarAlumno.setCursoAsignado(alumno.getCursoAsignado());
        return objAlumnoRepo.save(actualizarAlumno);
    }
    @Override
    public List<Alumno> listarAlumno() {
        List<Alumno> listaAMostrar = new ArrayList<>();
        listaAMostrar = objAlumnoRepo.findAll();
        return listaAMostrar;
    }
    @Override
    public Alumno listarAlumnoID(int id) {
        return objAlumnoRepo.findById(id).orElse(null);
    }
    @Override
    public void eliminarAlumno(int id) {
        objAlumnoRepo.deleteById(id);
    }
    @Override
    public void eliminarAlumno2(Alumno alumno) {
        objAlumnoRepo.delete(alumno);
    }
}
