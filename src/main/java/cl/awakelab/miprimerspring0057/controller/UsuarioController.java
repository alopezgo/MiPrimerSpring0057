package cl.awakelab.miprimerspring0057.controller;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;
    public String listaUsuarios(Model model){
        List<Usuario> listaDeUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaDeUsuarios", listaDeUsuarios);
        return "templateListarUsuarios";
    }
}