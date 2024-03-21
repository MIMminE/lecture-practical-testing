package sample.cafekiosk.spring.api.service.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void getSellingProducts(){
        List<ProductResponse> sellingProducts = productService.getSellingProducts();
        System.out.println(sellingProducts);
    }


}