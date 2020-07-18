package itspace.am.demo.service;

import itspace.am.demo.model.ImgClass;
import itspace.am.demo.repository.ImgClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImgService {
    private final ImgClassRepository imgClassRepository;

    public void save(ImgClass imgClass) {
        imgClassRepository.save(imgClass);
    }


    public List<ImgClass> findAll() {
        return imgClassRepository.findAll();
    }

    public List<ImgClass> findAllByCategory(int id) {
        return imgClassRepository.findAllByCategory_Id(id);

    }
}
