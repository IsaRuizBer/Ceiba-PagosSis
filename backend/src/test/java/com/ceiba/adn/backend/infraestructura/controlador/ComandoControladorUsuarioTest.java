package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.aplicacion.comando.ComandoUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.testdatabuilder.PagoTestDataBuilder;
import com.ceiba.adn.backend.testdatabuilder.UsuarioTestDataBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
@Sql("/data.sql")
@ComponentScan("com.ceiba")
public class ComandoControladorUsuarioTest {

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void agregar() throws Exception {
        //arrange
        ComandoUsuario builder = new UsuarioTestDataBuilder()
                .conNombre("Ivan")
                .conApellido("Belmonte")
                .conDocumento("1222222222")
                .conCorreo("ivan.belmonte@correo.com")
                .buildComando();

        //act-assert
        mocMvc.perform(MockMvcRequestBuilders.
                post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(builder)))
                .andExpect(status().isOk());

    }

    @Test
    public void editar() throws Exception {
        //arrange
        ComandoUsuario builder = new UsuarioTestDataBuilder()
                .conNombre("Ivan")
                .conApellido("Belmonte")
                .conDocumento("1222222222")
                .conCorreo("ivan.belmonte82@correo.com")
                .buildComando();

        //act-assert
        mocMvc.perform(MockMvcRequestBuilders.
                put("/usuarios/{documento}","1222222222")
                .content(objectMapper.writeValueAsString(builder))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(MockMvcRequestBuilders
                .get("/usuarios/buscar/{documento}","1222222222")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.correo").value("ivan.belmonte82@correo.com"));

    }

    @Test
    public void eliminar() throws Exception {
        //act-assert
        mocMvc.perform(MockMvcRequestBuilders.
                delete("/usuarios/{documento}","722258"))
                .andExpect(status().isOk());
    }



}
