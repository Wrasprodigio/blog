package com.spring.blog.repository;

import com.spring.blog.model.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface BlogRepository extends JpaRepository<Post, Long> {

    @Query(value = "select u from Post u where upper(trim(u.titulo)) like %?1%")
    List<Post> buscarPorNome(String name);

}
