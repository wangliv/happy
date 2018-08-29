package com.wangli.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
public class HappyControllerTest {

    MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext wc;
    
    @Before
    public void beforeSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
    }
    
    @Test
    public void test1() throws Exception {
        String msg = "happy";
        MvcResult result = this.mockMvc.perform(get("/").param("msg", msg)).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(msg, result.getResponse().getContentAsString());
 
    }
}
