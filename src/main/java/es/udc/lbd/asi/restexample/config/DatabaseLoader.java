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
    private UserDAO userDAO;

    @Autowired
    private PostDAO postDAO;

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
        userDAO.save(new User("Pepe"));
        userDAO.save(new User("María"));
        userDAO.save(new User("Laura"));

        postDAO.save(new Post("Título 1", "Texto del primer post", userDAO.findByName("Pepe")));
        postDAO.save(new Post("Título 2", "Texto del segundo post", userDAO.findByName("María")));
        postDAO.save(new Post("Título 3", "Texto del tercero post", userDAO.findByName("María")));
        postDAO.save(new Post("Título 4", "Texto del cuarto post", userDAO.findByName("Laura")));
        postDAO.save(new Post("Título 5", "Texto del quinto post", userDAO.findByName("Laura")));
        postDAO.save(new Post("Título 6", "Texto del sexto post", userDAO.findByName("Laura")));
    }
}
