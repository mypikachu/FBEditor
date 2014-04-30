package de.FBEditor;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

class EditMenuListener implements MenuListener {

	public EditMenuListener(FBEdit fbedit) {
		this.fbedit = fbedit;
	}

        @Override
	public void menuSelected(MenuEvent e) {
		fbedit.updateMenu(fbedit.getMenu());
	}

        @Override
	public void menuCanceled(MenuEvent menuevent) {
	}

        @Override
	public void menuDeselected(MenuEvent menuevent) {
	}

	private final FBEdit fbedit;
}
