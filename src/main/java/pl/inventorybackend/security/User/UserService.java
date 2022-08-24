package pl.inventorybackend.security.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.inventorybackend.entiti.User;
import pl.inventorybackend.repository.UserRepo;
import pl.inventorybackend.security.User.CurrentUser;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent()){
            final CurrentUser currentUser = new CurrentUser();
            currentUser.setUsername(user.get().getUsername());
            currentUser.setPassword(user.get().getPassword());
            return currentUser;
        }
        throw new UsernameNotFoundException("Nie znalezionego użytkownika o takim: "+username);
    }
}
