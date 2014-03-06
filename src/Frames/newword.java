package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.JComboBox;

import controllers.*;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.ObjectInputStream.GetField;
import java.text.AttributedString;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit.ItalicAction;
import javax.swing.text.html.HTML;
import javax.swing.text.rtf.RTFEditorKit;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JPanel;

import java.awt.Rectangle;
import java.awt.FlowLayout;

import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class newword {

	private JFrame frmAddNewWord;
	
	private static newword _newword;
	private JTextField txtword;
	
	private ImageIcon subscript_icon;
	private ImageIcon superscript_icon;
	private ImageIcon italic_icon;
	private ImageIcon bold_icon;
	
	private ImageIcon btn_close;
	private ImageIcon btn_closeRolovr;
	private ImageIcon btn_minimize;
	private ImageIcon btn_minimizerolover;
	private ImageIcon btn_yes;
	private ImageIcon btn_no;
	private ImageIcon btn_yes_rol;
	private ImageIcon btn_no_rol;
	
	public static newword instance(){
		
		if(_newword==null)
			
			_newword=new newword();
			
			return _newword;
		
	}
	
	public void run() {
		try {
			newword window = new newword();
			window.frmAddNewWord.setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * Create the application.
	 */
	public newword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddNewWord = new JFrame();
		frmAddNewWord.setIconImage(Toolkit.getDefaultToolkit().getImage(newword.class.getResource("/images/favicon copy.png")));
		frmAddNewWord.setResizable(false);
		frmAddNewWord.setFont(new Font("Bitstream Charter", Font.PLAIN, 12));
		frmAddNewWord.setTitle("Add New Word");
		frmAddNewWord.setBounds(400, 300, 672, 387);
		frmAddNewWord.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddNewWord.setUndecorated(true);
		JLayeredPane desktopPane = new JLayeredPane();
		desktopPane.setBackground(new Color(212, 243, 246));
		frmAddNewWord.getContentPane().add(desktopPane, BorderLayout.CENTER);
		//-------------------------------------UI Customization Here--------------------------------------------
		Panel panel = new Panel();
		panel.setBounds(new Rectangle(100, -77, 100, 30));
		panel.setBackground(new Color(0, 153, 204));
		frmAddNewWord.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		
		JButton btnminimize = new JButton("");
		btnminimize.setBorder(null);
		
		btnminimize.setBounds(580, 0, 40, 20);
		btn_minimize=new ImageIcon(mainform.class.getResource("/images/minimize.png"));
		btn_minimizerolover=new ImageIcon(mainform.class.getResource("/images/minimize_rolover.png"));
		panel.setLayout(null);
		btnminimize.setIcon(btn_minimize);
		btnminimize.setRolloverIcon(btn_minimizerolover);
		btnminimize.setPreferredSize(new Dimension(btn_minimize.getIconWidth(),btn_minimize.getIconHeight()));
		btnminimize.setBorderPainted(false);
		btnminimize.setFocusCycleRoot(false);
	btnminimize.setBorderPainted(true);
		//panel.add(btnminimize);
		
		
		
		JButton btnstop = new JButton("");
		btnstop.setBorder(null);
		btnstop.setBounds(620, 0, 40, 20);
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
		
		JLabel lblNewLabel = new JLabel("Add New Word");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 5, 125, 20);
		panel.add(lblNewLabel);
		
		//--------------------------UI Customization ENDS Here--------------------------------------------
		
		
		
		//Binding List of Word in forminitialization
		String[] TableList={"Select Start Character","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		
		
		
		JComboBox cbotypelst = new JComboBox();
		cbotypelst.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		cbotypelst.setBackground(new Color(238, 238, 238));
		cbotypelst.setBounds(131, 63, 187, 24);
		desktopPane.add(cbotypelst);
		
		String[] typelist={"Please Select Type","abbrev","prefix","suffix","n","v","adj","adv","prep","pron","conj","intj"};
		cbotypelst.setModel(new JComboBox(typelist).getModel());
		
		JLabel lblStarttxt = new JLabel("Beginning Word");
		lblStarttxt.setDisplayedMnemonic('W');
		lblStarttxt.setBounds(12, 31, 126, 15);
		desktopPane.add(lblStarttxt);
		
		JLabel lbltype = new JLabel("Word Type");
		lbltype.setLabelFor(cbotypelst);
		lbltype.setDisplayedMnemonic('T');
		lbltype.setToolTipText("Word Type(Eg. n,v,adj,..,etc)");
		lbltype.setBounds(12, 68, 126, 15);
		desktopPane.add(lbltype);
		
		JButton btnadd = new JButton("");
		btnadd.setBackground(Color.WHITE);
		btnadd.setOpaque(false);
		btnadd.setBorder(null);
		btnadd.setToolTipText("Add(Alt+A)");
		btn_yes=new ImageIcon(newword.class.getResource("/images/yes.png"));
		btn_yes_rol=new ImageIcon(newword.class.getResource("/images/yes_rol.png"));
		btnadd.setIcon(btn_yes);
		btnadd.setRolloverIcon(btn_yes_rol);
		btnadd.setMnemonic('A');
		btnadd.setBounds(131, 263, btn_yes.getIconWidth(), btn_yes.getIconHeight());
		desktopPane.add(btnadd);
		
		JButton btncancel = new JButton("");
		btncancel.setBackground(Color.WHITE);
		btncancel.setOpaque(false);
		btncancel.setBorder(null);
		btncancel.setToolTipText("Cancel(Alt+C)");
		btn_no=new ImageIcon(newword.class.getResource("/images/no.png"));
		btn_no_rol=new ImageIcon(newword.class.getResource("/images/no_rol.png"));
		btncancel.setIcon(btn_no);
		btncancel.setRolloverIcon(btn_no_rol);
		btncancel.setMnemonic('C');
		btncancel.setBounds(230, 263, btn_no.getIconWidth(), btn_no.getIconHeight());
		desktopPane.add(btncancel);
		
		JScrollPane jscroll=new JScrollPane();
		jscroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JEditorPane txtdesc = new JTextPane();
		txtdesc.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtdesc.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtdesc.setBounds(131, 129, 520, 122);	
		
		
		jscroll.setBounds(131, 129, 520, 122);
		jscroll.setViewportView(txtdesc);
		desktopPane.add(jscroll);
		txtword = new JTextField();
		
		
		txtword.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblStarttxt.setLabelFor(txtword);
		txtword.setBounds(131, 27, 187, 24);
		desktopPane.add(txtword);
		txtword.setColumns(10);
		subscript_icon=new ImageIcon(newword.class.getResource("/images/subicon.png"));
		superscript_icon=new ImageIcon(newword.class.getResource("/images/sup_icon.png"));
		
		
		
		
		JButton btnsubscript = new JButton("");
		btnsubscript.setBounds(169, 95, 22, 22);
		desktopPane.add(btnsubscript);
		btnsubscript.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnsubscript.setToolTipText("Make Sub Script(Alt+S)");
		btnsubscript.setMnemonic('s');
		btnsubscript.setIcon(subscript_icon);
		
		
		
		JButton btnBtnsuperscript = new JButton("");
		
		btnBtnsuperscript.setToolTipText("Make Super Script(Alt+D)");
		btnBtnsuperscript.setMnemonic('d');
		btnBtnsuperscript.setBounds(141, 95, 22, 22);
		desktopPane.add(btnBtnsuperscript);
		btnBtnsuperscript.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		btnBtnsuperscript.setIcon(superscript_icon);
		
		
		
		
		JLabel lbldesc = new JLabel("Description");
		lbldesc.setDisplayedMnemonic('p');
		lbldesc.setLabelFor(txtdesc);
		lbldesc.setBounds(12, 138, 101, 15);
		desktopPane.add(lbldesc);
		
		JButton btnbold = new JButton("");
		btnbold.setToolTipText("Bold(Alt+b)");
		btnbold.setMnemonic('b');
		bold_icon=new ImageIcon(newword.class.getResource("/images/bold_icon.png"));
		btnbold.setBounds(213, 95, bold_icon.getIconWidth()+2, bold_icon.getIconHeight()+2);
		btnbold.setIcon(bold_icon);
		desktopPane.add(btnbold);
		
		JButton btnitalic = new JButton("");
		btnitalic.setToolTipText("Italic(Alt+i)");
		btnitalic.setMnemonic('i');
		italic_icon=new ImageIcon(newword.class.getResource("/images/italic_icon.png"));
		btnitalic.setBounds(235, 95, bold_icon.getIconWidth()+2, bold_icon.getIconHeight()+2);
		btnitalic.setIcon(italic_icon);
		desktopPane.add(btnitalic);
		
		JLabel lblbackground = new JLabel("New label");
		lblbackground.setBorder(new LineBorder(Color.LIGHT_GRAY, 5, true));
		lblbackground.setIcon(new ImageIcon(newword.class.getResource("/images/background.png")));
		lblbackground.setBounds(0, -33, 671, 388);
		desktopPane.add(lblbackground);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(newword.class.getResource("/images/topbar.png")));
		lblNewLabel_1.setBounds(0, 0, 672, 30);
		panel.add(lblNewLabel_1);
		
		
		newwordcontroller newwordcontrol=new newwordcontroller(frmAddNewWord,btnbold,btnitalic,btnstop,panel,txtword,btnsubscript,btnBtnsuperscript,cbotypelst, txtdesc, btnadd, btncancel);
		
		btnstop.addActionListener(newwordcontrol);
		btnBtnsuperscript.addActionListener(newwordcontrol);
		btnsubscript.addActionListener(newwordcontrol);
		btnadd.addActionListener(newwordcontrol);
		btncancel.addActionListener(newwordcontrol);
		btnbold.addActionListener(newwordcontrol);
		btnitalic.addActionListener(newwordcontrol);
		panel.addMouseMotionListener(newwordcontrol);
		panel.addMouseListener(newwordcontrol);
		
		
	}
}
