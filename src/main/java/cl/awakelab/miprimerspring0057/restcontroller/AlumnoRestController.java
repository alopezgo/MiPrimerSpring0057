package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/alumno")
public class AlumnoRestController {
    @Autowired
    IAlumnoService objAlumnoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno){
        return objAlumnoService.crearAlumno(alumno);
    }
    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@RequestBody Alumno alumno){
        return objAlumnoService.actualizarAlumno(alumno);
    }
    @GetMapping
    public List<Alumno> listarAlumno(){
        return objAlumnoService.listarAlumno();
    }
    @GetMapping("/{id}")
    public Alumno listarAlumnoID(@PathVariable int id){

        return objAlumnoService.listarAlumnoID(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
        return true;
    }
    @DeleteMapping
    public boolean eliminarAlumno(@RequestBody Alumno alumno){
        objAlumnoService.eliminarAlumno2(alumno);
        return true;
    }
}
