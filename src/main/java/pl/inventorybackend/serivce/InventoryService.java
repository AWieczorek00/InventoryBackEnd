package pl.inventorybackend.serivce;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.inventorybackend.ResourcesNotFoundException;
import pl.inventorybackend.entiti.Equipment;
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
        return inventoryRepo.findInventoryById(id).orElseThrow(()-> new ResourcesNotFoundException("Nie znalezionego takiej inwetaryzacji"));
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepo.save(inventory);

    }


    @Transactional
    public Inventory updateInventoryById(Long id, Inventory inventory){
        return inventoryRepo.findInventoryById(id).map(inventoryUpdate -> {
            inventoryUpdate.setInventoryName(inventory.getInventoryName());
            inventoryUpdate.setInventoryNumber(inventory.getInventoryNumber());
            inventoryUpdate.setEquipment(inventory.getEquipment());
            return inventoryRepo.save(inventoryUpdate);
        }).orElseThrow(()-> new ResourcesNotFoundException("Nie znalezionego takiej inwetaryzacji"));
    }

    public void delete(Inventory inventory) {
        inventoryRepo.delete(inventory);
    }
}
