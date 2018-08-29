package com.wangli.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HappyServiceTest {

    @Autowired
    private HappyService service;
    
    @Test
    public void test1() throws Exception {
        String result = service.happy();
        assertEquals(result,"happy");
    }
}
