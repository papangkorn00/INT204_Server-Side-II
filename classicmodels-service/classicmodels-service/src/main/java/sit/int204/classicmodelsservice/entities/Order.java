package sit.int204.classicmodelsservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "orderNumber", nullable = false, length = 50)
    private Integer orderNumber;
    @Column(name = "orderDate", nullable = false, length = 50)
    private String orderDate;
    @Column(name = "requiredDate", nullable = false, length = 50)
    private String requiredDate;
    @Column(name = "shippedDate", nullable = false, length = 50)
    private String shippedDate;
    @Column(name = "status", nullable = false, length = 50)
    private String status;
    @Column(name = "comments", nullable = false, length = 50)
    private String comments;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customers")
    private Customer customers;
}
