package ibf2024.assessment.paf.batch4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.repositories.BeerRepository;

@SpringBootApplication
public class Batch2Application /*implements CommandLineRunner*/{

	@Autowired BeerRepository beerRepo;

	public static void main(String[] args) {
		SpringApplication.run(Batch2Application.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	List<Style> ls = beerRepo.getStyles();

	// 	for (Style style : ls) {
	// 		System.out.println(style.toString());
	// 	}

	// 	List<Beer> br = beerRepo.getBreweriesByBeer(1);

	// 	for (Beer beer : br) {
	// 		System.out.println(beer.toString());
	// 	}

	// 	Optional<Brewery> brw = beerRepo.getBeersFromBrewery(10);
	// 	System.out.println(brw.toString());
	// }

}
