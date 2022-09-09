package com.syj;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client-feign", url = "http://localhost:8001/server")
public interface TestClient {

    @GetMapping("get")
    String getString();

}
