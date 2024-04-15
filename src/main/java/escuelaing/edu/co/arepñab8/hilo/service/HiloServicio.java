package escuelaing.edu.co.arepñab8.hilo.service;

import java.util.List;

import escuelaing.edu.co.arepñab8.exception.TwitterException;
import escuelaing.edu.co.arepñab8.hilo.domain.Hilo;
import escuelaing.edu.co.arepñab8.post.domain.Post;

public interface HiloServicio {

    Hilo agregarHilo(Hilo hilo) throws TwitterException;

    List<Hilo> consultarHilos();

    Hilo consultarHiloPorId(String id) throws TwitterException;

    void agregarPostAlHilo(String id, Post post) throws TwitterException;
    
}
