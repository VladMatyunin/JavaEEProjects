package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.form.PostForm;
import ru.kpfu.itis.model.Post;
import ru.kpfu.itis.model.Tag;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.repository.TagRepository;
import ru.kpfu.itis.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Vlad.M on 07.09.2016.
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TagRepository tagRepository;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadProfile(ModelMap modelMap){
        modelMap.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        modelMap.addAttribute("tags",tagRepository.findAll());
        modelMap.addAttribute("postform", new PostForm());
        return "Profile";
    }
    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String addPost(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("tags") String tags){
        ArrayList<Tag> tagsList = new ArrayList<>();

        String[] tagsArray = tags.split(",");
        for(int i = 0; i < tagsArray.length; i++){
            tagsList.add(tagRepository.findByName(tagsArray[i]));
        }
        System.out.print("______________"+tags);
        postRepository.save(new Post(name,text,userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()),tagsList, new Date()));
        return "redirect:/profile";
    }
}
