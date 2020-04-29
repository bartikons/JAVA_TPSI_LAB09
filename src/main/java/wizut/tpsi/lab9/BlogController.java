/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.lab9;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author naeri
 */
@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @PostMapping("/post")
    public String post(BlogPost post) throws SQLException {
        blogRepository.deletePost(post);
        return "redirect:/";
    }

    @GetMapping("/post")
    public String post(Model model) throws SQLException {
        model.addAttribute("blogRepository", blogRepository.getAllPosts());
        return "post";
    }

    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException {
        blogRepository.createPost(post);
        return "redirect:/";
    }

    @GetMapping("/newpost")
    public String newpost() {
        return "newpost";
    }
}
