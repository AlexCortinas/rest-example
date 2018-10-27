package es.udc.lbd.asi.restexample.model.service.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import es.udc.lbd.asi.restexample.model.domain.Post;

public class PostDTO {
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String body;
    @NotNull
    private UserDTOPublic author;

    public PostDTO() {
    }

    public PostDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.author = new UserDTOPublic(post.getAuthor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserDTOPublic getAuthor() {
        return author;
    }

    public void setAuthor(UserDTOPublic author) {
        this.author = author;
    }
}
