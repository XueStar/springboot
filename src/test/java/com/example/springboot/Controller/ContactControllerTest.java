package com.example.springboot.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class ContactControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() throws Exception{
        mvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getContactList() {
    }

    @Test
    public void getContact() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/Contact/get/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void editContact() {
    }

    @Test
    public void addContact() {
    }

    @Test
    public void delContact() {
    }
}