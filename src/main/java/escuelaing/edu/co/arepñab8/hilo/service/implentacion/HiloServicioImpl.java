package escuelaing.edu.co.arepñab8.hilo.service.implentacion;

import java.util.List;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.hilo.domain.Hilo;
import escuelaing.edu.co.arepñab8.hilo.persistence.repository.HiloRepositorio;
import escuelaing.edu.co.arepñab8.hilo.service.HiloServicio;
import escuelaing.edu.co.arepñab8.post.domain.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HiloServicioImpl implements HiloServicio {

    private HiloRepositorio hiloRepositorio;

    @Inject
    public HiloServicioImpl(HiloRepositorio hiloRepositorio) {
        this.hiloRepositorio = hiloRepositorio;
    }

    @Override
    public Hilo agregarHilo(Hilo hilo) throws TwitterException {
        return hiloRepositorio.agregarHilo(hilo);
    }

    @Override
    public List<Hilo> consultarHilos(){
        return hiloRepositorio.consultarHilos();
    }

    @Override
    public Hilo consultarHiloPorId(String id) throws TwitterException {
        return hiloRepositorio.consultarHiloPorId(id);
    }

    @Override
    public void agregarPostAlHilo(String id, Post post) throws TwitterException {
        if(post.getComentario().length() > 140){
            throw new TwitterException("El comentario supera los 140 caracteres");
        }
        hiloRepositorio.agregarPostAlHilo(id, post);
    }
    
}
