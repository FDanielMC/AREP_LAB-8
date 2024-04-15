package escuelaing.edu.co.arepñab8.usuario.persistence.dao;

import java.util.HashMap;
import java.util.Map;

import escuelaing.edu.co.arepñab8.usuario.util.Encriptacion;

public class LoginDAO {

    private Map<String,String> logins;
    private Encriptacion encriptacion;

    public LoginDAO() {
        logins = new HashMap<>();
        encriptacion = new Encriptacion();
        logins.put("DanielMoreno", encriptacion.hashString("Daniel2003"));
        logins.put("JuanVivas", encriptacion.hashString("Juan2001"));
        logins.put("SergioLopez",encriptacion.hashString("Sergio2002"));
    }

    public boolean existeUsuario(String usuario, String contrasena){
        if(logins.containsKey(usuario)){
            return logins.get(usuario).equals(encriptacion.hashString(contrasena));
        }
        return false;

    }
}
