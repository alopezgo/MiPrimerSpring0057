package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
