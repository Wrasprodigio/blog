package com.spring.blog.service.serviceImplements;

import com.spring.blog.model.Post;
import com.spring.blog.repository.BlogRepository;
import com.spring.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImplements implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Post> findByAll() {
        return blogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return blogRepository.save(post);
    }


    @Override
    public List<Post> buscarPorNome(String name) {
        return blogRepository.buscarPorNome(name);
    }

    @Override
    public void excluirPost(Long id) {
        blogRepository.deleteById(id);
    }
}
