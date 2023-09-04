package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario usuario);
    public Usuario actualizarUsuario(int id);
    public List<Usuario> listarUsuario();
    public void eliminarUsuario(int id);
}
