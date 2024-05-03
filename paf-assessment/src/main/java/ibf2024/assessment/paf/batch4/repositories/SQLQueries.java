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
        where beers.style_id = 1;
      """;

  // Task 4
  // To get description of brewery for view 2
  public static final String GET_BREWERY_BY_ID = """
      select * from breweries where id = ?;
      """;
  
  // To get relevant rows for view 2
  public static final String GET_BEERS_AND_DESCRIP_FOR_BREWERY = """
      select beers.name as beer_name, beers.descript as description
      from beers
        inner join breweries
        on beers.brewery_id = breweries.id
        where breweries.id = 10
        order by beer_name ASC;
      """;
}
