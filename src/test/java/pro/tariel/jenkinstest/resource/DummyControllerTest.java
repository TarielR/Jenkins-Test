package pro.tariel.jenkinstest.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pro.tariel.jenkinstest.domain.Item;
import pro.tariel.jenkinstest.service.DummyService;
import pro.tariel.jenkinstest.util.TestUtils;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@SuppressWarnings("WeakerAccess")
public class DummyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    @Qualifier("dummy")
    private DummyService service;

    private Item item;

    @BeforeEach
    void setUp() {
        item = TestUtils.retrieveItem();
    }

    @Test
    void getItemMockTest() throws Exception {
        when(service.getItem()).thenReturn(item);

        this.mockMvc.perform(get("/api/item").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("First item")))
                .andExpect(jsonPath("$.asset.bonds", is("20")))
                .andReturn();

        verify(service, times(1)).getItem();
        verifyNoMoreInteractions(service);
    }

    @Test
    void getResponseMockTest() throws Exception {
        when(service.getItem()).thenReturn(item);

        this.mockMvc.perform(get("/api/response").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("First item")))
                .andExpect(jsonPath("$.asset.bonds", is("20")))
                .andReturn();

        verify(service, times(1)).getItem();
        verifyNoMoreInteractions(service);
    }
}
