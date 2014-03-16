package Frames;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.JTextPane;

import controllers.*;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class aboutform {

	private JFrame frmAbout;
	private ImageIcon btn_close;
	private ImageIcon btn_closeRolovr;
	/**
	 * Launch the application.
	 */
	
	private static aboutform _abtform;
	
	public static aboutform instance() {
		if (_abtform == null)
			_abtform = new aboutform();
		return _abtform;
	}
	public void run() {
		try {
			aboutform window = new aboutform();
			window.frmAbout.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public aboutform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbout = new JFrame();
		frmAbout.setIconImage(Toolkit.getDefaultToolkit().getImage(aboutform.class.getResource("/images/favicon copy.png")));
		frmAbout.setResizable(false);
		frmAbout.setBounds(new Rectangle(100, 27, 0, 0));
		frmAbout.setTitle("About");
		frmAbout.setBounds(100, 100, 520, 369);
		frmAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLayeredPane desktopPane = new JLayeredPane();
		desktopPane.setBackground(SystemColor.control);
		frmAbout.getContentPane().add(desktopPane, BorderLayout.CENTER);
		frmAbout.setUndecorated(true);
		
		Panel panel = new Panel();
		panel.setBounds(new Rectangle(100, -77, 100, 30));
		panel.setBackground(new Color(0, 153, 204));
		frmAbout.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnstop = new JButton("");
		btnstop.setBorder(null);
		btnstop.setBounds(465, 0, 40, 20);
		btn_close=new ImageIcon(mainform.class.getResource("/images/close_btn.png"));
		btn_closeRolovr=new ImageIcon(mainform.class.getResource("/images/close_rol.png"));
		panel.setLayout(null);
		btnstop.setIcon(btn_close);
		btnstop.setRolloverIcon(btn_closeRolovr);
		btnstop.setPreferredSize(new Dimension(btn_close.getIconWidth(),btn_close.getIconHeight()));
		
		btnstop.setBorderPainted(false);
		btnstop.setFocusCycleRoot(false);
		btnstop.setBorderPainted(true);
		panel.add(btnstop);
		
		JLabel lblNewLabel = new JLabel("About Us");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 5, 112, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(newword.class.getResource("/images/topbar.png")));
		lblNewLabel_1.setBounds(0, 0, 520, 30);
		panel.add(lblNewLabel_1);
		
		
		
		
		JButton btnepic = new JButton("");
		btnepic.setBackground(Color.WHITE);
		btnepic.setIcon(new ImageIcon(aboutform.class.getResource("/images/logo64x64.png")));
		btnepic.setBounds(22, 12, 64, 64);
		btnepic.setBorder(null);
		desktopPane.add(btnepic);
		
		JScrollPane jscrol=new JScrollPane();
		JTextPane txtabout = new JTextPane();
		txtabout.setText("This Software is dedicated to all geologist around the world.\n\nThis Product is  under GNU/GPL License \n\nSpecial thanks to Khin Zaw Hein, Chit Sum Maung, Phyo Han Htet, Chit Myo Lwin who help us in DataEntry.\n\n If You find any bugs please Let me know!\nContact khinzawhein24@gmail.com\nWant to get source! Please Visit Here https://github.com/winhtaikaung/Dictionary/ ");
		txtabout.setEditable(false);
		txtabout.setBounds(126, 64, 258, 156);
		//desktopPane.add(txtabout);
		
		jscrol.setBounds(126, 64, 258, 156);
		jscrol.setViewportView(txtabout);
		
		desktopPane.add(jscrol);
		
		
		
		
		JButton btnhref = new JButton();
		btnhref.setBorder(new CompoundBorder(null, UIManager.getBorder("EditorPane.border")));
		btnhref.setOpaque(false);
		btnhref.setEnabled(false);
		btnhref.setBackground(Color.WHITE);
		btnhref.setIconTextGap(5);
		btnhref.setBounds(121, 302, 230, 25);
		
		btnhref.setText("<HTML><a href=\"http://www.epicmyanmar.com\">www.epicmyanmar.com</a></HTML>");
		desktopPane.add(btnhref);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(aboutform.class.getResource("/images/24Hour Logo64_64.jpg")));
		lblNewLabel_2.setBounds(431, 12, 64, 64);
		desktopPane.add(lblNewLabel_2);
		
		aboutcontroller abtcontroll=new aboutcontroller(frmAbout,btnepic,btnstop,panel,btnhref);
		
		JTextPane animatemarque = new JTextPane();
		animatemarque.setBackground(Color.BLACK);
		animatemarque.setContentType("text/html");
		animatemarque.setEditable(false);
		animatemarque.setText("<html><marquee behavior='alternate'><span style='backgound-color:black;color:green;' >Android Application will available soon </span></marquee></html>");
		animatemarque.setBounds(102, 280, 277, 21);
		desktopPane.add(animatemarque);
		
		
		btnhref.addActionListener(abtcontroll);
		btnepic.addActionListener(abtcontroll);
		btnstop.addActionListener(abtcontroll);
		panel.addMouseListener(abtcontroll);
		panel.addMouseMotionListener(abtcontroll);
	}
}
