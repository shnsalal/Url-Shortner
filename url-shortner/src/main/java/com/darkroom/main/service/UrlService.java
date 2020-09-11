package com.darkroom.main.service;
import com.darkroom.main.model.Url;

public interface UrlService {
	public String getShortUrl(Url request);
	public String getOriginalUrl(String shortUrl) throws Exception;
}
