package escuelaing.edu.co.arepñab8.hilo.domain;

import java.util.Collection;

import escuelaing.edu.co.arepñab8.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Hilo {

    private String id;
    private String usuarioCreador;
    private Collection<Post> posts;

    public void agregarPost(Post post) {
        this.posts.add(post);
    }
    
}
