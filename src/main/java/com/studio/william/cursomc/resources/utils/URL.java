package com.studio.william.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}
	
	public static List<Integer> decodeIntList(String s){
			
//		String[] vet = s.split(",");
//		List<Integer> list = new ArrayList<>();
//		for (String string : vet) {
//			list.add(Integer.parseInt(string));
//		}
		return Arrays.asList(s.split(",")).stream().map(x-> Integer.parseInt(x)).collect(Collectors.toList());
		
		
		
	}
}
