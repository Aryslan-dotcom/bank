package Kaspi.bank.Users.service;

import Kaspi.bank.permission.entity.Permission;
import Kaspi.bank.Users.entity.Users;
import Kaspi.bank.permission.repository.PermissionRepository;
import Kaspi.bank.Users.repository.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {
    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepositories.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
    public String userSignUp(String full_name, String email, String password, String rePassword) {
        String flag = "userExist";

        if (!email.isEmpty()&&!password.isEmpty()&& !rePassword.isEmpty()) {
            Users user = userRepositories.findByEmail(email);

            if (user == null) {
                flag = "passwordNotMatch";

                if (password.equals(rePassword)) {
                    Permission permission = permissionRepository.findAllByRole("ROLE_USER");
                    List<Permission> permissions = new ArrayList<>();
                    permissions.add(permission);

                    Users newUser = Users.builder()
                            .email(email)
                            .full_name(full_name)
                            .permissions(permissions)
                            .password(passwordEncoder.encode(password))
                            .build();

                    userRepositories.save(newUser);
                    flag = "registerSuccess";
                }
            }
        }

        return flag;
    }

    public String changePassword(Long id, String oldPassword, String newPassword, String rePassword){
        String flag = "oldPasswordNotMatches";
        Users user = userRepositories.findAllById(id);
        if (passwordEncoder.matches(oldPassword,user.getPassword())){
            flag = "newPasswordsNotMatches";
            if (newPassword.equals(rePassword)){
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepositories.save(user);
                flag = "changePasswordSuccess";
            }
        }
        return flag;
    }

    public String addAdminUser(String email, String full_name, String password, String re_password) {
        String flag = "userIsEmpty";

        if (!email.isEmpty() && !full_name.isEmpty() && !password.isEmpty() && !re_password.isEmpty()) {
            List<Users> list = userRepositories.findAll();
            flag = "userEmailNotMatches";

            for (int i = 0; i < list.size(); i++) {
                if (email.equals(list.get(i).getEmail())) {
                    flag = "userEmailMatches";
                    break;
                }
            }

            if (!flag.equals("userEmailMatches")) {
                flag = "userPasswordNotMatches";

                if (password.equals(re_password)) {
                    Permission permission = permissionRepository.findAllByRole("ROLE_ADMIN");
                    List<Permission> permissions = new ArrayList<>();
                    permissions.add(permission);

                    Users newUser = Users.builder()
                            .email(email)
                            .full_name(full_name)
                            .password(passwordEncoder.encode(password))
                            .permissions(permissions)
                            .build();

                    userRepositories.save(newUser);
                    flag = "userAdminSuccessAdd";
                }
            }
        }
        return flag;
    }
}
