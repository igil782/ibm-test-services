package co.com.ibm.test.controller;

import co.com.ibm.test.data.entity.CardEntity;
import co.com.ibm.test.data.entity.CityEntity;
import co.com.ibm.test.data.entity.CustomerEntity;
import co.com.ibm.test.data.entity.MovementCardEntity;
import co.com.ibm.test.data.repo.*;
import co.com.ibm.test.domain.CardRequest;
import co.com.ibm.test.domain.CustomerRequest;
import co.com.ibm.test.domain.MovementRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MovementCardRepository movementCardRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private TypeCardRepository typeCardRepository;
    @Transactional
    public Iterable<CustomerEntity> getListCustomerAll() {
        return customerRepository.findAll();
    }
    @Transactional
    public List<MovementCardEntity> getMovementsCustomerCard(Long idCard){
        return movementCardRepository.findByCardIdCard(idCard);
    }
    @Transactional
    public Boolean saveCustomer(CustomerRequest customerRequest) throws Exception{
        CustomerEntity customerEntity = null;
        if(customerRequest != null && customerRequest.getIdCustomer() != null ){
            customerEntity = customerRepository.findById(customerRequest.getIdCustomer()).get();
        }else{
            customerEntity = new CustomerEntity();
        }
        customerEntity.setAddress(customerRequest.getDireccion());
        customerEntity.setName(customerRequest.getNombre());
        customerEntity.setTelephone(customerRequest.getTelefono());
        if(customerRequest.getIdCiudad() != null)
            customerEntity.setCity(cityRepository.findById(customerRequest.getIdCiudad()).get());
        else
            customerEntity.setCity(null);
        customerRepository.save(customerEntity);
        return true;

    }
    @Transactional
    public Boolean saveCard(CardRequest cardRequest) throws Exception{
        CardEntity cardEntity = null;
        if(cardRequest != null && cardRequest.getIdCard() != null ){
            cardEntity = cardRepository.findById(cardRequest.getIdCard()).get();
        }else{
            cardEntity = new CardEntity();
        }
        cardEntity.setCcv(cardRequest.getCcv());
        cardEntity.setNumberCard(cardRequest.getNumberCard());
        if(cardRequest.getIdTypeCard() != null)
            cardEntity.setTypeCardEntity(typeCardRepository.findById(cardRequest.getIdTypeCard()).get());
        else
            cardEntity.setTypeCardEntity(null);

        CardEntity cardSave = cardRepository.save(cardEntity);
        if(cardRequest.getIdCustomer() != null) {
            CustomerEntity customerEntity = customerRepository.findById(cardRequest.getIdCustomer()).get();
            if(customerEntity != null){
                customerEntity.getCardEntitySet().add(cardSave);
                customerRepository.save(customerEntity);
            }
        }
        return true;
    }
    @Transactional
    public Boolean saveMovementCardCustomer(MovementRequest movementRequest) throws Exception{
        MovementCardEntity movementEntity = null;
        if(movementRequest != null && movementRequest.getIdMovement() != null ){
            movementEntity = movementCardRepository.findById(movementRequest.getIdMovement()).get();
        }else{
            movementEntity = new MovementCardEntity();
        }
        movementEntity.setAmount(movementRequest.getAmount());
        movementEntity.setDescription(movementRequest.getDescription());
        movementEntity.setDateMovement(movementRequest.getDate());
        if(movementRequest.getIdCard() != null)
            movementEntity.setCard(cardRepository.findById(movementRequest.getIdCard()).get());
        movementCardRepository.save(movementEntity);
        return true;
    }
    @Transactional
    public Boolean deleteCard(Long idCard) throws Exception{
        CustomerEntity customerEntity = customerRepository.findByCardEntitySetIdCard(idCard);
        customerEntity.getCardEntitySet().forEach(card -> {
            if(card.getIdCard().equals(idCard))
                customerEntity.getCardEntitySet().remove(card);
        });
        customerRepository.save(customerEntity);
        movementCardRepository.deleteAll(movementCardRepository.findByCardIdCard(idCard));
        cardRepository.deleteById(idCard);
        return true;
    }
    @Transactional
    public Boolean deleteCustomer(Long idCustomer) throws Exception{
        CustomerEntity customerEntity = customerRepository.findById(idCustomer).get();
        customerEntity.getCardEntitySet().forEach(card -> {
            movementCardRepository.deleteAll(movementCardRepository.findByCardIdCard(card.getIdCard()));
            cardRepository.deleteById(card.getIdCard());
        });
        customerRepository.deleteById(idCustomer);
        return true;
    }
    @Transactional
    public Boolean deleteMovementCard(Long idMovement) throws Exception{
        movementCardRepository.deleteById(idMovement);
        return true;
    }

}
