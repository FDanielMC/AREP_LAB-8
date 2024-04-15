package escuelaing.edu.co.arepñab8.usuario.persistence.repository;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.usuario.domain.Usuario;
import escuelaing.edu.co.arepñab8.usuario.persistence.dao.LoginDAO;
import escuelaing.edu.co.arepñab8.usuario.persistence.dao.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioRepositorio {

    private UsuarioDAO usuarioDAO;
    private LoginDAO loginDAO;

    @Inject
    public UsuarioRepositorio(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.loginDAO = new LoginDAO();
    }

    public Usuario agregarUsuario(Usuario usuario) throws TwitterException {
        return usuarioDAO.agregarUsuario(usuario);
    }

    public Usuario consultarUsuarioPorId(String usuario) throws TwitterException {
        return usuarioDAO.consultarUsuarioPorId(usuario);
    }

    public Usuario login(String usuario, String contrasena) throws TwitterException {
        if(!loginDAO.existeUsuario(usuario, contrasena)){
            throw new TwitterException("El usuario o contraseña incorrectos");
        } 
        return usuarioDAO.consultarUsuarioPorId(usuario);       

    }

    
}
