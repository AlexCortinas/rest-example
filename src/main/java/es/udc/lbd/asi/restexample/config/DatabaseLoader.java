package es.udc.lbd.asi.restexample.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import es.udc.lbd.asi.restexample.model.domain.Post;
import es.udc.lbd.asi.restexample.model.domain.User;
import es.udc.lbd.asi.restexample.model.repository.PostDAO;
import es.udc.lbd.asi.restexample.model.repository.UserDAO;

@Configuration
public class DatabaseLoader {
    @Autowired
    private UserDAO userService;

    @Autowired
    private PostDAO postService;

    @Autowired
    private DatabaseLoader databaseLoader;

    /*
     * Para hacer que la carga de datos sea transacional, hay que cargar el propio
     * objeto como un bean y lanzar el método una vez cargado, ya que en el
     * PostConstruct (ni similares) se tienen en cuenta las anotaciones de
     * transaciones.
     */
    @PostConstruct
    public void init() {
        databaseLoader.loadData();
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void loadData() {
        userService.save(new User("Pepe"));
        userService.save(new User("María"));
        userService.save(new User("Laura"));

        postService.save(new Post("Título 1", "Texto del primer post", userService.findByName("Pepe")));
        postService.save(new Post("Título 2", "Texto del segundo post", userService.findByName("María")));
        postService.save(new Post("Título 3", "Texto del tercero post", userService.findByName("María")));
        postService.save(new Post("Título 4", "Texto del cuarto post", userService.findByName("Laura")));
        postService.save(new Post("Título 5", "Texto del quinto post", userService.findByName("Laura")));
        postService.save(new Post("Título 6", "Texto del sexto post", userService.findByName("Laura")));
    }
}
