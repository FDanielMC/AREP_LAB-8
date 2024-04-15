package escuelaing.edu.co.arepñab8.post.persistence.repository;

import java.util.List;

import escuelaing.edu.co.arepñab8.post.domain.Post;
import escuelaing.edu.co.arepñab8.post.persistence.dao.PostDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostRepositorio {

    private PostDAO postDAO;

    @Inject
    public PostRepositorio(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public List<Post> consultarPosts(){
        return postDAO.consultarPosts();
    }

}
