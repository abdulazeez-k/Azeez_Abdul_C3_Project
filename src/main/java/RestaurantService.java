import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        if(restaurantName != ""){
            if(restaurants != null) {
                for (Restaurant restaurant : restaurants) {
                    if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                        return restaurant;
                    } else {
                        throw new restaurantNotFoundException("Restaurant : '" + restaurantName + "' is not found.");
                    }
                }
            }
            else{
                throw new restaurantNotFoundException("No restaurant's are available. Kindly contact the administrator.");
            }
        }
        throw new restaurantNotFoundException("Please enter a valid restaurant name.");
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
