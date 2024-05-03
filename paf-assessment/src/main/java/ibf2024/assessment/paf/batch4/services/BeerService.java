package ibf2024.assessment.paf.batch4.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import ibf2024.assessment.paf.batch4.repositories.OrderRepository;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

@Service
public class BeerService {

	@Autowired private OrderRepository orderRepo;
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public String placeOrder(MultiValueMap<String, String> orders, String breweryID) {
		// TODO: Task 5 

		// Generate order Id
		String orderId = UUID.randomUUID().toString().substring(0, 8);

		// Generate date
		Date date = new Date(); 

		// Convert form params into json
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

		List<String> beerIds = orders.get("beerId");
		List<String> quantity = orders.get("qty");

		for (int i = 0; i < quantity.size(); i++) {
			if (!quantity.get(i).isEmpty()) {
				String qty = quantity.get(i);
				String beerId = beerIds.get(i);
				arrayBuilder.add(Json.createObjectBuilder()
										.add("beerId", beerId)
										.add("quantity", qty));
			}
		}

		// Build Json
		JsonObject resp = Json.createObjectBuilder()
													.add("orderId", orderId)
													.add("date", date.toString())
													.add("breweryId", breweryID)
													.add("orders", arrayBuilder)
													.build();

		orderRepo.postOrder(Document.parse(resp.toString()));

		return orderId;
	}

}
