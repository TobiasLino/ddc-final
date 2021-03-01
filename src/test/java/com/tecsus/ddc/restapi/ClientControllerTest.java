package com.tecsus.ddc.restapi;

import com.google.gson.Gson;
import com.tecsus.ddc.integration.AbstractintegrationTest;
import com.tecsus.ddc.model.client.Client;
import com.tecsus.ddc.model.client.ClientService;
import com.tecsus.ddc.model.identification.Identification;
import com.tecsus.ddc.model.identification.IdentificationService;
import com.tecsus.ddc.model.identification.IdentityType;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

        final var mvcResult = mockMvc.perform(get("/rest/client/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        JSONAssert.assertEquals(jsonAsString("expected-client-list.json"), getJsonResult(mvcResult), true);
    }

    @Test
    @WithMockUser(username = "admin")
    public void givenRequestOnClientServiceFindById_shouldSuceedWith200() throws Exception {
        var expectedResponse = simpleClient();
        System.out.println(expectedResponse.toString());

        when(clientService.findById(1L)).thenReturn(expectedResponse);

        final var mvcResult = mockMvc.perform(get("/rest/client/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        JSONAssert.assertEquals(jsonAsString("expected-client.json"), getJsonResult(mvcResult), true);
    }

    private List<Client> simpleList() throws Exception {
        var idents = new LinkedList<Client>();
        idents.add(simpleClient());
        return idents;
    }

    private Client simpleClient() throws Exception {
        return new Gson().fromJson(jsonAsString("expected-client.json"), Client.class);
    }
}
