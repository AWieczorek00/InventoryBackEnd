package pl.inventorybackend.entiti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String serialNumber;
    private String typeOfEquipment;
    private LocalDate dateOfPurchase;
    private int roomNumber;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @Nullable
    private Employee employee;
    private boolean isRepair;


}
