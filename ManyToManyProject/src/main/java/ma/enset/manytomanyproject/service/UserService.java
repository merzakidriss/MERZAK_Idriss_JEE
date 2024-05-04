package ma.enset.manytomanyproject.service;

import ma.enset.manytomanyproject.entities.Role;
import ma.enset.manytomanyproject.entities.User;

public interface UserService {
   User addUser(User user);
   Role addRole(Role role);
   User findUserByUserName(String username);

   Role findRoleByRoleName(String roleName);

   void  addRoleToUser(String username, String roleName);


}
