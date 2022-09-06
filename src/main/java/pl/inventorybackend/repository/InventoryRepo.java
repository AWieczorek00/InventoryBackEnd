package pl.inventorybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.inventorybackend.entiti.Equipment;
import pl.inventorybackend.entiti.Inventory;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findInventoryById(Long id);
}
