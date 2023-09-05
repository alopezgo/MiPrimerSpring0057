package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorRestController {
    @Autowired
    IProfesorService objProfesorService;
    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor){
        return objProfesorService.crearProfesor(profesor);
    }
    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@RequestBody Profesor profesor){
        return objProfesorService.actualizarProfesor(profesor);
    }
    @GetMapping
    public List<Profesor> listarProfesor(){
        return objProfesorService.listarProfesor();
    }
    @GetMapping("/{id}")
    public Profesor listarProfesorID(@PathVariable int id){
        return objProfesorService.listarProfesorID(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return true;
    }
    @DeleteMapping
    public boolean eliminarProfesor(@RequestBody Profesor profesor){
        objProfesorService.eliminarProfesor2(profesor);
        return true;
    }

}
