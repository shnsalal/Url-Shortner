package com.darkroom.main.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.darkroom.main.service.BaseConversion;

@Service
public class BaseConversionImpl implements BaseConversion {
	private final String base62String = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final char[] base62character = base62String.toCharArray();
	private final int base62length = base62character.length;
	
	@Override
	public String encoder(long input) {
		StringBuilder encodedString = new StringBuilder();
		while(input != 0) {
			long reminder = input % base62length;
			encodedString.append(base62character[(int)reminder]);
			input = input / base62length;
		}
		return encodedString.reverse().toString();
	}

	@Override
	public long decoder(String input) {
		long id = 0;
		int count = 1;
		int inputLength = input.length();
		for (int i = 0; i < inputLength; i++) {
			id = (long) (id + base62String.indexOf(input.charAt(i)) * Math.pow(base62length, (inputLength - count)));
			count++;
		}
		return id;
	}

}
