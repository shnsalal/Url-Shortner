package com.darkroom.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkroom.main.model.Url;
import com.darkroom.main.service.UrlService;

@RestController
@RequestMapping("/api")
public class UrlController {
	@Autowired
	UrlService urlService;

	@PostMapping("get-short-url")
	public ResponseEntity<?> requestShortUrl(@RequestBody Url request) {
			return ResponseEntity.ok("www.tiny.url/" + urlService.getShortUrl(request));
	}

	
	@GetMapping("get-original-url/{shortUrl}")
	public ResponseEntity<?> requestOriginalUrl(@PathVariable String shortUrl) throws Exception {
		return ResponseEntity.ok(urlService.getOriginalUrl(shortUrl));
		
	}
}
