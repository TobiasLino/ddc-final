package com.tecsus.ddc.restapi;

import com.tecsus.ddc.integration.AbstractintegrationTest;
import com.tecsus.ddc.model.client.Client;
import com.tecsus.ddc.model.client.ClientService;
import com.tecsus.ddc.model.identification.Identification;
import com.tecsus.ddc.model.identification.IdentificationService;
import com.tecsus.ddc.model.identification.IdentityType;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
public class ClientControllerTest extends AbstractintegrationTest<Client> {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    @WithMockUser(username = "admin")
    public void givenRequestOnClientServiceFindAll_shouldSuceedWith200() throws Exception {
        var expectedResponse = simpleList();
        when(clientService.findAll()).thenReturn(expectedResponse);

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(listAsJson(expectedResponse)));
    }

    @Test
    @WithMockUser(username = "admin")
    public void givenRequestOnClientServiceFindById_shouldSuceedWith200() throws Exception {
        var expectedResponse = simpleClient();

        when(clientService.findById(1L)).thenReturn(expectedResponse);

        mockMvc.perform(get("/get/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectAsJson(expectedResponse)));
    }

    private List<Client> simpleList() throws Exception {
        var idents = new LinkedList<Client>();
        idents.add(simpleClient());
        return idents;
    }

    private Client simpleClient() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-ddT");
        return Client.builder()
                .id(1L)
                .name("Tobias Lino")
                .identity(Identification.builder()
                        .id(1L)
                        .type(IdentityType.CPF)
                        .document("44521581889")
                        .build())
                .dataCria(new DateTime(formatter.parse("2021-03-01T01:24:36.000+00:00")).withDate(2021, 2, 28).toDate())
                .build();
    }
}
