package pl.inventorybackend.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.inventorybackend.entiti.Register;
import pl.inventorybackend.serivce.RegisterService;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Register>> getAllRegister(){
        List<Register> registerList = registerService.findAllRegister();
        return new ResponseEntity<>(registerList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Register> postRegister(@RequestBody Register registerFront){
        Register register = registerService.addRegister(registerFront);
        return  new ResponseEntity<>(register,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Register> putRegister(@PathVariable("id") Long id ,@RequestBody Register registerFront){
        Register register = registerService.updateRegister(id, registerFront);
        return  new ResponseEntity<>(register,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRegister(@RequestBody Register registerFront){
        registerService.deleteRegister(registerFront);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
