package ibf2024.assessment.paf.batch4.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Style;

@Repository
public class BeerRepository implements SQLQueries, SQLColumnNames {

	@Autowired private JdbcTemplate jdbcTemplate; 


	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2
		final List<Style> styleList = new LinkedList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_STYLES_AND_COUNT);

		while (rs.next()) {
			Style style = new Style();
			style.setStyleId(rs.getInt(STYLE_ID));
			style.setName(rs.getString(STYLE_NAME));
			style.setBeerCount(rs.getInt(BEER_COUNT));
			styleList.add(style);
		}
		return styleList;
	}
		
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(/* You can add any number parameters here */) {
		// TODO: Task 3
		final List<Beer> beersList = new LinkedList<>(); 
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEERS_OF_STYLE);
		while (rs.next()) {
			Beer beer = new Beer();
			beer.setBeerId(rs.getInt(BEER_ID));
			beer.setBreweryId(rs.getInt(BREWERY_ID));
			beer.setBeerDescription(rs.getString(BEER_DESCRIPTION));
			beer.setBeerName(rs.getString(BEER_NAME));
			beer.setBreweryName(rs.getString(BREWERY_NAME));
			beersList.add(beer);
		}
		return beersList;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(/* You can add any number of parameters here */) {
		// TODO: Task 4

		return Optional.empty();
	}
}
