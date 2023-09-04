package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.repository.IProfesorRepository;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {
    @Autowired
    IProfesorRepository objProfesorRepo;
    @Override
    public Profesor crearProfesor(Profesor profesor) {
        Profesor nuevoProfesor = new Profesor();
        nuevoProfesor = objProfesorRepo.save(profesor);
        return nuevoProfesor;
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
        Profesor actualizarProfesor = objProfesorRepo.findById(profesor.getId()).orElse(null);
        actualizarProfesor.setNombres(profesor.getNombres());
        actualizarProfesor.setApellido1(profesor.getApellido1());
        actualizarProfesor.setApellido2(profesor.getApellido2());
        actualizarProfesor.setListaCursos(profesor.getListaCursos());
        return objProfesorRepo.save(actualizarProfesor);
    }

    @Override
    public List<Profesor> listarProfesor() {

        List<Profesor> listaAMostrar = new ArrayList<>();
        listaAMostrar = objProfesorRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public Profesor listarProfesorID(int id) {
        return objProfesorRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarProfesor(int id) {
        objProfesorRepo.deleteById(id);

    }

    @Override
    public void eliminarProfesor2(Profesor profesor) {
        objProfesorRepo.delete(profesor);
    }
}
