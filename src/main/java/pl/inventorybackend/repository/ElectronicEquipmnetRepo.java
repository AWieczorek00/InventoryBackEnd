package pl.inventorybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.inventorybackend.entiti.ElectronicEquipment;

import java.util.Optional;

@Repository
public interface ElectronicEquipmnetRepo extends JpaRepository<ElectronicEquipment, Long> {

    Optional<ElectronicEquipment> findElectronicEquipmentById(Long id);
}
