package ibf2024.assessment.paf.batch4.repositories;

public interface SQLQueries {

  // Task 2
  public static final String GET_STYLES_AND_COUNT = """
      select styles.id as style_id, styles.style_name as style_name, COUNT(beers.name) as beer_count
      from styles
        inner join beers
        on styles.id = beers.style_id
        group by styles.id
        order by style_name;
      """;

  // Task 3
  public static final String GET_BEERS_OF_STYLE = """
      select beers.id as beer_id, beers.name as beer_name, beers.descript as beer_descript, breweries.id as brewery_id, breweries.name as brewery_name
      from beers
      inner join breweries
        on beers.brewery_id = breweries.id
        where beers.style_id = ?;
      """;

  // Task 4
  // To get relevant rows for view 2
  public static final String GET_BEERS_AND_DESCRIP_FOR_BREWERY = """
    select breweries.id as brewery_id,
	  breweries.name as brewery_name,
    breweries.address1 as address1,
    breweries.address2 as address2,
    breweries.city as city, 
    breweries.state as state,
    breweries.code as code, 
    breweries.country as country,
    breweries.phone as phone,
    breweries.descript as brewery_descript,
	  breweries.website as website,
	  beers.id as beer_id,
	  beers.name as beer_name, 
    beers.descript as beer_descript
      from beers
      inner join breweries
      on beers.brewery_id = breweries.id
      where breweries.id = ?
      order by beer_name;
      """;
}
