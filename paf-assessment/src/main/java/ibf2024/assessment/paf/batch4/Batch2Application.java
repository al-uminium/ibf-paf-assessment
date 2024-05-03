package ibf2024.assessment.paf.batch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2024.assessment.paf.batch4.repositories.BeerRepository;

@SpringBootApplication
public class Batch2Application {

	@Autowired BeerRepository beerRepo;

	public static void main(String[] args) {
		SpringApplication.run(Batch2Application.class, args);
	}

}
