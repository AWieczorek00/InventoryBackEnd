package pl.inventorybackend.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/test")
     public String test1(){
        return "test1";
    }

}
