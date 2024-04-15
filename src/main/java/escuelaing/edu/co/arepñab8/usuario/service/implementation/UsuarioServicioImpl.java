package escuelaing.edu.co.arepñab8.usuario.service.implementation;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.usuario.persistence.repository.UsuarioRepositorio;
import org.json.JSONObject;

import escuelaing.edu.co.arepñab8.usuario.domain.Usuario;
import escuelaing.edu.co.arepñab8.usuario.service.UsuarioServicio;
import escuelaing.edu.co.arepñab8.usuario.util.GenerateToken;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepositorio usuarioRepositorio;


    @Inject
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @Override
    public Usuario agregarUsuario(Usuario usuario) throws TwitterException {
        return usuarioRepositorio.agregarUsuario(usuario);
    }

    @Override
    public Usuario consultarUsuarioPorId(String usuario) throws TwitterException {
        return usuarioRepositorio.consultarUsuarioPorId(usuario);
    }

    @Override
    public String login(String login) throws TwitterException {
        JSONObject objetoJson = new JSONObject(login);
        String usuario = objetoJson.getString("username");
        String contrasena = objetoJson.getString("password");
        Usuario usuarioRepo = usuarioRepositorio.login(usuario, contrasena);
        return GenerateToken.createJWT(usuarioRepo, 3600);
    }
}
