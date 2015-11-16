package ru.opa.pack.util;

import java.util.Scanner;

public final class ConsoleHelper {
	private static Scanner scanner = new Scanner(System.in);

	public String nextString(String message){
		System.out.print(message);
		if(scanner.hasNextLine()) return scanner.nextLine();

		return "";
	}

	public int nextInt(String message){
		System.out.print(message);
		if(scanner.hasNextInt()) return scanner.nextInt();

		return 0;
	}

	public double nextDouble(String message){
		System.out.print(message);
		if(scanner.hasNextDouble()) return scanner.nextDouble();

		return 0.0;
	}

	public String[] nextStringArray(String message){
		int length = nextInt(message);
		String[] array = new String[length];

		for(int i = 0;i < length; i++){
			array[i] = nextString("Введите " + (i + 1) + "-й элемент: ");
		}	

		return array;
	}
	
	public int[] nextIntArray(String message){
		int length = nextInt(message);
		int[] array = new int[length];
		
		for(int i = 0;i < length; i++){
			array[i] = nextInt("Введите " + (i + 1) + "-й элемент: ");
		}
		
		return array;
	}
}
