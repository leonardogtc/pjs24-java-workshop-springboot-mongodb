package br.com.leonardogtc.resources.util;

import java.net.URLDecoder;

public class URL {
	public static String decodeParam(String text) {
		return URLDecoder.decode(text, java.nio.charset.StandardCharsets.UTF_8);
	}
}
