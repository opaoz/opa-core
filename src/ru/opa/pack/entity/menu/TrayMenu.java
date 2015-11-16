package ru.opa.pack.entity.menu;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import ru.opa.pack.api.menu.MenuItems;

public class TrayMenu implements ActionListener {
	private PopupMenu popup;
	private TrayIcon trayIcon;

	/*
	 * Example:
	 * 
	 * <blockquote>Image first = Toolkit.getDefaultToolkit()
	 * .getImage("D:/test/damage.png");
	 * 
	 * TrayMenu t = new TrayMenu("Tуst", first); t.addMenuItem(new Exit());
	 * t.addMouseListener(new ChangeIcon(t, Toolkit.getDefaultToolkit()
	 * .getImage("D:/test/melon.png"))); t.setToolTip("Вот так вот");
	 * </blockquote>
	 */
	public TrayMenu(String name, Image image) {
		popup = new PopupMenu();
		trayIcon = new TrayIcon(image, name, popup);
		trayIcon.setImageAutoSize(true);

		trayIcon.addActionListener(this);
		addTrayToSystem(trayIcon);
	}

	public TrayIcon getTrayIcon() {
		return trayIcon;
	}

	public void replaceTrayIcon(Image image) {
		trayIcon.setImage(image);
	}

	public void setToolTip(String tooltip) {
		trayIcon.setToolTip(tooltip);
	}

	public PopupMenu getPopup() {
		return popup;
	}

	public void addTrayToSystem(TrayIcon trayIcon) {
		SystemTray systemTray = SystemTray.getSystemTray();

		try {
			systemTray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("Tray icon error");
		}
	}

	public void addMenuItem(MenuItem item) {
		popup.add(item);
		item.addActionListener(this);
	}

	public void addMouseListener(MouseListener action) {
		trayIcon.addMouseListener(action);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof MenuItems)
			((MenuItems) e.getSource()).action(this);
	}

}
