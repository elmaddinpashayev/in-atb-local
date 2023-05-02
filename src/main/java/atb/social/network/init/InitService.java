//package atb.social.network.init;
//
//import atb.social.network.model.EmployeeModel;
//import atb.social.network.model.security.ERole;
//import atb.social.network.model.security.Role;
//import atb.social.network.repository.EmployeeRepository;
//import atb.social.network.repository.security.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.transaction.Transactional;
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
//
//@Service
//public class InitService {
//
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    PasswordEncoder encoder;
//
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//
//    @PostConstruct
//    @Transactional
//    public void init() {
//
//        Role user = Role.builder()
//                .id(1)
//                .name(ERole.ROLE_USER)
//                .build();
//
//        Role mod = Role.builder()
//                .id(2)
//
//                .name(ERole.ROLE_MODERATOR)
//                .build();
//
//        Role admin = Role.builder()
//                .id(3)
//                .name(ERole.ROLE_ADMIN)
//                .build();
//        roleRepository.save(user);
//        roleRepository.save(mod);
//        roleRepository.save(admin);
//    }
//
//    @Scheduled(fixedRateString = "10000000")
//    public void insertUsers() {
//        Set<EmployeeModel> all = employeeRepository.findAll();
//        Set<Role> roles = new HashSet<>();
//
//
//        Role user = Role.builder()
//                .id(1)
//                .name(ERole.ROLE_USER)
//                .build();
//        roles.add(user);
//        for (EmployeeModel element : all) {
//            if (element.getUsername() == null && element.getEmail() != null) {
//                String email = element.getEmail();
//                String userName = element.getEmail().split("@")[0].toLowerCase();
//                element.setUsername(userName);
//                element.setPassword(encoder.encode("123456"));
//                element.setEmail(email);
//                employeeRepository.save(element);
//            }
//        }
//    }
//}
