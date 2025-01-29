package org.example.authservice.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String role;

    public void setId(Long id) {
        Id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return String.valueOf(Id);
    }



}

