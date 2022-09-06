package pl.inventorybackend.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.inventorybackend.entiti.Employee;
import pl.inventorybackend.serivce.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeList = employeeService.findAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employeeFront){
        Employee employee = employeeService.addEmployee(employeeFront);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
