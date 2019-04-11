package co.com.ibm.test.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
    private Long idCustomer;
    private String nombre;
    private String direccion;
    private Long idCiudad;
    private String telefono;
}
