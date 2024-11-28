package com.scaler.productservicedec2023;

import com.scaler.productservicedec2023.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RandomTest {

    @Autowired
    private ProductController productController;

    @Test
    void testOnePlusOneIsTwo() {

        // act
        int i = 1 + 1;

        // assert
        assert i == 2;
        assert i * i == 4;

        assertTrue(i == 2);

        assertEquals(i,2);
       // assertThrows()
        // assertNull(i);

        assertEquals(3,i);

    }
    @Test
    void testTwoTwoZaFour(){
        int i = 2 * 2 ;

        assertEquals(4,i);

    }
}
