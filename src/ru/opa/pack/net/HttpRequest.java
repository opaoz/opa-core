package ru.opa.pack.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class HttpRequest {
	/**
	 * @param urlLocation
	 * 			Url adres
	 * @return Connection with url location
	 */
	public static HttpURLConnection getConnection(String urlLocation)
			throws IOException {
		URL url = new URL(urlLocation);
		HttpURLConnection connection = null;
		connection = (HttpURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setConnectTimeout(Integer.MAX_VALUE);
		populateConnectionWithStandartProperties(connection);
		return connection;
	}

	/**
	 * Browser simulate
	 */
	public static void populateConnectionWithStandartProperties(
			HttpURLConnection connection) {
		connection.setRequestProperty("Accept", "text/html");
		connection.setRequestProperty("Accept-Language", "en-US");
		connection
				.setRequestProperty(
						"User-Agent",
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; ru; rv:1.8.1.12) Gecko/20080201 Firefox");
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded; charset=utf-8");
		connection.setRequestProperty("Pragma", "no-cache");
		connection.setInstanceFollowRedirects(false);
	}

	/**
	 * Send Post and returns result
	 * <blockquote>
	 *		List<String[]> params = new LinkedList<String[]>();
	 *		params.add(new String[] { "need_user", "0" });
	 *		params.add(new String[] { "count", "1" });
	 *		params.add(new String[] { "offset", "1" });
	 *		params.add(new String[] { "access_token", token });
	 * </blockquote>
	 * @return Post request
	 */
	public static String sendPostRequest(String urlLocation,
										 List<String[]> parameters) throws IOException {
		StringBuffer result = new StringBuffer();
		HttpURLConnection connection = getConnection(urlLocation);
		System.out.println("Соединение с " + urlLocation + " установлено.");
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Referer", urlLocation);
		connection.setRequestProperty("Cookie", "your cookies may be here");
		String data = "";
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				String param[] = (String[]) parameters.get(i);
				if (i != 0) {
					data = data + "&";
				}
				data = data + param[0] + "="
						+ URLEncoder.encode(param[1], "UTF-8");
			}

		}
		if (parameters != null && data.length() != 0) {
			connection.setRequestProperty("Content-Length",
					Integer.toString(data.length()));
		}
		connection.connect();
		if (parameters != null && data.length() != 0) {
			System.out.println("Отправка данных..");

			try (PrintWriter out = new PrintWriter(connection.getOutputStream())) {

				out.write(data);
			} catch (IOException e) {
				System.out.println("Ошибка потока ");
			}
			System.out.println("Получение ответа от сервера..");
		}

		try (BufferedReader rd = new BufferedReader(new InputStreamReader(
				connection.getInputStream()))) {
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line).append("\n");
			}
		} catch (IOException e) {
			System.out.println("Ошибка потока ");
		}

		connection.disconnect();
		return result.toString();
	}
}
