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
    public String index(Model model) throws SQLException {
        model.addAttribute("blogRepository", blogRepository.getAllPosts());
        return "index";
    }
    
    @PostMapping("/post")
    public String post(Model model,BlogPost post) throws SQLException {
        blogRepository.deletePost(post);
        model.addAttribute("blogRepository", blogRepository.getAllPosts());
        return "redirect:/";
    }

    @PostMapping("/newpost")
    public String newPost(Model model,BlogPost post) throws SQLException {
        blogRepository.createPost(post);
        model.addAttribute("blogRepository", blogRepository.getAllPosts());
        return "redirect:/";
    }
}
