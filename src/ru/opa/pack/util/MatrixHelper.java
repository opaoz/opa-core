package ru.opa.pack.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class MatrixHelper {

	public static double[][] readMatrix(String path) {
		File file = new File(path);
		int row, col;
		double matrix[][];

		try (BufferedReader reader = new BufferedReader(new FileReader(
				file.getAbsoluteFile()))) {
			double tmp[] = StringHelper.getDoubleArrayFromString(reader
					.readLine());

			row = (int) tmp[0];
			col = (int) tmp[1];
			matrix = new double[row][col];

			for (int i = 0; i < row; i++) {
				matrix[i] = StringHelper.getDoubleArrayFromString(reader
						.readLine());
			}

			return matrix;
		} catch (IOException e) {
			System.out.println("Ошибка потока для файла " + file.getName());
		}

		return null;
	}
}
