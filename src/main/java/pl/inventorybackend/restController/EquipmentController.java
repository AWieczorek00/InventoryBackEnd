package pl.inventorybackend.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.inventorybackend.entiti.Equipment;
import pl.inventorybackend.serivce.EquipmentService;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@CrossOrigin(origins = "*")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipment>> getAllEquipment(){
        List<Equipment> equipmentList = equipmentService.findAllEquipment();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Long id ){
        Equipment equipment = equipmentService.findOneEquipment(id);
        return  new  ResponseEntity<>(equipment, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Equipment> postElectronicEquipment(@RequestBody Equipment equipment){
        System.out.println(equipment);
        Equipment electronicEquipment = equipmentService.addEquipment(equipment);
        return new ResponseEntity<>(electronicEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Equipment> updateElectronicEquipment(@RequestBody Equipment equipment) {
        Equipment electronicEquipment = equipmentService.updateElectronicEquipmentById(equipment.getId(), equipment);
        return new ResponseEntity<>(electronicEquipment, HttpStatus.OK);
    }

    @CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteElectronicEquipment(@RequestBody Equipment equipment){
        equipmentService.deleteElectronicEquipment(equipment);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
