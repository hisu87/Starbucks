package com.group4.source.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RATING", schema = "dbo")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RID", nullable = false)
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
    @Column(name = "RATING", nullable = false)
    private Integer rating;

    @Size(max = 45)
    @NotNull
    @Column(name = "COMMENT", nullable = false, length = 45)
    private String comment;

}