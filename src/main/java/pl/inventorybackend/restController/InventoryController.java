package pl.inventorybackend.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.inventorybackend.entiti.Inventory;
import pl.inventorybackend.serivce.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventoryList = inventoryService.findAllInventory();
        return new ResponseEntity<>(inventoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getOneInventory(@PathVariable Long id){
        Inventory inventory = inventoryService.findOneInventory(id);
        return new ResponseEntity<>(inventory,HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Inventory> postInventory(@RequestBody Inventory inventoryFront) {
        Inventory inventory = inventoryService.addInventory(inventoryFront);
        return new ResponseEntity<>(inventory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventoryFront){
        Inventory inventory = inventoryService.updateInventoryById(inventoryFront.getId(),inventoryFront);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteInventory(@RequestBody Inventory inventoryFront) {
        inventoryService.delete(inventoryFront);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
