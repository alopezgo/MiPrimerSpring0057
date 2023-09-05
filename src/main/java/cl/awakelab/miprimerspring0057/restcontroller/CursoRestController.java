package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {
    @Autowired
    ICursoService objCursoService;
    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso){
        return objCursoService.crearCurso(curso);
    }
    @PutMapping("/{id}")
    public Curso actualizarCurso(@RequestBody Curso curso){
        return objCursoService.actualizarCurso(curso);
    }
    @GetMapping
    public List<Curso> listarCurso(){
        return objCursoService.listarCurso();
    }
    @GetMapping("/{id}")
    public Curso listarCursoID(@PathVariable int id){
        return objCursoService.listarCursoID(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return true;
    }
    @DeleteMapping
    public boolean eliminarCurso(@RequestBody Curso curso){
        objCursoService.eliminarCurso2(curso);
        return true;
    }
}
