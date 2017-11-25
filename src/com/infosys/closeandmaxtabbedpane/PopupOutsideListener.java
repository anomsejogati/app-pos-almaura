package com.infosys.closeandmaxtabbedpane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class PopupOutsideListener extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            popupOutsideOperation(e);
        }
        public void mouseReleased(MouseEvent e) {
            popupOutsideOperation(e);
        }
	void popupOutsideOperation(MouseEvent e){
            if (e.isPopupTrigger()) {
           System.out.println("okloh");
            }
        }
}
