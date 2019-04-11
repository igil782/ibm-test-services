package co.com.ibm.test.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TYPE_CARD")
@Getter
@Setter
public class TypeCardEntity {
    @Id
    private Long idType;
    private String description;
}
