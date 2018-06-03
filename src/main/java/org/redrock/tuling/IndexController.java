package org.redrock.tuling;

import org.jboss.logging.Param;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class IndexController {

    private static final String URL = "http://www.tuling123.com/openapi/api";
    private static final String KEY = "8835224a2fe3421cba0c8af4393055f8";

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/chat")
    public String reply(@RequestParam("content") String content){
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("key",KEY);
        param.add("info",content);
        String str = restTemplate.postForObject(URL,param,String.class);
        Matcher matcher = Pattern.compile("\"text\":\"(.*)\"").matcher(str);
        if(matcher.find()){
            String s = matcher.group(1);
            return "{\"status\":200,\"text\":\""+s+"\"}";
        }
        return null;
    }

}
