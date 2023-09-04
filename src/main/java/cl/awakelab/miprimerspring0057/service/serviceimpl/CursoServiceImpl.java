package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.repository.ICursoRepository;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {
    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public Curso crearCurso(Curso curso) {
        Curso nuevoCurso = new Curso();
        nuevoCurso = objCursoRepo.save(curso);
        return nuevoCurso;
    }

    @Override
    public Curso actualizarCurso(int id) {
        return null;
    }

    @Override
    public List<Curso> listarCurso() {
        List<Curso> listaAMostrar = new ArrayList<>();
        listaAMostrar = objCursoRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public void eliminarCurso(int id) {
        objCursoRepo.deleteById(id);
    }

    @Override
    public void eliminarCurso2(Curso curso) {
        objCursoRepo.delete(curso);
    }
}
