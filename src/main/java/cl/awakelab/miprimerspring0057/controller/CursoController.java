package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listaUsuarios(Model model){
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("atributoListaCursos", listaCursos);

        return "templateListarCursos";
    }

    @GetMapping("/listar/{id}")
    public String listarCursoId(@PathVariable int id, Model model){
        model.addAttribute("tituloCursoId", "Curso encontrado por ID");
        Curso cursoEncontrado = objCursoService.listarCursoID(id);
        model.addAttribute("cursoEncontrado",cursoEncontrado);

        return "templateListarCursoID";
    }

    @GetMapping("/crearCurso")
    public String formCrearCurso(){

        return "templateFormCrearCurso";
    }

    @PostMapping("/crearCurso")
    public String crearCurso(@ModelAttribute Curso curso){
        objCursoService.crearCurso(curso);

        return "redirect:/curso";
    }
}