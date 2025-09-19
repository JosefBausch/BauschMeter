package unit;

import org.junit.Test;
import static org.junit.Assert.*;

import com.hydracommunications.meter.entities.Restaurant;

import java.util.UUID;

public class RestaurantTest {
    @Test
    public void restaurantHasNoReviews_ReturnsZeroAverageRating() {
        // A restaurant with no ratings should return 0 average rating/score
        // Arrange
        UUID id = UUID.randomUUID();
        Restaurant r = new Restaurant();
        r.setId(id);
        r.setName("McDonald's");

        // Act
        double average = r.getAverageRating();

        // Assert
        // Double, Double is not usable/deprecated due to floating point math.
        assertEquals(0.0, average, 0.1);
    }

    @Test
    public void restaurantWithOneReview_ReturnsOneAverageRating() {
        UUID id = UUID.randomUUID();
        Restaurant r = new Restaurant(id, "McDonald's");

        r.addRating(5);
        r.addRating(4);

        assertEquals(4.5, r.getAverageRating(), 0.1);
    }
}
