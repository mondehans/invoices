package net.monde.hans.invoices.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
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
        entity.getStatusCode();
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void shouldFind1(){
        ResponseEntity<String> entity= this.template.getForEntity("/invoices/1", String.class);
        entity.getStatusCode();
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(entity.getBody(),"{\"id\":1,\"client\":\"Monde\",\"vatRate\":15,\"invoiceDate\":\"2018-08-12T22:00:00.000+0000\",\"lineItems\":[{\"id\":1,\"quantity\":10,\"description\":\"water coller\",\"unitPrice\":12.00}]}");
    }

    @Test
    public void shouldFail(){
        ResponseEntity<String> entity= this.template.getForEntity("/invoices1", String.class);
        entity.getStatusCode();
        assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void shouldNotFindInvoice(){
        ResponseEntity<String> entity= this.template.getForEntity("/invoices/4", String.class);
        entity.getStatusCode();
        assertEquals(entity.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(entity.getBody(),"[{\"logref\":\"error\",\"message\":\"Invoice not found \",\"links\":[]}]");
    }

}
