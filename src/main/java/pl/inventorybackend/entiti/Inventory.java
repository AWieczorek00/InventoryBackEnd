package pl.inventorybackend.entiti;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Inventory {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long inventoryNumber;
    private String inventoryName;
    private LocalDate dateOfCreation;



    @ManyToMany
    @JoinColumn(name = "equipment_id")
    private Set<Equipment> equipment;
}
