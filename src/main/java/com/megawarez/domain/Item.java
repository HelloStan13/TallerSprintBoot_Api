package com.megawarez.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itm_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = SubCategory.class ,
            optional = false)
    @JoinColumn(name = "itm_subcategoria_id", nullable = false)
    @JsonBackReference
    private SubCategory subCategory;

    @Column(name = "itm_nombre",
            nullable = false,
            length = 80)
    private String name;

    @Column(name = "itm_created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "item",
            targetEntity = Download.class,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Download> downloads = new LinkedHashSet<>();
}