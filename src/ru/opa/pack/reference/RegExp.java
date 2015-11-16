package ru.opa.pack.reference;

public final class RegExp {
	/**
	 * Credit card number
	 */
	public static final String CARD_NUMBER = "[0-9]{13,16}";
	
	/**
	 * ICQ number
	 */
	public static final String ICQ = "([1-9])+(?:-?\\d){4,}";
	
	/**
	 * String contains only numbers and letters
	 * <hr><blockquote>
	 * 		<b>A-z0-9</b>
	 * </blockquote>
	 * @see NUMBERS_AND_LETTERS_RUS
	 */
	public static final String NUMBERS_AND_LETTERS = "^[a-zA-Z0-9]+$";
	
	/**
	 * String contains only numbers and letters
	 * <hr><blockquote>
	 * 		<b>À-ÿ¨¸A-z0-9</b>
	 * </blockquote>
	 * @see NUMBERS_AND_LETTERS
	 */
	public static final String NUMBERS_AND_LETTERS_RUS = "^[à-ÿÀ-ß¸¨a-zA-Z0-9]+$";
	
	/**
	 * Domen name 
	 * <hr><blockquote>
	 * 		<b>yandex.ru</b>
	 * </blockquote>
	 * @see URL_RUS
	 */
	public static final String DOMEN = "([a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";
	
	/**
	 * User name 3-20 letters
	 * <hr><blockquote>
	 * 		<b>opa_oz</b>
	 * </blockquote>
	 * @see PASSWORD
	 */
	public static final String USER_NAME = "[a-zA-Z][a-zA-Z0-9-_.]{2,20}";
	
	/**
	 * Password
	 * <hr><blockquote>
	 * 		<b>A-z-,?0-9_=.</b>
	 * </blockquote>
	 */
	public static final String PASSWORD = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*";
	
	/**
	 * Date in YYYY-MM-DD
	 * <hr><blockquote>
	 * 		<b>2015-07-25</b>
	 * </blockquote>
	 * @see DATE_DMY
	 */
	public static final String DATE_YMD = "(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)";
	
	/**
	 * Date in DD/MM/YYYY
	 * <hr><blockquote>
	 * 		<b>25/07/2005</b>
	 * </blockquote>
	 * @see DATE_YMD
	 */
	public static final String DATE_DMY = "(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d";
	
	/**
	 * int, float, double numbers
	 */
	public static final String NUMBER = "\\-?\\d+(\\.\\d{0,})?";
	
	public static final String UUID = "[0-9A-Fa-f]{8}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{4}\\-[0-9A-Fa-f]{12}";
	
	public static final String EMAIL = "[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}";
	
	/**
	 * Domen name <i>include äîìåí.ðô</i> 
	 * <hr><blockquote>
	 * 		<b>yandex.ru && ÿíäåêñ.ðô</b>
	 * </blockquote>
	 * @see DOMEN
	 */
	public static final String URL_RUS = "(?:(?:https?|ftp|telnet)://(?:[à-ÿ¸a-z0-9_-]{1,32}(?::[à-ÿ¸a-z0-9_-]{1,32})?@)?)?(?:(?:[à-ÿ¸a-z0-9-]{1,128}\\.)+(?:ðô|ru|su|com|net|org|mil|edu|arpa|gov|biz|info|aero|inc|name|[a-z]{2})|(?!0)(?:(?!0[^.]|255)[0-9]{1,3}\\.){3}(?!0|255)[0-9]{1,3})(?:/[à-ÿ¸a-z0-9.,_@%&?+=\\~/-]*)?(?:#[^ '\\\"&]*)?";
	
	/**
	 * Time in HH:MM:SS
	 * <hr><blockquote>
	 * 		<b>14:50:22</b>
	 * </blockquote>
	 */
	public static final String TIME_HMS = "([0-1]\\d|2[0-3])(:[0-5]\\d){2}";
}
