package grhapp;
import java.util.Collections;


import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import grhapp.entites.Role;
import grhapp.entites.User;
import grhapp.enums.ERole;
import grhapp.repositories.RoleRepository;
import grhapp.repositories.UserRepository;

@Component
public class InitialDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialDataLoader(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            Role role1 = roleRepository.save(new Role(ERole.ROLE_RH));
            Role role2 = roleRepository.save(new Role(ERole.ROLE_DAF));
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword(passwordEncoder.encode("password1"));
            user1.setEmail("user1@test.com");
            user1.setRoles(Collections.singleton(role1));
            userRepository.save(user1);

            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword(passwordEncoder.encode("password2"));
            user2.setEmail("user2@test.com");
            user2.setRoles(Collections.singleton(role2));
            userRepository.save(user2);
        }
    }
}

