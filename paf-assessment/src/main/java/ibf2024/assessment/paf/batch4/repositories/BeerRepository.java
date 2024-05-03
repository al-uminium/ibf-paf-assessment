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
	public List<Beer> getBreweriesByBeer(Integer styleID) {
		// TODO: Task 3
		final List<Beer> beersList = new LinkedList<>(); 
		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEERS_OF_STYLE, styleID);
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
	public Optional<Brewery> getBeersFromBrewery() {
		// TODO: Task 4
		Brewery brewery = new Brewery();
		List<Beer> beersList = new LinkedList<>();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BEERS_AND_DESCRIP_FOR_BREWERY);

		while (rs.next()) {
			Beer beer = new Beer();
			brewery.setBreweryId(rs.getInt(BREWERY_ID));
			brewery.setAddress1(rs.getString(ADDRESS1));
			brewery.setAddress2(rs.getString(ADDRESS2));
			brewery.setCity(rs.getString(CITY));
			brewery.setDescription(rs.getString(BREWERY_DESCRIPTION));
			brewery.setName(rs.getString(BREWERY_NAME));
			brewery.setPhone(rs.getString(PHONE));
			brewery.setWebsite(rs.getString(WEBSITE));	
			beer.setBeerId(rs.getInt(BEER_ID));
			beer.setBreweryId(rs.getInt(BREWERY_ID));
			beer.setBeerDescription(rs.getString(BEER_DESCRIPTION));
			beer.setBeerName(rs.getString(BEER_NAME));
			beer.setBreweryName(rs.getString(BREWERY_NAME));
			beersList.add(beer);
		}
		brewery.setBeers(beersList);
		
		Optional<Brewery> optBrewery = Optional.of(brewery);

		return optBrewery;
	}
}
