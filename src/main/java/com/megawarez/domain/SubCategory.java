package com.megawarez.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "subcategoria")
public class SubCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scat_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Category.class,
            optional = false)
    @JoinColumn(name = "scat_categoria_id")
    @JsonBackReference
    private Category category;

    @Column(name = "scat_nombre", nullable = false)
    private String name;

    @Column(name = "scat_created_at", nullable = false)
    private Instant createdAt;
}