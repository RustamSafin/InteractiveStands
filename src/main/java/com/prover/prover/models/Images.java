package com.prover.prover.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Admin on 23.05.2017.
 */
@Entity
@Table
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath;

    @Column
    private Timestamp expiration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @PreUpdate
    public void setTimes(){
        this.expiration = new Timestamp(new Date().getTime() + 24 * 3600);
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }
}