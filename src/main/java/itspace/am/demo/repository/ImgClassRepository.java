package itspace.am.demo.repository;

import itspace.am.demo.model.ImgClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ImgClassRepository extends JpaRepository<ImgClass, Integer> {
    List<ImgClass> findAllByCategory_Id(int id);
}
