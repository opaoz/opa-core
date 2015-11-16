package ru.opa.pack.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public final class FileHelper {

	public static String read(File file) {
		StringBuilder lines = new StringBuilder();
		if (!file.exists()) {
			System.out.println("Файла не существует!");
			return "";
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(
				file.getAbsoluteFile()))) {
			String temp;
			while ((temp = reader.readLine()) != null) {
				lines.append(temp + "\n");
			}
		} catch (IOException e) {
			System.out.println("Ошибка потока для файла " + file.getName());
			return "";
		}

		return lines.toString();
	}

	public static String[] readLines(File file) {
		List<String> list = new ArrayList<String>();

		if (!file.exists()) {
			System.out.println("Файла не существует!");
			return null;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(
				file.getAbsoluteFile()))) {
			String temp;
			while ((temp = reader.readLine()) != null) {
				list.add(temp);
			}
		} catch (IOException e) {
			System.out.println("Ошибка потока ");
		}

		return list.toArray(new String[list.size()]);
	}

	public static boolean write(File file, String[] lines) {
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				System.out.println("Ошибка создания файла " + file.getName());
			}

		try (BufferedWriter output = new BufferedWriter(new FileWriter(
				file.getAbsoluteFile()))) {
			for (String line : lines) {
				output.write(line + "\n");
			}
		} catch (IOException e) {
			System.out.println("Ошибка потока для файла " + file.getName());
			return false;
		}

		return true;
	}

	public static boolean write(File file, String line) {
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				System.out.println("Ошибка создания файла " + file.getName());
			}

		try (BufferedWriter output = new BufferedWriter(new FileWriter(
				file.getAbsoluteFile()))) {
			output.write(line + "\n");

		} catch (IOException e) {
			System.out.println("Ошибка потока для файла " + file.getName());
			return false;
		}

		return true;
	}

	/*
	 * Download file from Internet. Dont replace exists files
	 *
	 * @param url Url for download
	 *
	 * @param path Path for local file save
	 *
	 * @param fileName Name of file on local drive
	 */
	public static void download(String url, String path, String fileName) {
		try {
			URL urlConnection = new URL(url);
			File file = new File(path + "/" + fileName);
			//if (!file.exists())
			//file.createNewFile();

			//System.out.println(file.getName());

			Files.copy(urlConnection.openStream(), file.toPath());
		} catch (FileAlreadyExistsException e) {
			//System.out.println("Already exists");
		} catch (IOException e) {
			System.out.println("Ошибка копирования");
			System.out.println(e.getMessage());
		}

	}
}
