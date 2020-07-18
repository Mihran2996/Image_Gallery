package itspace.am.demo.controller;

import itspace.am.demo.model.Category;
import itspace.am.demo.model.ImgClass;
import itspace.am.demo.service.CategoryService;
import itspace.am.demo.service.ImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ImgService imgService;

    @GetMapping("/")
    public String homePage(Model model, @AuthenticationPrincipal Principal principal) {
        String userName = null;
        if (principal != null) {
            userName = principal.getName();
        }
        List<Category> all = categoryService.findAll();
        List<ImgClass> all1 = imgService.findAll();
        model.addAttribute("categories", all);
        model.addAttribute("images", all1);
        model.addAttribute("username", userName);
        return "index";
    }

    @PostMapping("/saveCategory")
    public String save(@ModelAttribute Category category) throws IOException {
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("/addCategory")
    public String addCategory() {
        return "addCategory";
    }
}
