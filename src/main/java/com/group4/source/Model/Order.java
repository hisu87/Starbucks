package com.group4.source.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"ORDER\"", schema = "dbo")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID", nullable = false)
    private User uid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PID", nullable = false)
    private Product pid;

    @NotNull
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "TOTALPRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalprice;

    @NotNull
    @Column(name = "ORDERDATE", nullable = false)
    private LocalDate orderdate;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    private Boolean status = false;

    @OneToMany(mappedBy = "oid")
    private Set<Orderdetail> orderdetails = new LinkedHashSet<>();

}