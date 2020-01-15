package ru.pvolok.musictool.utils;

public class StringUtils {

	public static String removeQuotes(String s) {
		return s.replaceAll("\"", "");
	}
}
