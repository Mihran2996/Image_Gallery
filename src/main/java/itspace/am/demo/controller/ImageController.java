package itspace.am.demo.controller;

import itspace.am.demo.model.Category;
import itspace.am.demo.model.ImgClass;
import itspace.am.demo.service.CategoryService;
import itspace.am.demo.service.ImgService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ImageController {
    @Value("${file.upload.dir}")
    private String uploadDir;
    private final ImgService imgService;
    private final CategoryService categoryService;

    @PostMapping("/saveImage")
    public String save(ImgClass imgClass, @RequestParam("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File image = new File(uploadDir, name);
        file.transferTo(image);
        imgClass.setPicUrl(name);
        imgService.save(imgClass);
        return "redirect:/";
    }

    @GetMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("name") String imageName) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
        return IOUtils.toByteArray(in);
    }

    @GetMapping("/categoryImg")
    public String imgPage(@RequestParam("id") int id, Model model) {
        List<ImgClass> images = imgService.findAllByCategory(id);
        model.addAttribute("images", images);
        return "imagePage";
    }

    @GetMapping("/addImage")
    public String addImage(Model model) {
        List<Category> all = categoryService.findAll();
        model.addAttribute("categories", all);
        return "addImage";
    }
}
