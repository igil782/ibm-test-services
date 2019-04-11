package co.com.ibm.test.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "GEO_CITY")
@Getter
@Setter
public class CityEntity {
    @Id
    private Long idCity;
    private String description;
}
