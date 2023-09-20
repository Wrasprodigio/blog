package com.spring.blog.controller;

import com.spring.blog.model.Post;
import com.spring.blog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        List<Post> posts = blogService.findByAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("posts", posts);
        return mav;
    }

    @GetMapping(value = "/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Post> posts = blogService.listAll(keyword);
        model.addAttribute("posts", posts);
        model.addAttribute("keyword", keyword);

        return "index";
    }


    @GetMapping(value = "/api/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("postDetails");
        Post post = blogService.findById(id);
        mav.addObject("post", post);
        return mav;
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
        attributes.addFlashAttribute("addSucesso", "Post adicionado com sucesso.");
        return "redirect:/posts";
    }

    @GetMapping("/posts/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("post", blogService.findById(id));

        return "editar_post";
    }

    @PostMapping("/posts/{id}")
    public String atualizarPost(@PathVariable Long id, @ModelAttribute("post") Post post, RedirectAttributes attributes) {
        Post postExiste = blogService.findById(id);
//        postExiste.setId(id);
        postExiste.setTitulo(post.getTitulo());
        postExiste.setAutor(post.getAutor());
        postExiste.setTexto(post.getTexto());

        blogService.save(postExiste);
        attributes.addFlashAttribute("editSucesso", "Post editado com sucesso!");
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String excluirPost(@PathVariable Long id, RedirectAttributes attributes) {
        blogService.excluirPost(id);
        attributes.addFlashAttribute("deleteSucesso", "Post excluido com sucesso!");
        return "redirect:/posts";

    }

}
