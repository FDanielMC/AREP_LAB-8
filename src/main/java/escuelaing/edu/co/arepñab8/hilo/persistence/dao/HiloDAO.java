package escuelaing.edu.co.arepñab8.hilo.persistence.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.hilo.domain.Hilo;
import escuelaing.edu.co.arepñab8.post.domain.Post;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class HiloDAO {
    
    private HashMap<String, Hilo> hilos;

    public HiloDAO() {
        this.hilos = new HashMap<>();
        hilos.put("1", new Hilo("1", "Daniel Moreno", new ArrayList<>()));
    }

    public Hilo agregarHilo(Hilo hilo) throws TwitterException {
        if(hilos.containsKey(hilo.getId()) || hilo.getId() == null){
            throw new TwitterException("El hilo ya existe o el id es nulo");
        }
        return hilos.put(hilo.getId(), hilo);
    }

    public List<Hilo> consultarHilos(){
        return  hilos.values().stream().toList();
    }

    public Hilo consultarHiloPorId(String id) throws TwitterException {
        if (!hilos.containsKey(id)) {
            throw new TwitterException("El hilo no existe");
            
        }
        return hilos.get(id);
    }

    public void agregarPostAlHilo(String id, Post post) throws TwitterException{
        Hilo hilo = consultarHiloPorId(id);
        hilo.agregarPost(post);
    }
}
