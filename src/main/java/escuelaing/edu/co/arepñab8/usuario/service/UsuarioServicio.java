package escuelaing.edu.co.arepñab8.usuario.service;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.usuario.domain.Usuario;


public interface UsuarioServicio {

    Usuario agregarUsuario(Usuario usuario) throws TwitterException;

    Usuario consultarUsuarioPorId(String usuario) throws TwitterException;

    String login(String login) throws TwitterException;
    
}
