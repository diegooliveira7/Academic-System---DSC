/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.AcademicSystem_LogicaAplicacao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", length = 250, nullable = true)
    private String name;
    
    @Column(name = "cpf", length = 20, nullable = true, unique = true)
    private String cpf;
    
    @Column(name = "email", length = 250)
    private String email;
    
    @Column(name = "status")
    private int status;
    
    @Column(name = "street", length = 250)
    private String street;
    
    @Column(name = "numberhouse")
    private int numberhouse;
    
    @Column(name = "neighborhood", length = 250)
    private String neighborhood;
    
    @Column(name = "telephone", length = 250)
    private String telephone;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;
    
    @Version
    private int version;
    
    public Client(){
        this.sex = Sex.Female;
        this.cpf = "";
        this.email = "";
        this.id = 0L;
        this.name = "";
        this.neighborhood = "";
        this.numberhouse = 0;
        this.status = 1;
        this.street = "";
        this.telephone = "";
        this.version = 1;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public String getStreet() {
        return street;
    }

    public int getNumberhouse() {
        return numberhouse;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getTelephone() {
        return telephone;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumberhouse(int numberhouse) {
        this.numberhouse = numberhouse;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + this.status;
        hash = 79 * hash + Objects.hashCode(this.street);
        hash = 79 * hash + this.numberhouse;
        hash = 79 * hash + Objects.hashCode(this.neighborhood);
        hash = 79 * hash + Objects.hashCode(this.telephone);
        hash = 79 * hash + Objects.hashCode(this.sex);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.status != other.status) {
            return false;
        }
        if (this.numberhouse != other.numberhouse) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.neighborhood, other.neighborhood)) {
            return false;
        }
        if (!Objects.equals(this.telephone, other.telephone)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return this.name;
    }
    
}
