package es.udc.lbd.asi.restexample.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.lbd.asi.restexample.model.domain.Post;
import es.udc.lbd.asi.restexample.model.repository.PostDAO;
import es.udc.lbd.asi.restexample.model.repository.UserDAO;
import es.udc.lbd.asi.restexample.model.service.dto.PostDTO;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PostService {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UserDAO userDAO;

    public List<PostDTO> findAll() {
        return postDAO.findAll().stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
    }

    public PostDTO findById(Long id) {
        return new PostDTO(postDAO.findById(id));
    }

    @Transactional(readOnly = false)
    public PostDTO save(PostDTO post) {
        Post bdPost = new Post(post.getTitle(), post.getBody());
        bdPost.setAuthor(userDAO.findById(post.getAuthor().getId()));
        postDAO.save(bdPost);
        return new PostDTO(bdPost);
    }

    @Transactional(readOnly = false)
    public PostDTO update(PostDTO post) {
        Post bdPost = postDAO.findById(post.getId());
        bdPost.setTitle(post.getTitle());
        bdPost.setBody(post.getBody());
        bdPost.setAuthor(userDAO.findById(post.getAuthor().getId()));
        postDAO.save(bdPost);
        return new PostDTO(bdPost);
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        postDAO.deleteById(id);
    }
}
