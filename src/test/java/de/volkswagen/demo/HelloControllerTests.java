package de.volkswagen.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class HelloControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void sayHello_noParams_rtnHelloWorld() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void sayHello_myName_rtnHelloName() throws Exception {
        mockMvc.perform(get("/hello?name=Sven"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Sven"));
    }

}
