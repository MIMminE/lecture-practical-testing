package unit;

import lombok.Getter;
import unit.beverage.Beverage;
import unit.order.Order;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CafeKiosk {

    public static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
    public static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage) {
        beverages.add(beverage);
    }

    public void remove(Beverage beverage) {
        beverages.remove(beverage);
    }

    public void clear() {
        beverages.clear();
    }

    public int calculateTotalPrice() {
        return beverages.stream()
                .mapToInt(Beverage::getPrice)
                .sum();
    }

    public Order createOrder() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalTime currentTime = currentDateTime.toLocalTime();
        if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw new IllegalArgumentException("It's not order time.");
        }

        return new Order(LocalDateTime.now(), beverages);
    }

    // Test
    public Order createOrder(LocalDateTime currentDateTime) {
        LocalTime currentTime = currentDateTime.toLocalTime();
        if (currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw new IllegalArgumentException("It's not order time.");
        }

        return new Order(LocalDateTime.now(), beverages);
    }
}
