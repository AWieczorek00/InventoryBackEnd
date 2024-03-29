package pl.inventorybackend.security.restAuthController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.inventorybackend.dto.ResponseDTO;
import pl.inventorybackend.dto.UserDTO;
import pl.inventorybackend.security.session.SessionRegistry;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

    public final AuthenticationManager manager;

    public final SessionRegistry sessionRegistry;

    @Autowired
    public AuthenticationController(SessionRegistry sessionRegistry, AuthenticationManager manager) {
        this.sessionRegistry = sessionRegistry;
        this.manager = manager;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO user) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        final String sessionId = sessionRegistry.registerSession(user.getUsername());
        ResponseDTO response = new ResponseDTO();
        response.setSessionId(sessionId);

        return ResponseEntity.ok(response);
    }



}
