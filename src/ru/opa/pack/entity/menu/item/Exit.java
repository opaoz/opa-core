package ru.opa.pack.entity.menu.item;

import java.awt.MenuItem;

import ru.opa.pack.api.menu.MenuItems;
import ru.opa.pack.entity.menu.TrayMenu;

public class Exit extends MenuItem implements MenuItems {
	private static final long serialVersionUID = 5690781598317859805L;

	public Exit() {
		super("Exit");
	}

	@Override
	public void action(TrayMenu menu) {
		System.exit(0);
	}
}
