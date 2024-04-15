package escuelaing.edu.co.arepñab8.hilo.persistence.repository;

import java.util.List;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.hilo.domain.Hilo;
import escuelaing.edu.co.arepñab8.hilo.persistence.dao.HiloDAO;
import escuelaing.edu.co.arepñab8.post.domain.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HiloRepositorio {

    private HiloDAO hiloDAO;

    @Inject
    public HiloRepositorio(HiloDAO hiloDAO) {
        this.hiloDAO = hiloDAO;
    }

    public Hilo agregarHilo(Hilo hilo) throws TwitterException {
        return hiloDAO.agregarHilo(hilo);
    }

    public List<Hilo> consultarHilos(){
        return hiloDAO.consultarHilos();
    }

    public Hilo consultarHiloPorId(String id) throws TwitterException {
        return hiloDAO.consultarHiloPorId(id);
    }

    public void agregarPostAlHilo(String id, Post post) throws TwitterException  {
        hiloDAO.agregarPostAlHilo(id, post);
    }
    
}
