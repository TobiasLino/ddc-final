package com.tecsus.ddc.security;

import com.tecsus.ddc.model.bill.BillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillService billService;

    @Test
    @WithMockUser(value = "admin")
    public void givenAuthRequestONBillService_shouldSuceedWith200() throws Exception {
        mockMvc.perform(get("/get"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user1")
    public void givenRequestOnBillService_shouldErrorWith403() throws Exception {
        mockMvc.perform(get("/get"))
                .andDo(print())
                .andExpect(status().is(403));
    }
}
