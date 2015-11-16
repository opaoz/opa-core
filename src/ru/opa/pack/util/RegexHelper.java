package ru.opa.pack.util;

import java.util.regex.Pattern;

public final class RegexHelper {

	/**
	 * If text is regexp return <b>true</b>, else <b>false</b>
	 * 
	 * @param text
	 *            Text for testing
	 * @param regex
	 *            Regular expression for testing
	 */
	public static boolean test(String text, String regex) {
		return Pattern.compile(regex).matcher(text).matches();
	}
}
