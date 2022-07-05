package pl.inventorybackend.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.inventorybackend.entiti.ElectronicEquipment;
import pl.inventorybackend.serivce.ElectronicEquipmentService;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class ElectronicEquipmentController {

    private final ElectronicEquipmentService equipmentService;

    @Autowired
    public ElectronicEquipmentController(ElectronicEquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ElectronicEquipment>> getAllEquipment(){
        List<ElectronicEquipment> equipmentList = equipmentService.findAllEquipment();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ElectronicEquipment> postElectronicEquipment(@RequestBody ElectronicEquipment equipment){
        ElectronicEquipment electronicEquipment = equipmentService.addEquipment(equipment);
        return new ResponseEntity<>(electronicEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ElectronicEquipment> updateElectronicEquipment(@PathVariable Long id,@RequestBody ElectronicEquipment equipment) {
        ElectronicEquipment electronicEquipment = equipmentService.updateElectronicEquipmentById(id, equipment);
        return new ResponseEntity<>(electronicEquipment, HttpStatus.OK);
    }


}
