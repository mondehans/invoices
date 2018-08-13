package net.monde.hans.invoices.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InvoicesTests {

    @Autowired
    private TestRestTemplate template;


    @Test
    public void shouldBeavailable(){
        ResponseEntity<String> entity= this.template.getForEntity("/invoices", String.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
    }


    @Test
    public void shouldFind1(){
        ResponseEntity<String> entity= this.template.getForEntity("/invoices/1", String.class);
        assertEquals( HttpStatus.OK,entity.getStatusCode());
        assertEquals("{\"id\":1,\"client\":\"Monde\",\"vatRate\":15,\"invoiceDate\":\"2018-08-12T22:00:00.000+0000\",\"lineItems\":[{\"id\":1,\"quantity\":10,\"description\":\"water coller\",\"unitPrice\":12.00}]}",entity.getBody());
    }

    @Test
    public void shouldFail(){
        ResponseEntity<String> entity= this.template.getForEntity("/invoices1", String.class);
        assertEquals( HttpStatus.NOT_FOUND,entity.getStatusCode());
    }

    @Test
    public void shouldNotFindInvoice(){
        ResponseEntity<String> entity= this.template.getForEntity("/invoices/4", String.class);
        assertEquals( HttpStatus.NOT_FOUND,entity.getStatusCode());
        assertEquals("[{\"logref\":\"error\",\"message\":\"Invoice not found \",\"links\":[]}]",entity.getBody());
    }

}
