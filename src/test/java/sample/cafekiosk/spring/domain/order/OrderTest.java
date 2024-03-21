package sample.cafekiosk.spring.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.spring.domain.product.Product;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.*;
import static sample.cafekiosk.spring.domain.product.ProductType.HANDMADE;

class OrderTest {

    @DisplayName("주문 생성 시 상품 리스트에서 주문의 총 금액을 계산한다.")
    @Test
    void calculateTotalPrice() {
        // given
        List<Product> products = List.of(
                createProduct("001", 4500),
                createProduct("002", 5000));

        // when
        Order order = Order.create(products, LocalDateTime.now());

        // then
        assertThat(order.getTotalPrice()).isEqualTo(9500);
    }


    @DisplayName("주문 생성 시 주문의 초기 상태는 Init 이다.")
    @Test
    void init() {
        // given
        List<Product> products = List.of(
                createProduct("001", 4500),
                createProduct("002", 5000));
        // when
        Order order = Order.create(products, LocalDateTime.now());
        // then
        assertThat(order.getOrderStatus()).isEqualByComparingTo(OrderStatus.INIT);
    }


    private Product createProduct(String productNumber, int price) {
        return Product.builder()
                .productNumber(productNumber)
                .type(HANDMADE)
                .sellingStatus(SELLING)
                .name("테스트 메뉴")
                .price(price)
                .build();
    }

    @DisplayName("주문 생성 시 주문 등록 시간을 기록한다.")
    @Test
    void registerDateTime() {
        // given
        LocalDateTime registerDateTime = LocalDateTime.now();
        List<Product> products = List.of(
                createProduct("001", 4500),
                createProduct("002", 5000));

        // when
        Order order = Order.create(products, registerDateTime);

        // then
        assertThat(order.getRegisteredDateTime()).isEqualTo(registerDateTime);
    }

}