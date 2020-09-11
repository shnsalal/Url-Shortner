package com.darkroom.main.service;

public interface BaseConversion {
	public String encoder(long id);
	public long decoder(String shortUrl);
}
