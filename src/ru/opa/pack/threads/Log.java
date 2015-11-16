package ru.opa.pack.threads;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import ru.opa.pack.ui.components.LogPanel;

public class Log implements Runnable {
	private LogPanel log = new LogPanel();

	public Log() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		JFrame frame = new JFrame("Log");

		frame.setLayout(new FlowLayout());
		frame.add(log);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

	public void info(String message){
		log.info(message);
	}
}
