package ru.opa.pack.ui.components;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class FileChooser extends JPanel implements ActionListener {
	private static final long serialVersionUID = 4416309433345507903L;
	private JButton fileOpen;
	private JLabel fileName;
	private JFileChooser fileChooser;
	private File file;

	/*
	 * new FileNameExtensionFilter( "Text file (.txt)", "txt");
	 */
	public FileChooser(String text, String defaultPath, int option,
			FileFilter filter) {
		if (option < 0 && option > 3)
			option = 0;
		fileOpen = new JButton("Открыть");
		fileOpen.addActionListener(this);

		fileName = new JLabel(text);

		fileChooser = new JFileChooser(defaultPath);

		if (filter != null) {
			FileFilter filteFilter = filter;
			fileChooser.setFileFilter(filteFilter);
		}

		fileChooser.setFileSelectionMode(option);

		this.setLayout(new FlowLayout());
		this.add(fileName);
		this.add(fileOpen);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			fileName.setText(file.getAbsolutePath());
		}
	}

	public boolean isSelected() {
		if (file == null)
			return false;
		return true;
	}

	public File getFile() {
		return file;
	}

}
