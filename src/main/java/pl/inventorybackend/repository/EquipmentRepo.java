package pl.inventorybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.inventorybackend.entiti.Equipment;

import java.util.Optional;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findEquipmentById(Long id);

    void deleteById(Long id);
}
