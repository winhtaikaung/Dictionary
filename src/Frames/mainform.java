package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JOptionPane;

import javax.swing.JButton;

import controllers.*;
import images.*;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Panel;

import net.miginfocom.swing.MigLayout;

import java.awt.Button;
import java.util.Dictionary;

import javax.swing.SwingConstants;

import java.awt.ComponentOrientation;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;/*implementing Controllers*/



public class mainform {

	private static JFrame frmOpenGeoDictionary;

	/**
	 * Launch the application.
	 */
	private static mainform _test;
	private JTextField txtsearch;
	
	private ImageIcon btn_close;
	private ImageIcon btn_closeRolovr;
	private ImageIcon btn_minimize;
	private ImageIcon btn_minimizerolover;
	private ImageIcon btn_previcon;
	private ImageIcon btn_previconrol;
	private ImageIcon btn_edit;
	private ImageIcon btn_edit_rol;
	private ImageIcon btn_del;
	private ImageIcon btn_del_rol;
	
	private ImageIcon btn_nexicon;
	private ImageIcon btn_nexiconrol;
	
	
	public static mainform instance() {
		if (_test == null)
			_test = new mainform();
		return _test;
	}

	
	public void run() {
		try {
			mainform window = new mainform();
			window.frmOpenGeoDictionary.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Create the application.
	 */
	public mainform() {
		initialize();
		
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmOpenGeoDictionary = new JFrame();
		frmOpenGeoDictionary.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frmOpenGeoDictionary.setBackground(Color.LIGHT_GRAY);
		frmOpenGeoDictionary.setForeground(new Color(0, 0, 0));
		frmOpenGeoDictionary.setIconImage(Toolkit.getDefaultToolkit().getImage(mainform.class.getResource("/images/favicon copy.png")));
		frmOpenGeoDictionary.setFont(new Font("Bitstream Charter", Font.PLAIN, 12));
		frmOpenGeoDictionary.setTitle("Open Geo Dictionary");
		frmOpenGeoDictionary.setBounds(100, 100, 1030, 521);
		frmOpenGeoDictionary.setUndecorated(true);
		//frmOpenGeoDictionary.setDefaultLookAndFeelDecorated(true);
		
		frmOpenGeoDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		panel.setBounds(new Rectangle(100, -77, 100, 30));
		panel.setBackground(new Color(0, 153, 204));
		panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		frmOpenGeoDictionary.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		/*testing here*/
		
		JButton btnminimize = new JButton("");
		btnminimize.setBorder(null);
		
		btnminimize.setBounds(935, 0, 40, 20);
		btn_minimize=new ImageIcon(mainform.class.getResource("/images/minimize.png"));
		btn_minimizerolover=new ImageIcon(mainform.class.getResource("/images/minimize_rolover.png"));
		panel.setLayout(null);
		btnminimize.setIcon(btn_minimize);
		btnminimize.setRolloverIcon(btn_minimizerolover);
		btnminimize.setPreferredSize(new Dimension(btn_minimize.getIconWidth(),btn_minimize.getIconHeight()));
		btnminimize.setBorderPainted(false);
		btnminimize.setFocusCycleRoot(false);
	btnminimize.setBorderPainted(true);
		panel.add(btnminimize);
		
		
		
		JButton btnstop = new JButton("");
		btnstop.setBorder(null);
		btnstop.setBounds(975, 0, 40, 20);
		btn_close=new ImageIcon(mainform.class.getResource("/images/close_btn.png"));
		btn_closeRolovr=new ImageIcon(mainform.class.getResource("/images/close_rol.png"));
		panel.setLayout(null);
		btnstop.setIcon(btn_close);
		btnstop.setRolloverIcon(btn_closeRolovr);
		btnstop.setPreferredSize(new Dimension(btn_minimize.getIconWidth(),btn_minimize.getIconHeight()));
		
		btnstop.setBorderPainted(false);
		btnstop.setFocusCycleRoot(false);
		btnstop.setBorderPainted(true);
		panel.add(btnstop);
		
		
		
		
		
		
		
		
		
		
		JLayeredPane desktopPane = new JLayeredPane();
		desktopPane.setBackground(new Color(212, 243, 246));
		
		frmOpenGeoDictionary.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		
		
		
		txtsearch = new JTextField();
		txtsearch.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		
		
		txtsearch.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtsearch.setBounds(10, 32, 300, 40);
		txtsearch.setToolTipText("Enter Words Here");
		txtsearch.selectAll();
		
		desktopPane.add(txtsearch);
		txtsearch.setColumns(10);
		
		//This part is Binding Button events 
		
		
		
		
		
		
		
		
		
		JScrollPane jscroll=new JScrollPane();
		jscroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JList lstword = new JList();
		
		
		
		lstword.setFont(new Font("Dialog", Font.PLAIN, 17));
		lstword.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstword.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lstword.setBackground(Color.WHITE);
		lstword.setVisibleRowCount(10);
		lstword.setBounds(10, 76, 240, 408);
		lstword.scrollRectToVisible(new Rectangle(240, 288));
		lstword.setAutoscrolls(true);
		//JScrollPane jb=new JScrollPane(lstword,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//desktopPane.add(jb);
		jscroll.setBounds(10, 76, 240, 408);
		jscroll.setViewportView(lstword);
		
		
		desktopPane.add(jscroll);
		
		
		
		JScrollPane contentscroll=new JScrollPane();
		
		contentscroll.setBorder(null);
		jscroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JTextPane txtcontent = new JTextPane();		
		txtcontent.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtcontent.setContentType("text/html");		
		txtcontent.setEditable(false);		
		desktopPane.setLayer(txtcontent, 0);
		txtcontent.setBounds(262, 170, 748, 313);
		
		contentscroll.setBounds(262, 170, 745, 313);
		
		contentscroll.setViewportView(txtcontent);
		desktopPane.add(contentscroll);
		
		JTextPane txtword = new JTextPane();
		txtword.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		txtword.setEditable(false);
		txtword.setFont(new Font("Bitstream Charter", Font.BOLD, 21));
		txtword.setBounds(262, 78, 745, 53);
		desktopPane.add(txtword);
		
		JTextPane txttype = new JTextPane();
		txttype.setEditable(false);
		txttype.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		txttype.setForeground(Color.RED);
		txttype.setFont(new Font("Dialog", Font.BOLD, 20));
		txttype.setBounds(262, 130, 745, 40);
		desktopPane.add(txttype);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1030, 30);
		desktopPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmExit.setMnemonic('x');
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnEdit.setMnemonic('t');
		//menuBar.add(mnEdit);
		
		JMenuItem mntmneword = new JMenuItem("Add New Word  ");
		mntmneword.setFont(new Font("Dialog", Font.PLAIN, 14));
		mntmneword.setMnemonic('a');
		mntmneword.setSize(new Dimension(0, 30));
		//----------------Binding key Strokes
		
		KeyStroke control=KeyStroke.getKeyStroke("control N");
		
		mntmneword.setAccelerator(control);
		//--------------------------------------------
		mnEdit.add(mntmneword);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About      ");
		mntmAbout.setFont(new Font("Dialog", Font.PLAIN, 14));
		mnHelp.add(mntmAbout);
		
		KeyStroke f1=KeyStroke.getKeyStroke("F1");
		mntmAbout.setAccelerator(f1);
		
		JButton btnprev = new JButton("");
		btnprev.setBorder(null);
		btnprev.setBackground(Color.WHITE);
		btnprev.setOpaque(false);
		btnprev.setToolTipText("Previous");
		
		btn_previcon=new ImageIcon(mainform.class.getResource("/images/previcon.png"));
		btn_previconrol=new ImageIcon(mainform.class.getResource("/images/previcon_rol.png"));
		btnprev.setBounds(322, 32, btn_previcon.getIconWidth(), btn_previcon.getIconHeight());
		btnprev.setIcon(btn_previcon);
		btnprev.setRolloverIcon(new ImageIcon(mainform.class.getResource("/images/previcon_rol.png")));
		
		desktopPane.add(btnprev);
		
		JButton btnnex = new JButton("");
		btnnex.setBorder(null);
		btnnex.setOpaque(false);
		btnnex.setBackground(Color.WHITE);
		btnnex.setToolTipText("Next");
		btn_nexicon=new ImageIcon(mainform.class.getResource("/images/nexicon.png"));
		btn_nexiconrol=new ImageIcon(mainform.class.getResource("/images/nexicon_rol.png"));
		btnnex.setBounds(365, 32, btn_nexicon.getIconWidth(), btn_nexicon.getIconHeight());
		btnnex.setIcon(btn_nexicon);
		btnnex.setRolloverIcon(new ImageIcon(mainform.class.getResource("/images/nexicon_rol.png")));
		desktopPane.add(btnnex);
		
		JButton btn_editword = new JButton("");
		btn_editword.setMnemonic('e');
		btn_editword.setToolTipText("Edit Text(Alt+E)");
		btn_editword.setBorder(null);
		btn_editword.setOpaque(false);
		btn_editword.setBackground(Color.white);
		btn_edit=new ImageIcon(mainform.class.getResource("/images/edit-icon.png"));
		btn_edit_rol=new ImageIcon(mainform.class.getResource("/images/edit-icon_rolover.png"));
		
		
		btn_editword.setIcon(btn_edit);
		btn_editword.setRolloverIcon(btn_edit_rol);
		btn_editword.setVisible(false);
		btn_editword.setBounds(930, 32, btn_edit.getIconWidth(),btn_edit.getIconHeight());
		
		
		//desktopPane.add(btn_editword);
		
		JButton btndel = new JButton("");
		btndel.setMnemonic('d');
		btndel.setToolTipText("Delete(Alt+D)");
		btndel.setOpaque(false);
		btndel.setBackground(Color.white);
		btndel.setBorder(null);
		btn_del=new ImageIcon(mainform.class.getResource("/images/trash_bin.png"));
		btn_del_rol=new ImageIcon(mainform.class.getResource("/images/trash_bin_rolover.png"));
		
		btndel.setIcon(btn_del);
		btndel.setRolloverIcon(btn_del_rol);
		btndel.setVisible(false);
		btndel.setBounds(967, 32, btn_del.getIconWidth(), btn_del.getIconHeight());
		//desktopPane.add(btndel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new LineBorder(new Color(192, 192, 192), 5, true));
		lblNewLabel_1.setIcon(new ImageIcon(mainform.class.getResource("/images/background.png")));
		lblNewLabel_1.setBounds(0, -30, 1030, 521);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("24 hr Geological Dictionary");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 5, 215, 20);
		panel.add(lblNewLabel);
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new ImageIcon(mainform.class.getResource("/images/topbar.png")));
		lblbackground.setBounds(0, 0, 1030, 30);
		panel.add(lblbackground);
		

		JMenuItem mnulink = new JMenuItem("Link to db");
		mnEdit.add(mnulink);
		
		maincontroller _maincontoll=new maincontroller(frmOpenGeoDictionary,panel, txtsearch,lstword,txtcontent,txtword,txttype,mntmAbout,mnulink,mntmneword,mntmExit,btnstop,btnminimize,btnprev,btnnex,btn_editword,btndel);
		
		
		
		mntmAbout.addActionListener(_maincontoll);
		mntmneword.addActionListener(_maincontoll);
		lstword.addListSelectionListener(_maincontoll);
		panel.addMouseMotionListener(_maincontoll);
		panel.addMouseListener(_maincontoll);
		btnstop.addActionListener(_maincontoll);
		btnprev.addActionListener(_maincontoll);
		btnnex.addActionListener(_maincontoll);
		btn_editword.addActionListener(_maincontoll);
		mnulink.addActionListener(_maincontoll);
		mntmExit.addActionListener(_maincontoll);
		
		btnminimize.addActionListener(_maincontoll);
		btndel.addActionListener(_maincontoll);
		txtsearch.getDocument().addDocumentListener(_maincontoll);
		frmOpenGeoDictionary.addKeyListener(_maincontoll);
		
		
		
	}
}
