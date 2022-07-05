package pl.inventorybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.inventorybackend.entiti.Register;
@Repository
public interface RegisterRepo extends JpaRepository<Register,Long> {
}
