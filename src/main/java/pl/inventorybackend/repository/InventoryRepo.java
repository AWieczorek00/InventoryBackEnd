package pl.inventorybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.inventorybackend.entiti.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
}
