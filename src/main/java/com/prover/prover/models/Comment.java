package com.prover.prover.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String content;

    private Integer position;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "comments",cascade = CascadeType.REMOVE)
    private List<Stand> stands ;
}
