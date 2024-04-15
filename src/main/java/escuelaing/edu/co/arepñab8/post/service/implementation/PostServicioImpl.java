package escuelaing.edu.co.arepñab8.post.service.implementation;

import java.util.List;

import escuelaing.edu.co.arepñab8.post.domain.Post;
import escuelaing.edu.co.arepñab8.post.persistence.repository.PostRepositorio;
import escuelaing.edu.co.arepñab8.post.service.PostServicio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostServicioImpl implements PostServicio{

    private PostRepositorio postRepositorio;

    @Inject
    public PostServicioImpl(PostRepositorio postRepositorio) {
        this.postRepositorio = postRepositorio;
    }


    @Override
    public List<Post> consultarPosts(){
        return postRepositorio.consultarPosts();
    }


    
}
