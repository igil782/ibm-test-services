package co.com.ibm.test.service;

import co.com.ibm.test.data.entity.CustomerEntity;
import co.com.ibm.test.data.entity.MovementCardEntity;
import co.com.ibm.test.domain.CardRequest;
import co.com.ibm.test.domain.CustomerRequest;
import co.com.ibm.test.domain.MovementRequest;
import co.com.ibm.test.domain.ResponseIBM;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface CustomerService {
    String PATH_SERVICE_LIST_CUSTOMER = "customer/list";
    String PATH_SERVICE_LIST_MOVEMENTS = "customer/movement/list";
    String PATH_SERVICE_SAVE_CUSTOMER = "customer/";
    String PATH_SERVICE_SAVE_CARD = "customer/card";
    String PATH_SERVICE_SAVE_MOVEMENT = "customer/movement";


    Iterable<CustomerEntity> getListCustomerAll();
    List<MovementCardEntity> getMovementsCustomerCard(Long idCard);
    ResponseIBM saveCustomer(CustomerRequest customerRequest);
    ResponseIBM saveCard(CardRequest cardRequest);
    ResponseIBM saveMovementCardCustomer(MovementRequest movementRequest);
}
