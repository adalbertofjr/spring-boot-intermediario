package com.adalbertofjr.RestAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Can not be empty")
    @NotBlank(message = "Can not be blank")
    private String name;

    @Column
    @NotNull(message = "Can not be empty")
    @Min(value = 0)
    @Max(value = 1000)
    private Integer qtd;

    @Column
    private Date dateCreated;

    public Product() {
    }

    public Product(String name, Integer qtd, Date dateCreated) {
        this.name = name;
        this.qtd = qtd;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qtd=" + qtd +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
