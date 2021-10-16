package com.test.product.main;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth1")
public class SecuredServerController {
	@RequestMapping("/test1")
    public String secured(){
        System.out.println("auth1 Inside secured()");
        return "Hello user !!! : " + new Date();
    }
}
