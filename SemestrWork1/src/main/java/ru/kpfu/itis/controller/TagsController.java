package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.repository.PostRepository;
import ru.kpfu.itis.repository.TagRepository;

/**
 * Created by Vlad.M on 09.09.2016.
 */
@Controller
public class TagsController {
    @Autowired
    TagRepository tagRepository;
    @Autowired
    PostRepository postRepository;
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("tagname") String tagname, ModelMap modelMap){
        if (tagRepository.findByName(tagname)!=null){
            modelMap.addAttribute("Posts",postRepository.findByTagsName(tagname));
        }
        return "Tags";
    }
}
