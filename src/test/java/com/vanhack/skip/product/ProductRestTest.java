package com.vanhack.skip.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanhack.skip.order.service.OrderService;
import com.vanhack.skip.product.controller.ProductController;
import com.vanhack.skip.product.model.Product;
import com.vanhack.skip.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductRestTest {
    private static final Integer ID = 1;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService service;

    @Autowired
    private MockMvc mockMvc;

    public ProductRestTest() {
    }

    @Test
    public void shouldReturnProductFromCustomer() throws Exception {
        Product product = new Product(ID);
        String productStr = objectMapper.writeValueAsString(product);

        this.mockMvc.perform(
                get("/api/v1/Product"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(productStr))
                );
    }
}
