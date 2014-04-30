package de.FBEditor.utils;

import de.FBEditor.CutAndPastePopup;
import de.FBEditor.FBEdit;
import de.FBEditor.FindReplace;
import de.FBEditor.struct.JTextPane2;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPopupMenu;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public class Listener {

	public static void addKeyListener(final FBEdit fbedit) {
		final JTextPane2 pane2 = fbedit.getJTextPane();
		
		pane2.addKeyListener(new KeyListener() {

                        @Override
			public void keyTyped(KeyEvent keyevent) {
			}

                        @Override
			public void keyPressed(KeyEvent keyevent) {
			}

                        @Override
			public void keyReleased(KeyEvent arg0) {
				FindReplace findReplace = fbedit.getFindReplace();
				int key = arg0.getKeyCode();

				/* Insert Mode */
				if (key == 155) {
					fbedit.toggleInsertMode();
					fbedit.selectCaret(pane2);
				}

				/* F3 - Weitersuchen */
				if (key == KeyEvent.VK_F3) {
					if (findReplace != null)
						findReplace.searchon();
				}
			}
		});
	}

	public static void addWinListener(final FBEdit fbedit) {
		fbedit.addWindowListener(new WindowListener() {

                        @Override
			public void windowOpened(WindowEvent windowevent) {
			}

                        @Override
			public void windowClosing(WindowEvent e) {
				fbedit.exit();
			}

                        @Override
			public void windowClosed(WindowEvent windowevent) {
			}

                        @Override
			public void windowIconified(WindowEvent windowevent) {
			}

                        @Override
			public void windowDeiconified(WindowEvent windowevent) {
			}

                        @Override
			public void windowActivated(WindowEvent windowevent) {
			}

                        @Override
			public void windowDeactivated(WindowEvent windowevent) {
			}
		});
	}

	public static DocumentListener myDocumentListener(final FBEdit fbedit) {
		DocumentListener myDocumentListener = new DocumentListener() {

                        @Override
			public void insertUpdate(DocumentEvent aEvent) {
				fbedit.updateMenu(fbedit.getMenu());
			}

                        @Override
			public void removeUpdate(DocumentEvent documentevent) {
			}

                        @Override
			public void changedUpdate(DocumentEvent aEvent) {
				fbedit.updateMenu(fbedit.getMenu());
			}
		};

		return myDocumentListener;
	}
	
	public static void addMouseListener(final FBEdit fbedit, final CutAndPastePopup cutAndPastePopup, final JPopupMenu popup ) {
	
	fbedit.getJTextPane().addMouseListener(new MouseAdapter() {

                @Override
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				cutAndPastePopup.updateSource((JTextComponent) e.getSource());
				cutAndPastePopup.updateMenu();
				popup.show((Component) e.getSource(), e.getX(), e.getY());
			}
		}

                @Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				cutAndPastePopup.updateSource((JTextComponent) e.getSource());
				cutAndPastePopup.updateMenu();
				popup.show((Component) e.getSource(), e.getX(), e.getY());
			}
		}
	});
	}
}
