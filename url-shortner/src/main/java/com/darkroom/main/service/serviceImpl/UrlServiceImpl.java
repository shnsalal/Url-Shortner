package com.darkroom.main.service.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkroom.main.model.Url;
import com.darkroom.main.repository.UrlRepository;
import com.darkroom.main.service.BaseConversion;
import com.darkroom.main.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
	
	@Autowired
	UrlRepository urlRepository;
	
	@Autowired
	BaseConversion baseConversion;

	@Override
	public String getShortUrl(Url request) {
		urlRepository.save(request);
		return baseConversion.encoder(request.getId());
	}

	@Override
	public String getOriginalUrl(String shortUrl) throws Exception {
		long id = baseConversion.decoder(shortUrl);
		Url url = urlRepository.findById(id)
				.orElseThrow(() -> new Exception("Url Not Found"));
		
		if(url.getExpiresDate() != null && url.getExpiresDate().before(new Date())) {
			urlRepository.deleteById(id);
			throw new Exception("Link Expired");
		}
		return url.getOriginalUrl();
	}

}
