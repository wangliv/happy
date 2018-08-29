package com.wangli;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wangli.service.HappyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HappyApplicationTests {

    @Autowired
    HappyService service;
    
    //引入 ContiPerf 进行性能测试
    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();
    
	@Test
	//10个线程 执行10次
    @PerfTest(invocations = 100,threads = 10)
	public void test1() {
	    String result = service.happy();
	    Assert.assertEquals("happy", result);
	}

}
