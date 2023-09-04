package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.repository.IUsuarioRepository;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario = objUsuarioRepo.save(usuario);
        return nuevoUsuario;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario actualizarUsuario = objUsuarioRepo.findById(usuario.getId()).orElse(null);
        actualizarUsuario.setNombreUsuario(usuario.getNombreUsuario());
        actualizarUsuario.setContrasena(usuario.getContrasena());
        actualizarUsuario.setRol(usuario.getRol());
        return objUsuarioRepo.save(actualizarUsuario);
    }

    @Override
    public List<Usuario> listarUsuario() {

        List<Usuario> listaAMostrar = new ArrayList<>();
        listaAMostrar = objUsuarioRepo.findAll();
        return listaAMostrar;
    }

    @Override
    public Usuario listarUsuarioID(int id) {
        return objUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);
    }

    @Override
    public void eliminarUsuario2(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
    }
}
