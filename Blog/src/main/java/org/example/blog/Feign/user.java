package org.example.blog.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CODING-BLOCKS-INTERN")
public interface user {
    @GetMapping("/validateToken")
    boolean validateToken(@RequestHeader("Authorization") String token, @RequestParam("username") String username);
}

