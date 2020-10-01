package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.testdatabuilder.PagoTestDataBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
@Sql("/data.sql")
@ComponentScan("com.ceiba")
public class ControladorCrearPagoTest {

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void agregar() throws Exception {
        //arrange
        PagoTestDataBuilder builder= new PagoTestDataBuilder().
                conDocumento("102548785")
                .conEstado("Al día")
                .conMonto(new BigDecimal(900000))
                .conFecha(new Date());

        //act-assert
        mocMvc.perform(MockMvcRequestBuilders.
                 post("/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(builder)))
                .andExpect(status().isOk());

        mocMvc.perform(MockMvcRequestBuilders
                .get("/pagos/listar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
           .andExpect(jsonPath("$[2].documento", is("102548785")));

    }


}
