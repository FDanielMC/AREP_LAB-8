package escuelaing.edu.co.arepñab8.usuario.persistence.dao;

import java.util.HashMap;
import java.util.Map;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.usuario.domain.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDAO {

    private Map<String,Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new HashMap<>();
        usuarios.put("DanielMoreno", new Usuario("Daniel Moreno", "DanielMoreno"));
        usuarios.put("JuanVivas", new Usuario("Juan Vivas", "JuanVivas"));
        usuarios.put("SergioLopez", new Usuario("Sergio Lopez", "SergioLopez"));
    }

    public Usuario agregarUsuario(Usuario usuario) throws TwitterException {
        if(usuarios.containsKey(usuario.getUsuario()) || usuario.getUsuario() == null){
            throw new TwitterException("Usuario existente o id es nulo");
        }
        return usuarios.put(usuario.getUsuario(), usuario);
    }

    public Usuario consultarUsuarioPorId(String usuario) throws TwitterException {
        if (!usuarios.containsKey(usuario)) {
            throw new TwitterException("Usuario no existente");
        }
        return usuarios.get(usuario);
    }
    
}
