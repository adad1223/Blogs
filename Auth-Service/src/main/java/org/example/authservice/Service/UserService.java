package org.example.authservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.authservice.Model.User;
import org.example.authservice.Repo.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public void register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }


    public Iterable<User> getUsers() {
        return repo.findAll();
    }
}
