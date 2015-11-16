package ru.opa.pack.entity.menu.actions;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ru.opa.pack.entity.menu.TrayMenu;

public class ChangeIcon implements MouseListener {
	private Image image;
	private TrayMenu menu;

	public ChangeIcon(TrayMenu menu, Image image) {
		this.image = image;
		this.menu = menu;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			menu.replaceTrayIcon(image);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
