package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.model.Post;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.repository.UserRepository;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Controller
public class MainController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String loadPosts(ModelMap modelMap){
        modelMap.addAttribute("Posts",postRepository.findAll());
        return "mainPage";
    }
    @RequestMapping (value = "/like", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void likePost(@RequestParam("id") Long id ){
        Post post = postRepository.findOne(id);
        post.setRating(post.getRating()+1);
        postRepository.save(post);
        User user = postRepository.findOne(id).getPostOwner();
        user.setRating(postRepository.findOne(id).getPostOwner().getRating()+0.1);
        userRepository.save(user);
        return;
    }
    @RequestMapping (value = "/dislike", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void dislikePost(@RequestParam("id") Long id ){
        Post post = postRepository.findOne(id);
        post.setRating(post.getRating()-1);
        postRepository.save(post);
        User user = postRepository.findOne(id).getPostOwner();
        user.setRating(postRepository.findOne(id).getPostOwner().getRating()-0.1);
        userRepository.save(user);
        return;
    }
}
