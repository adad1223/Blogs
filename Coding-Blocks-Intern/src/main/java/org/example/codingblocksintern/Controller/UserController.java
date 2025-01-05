package org.example.codingblocksintern.Controller;

import org.example.codingblocksintern.Model.User;
//import org.example.codingblocksintern.Service.JWTService;
import org.example.codingblocksintern.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {
    private UserService userService;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JWTService jwtService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody User user) {
//        userService.register(user);
//        // Register user logic here
//        return ResponseEntity.ok("User added successfully");
//    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User User) {
//        System.out.println(User.getEmail());
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(User.getEmail(), User.getPassword()));
//        System.out.println("CALLED!");
//        if (authentication.isAuthenticated()) {
//            return ResponseEntity.ok(jwtService.generateToken(User.getEmail()));
//        } else {
//            System.out.println("Invalid Credentials");
//            return ResponseEntity.badRequest().body("Invalid Credentials");
//        }
//    }
    @GetMapping("/user/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        System.out.println("NEWI");
        return ResponseEntity.ok(userService.getUser(email));
    }
    @PutMapping("/user/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email, @RequestBody User user) {
        userService.updateUser(email, user);
        return ResponseEntity.ok("User updated successfully");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.ok("User deleted successfully");
    }
}
