package co.com.ibm.test;

import co.com.ibm.test.data.entity.MovementCardEntity;
import co.com.ibm.test.domain.CardRequest;
import co.com.ibm.test.domain.CustomerRequest;
import co.com.ibm.test.domain.MovementRequest;
import co.com.ibm.test.domain.ResponseIBM;
import co.com.ibm.test.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbmTestServiceApplicationTests {
	@Autowired
	private CustomerService customerService;

	@Test
	public void listaClientes_COUNT_OK() {
		AtomicInteger size = new AtomicInteger();
		AtomicReference<Boolean> correcto = new AtomicReference<>(true);
		customerService.getListCustomerAll().forEach(customer ->{
			size.getAndIncrement();
		});
		Assert.assertEquals(6, size.get());
	}
	@Test
	public void listaClientes_COUNT_KO() {
		AtomicInteger size = new AtomicInteger();
		AtomicReference<Boolean> correcto = new AtomicReference<>(true);
		customerService.getListCustomerAll().forEach(customer ->{
			size.getAndIncrement();
		});
		Assert.assertNotEquals(10, size.get());
	}
	@Test
	public void listaMovimientosClienteExistente(){
		List<MovementCardEntity> movimientos= customerService.getMovementsCustomerCard(10001l);
		Assert.assertEquals(2, movimientos.size());

	}
	@Test
	public void listaMovimientosClienteNoTiene(){
		List<MovementCardEntity> movimientos= customerService.getMovementsCustomerCard(4l);
		Assert.assertEquals(0, movimientos.size());
	}
	@Test
	public void guardarClienteOK(){
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setDireccion("PRUEBAS 1111");
		customerRequest.setIdCiudad(1l);
		customerRequest.setNombre("JUAN PRUEBA");
		customerRequest.setTelefono("7197268");
		ResponseIBM responseIBM = customerService.saveCustomer(customerRequest);
		Assert.assertEquals("200", responseIBM.getCode());
	}
	@Test
	public void guardarTarjetaExistenteOK(){
		CardRequest cardRequest = new CardRequest();
		cardRequest.setCcv("999");
		cardRequest.setIdCard(10001l);
		cardRequest.setIdTypeCard(1l);
		cardRequest.setNumberCard("800000000000");
		cardRequest.setIdCustomer(10001l);
		ResponseIBM responseIBM = customerService.saveCard(cardRequest);
		Assert.assertEquals("200", responseIBM.getCode());
	}

	@Test
	public void guardarMovimientoOK(){
		MovementRequest movementRequest = new MovementRequest();
		movementRequest.setAmount(92222.2);
		movementRequest.setDate(LocalDate.now());
		movementRequest.setDescription("COMPRA PRUEBA");
		movementRequest.setIdCard(10001l);
		ResponseIBM responseIBM = customerService.saveMovementCardCustomer(movementRequest);
		Assert.assertEquals("200", responseIBM.getCode());
	}
}
