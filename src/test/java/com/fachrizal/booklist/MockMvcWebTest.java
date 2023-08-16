package com.fachrizal.booklist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookListApplication.class)
@WebAppConfiguration
public class MockMvcWebTest {
    @Autowired
    private WebApplicationContext webContext;
    private MockMvc mockMvc;

    //@Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webContext)
                .build();
    }

    @Test
    public void homePage() throws Exception {
        setupMockMvc();
        mockMvc.perform(get("/bookList"))
                .andExpect(status().isOk())
                .andExpect(view().name("book-list"))
                .andExpect(model().attributeExists("books"));
    }
}
