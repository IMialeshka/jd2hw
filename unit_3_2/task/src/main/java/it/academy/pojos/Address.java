package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Address {
    @Id
    @Column
    @Access(AccessType.FIELD)
    @GeneratedValue
    private Integer AddressId;

    @Access(AccessType.FIELD)
    @Column
    private String city;

    @Column
    private String street;

    @Access(AccessType.PROPERTY)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = Objects.requireNonNullElse(street, "Unknown");
    }

    @Column
    private Integer numberFlat;

    @Access(AccessType.PROPERTY)
    public Integer getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(Integer numberFlat) {
        this.numberFlat = numberFlat;
    }

    @Column
    @Transient
    private Integer countRegister;

    @Embedded
    private DescribeAddress describeAddress;
}
