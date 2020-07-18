package itspace.am.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "image")
@Entity
public class ImgClass {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @Column
    private Date uploadDate;
    @Column
    private String picUrl;

}
