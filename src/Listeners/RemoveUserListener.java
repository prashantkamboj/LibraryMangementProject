package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import MainPacakge.RemoveUserPanel;
public class RemoveUserListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		RemoveUserPanel rmu = new RemoveUserPanel();
		rmu.setSize(450, 300);
		rmu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		rmu.setVisible(true);
	}

}
