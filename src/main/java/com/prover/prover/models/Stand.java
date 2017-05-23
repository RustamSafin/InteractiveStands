package com.prover.prover.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Admin on 21.05.2017.
 */
@Entity
@Table(name = "Stand")
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_patterns", joinColumns = {
            @JoinColumn(name = "STAND_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "PATTERN_ID",
                    nullable = false)})
    @LazyCollection( LazyCollectionOption.EXTRA )
    private Set<Pattern> patterns;

    @ManyToOne(fetch = FetchType.LAZY)
    private Images images;

    private Timestamp created_at;

    private Timestamp updated_at;

    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Pattern> getPatterns() {
        return patterns == null ? patterns =  new LinkedHashSet<>() : patterns;
    }

    public void setPatterns(Set<Pattern> patterns) {
        this.patterns = patterns;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @PreUpdate
    public void setTimes(){
        this.created_at = new Timestamp(new Date().getTime());
        this.updated_at = new Timestamp(new Date().getTime());
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}