package org.example.authservice.Controller;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.apache.catalina.core.ApplicationContext;
import org.example.authservice.Service.JWTService;
import org.example.authservice.Service.MyUserDetailsService;
import org.example.authservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.authservice.Model.User;
@Controller
@RequestMapping
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("User added successfully");
    }
    @GetMapping("/auth/all")
    public ResponseEntity<Iterable<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login( @RequestBody User User) {
        System.out.println("called ");
        System.out.println(User.getEmail()+ User.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(User.getEmail(), User.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtService.generateToken(User.getEmail()));
        } else {
            System.out.println("Invalid Credentials");
            return ResponseEntity.badRequest().body("Invalid Credentials");
        }

    }
    @GetMapping("/auth/validate/{token}")
    public ResponseEntity<String> validateToken(@PathVariable String token) {

        System.out.println("CALLED123"+token);
        String userName = jwtService.extractUserName(token);
        UserDetails userDetails =userDetailsService.loadUserByUsername(userName);
        if (jwtService.validateToken(token, userDetails)) {
            return ResponseEntity.ok("Token is valid");
        } else {
            return ResponseEntity.badRequest().body("Token is invalid");
        }
    }

}
