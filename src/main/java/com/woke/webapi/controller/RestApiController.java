package com.woke.webapi.controller;

import com.woke.webapi.Constant;
import com.woke.webapi.entity.Movie;
import com.woke.webapi.repository.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.woke.webapi.Constant.*;

/*
 * The "Access-Control-Allow-Origin" response header will only be set if
 * the request header includes "Origin" and the value of "Origin" is
 * different from the server URI.
 */
@CrossOrigin(origins = "*")
@RestController
public class RestApiController {
    @Autowired
    private MovieService movieService;

    @GetMapping(value = WEBAPI_V1_PING, produces = "text/plain;charset=UTF-8")
    public String ping() {
        return "pong";
    }

    @GetMapping(value = WEBAPI_V1_GET_TEST_DATA, produces = "application/json")
    public String getTestData() throws IOException {
        ClassPathResource resource = new ClassPathResource("test-data/db.json");
        byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());
        String data = new String(bdata, StandardCharsets.UTF_8);
        return data;
    }

    @GetMapping(value = Constant.WEBAPI_V1_GET_TEST_DATA_SEARCH_CONTAIN, produces = "application/json")
    public List<Movie> getTestData(@RequestParam String title) {
        return movieService.findByTitleContaining(title);
    }
}
