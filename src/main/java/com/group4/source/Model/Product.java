package com.group4.source.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT", schema = "dbo")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @NotNull
    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Size(max = 45)
    @NotNull
    @Column(name = "DESCRIPTION", nullable = false, length = 45)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CID", nullable = false)
    private Category cid;

    @Size(max = 45)
    @NotNull
    @Column(name = "IMAGE", nullable = false, length = 45)
    private String image;

    @OneToMany(mappedBy = "pid")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pid")
    private Set<Orderdetail> orderdetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pid")
    private Set<Rating> ratings = new LinkedHashSet<>();

}