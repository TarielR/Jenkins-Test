package pro.tariel.jenkinstest.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pro.tariel.jenkinstest.domain.Item;
import pro.tariel.jenkinstest.util.TestUtils;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@SuppressWarnings("WeakerAccess")
public class DummyControllerIT {
    @Autowired
    MockMvc mockMvc;

    private Item item;

    @BeforeEach
    void setUp() {
        item = TestUtils.retrieveItem();
    }

    @Test
    void getItemMockTest() throws Exception {

        this.mockMvc.perform(get("/api/item").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.name", is("First item")))
                .andExpect(jsonPath("$.asset").isNotEmpty())
                .andExpect(jsonPath("$.asset.bonds", is("20")))
                .andReturn();
    }

    @Test
    void getResponseMockTest() throws Exception {

        this.mockMvc.perform(get("/api/response").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.name", is("First item")))
                .andExpect(jsonPath("$.asset").isNotEmpty())
                .andExpect(jsonPath("$.asset.bonds", is("20")))
                .andReturn();
    }
}
