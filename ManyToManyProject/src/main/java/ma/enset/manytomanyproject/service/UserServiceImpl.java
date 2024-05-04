package ma.enset.manytomanyproject.service;

import jakarta.transaction.Transactional;
import ma.enset.manytomanyproject.entities.Role;
import ma.enset.manytomanyproject.entities.User;
import org.springframework.stereotype.Service;


@Service @Transactional
public class UserServiceImpl implements UserService {
    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public Role addRole(Role role) {
        return null;
    }

    @Override
    public User findUserByUserName(String username) {
        return null;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }
}
