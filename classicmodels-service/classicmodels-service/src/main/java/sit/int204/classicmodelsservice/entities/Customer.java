package sit.int204.classicmodelsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customers")

public class Customer {
    @Id
    @Column(name = "CustomerNumber", nullable = false, length = 50)
    private String customerNumber;
    @Column(name = "customerName", nullable = false, length = 100)
    private String customerName;
    @Column(name = "ContactLastName", nullable = false, length = 50)
    private String contactLastName;
    @Column(name = "ContactFirstName", nullable = false, length = 50)
    private String contactFirstName;
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @Column(name = "state", nullable = false, length = 50)
    private String state;
    @Column(name = "postalCode", nullable = false, length = 50)
    private String postalCode;
    @Column(name = "country", nullable = false, length = 50)
    private String country;
    @Column(name = "salesRepEmployeeNumber", nullable = false, length = 50)
    private String salesRepEmployeeNumber;
    @Column(name = "creditLimit", nullable = false, length = 50)
    private Double creditLimit;

    @JsonIgnore
    @OneToMany(mappedBy = "customers")
    private Set<Order> orders = new LinkedHashSet<>();

}
