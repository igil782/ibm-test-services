package co.com.ibm.test.service;

import co.com.ibm.test.controller.CustomerController;
import co.com.ibm.test.data.entity.CustomerEntity;
import co.com.ibm.test.data.entity.MovementCardEntity;
import co.com.ibm.test.domain.CardRequest;
import co.com.ibm.test.domain.CustomerRequest;
import co.com.ibm.test.domain.MovementRequest;
import co.com.ibm.test.domain.ResponseIBM;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "Service Customer - TEST IBM - IG", description = "Service Customer - TEST IBM - IG")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerController customerController;
    @Override
    @RequestMapping(value = PATH_SERVICE_LIST_CUSTOMER,  method = RequestMethod.GET)
    public Iterable<CustomerEntity> getListCustomerAll() {
        return customerController.getListCustomerAll();

    }

    @Override
    @RequestMapping(value = PATH_SERVICE_LIST_MOVEMENTS,  method = RequestMethod.GET)
    public List<MovementCardEntity> getMovementsCustomerCard(@RequestParam Long idCard) {
        return customerController.getMovementsCustomerCard(idCard);
    }

    @Override
    @RequestMapping(value = PATH_SERVICE_SAVE_CUSTOMER,  method = RequestMethod.POST)
    public ResponseIBM saveCustomer(@RequestBody CustomerRequest customerRequest) {
        ResponseIBM responseIBM = new ResponseIBM();
        try{
            if(customerController.saveCustomer(customerRequest)){
                responseIBM.setCode("200");
                responseIBM.setDescription("Saved Correct !!");
            }

        }catch(Exception e){
            responseIBM.setCode("501");
            responseIBM.setDescription("Exception catch access data !! e ->"+ e.getCause() + " - "+ e.getMessage());

        }
        return responseIBM;
    }

    @Override
    @RequestMapping(value = PATH_SERVICE_SAVE_CARD,  method = RequestMethod.POST)
    public ResponseIBM saveCard(@RequestBody CardRequest cardRequest) {
        ResponseIBM responseIBM = new ResponseIBM();
        try{
            if(customerController.saveCard(cardRequest)){
                responseIBM.setCode("200");
                responseIBM.setDescription("Saved Correct !!");
            }
        }catch(Exception e){
            responseIBM.setCode("501");
            responseIBM.setDescription("Exception catch access data !! e ->"+ e.getCause() + " - "+ e.getMessage());
        }
        return responseIBM;
    }

    @Override
    @RequestMapping(value = PATH_SERVICE_SAVE_MOVEMENT,  method = RequestMethod.POST)
    public ResponseIBM saveMovementCardCustomer(@RequestBody MovementRequest movementRequest) {
        ResponseIBM responseIBM = new ResponseIBM();
        try{
            if(customerController.saveMovementCardCustomer(movementRequest)){
                responseIBM.setCode("200");
                responseIBM.setDescription("Saved Correct !!");
            }
        }catch(Exception e){
            responseIBM.setCode("501");
            responseIBM.setDescription("Exception catch access data !! e ->"+ e.getCause() + " - "+ e.getMessage());
        }
        return responseIBM;
    }

    @Override
    @RequestMapping(value = PATH_SERVICE_SAVE_CARD,  method = RequestMethod.DELETE)
    public ResponseIBM deleteCard(@RequestParam Long idCard) {
        ResponseIBM responseIBM = new ResponseIBM();
        try{
            if(customerController.deleteCard(idCard)){
                responseIBM.setCode("200");
                responseIBM.setDescription("Delete Correct !!");
            }
        }catch(Exception e){
            responseIBM.setCode("501");
            responseIBM.setDescription("Exception catch access data !! e ->"+ e.getCause() + " - "+ e.getMessage());
        }
        return responseIBM;
    }

    @Override
    @RequestMapping(value = PATH_SERVICE_SAVE_CUSTOMER,  method = RequestMethod.DELETE)
    public ResponseIBM deleteCustomer(@RequestParam Long idCustomer) {
        ResponseIBM responseIBM = new ResponseIBM();
        try{
            if(customerController.deleteCustomer(idCustomer)){
                responseIBM.setCode("200");
                responseIBM.setDescription("Delete Correct !!");
            }
        }catch(Exception e){
            responseIBM.setCode("501");
            responseIBM.setDescription("Exception catch access data !! e ->"+ e.getCause() + " - "+ e.getMessage());
        }
        return responseIBM;
    }

    @Override
    @RequestMapping(value = PATH_SERVICE_SAVE_MOVEMENT,  method = RequestMethod.DELETE)
    public ResponseIBM deleteMovement(@RequestParam Long idMovement) {
        ResponseIBM responseIBM = new ResponseIBM();
        try{
            if(customerController.deleteMovementCard(idMovement)){
                responseIBM.setCode("200");
                responseIBM.setDescription("Delete Correct !!");
            }
        }catch(Exception e){
            responseIBM.setCode("501");
            responseIBM.setDescription("Exception catch access data !! e ->"+ e.getCause() + " - "+ e.getMessage());
        }
        return responseIBM;
    }
}
