package com.vanhack.skip;

import com.vanhack.skip.order.controller.OrderController;
import com.vanhack.skip.order.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    private static final Integer ID = 1;

    @Autowired
    private OrderController controller;


    @Test
    public void contexLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnOneOrderNew() {
        assertThat(controller.getOrder(ID).getId()).isEqualTo(new Order(ID).getId());
    }
}
