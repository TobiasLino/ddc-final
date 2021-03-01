package com.tecsus.ddc.restapi;

import com.tecsus.ddc.integration.AbstractintegrationTest;
import com.tecsus.ddc.model.identification.Identification;
import com.tecsus.ddc.model.identification.IdentificationService;
import com.tecsus.ddc.model.identification.IdentityType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IdentificationController.class)
public class IdentificationControllerTest extends AbstractintegrationTest<Identification> {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IdentificationService identificationService;

    @Test
    @WithMockUser(username = "admin")
    public void givenRequestOnIdentificationServiceFindAll_shouldSuceedWith200() throws Exception {
        var expectedResponse = simpleList();
        when(identificationService.findAll()).thenReturn(expectedResponse);

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(listAsJson(expectedResponse)));
    }

    @Test
    @WithMockUser(username = "admin")
    public void givenRequestOnIdentificationServiceFindById_shouldSuceedWith200() throws Exception {
        var expectedResponse = simpleIdentity();

        when(identificationService.findById(1)).thenReturn(expectedResponse);

        mockMvc.perform(get("/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectAsJson(expectedResponse)));
    }

    private List<Identification> simpleList() {
        var idents = new LinkedList<Identification>();
        idents.add(simpleIdentity());
        return idents;
    }

    private Identification simpleIdentity() {
        return Identification.builder()
                .id(1L)
                .document("44521581889")
                .type(IdentityType.CPF).build();
    }
}
