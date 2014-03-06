package Frames;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;

public class Splash {

	private JWindow frame;

	/**
	 * Launch the application.
	 */
	private static Splash _splash;
	
	private ImageIcon splash_icon;
	
	public static Splash instance() {
		if (_splash == null)
			_splash = new Splash();
		return _splash;
	}
	
	public void run() {
		try {
			Splash window = new Splash();
			window.frame.setVisible(true);
			Thread.sleep(5000);
			window.frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the application.
	 */
	public Splash() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		splash_icon=new ImageIcon(Splash.class.getResource("/images/splashlogo.jpg"));
		frame = new JWindow();
		//frame.setResizable(false);
		frame.setBounds(100, 100, 602, 595);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		//frame.setUndecorated(true);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Splash.class.getResource("/images/splashlogo.jpg")));
		lblNewLabel.setBounds(0, -7, 600, 605);
		desktopPane.add(lblNewLabel);
		
	}
}
