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
    public Profesor actualizarProfesor(int id) {
        return null;
    }

    @Override
    public List<Profesor> listarProfesor() {

        List<Profesor> listaAMostrar = new ArrayList<>();
        listaAMostrar = objProfesorRepo.findAll();
        return listaAMostrar;
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
