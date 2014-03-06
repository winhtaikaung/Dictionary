package Frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import entity.Word;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controllers.editwordcontroller;
import controllers.newwordcontroller;

import java.awt.BorderLayout;

public class Editword {

	private JFrame frmeditword;
	private static Editword _Editword;
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

	/**
	 * Launch the application.
	 */
public static Editword instance(Word w){
		
		if(_Editword==null)
			
			_Editword=new Editword(w);
			
			return _Editword;
		
	}
	
	
	public void run(Word w) {
		try {
			Editword window = new Editword(w);
			window.frmeditword.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Editword(Word w) {
		initialize(w);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Word w) {
		frmeditword = new JFrame();
		frmeditword.setIconImage(Toolkit.getDefaultToolkit().getImage(newword.class.getResource("/images/favicon copy.png")));
		frmeditword.setResizable(false);
		frmeditword.setFont(new Font("Bitstream Charter", Font.PLAIN, 12));
		frmeditword.setTitle("Edit Word");
		frmeditword.setBounds(400, 300, 672, 387);
		frmeditword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmeditword.setUndecorated(true);
		JLayeredPane desktopPane = new JLayeredPane();
		desktopPane.setBackground(new Color(212, 243, 246));
		frmeditword.getContentPane().add(desktopPane, BorderLayout.CENTER);
		//-------------------------------------UI Customization Here--------------------------------------------
		Panel panel = new Panel();
		panel.setBounds(new Rectangle(100, -77, 100, 30));
		panel.setBackground(new Color(0, 153, 204));
		frmeditword.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		
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
		
		JLabel lblNewLabel = new JLabel("Edit Word");
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
		cbotypelst.setSelectedItem(w.getWtype());//make auto selected word Type
		
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
		txtdesc.setText(w.getDesc());
		
		
		jscroll.setBounds(131, 129, 520, 122);
		jscroll.setViewportView(txtdesc);
		desktopPane.add(jscroll);
		txtword = new JTextField();
		
		
		txtword.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblStarttxt.setLabelFor(txtword);
		txtword.setText(w.getWord());
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
		btnBtnsuperscript.setMnemonic('d');
		btnBtnsuperscript.setToolTipText("Make Super Script(Alt+D)");
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
		
		
		editwordcontroller editwordcontrol=new editwordcontroller(frmeditword,btnbold,btnitalic,btnstop,panel,txtword,btnsubscript,btnBtnsuperscript,cbotypelst, txtdesc, btnadd, btncancel);
		
		btnstop.addActionListener(editwordcontrol);
		btnBtnsuperscript.addActionListener(editwordcontrol);
		btnsubscript.addActionListener(editwordcontrol);
		btnadd.addActionListener(editwordcontrol);
		btncancel.addActionListener(editwordcontrol);
		btnbold.addActionListener(editwordcontrol);
		btnitalic.addActionListener(editwordcontrol);
		panel.addMouseMotionListener(editwordcontrol);
		panel.addMouseListener(editwordcontrol);
		
		
	}

}
