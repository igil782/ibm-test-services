package co.com.ibm.test.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRequest {
    private Long idCard;
    private String numberCard;
    private String ccv;
    private Long idCustomer;
    private Long idTypeCard;
}
