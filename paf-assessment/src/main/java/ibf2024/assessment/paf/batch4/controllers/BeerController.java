package ibf2024.assessment.paf.batch4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Style;
import ibf2024.assessment.paf.batch4.repositories.BeerRepository;


@Controller
public class BeerController {

	@Autowired private BeerRepository beerRepo;

	//TODO Task 2 - view 0
	@GetMapping(path = {"/", "/index.html"})
	public String getView0(Model model) {
		List<Style> styles = beerRepo.getStyles();
		model.addAttribute("styles", styles);
		return "view0";
	}
	
	
	//TODO Task 3 - view 1
	@GetMapping("/beer/style/{styleID}{styleName}")
	public String getMethodName(@PathVariable Integer styleID, @RequestParam String styleName, Model model) {
		List<Beer> beers = beerRepo.getBreweriesByBeer(styleID);
		model.addAttribute("styleName", styleName);
		model.addAttribute("beers", beers);
		return "view1";
	}
	
	

	//TODO Task 4 - view 2

	
	//TODO Task 5 - view 2, place order

}
