package ru.opa.pack.util;

import java.util.ArrayList;

import ru.opa.pack.entity.Point;

public final class StringHelper {

	public static String[] stringByLength(String text, int length) {
		String separator = "[,.?!\\s]";
		ArrayList<String> tokens = new ArrayList<String>();

		for (String token : text.split(separator)) {
			if (token.length() == length)
				tokens.add(token);
		}

		return tokens.toArray(new String[tokens.size()]);
	}

	public static double[] getDoubleArrayFromString(String text) {
		String tokens[] = text.split(" ");
		double array[] = new double[tokens.length];

		for (int i = 0; i < tokens.length; i++) {
			array[i] = Double.parseDouble(tokens[i]);
		}
		return array;
	}

	public static Point getPointFromString(String str) {
		String[] koords = str.split(" ");
		return new Point(Double.parseDouble(koords[0]),
				Double.parseDouble(koords[1]));
	}

	public static String fixWndowsFileName(String pathname) {
		String[] forbiddenSymbols = new String[] { "<", ">", ":", "\"", "/",
				"\\", "|", "?", "*" };
		String result = pathname;
		for (String forbiddenSymbol : forbiddenSymbols) {
			result = result.replace(forbiddenSymbol, "");
		}
		return result;
	}

	public static String cutMp3Url(String url) {
		return url.substring(0, url.indexOf(".mp3") + 4);
	}

	public static String overflowByLength(String str, int length) {
		if (length < str.length()) {
			str = str.substring(0, length - 2) + "..";
		}
		return str;
	}
}
