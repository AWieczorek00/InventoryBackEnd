package pl.inventorybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.inventorybackend.entiti.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
