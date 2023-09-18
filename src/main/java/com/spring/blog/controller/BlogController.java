package com.spring.blog.controller;

import com.spring.blog.model.Post;
import com.spring.blog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;


    @GetMapping(value = "/posts")
    public ModelAndView getPosts() {
        ModelAndView mav = new ModelAndView("posts");
        List<Post> posts = blogService.findByAll();
        mav.addObject("posts", posts);
        return mav;
    }

    @GetMapping(value = "/api/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("postDetails");
        Post post = blogService.findById(id);
        mav.addObject("post", post);
        return mav;
    }

    @GetMapping(value = "buscarPorNome") /* mapeia a url */
    @ResponseBody /* Descrição da resposta */
    ResponseEntity<List<Post>> buscarPorNome(@RequestParam(name = "name") String name) { /* Recebe os dados para consultar */

        List<Post> posts = blogService.buscarPorNome(name.trim().toUpperCase());
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

    @GetMapping(value = "/newpost")
    public String getPostForm() {
        return "postForm";
    }

    @PostMapping(value = "/newpost") /* mapeia a url */
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        blogService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("post", blogService.findById(id));
        return "editar_post";
    }
    @PostMapping("/posts/{id}")
    public String atualizarPost(@PathVariable Long id, @ModelAttribute("estudante") Post post, Model modelo) {
        Post postExiste = blogService.findById(id);
        postExiste.setId(id);
        postExiste.setTitulo(post.getTitulo());
        postExiste.setAutor(post.getAutor());
        postExiste.setTexto(post.getTexto());

        blogService.save(postExiste);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}")
    public String excluirPost(@PathVariable Long id) {
        blogService.excluirPost(id);
        return "redirect:/posts";
    }

}
