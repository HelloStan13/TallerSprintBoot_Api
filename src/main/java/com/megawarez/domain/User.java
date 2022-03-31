package com.megawarez.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

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
@Table(name = "usuario")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Integer id;

    @Column(name = "usu_username",
            nullable = false,
            length = 80)
    private String username;

    @Column(name = "usu_password",
            nullable = false,
            length = 32)
    private String password;

    @Column(name = "usu_created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "usu_updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "user",
            targetEntity = Download.class,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Download> downloads = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user",
            targetEntity = Session.class,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Session> sessions = new LinkedHashSet<>();
}