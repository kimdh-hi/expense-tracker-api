package com.dhk.expensetrackerapi.user.entity;

import com.dhk.expensetrackerapi.common.entity.Timestamp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private long age;

    public User(String name, String email, String password, long age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }
}
