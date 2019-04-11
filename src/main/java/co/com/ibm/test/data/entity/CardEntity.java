package co.com.ibm.test.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "BANK_CARD")
@Getter
@Setter
public class CardEntity {
    @Id
    @GeneratedValue
    private Long idCard;
    private String numberCard;
    private String ccv;
    @ManyToOne
    @JoinColumn(name="ID_TYPE")
    private TypeCardEntity typeCardEntity;
}
