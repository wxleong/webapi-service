package com.woke.webapi.controller;

import com.woke.webapi.Constant;
import com.woke.webapi.dto.MovieDTO;
import com.woke.webapi.model.TestDataSearch;
import com.woke.webapi.repository.GenreService;
import com.woke.webapi.repository.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.woke.webapi.Constant.WEBAPI_V1_GET_TEST_DATA;
import static com.woke.webapi.Constant.WEBAPI_V1_PING;

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
    @Autowired
    private GenreService genreService;

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
    public TestDataSearch getTestData(@RequestParam String title) {
        List<MovieDTO> movies = movieService.findByTitleCaseInsensitiveContaining(title);
        List<String> genres = genreService.findAllGenreNames();
        TestDataSearch testDataSearch = new TestDataSearch(genres, movies);
        return testDataSearch;
    }
}
