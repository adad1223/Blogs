package org.example.codingblocksintern.Service;

import org.example.codingblocksintern.Model.User;
import org.example.codingblocksintern.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public void register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    public User getUser(String email) {
        System.out.println("NEW");
        return repo.findByEmail(email);
    }

    public void updateUser(String email, User user) {
        User user1 = repo.findByEmail(email);
        user1.setEmail(user.getEmail());
        user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user1.setName(user.getName());
        repo.save(user1);
    }

    public void deleteUser(String email) {
        repo.delete(repo.findByEmail(email));
    }
}
