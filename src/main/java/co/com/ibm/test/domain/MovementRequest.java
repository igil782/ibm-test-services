package co.com.ibm.test.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovementRequest {
    private Long idMovement;
    private Long idCard;
    private LocalDate date;
    private String description;
    private Double amount;
}
