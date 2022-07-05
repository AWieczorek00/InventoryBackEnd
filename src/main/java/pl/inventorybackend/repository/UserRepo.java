package pl.inventorybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.inventorybackend.entiti.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
