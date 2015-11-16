package ru.opa.pack.entity.menu.item;

import java.awt.Desktop;
import java.awt.MenuItem;
import java.io.File;
import java.io.IOException;

import ru.opa.pack.api.menu.MenuItems;
import ru.opa.pack.entity.menu.TrayMenu;

public class OpenFolder extends MenuItem implements MenuItems {
	private static final long serialVersionUID = 1032807463445349417L;
	private String path;

	public OpenFolder(String title, String path) {
		super(title);
		this.path = path;
	}

	@Override
	public void action(TrayMenu menu) {
		try {
			System.out.println(path);
			Desktop.getDesktop().open(new File(path));
		} catch (IOException e) {
			return;
		}
	}

	public void setPath(String newPath) {
		path = newPath;
	}

}
