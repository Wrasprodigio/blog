package com.spring.blog.repository;

import com.spring.blog.model.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface BlogRepository extends JpaRepository<Post, Long> {

    @Query("SELECT u FROM Post u WHERE (trim(u.titulo)) ILIKE %?1%"
            + " OR (trim(u.autor)) ILIKE %?1%"
            + " OR CONCAT(u.id, '') ILIKE %?1%")
    public List<Post> findAll(String keyword);


}
