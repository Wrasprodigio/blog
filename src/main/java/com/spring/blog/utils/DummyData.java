package com.spring.blog.utils;

import com.spring.blog.model.Post;
import com.spring.blog.repository.BlogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    BlogRepository blogRepository;

    //@PostConstruct
    public void savePosts() {
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Willyam Rodrigo");
        post1.setData(LocalDate.now());
        post1.setTitulo("Java");
        post1.setTexto("Java é uma linguagem de programação orientada a objetos desenvolvida na década de 90 por uma equipe de programadores chefiada por James Gosling, na empresa Sun Microsystems, que em 2008 foi adquirido pela empresa Oracle Corporation.");

        Post post2 = new Post();
        post2.setAutor("Rafael Santis");
        post2.setData(LocalDate.now());
        post2.setTitulo("C#");
        post2.setTexto("C# é uma linguagem de programação, multiparadigma, de tipagem forte, desenvolvida pela Microsoft como parte da plataforma .NET. A sua sintaxe orientada a objetos foi baseada no C++ mas inclui muitas influências de outras linguagens de programação, como Object Pascal e, principalmente, Java.");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList) {
            Post postSaved = blogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
