package unit;

import org.junit.jupiter.api.Test;
import unit.beverage.Americano;

import static org.junit.jupiter.api.Assertions.*;

class CafeKioskTest {

    @Test
    void add(){
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> order unit count : " + cafeKiosk.getBeverages().size());
        System.out.println(">>> order unit : " + cafeKiosk.getBeverages().get(0).getName());

    }

}