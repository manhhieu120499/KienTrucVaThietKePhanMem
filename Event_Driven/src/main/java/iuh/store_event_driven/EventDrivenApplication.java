package iuh.store_event_driven;

import iuh.store_event_driven.service.InventoryService;
import iuh.store_event_driven.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventDrivenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EventDrivenApplication.class, args);
	}

	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private PaymentService paymentService;
	@Override
	public void run(String... args) throws Exception {
		inventoryService.receiveMessage();
		paymentService.receiveMessage();
	}
}
