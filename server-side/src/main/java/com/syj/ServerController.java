package com.syj;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class ServerController {

    @GetMapping("get")
    public String getString(@RequestHeader HttpHeaders headers){
        System.out.println("Headers:" + headers.toString());
        return headers.toString();
    }
}
