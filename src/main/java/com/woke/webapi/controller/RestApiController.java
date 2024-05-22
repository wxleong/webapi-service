package com.woke.webapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.woke.webapi.Constant.WEBAPI_V1_PING;

@RestController
public class RestApiController {
    @RequestMapping(WEBAPI_V1_PING)
    public String ping() {
        return "pong";
    }
}
