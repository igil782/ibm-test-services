package co.com.ibm.test.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "BANK_CUSTOMER")
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue
    private Long idCustomer;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name="ID_CITY")
    private CityEntity city;
    private String telephone;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BANK_CUSTOMER_CARD", joinColumns = @JoinColumn(name = "ID_CUSTOMER") , inverseJoinColumns = @JoinColumn(name = "ID_CARD") )
    private Set<CardEntity> cardEntitySet;


}
