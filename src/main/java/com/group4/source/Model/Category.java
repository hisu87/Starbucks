package com.group4.source.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "CATEGORY", schema = "dbo")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CID", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Size(max = 45)
    @NotNull
    @Column(name = "DESCRIPTION", nullable = false, length = 45)
    private String description;

    @OneToMany(mappedBy = "cid")
    private Set<Product> products = new LinkedHashSet<>();

}