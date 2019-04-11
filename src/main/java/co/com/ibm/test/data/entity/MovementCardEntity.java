package co.com.ibm.test.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "BANK_CARD_MOVEMENT")
@Getter
@Setter

public class MovementCardEntity {
    @Id
    @GeneratedValue
    private Long idMovement;
    @ManyToOne
    @JoinColumn(name="ID_CARD")
    private CardEntity card;
    private LocalDate dateMovement;
    private String description;
    private Double amount;

}
