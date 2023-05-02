//package atb.social.network.config.security.services;
//
//import atb.social.network.model.EmployeeModel;
//import atb.social.network.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        EmployeeModel user = employeeRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//
//        return UserDetailsImpl.build(user);
//    }
//
//}
