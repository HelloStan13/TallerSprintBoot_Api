package com.megawarez.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "categoria")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Integer id;

    @Column(name = "cat_nombre", nullable = false, length = 80)
    private String name;

    @Column(name = "cat_created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "category",
            targetEntity = SubCategory.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private Set<SubCategory> subCategories = new LinkedHashSet<>();

}