package com.dhk.expensetrackerapi.user.entity;

import com.dhk.expensetrackerapi.common.entity.Timestamp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tbl_users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Setter
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int age;

    public User(String name, String email, String password, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public void update(User newUser) {
        this.name = newUser.getName();
        this.email = newUser.getEmail();
        this.age = newUser.getAge();
        this.password = newUser.getPassword();
    }
}
