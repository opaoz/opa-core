package ru.opa.pack.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import ru.opa.pack.reference.Reference;

public class LogPanel extends JPanel {
	private static final long serialVersionUID = -7968405633747657642L;
	private JTextArea text;

	public LogPanel() {
		text = new JTextArea();
		text.setAlignmentX(LEFT_ALIGNMENT);
		text.setAlignmentY(TOP_ALIGNMENT);
		text.setPreferredSize(getPreferredSize());
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setFont(Reference.LOG_FONT);

		add(text);
		this.setVisible(true);
	}

	public void info(String message) {
		DateFormat dateFormat = Reference.DATE_FORMAT;
		text.append("[" + dateFormat.format(new Date()) + "] " + message
				+ " \n");
		validate();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}
}
