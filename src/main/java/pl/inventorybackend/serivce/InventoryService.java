package pl.inventorybackend.serivce;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inventorybackend.entiti.Inventory;
import pl.inventorybackend.repository.InventoryRepo;

import java.util.List;

@Service
public class InventoryService {

    private InventoryRepo inventoryRepo;

    @Autowired
    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public List<Inventory> findAllInventory() {
        return inventoryRepo.findAll();
    }

    public Inventory findOneInventory(Long id){
        return inventoryRepo.findInventoryById(id).orElseThrow();
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepo.save(inventory);

    }

    public void delete(Inventory inventory) {
        inventoryRepo.delete(inventory);
    }
}
