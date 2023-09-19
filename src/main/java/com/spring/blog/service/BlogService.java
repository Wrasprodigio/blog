package com.spring.blog.service;

import com.spring.blog.model.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BlogService {

    List<Post> findByAll();
    List<Post> listAll(String keyword);

    Post findById(long id);

    Post save(Post post);

    void excluirPost(Long id);
}
