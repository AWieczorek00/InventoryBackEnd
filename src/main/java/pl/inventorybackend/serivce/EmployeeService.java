package pl.inventorybackend.serivce;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inventorybackend.entiti.Employee;
import pl.inventorybackend.repository.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo ;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee addEmployee(@NotNull Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeRepo.delete(employee);
    }

}
