package com.example.springboot;

import com.example.util.JsonStreamingUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class JsonController {

	@GetMapping("/")
	public String welcome() {
		return "Greetings from JsonReder!";
	}

	@PostMapping("/loadJson")
	public List<Object> loadJsonObject(@RequestBody String jsonValue) throws IOException, JsonProcessingException {

		List<Object> oList = new ArrayList<>();
		JsonStreamingUtil.streamParse(jsonValue);
		System.out.println(jsonValue);
		System.out.println("Size of List" + oList.size());

		return oList;
	}
}
