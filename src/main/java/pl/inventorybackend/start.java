package pl.inventorybackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.inventorybackend.entiti.Employee;
import pl.inventorybackend.repository.EmployeeRepo;
import pl.inventorybackend.serivce.EmployeeService;

@Component
public class start {

    private final EmployeeRepo employeeRepo ;

    @Autowired
    public start(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test(){
        Employee employee = new Employee(0L,"adam","wieczorek");
        employeeRepo.save(employee);
    }
}
