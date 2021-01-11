import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
 
    	for(Restaurant restuarant : restaurants ) {
	    	if(restuarant.getName().equals(restaurantName)) {
	
	    		return restuarant;
	    	}
    	}
    	throw new restaurantNotFoundException(restaurantName);
		//return found;


    }

    // new feature implemented
    // user can search for restaurants which have a specific menu item
	public List<Restaurant> getResturantsByMenuItem(String itemName){

    	List<Restaurant> found = null;
    	for(Restaurant restuarant : restaurants ) {
	    	//if(restuarant.getMenu().size() > 0) {
    		List<Item> menu = restuarant.getMenu();
	    		for(Item itm : menu) {
	    			if(itm.getName().equals(itemName)) {
	    				found.add(restuarant);
	    			}
	    		}
	    	//}
    	}

    	return found;
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
