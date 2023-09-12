package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService objAlumnoService;

    @Autowired
    private ICursoService objCursoService;

    @GetMapping
    public String listarAlumnos(Model model) {
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumno();
        model.addAttribute("listaAlumnos", listaAlumnos);
        return "templateListarAlumnos";
    }
    @GetMapping("/{id}")
    public String listarAlumnoId(@PathVariable int id, Model model){
        model.addAttribute("tituloAlumnoId", "Alumno encontrado por ID");
        Alumno alumnoEncontrado = objAlumnoService.listarAlumnoID(id);
        model.addAttribute("alumnoEncontrado",alumnoEncontrado);

        return "templateListarAlumnos";
    }

    @GetMapping("/crearAlumno")
    public String formCrearAlumno(Model model) {
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("listaCursos", listaCursos);
        return "templateFormCrearAlumno";
    }

    @PostMapping("/crearAlumno")
    public String crearAlumno(@ModelAttribute Alumno alumno) {
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/alumno";
    }

    @PostMapping("/editar/{id}")
    public String editarAlumno(@ModelAttribute Alumno alumno){
        objAlumnoService.actualizarAlumno(alumno);
        return "redirect:/alumno";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {
        objAlumnoService.eliminarAlumno(id);
        return "redirect:/alumno";
    }
}
