package com.group4.source.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"USER\"", schema = "dbo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UID", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Size(max = 45)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 45)
    private String email;

    @Size(max = 45)
    @NotNull
    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;

    @Size(max = 45)
    @NotNull
    @Column(name = "ADDRESS", nullable = false, length = 45)
    private String address;

    @Size(max = 10)
    @NotNull
    @Column(name = "PHONE", nullable = false, length = 10)
    private String phone;

    @NotNull
    @Column(name = "DATEOFBIRTH", nullable = false)
    private LocalDate dateofbirth;

    @NotNull
    @Column(name = "ROLE", nullable = false)
    private Boolean role = false;

    @OneToMany(mappedBy = "uid")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "uid")
    private Set<Rating> ratings = new LinkedHashSet<>();

}