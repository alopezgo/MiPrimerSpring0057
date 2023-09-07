package cl.awakelab.miprimerspring0057.controller;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public String listaUsuarios(Model model){
        List<Usuario> listaDeUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaDeUsuarios", listaDeUsuarios);

        return "templateListarUsuarios";
    }
    @GetMapping("/listar/{id}")
    public String listarUsuarioId(@PathVariable int id, Model model){
        model.addAttribute("tituloUsuarioId", "Usuario encontrado por ID");
        Usuario usuarioEncontrado = objUsuarioService.listarUsuarioID(id);
        model.addAttribute("usuarioEncontrado",usuarioEncontrado);

        return "templateListarUsuarioID";
    }

//    @GetMapping("/agregar")
//    public String formulario(Model model){
//        model.addAttribute("titulo", "Formulario de agregación de usuario");
//
//        return "templateFormAgregarUsuario";
//    }
//
//    @PostMapping("/agregarUsuario")
//    public String agregarUsuario(Model model, @RequestParam String nombreUsuario,
//                                 @RequestParam String contrasena, @RequestParam String rol){
//        Usuario usuarioAgregar = new Usuario();
//        usuarioAgregar.setNombreUsuario(nombreUsuario);
//        usuarioAgregar.setContrasena(contrasena);
//        usuarioAgregar.setRol(rol);
//        objUsuarioService.crearUsuario(usuarioAgregar);
//        model.addAttribute("mensaje","Usuario agregado correctamente");
//
//        return "redirect:/listar";
//    }

    @GetMapping("/crearUsuario")
    public String formCrearUsuario(){

        return "templateFormCrearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objUsuarioService.crearUsuario(usuario);

        return "redirect:/usuario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);

        return "redirect:/listar";
    }
}