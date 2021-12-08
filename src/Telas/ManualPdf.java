package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ManualPdf {

	private JFrame frmManualFiklinda;

	
	public ManualPdf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManualFiklinda = new JFrame();
		frmManualFiklinda.setTitle("Manual FikLinda");
		frmManualFiklinda.getContentPane().setBackground(SystemColor.textHighlight);
		frmManualFiklinda.setBounds(100, 100, 450, 300);
		frmManualFiklinda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManualFiklinda.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Abrir Manual PDF");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "E:\\2-FATEC\\3-Engenharia-de-Software-Bruno\\FikLindaManualUsuario.pdf");
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Verifique se o seu arquivo existe");
			
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(10, 11, 414, 239);
		frmManualFiklinda.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
