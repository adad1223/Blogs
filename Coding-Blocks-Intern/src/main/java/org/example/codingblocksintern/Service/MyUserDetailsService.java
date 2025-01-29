//package org.example.codingblocksintern.Service;
//
//import org.example.codingblocksintern.Model.User;
//import org.example.codingblocksintern.Repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepo repo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = repo.findByEmail(email);
//        if (user == null) {
//            System.out.println("User 404");
//            throw new UsernameNotFoundException("User 404");
//        }
//        return new UserPrinciple(user);
//    }
//}