/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.wits.elen7046.surveyapplication.gui;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author f3418944
 */
public class CheckBoxList extends JList<JCheckBox>{
    
    private static final long serialVersionUID = 1L;
	private ListCellRenderer<JCheckBox> listCellRenderer = new ListCellRenderer<JCheckBox>() {
		
		@Override
		public Component getListCellRendererComponent(
				JList<? extends JCheckBox> parent, JCheckBox checkBox, int index,
				        boolean isSelected, boolean cellHasFocus) {
			checkBox.setBackground(isSelected ? getSelectionBackground() : getBackground());
			checkBox.setForeground(isSelected ? getSelectionForeground() : getForeground());
			checkBox.setEnabled(isEnabled());
			checkBox.setFont(getFont());
			checkBox.setFocusPainted(false);
			checkBox.setBorderPainted(true);
			checkBox.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : new EmptyBorder(1, 1, 1, 1));
            return checkBox;
		}
	}; 
	
	private MouseAdapter mouseAdapter = new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
            int index = locationToIndex(e.getPoint());
            
            if (index != -1) {
                JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
                checkbox.setSelected(!checkbox.isSelected());
                repaint();
            }
        }
	};
	
    public CheckBoxList() {
        setCellRenderer(listCellRenderer);
        addMouseListener(mouseAdapter);
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
}
