package org.redrock.tuling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TulingApplicationTests {

    @Autowired
    IndexController indexController;

    @Test
    public void contextLoads() {
        String str = indexController.reply("你好");
        System.out.println(str);
    }

}
