package itspace.am.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;

}
