package unit.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import unit.beverage.Beverage;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class Order {

    private final LocalDateTime orderDateTime;
    private final List<Beverage> beverages;
}
