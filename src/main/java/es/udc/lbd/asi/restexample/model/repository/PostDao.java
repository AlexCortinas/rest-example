package es.udc.lbd.asi.restexample.model.repository;

import java.util.List;

import es.udc.lbd.asi.restexample.model.domain.Post;

public interface PostDao {
  List<Post> findAll();

  Post findById(Long id);

  void create(Post post);

  void update(Post post);

  void deleteById(Long id);
}
