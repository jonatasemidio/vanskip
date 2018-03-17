package com.vanhack.skip.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanhack.skip.order.controller.OrderController;
import com.vanhack.skip.order.model.Order;
import com.vanhack.skip.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderRestTest {
    private static final Integer ID = 1;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderService service;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void shouldReturnFirstOrder() throws Exception {
        when(service.getOrder(ID)).thenReturn(new Order(ID));

        Order order = new Order(ID);
        String orderStr = objectMapper.writeValueAsString(order);

        this.mockMvc.perform(
                get("/api/v1/Order/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(orderStr))
        );
    }

    @Test
    public void shouldCreateOrder() throws Exception {
        Order order = new Order(ID);
        String orderStr = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/api/v1/Order").content(orderStr)
                .param("id", "1"))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnAllOrdersFromLogedCustomer() throws Exception {
        List<Order> orders = Arrays.asList(new Order(ID));
        String orderStr = objectMapper.writeValueAsString(orders);
        this.mockMvc.perform(
                get("/api/v1/Order/customer"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(orderStr))
        );
    }


}
