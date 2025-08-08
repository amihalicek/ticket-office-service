package hr.abysalto.ticket_office_service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AbstractIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected <T> T performHttpGet(String url, int expectedStatus, TypeReference<T> resultDtoClass) throws Exception {
        MvcResult mvcResult  = mockMvc.perform(get(url)
                                                   .with(getBasichAuth()))
            .andExpect(MockMvcResultMatchers.status().is(expectedStatus)).andReturn();

        String resultAsString = mvcResult.getResponse().getContentAsString();
        return objectMapper.readValue(resultAsString, resultDtoClass);
    }

    private RequestPostProcessor getBasichAuth() {
        return httpBasic("abysalto","abysalto");
    }


}
