package pl.inventorybackend.serivce;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.inventorybackend.ResourcesNotFoundException;
import pl.inventorybackend.entiti.Equipment;
import pl.inventorybackend.repository.EquipmentRepo;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;

    @Autowired
    public EquipmentService(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }

    public List<Equipment> findAllEquipment(){
        return equipmentRepo.findAll();
    }

    public Equipment addEquipment(@NotNull Equipment equipment){
        return equipmentRepo.save(equipment);
    }

    public void deleteElectronicEquipment(Equipment equipment){
        equipmentRepo.delete(equipment);
    }


    @Transactional
    public Equipment updateElectronicEquipmentById(Long id, Equipment equipment){
        return equipmentRepo.findEquipmentById(id).map(equipmentUpdate -> {
            equipmentUpdate.setName(equipment.getName());
            equipmentUpdate.setDateOfPurchase(equipment.getDateOfPurchase());
            equipmentUpdate.setSerialNumber(equipment.getSerialNumber());
            equipmentUpdate.setTypeOfEquipment(equipment.getTypeOfEquipment());
            equipmentUpdate.setRepair(equipment.isRepair());
            equipmentUpdate.setRoomNumber(equipment.getRoomNumber());
            equipmentUpdate.setEmployee(equipment.getEmployee());
            return equipmentRepo.save(equipmentUpdate);
        }).orElseThrow(()-> new ResourcesNotFoundException("Nie znalezionego takiego sprzętu"));
    }

    public Equipment findOneEquipment(Long id) {
        return equipmentRepo.findEquipmentById(id).orElseThrow();
    }
}
