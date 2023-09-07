package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;

    @GetMapping
    public String listaProfesores(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesor();
        model.addAttribute("atributoListaProfesores", listaProfesores);

        return "templateListarProfesores";
    }

    @GetMapping("/listar/{id}")
    public String listarProfesorId(@PathVariable int id, Model model){
        model.addAttribute("tituloProfesorId", "Profesor encontrado por ID");
        Profesor profesorEncontrado = objProfesorService.listarProfesorID(id);
        model.addAttribute("profesorEncontrado",profesorEncontrado);

        return "templateListarProfesorID";
    }
    @GetMapping("/crearProfesor")
    public String formCrearProfesor(){
        return "templateFormCrearProfesor";
    }

    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);

        return "redirect:/profesor";
    }
}
