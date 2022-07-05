package pl.inventorybackend.serivce;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.inventorybackend.ResourcesNotFoundException;
import pl.inventorybackend.entiti.ElectronicEquipment;
import pl.inventorybackend.repository.ElectronicEquipmnetRepo;

import java.util.List;

@Service
public class ElectronicEquipmentService {

    private final ElectronicEquipmnetRepo electronicEquipmnetRepo;

    @Autowired
    public ElectronicEquipmentService(ElectronicEquipmnetRepo electronicEquipmnetRepo) {
        this.electronicEquipmnetRepo = electronicEquipmnetRepo;
    }

    public List<ElectronicEquipment> findAllEquipment(){
        return electronicEquipmnetRepo.findAll();
    }

    public ElectronicEquipment addEquipment(@NotNull ElectronicEquipment electronicEquipment){
        return electronicEquipmnetRepo.save(electronicEquipment);
    }

    @Transactional
    public ElectronicEquipment updateElectronicEquipmentById(Long id, ElectronicEquipment equipment){
        return electronicEquipmnetRepo.findElectronicEquipmentById(id).map(equipmentUpdate -> {
            equipmentUpdate.setName(equipment.getName());
            equipmentUpdate.setDateOfPurchase(equipment.getDateOfPurchase());
            equipmentUpdate.setSerialNumber(equipment.getSerialNumber());
            equipmentUpdate.setInRepair(equipment.isInRepair());
            return electronicEquipmnetRepo.save(equipmentUpdate);
        }).orElseThrow(()-> new ResourcesNotFoundException("Nie znalezionego takiego sprzętu"));
    }

}
