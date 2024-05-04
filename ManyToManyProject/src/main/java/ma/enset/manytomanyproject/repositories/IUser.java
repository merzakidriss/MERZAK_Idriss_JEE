package ma.enset.manytomanyproject.repositories;

import ma.enset.manytomanyproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, String> {



}
