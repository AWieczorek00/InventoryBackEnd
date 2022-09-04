package pl.inventorybackend.configuration;


import org.springframework.context.annotation.Configuration;
import pl.inventorybackend.entiti.Equipment;
import pl.inventorybackend.entiti.Employee;
import pl.inventorybackend.entiti.User;
import pl.inventorybackend.repository.EquipmentRepo;
import pl.inventorybackend.repository.EmployeeRepo;
import pl.inventorybackend.repository.UserRepo;

import java.time.LocalDate;

@Configuration
public class start {
    public start(UserRepo userRepo, EmployeeRepo employeeRepo, EquipmentRepo equipmentRepo) {
        userRepo.save(new User(0l,"user1","$2a$10$4EvCE3wPMBPYEV/FA8B.3e1mrlCGaVuq.cO0x0fmrt198H61q/dFG"));
        userRepo.save(new User(0l,"user2","$2a$10$hvOa9FAisXftunkgb/QmkO5FLTQCI123rKTY.yuWAv9DjOW43/cSi"));
        Employee employee = new Employee(1l, "Magdalena", "Potrzebowska");
        Employee employee2 = new Employee(2l,"Paulina","Żelek");
        employeeRepo.save(employee);
        employeeRepo.save(employee2);
        employeeRepo.save(new Employee(0l,"Adam","Wieczorek"));
        employeeRepo.save(new Employee(0l,"Eryk","Winiecki"));
        employeeRepo.save(new Employee(0l,"Wojciech","Wymduch"));
        equipmentRepo.save(new Equipment(0l,"Dell","JKDHSAL89798798HDSABx","Komputer",LocalDate.now(),1, employee,false));
        equipmentRepo.save(new Equipment(0l,"Dell","JKD322AL89798798HzxcB","Monitor", LocalDate.now(),2,employee2,true));
        equipmentRepo.save(new Equipment(0l,"Brother","JKD322A321dfsad23zxcB","Drukarka", LocalDate.now(),3,null,true));
    }

}
