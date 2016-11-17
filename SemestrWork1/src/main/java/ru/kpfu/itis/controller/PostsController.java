package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Comment;
import ru.kpfu.itis.model.Post;
import ru.kpfu.itis.repository.CommentRepository;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.repository.UserRepository;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Controller
@RequestMapping(value = "/post")
public class PostsController {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String loadPosts(@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("post", postRepository.findOne(id));
        modelMap.addAttribute("comments", postRepository.findOne(id).getComments());
        return "Post";
    }
    @RequestMapping(value = "/{id}/newcomment/", method = RequestMethod.POST)
    public String addComment(@PathVariable("id") Long id, @RequestParam("text") String text){
        commentRepository.save(new Comment(text, userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())));
        Post post = postRepository.findOne(id);
        post.getComments().add(new Comment(text, userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())));
        postRepository.save(post);
        return "redirect:/post/"+id;
    }
}
