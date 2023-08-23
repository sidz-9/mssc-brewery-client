package com.example.msscbreweryclient.web.client;

import com.example.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


import java.net.URI;
import java.util.UUID;

@Slf4j
@SpringBootTest
public class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;
    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
        log.info(customerDto.toString());
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().customerName("A new Customer").build();
        URI uri = customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
        log.info(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().customerName("An updated customer").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}
