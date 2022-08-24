package pl.inventorybackend.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.inventorybackend.entiti.Employee;
import pl.inventorybackend.entiti.User;
import pl.inventorybackend.repository.EmployeeRepo;
import pl.inventorybackend.repository.UserRepo;
import pl.inventorybackend.serivce.EmployeeService;

@Configuration
public class start {
    public start(UserRepo userRepo, EmployeeRepo employeeRepo) {
        userRepo.save(new User(0l,"user1","$2a$10$4EvCE3wPMBPYEV/FA8B.3e1mrlCGaVuq.cO0x0fmrt198H61q/dFG"));
        userRepo.save(new User(0l,"user2","$2a$10$hvOa9FAisXftunkgb/QmkO5FLTQCI123rKTY.yuWAv9DjOW43/cSi"));
        employeeRepo.save(new Employee(0l,"Magdalena","Potrzebowska"));
        employeeRepo.save(new Employee(0l,"Paulina","Żelek"));
        employeeRepo.save(new Employee(0l,"Adam","Wieczorek"));
        employeeRepo.save(new Employee(0l,"Eryk","Winiecki"));
        employeeRepo.save(new Employee(0l,"Wojciech","Wymduch"));
    }

}
