package controllers;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import comm.comfunction;
import Frames.Editword;
import Frames.aboutform;
import Frames.newword;
import dao.Dac;
import entity.Word;


public class maincontroller implements ActionListener,ListSelectionListener,DocumentListener,MouseMotionListener,MouseListener,KeyListener  {
	
	private static maincontroller _testcontroller;
	public static String dbpath=null; 
	
	private JTextField txtsearch;
	private JFrame frmdict;
	//places to show selected definition
	private JTextPane txtcontent;
	private JTextPane txtword;
	private JTextPane txttype;
	private JList lstword;
	
	private Panel toppanel;
	
	private JButton btnstop;
	private JButton btnminimize;
	private JButton btnprev;
	private JButton btnnex;
	private JButton btn_editword;
	private JButton btn_del;
	
	private comfunction com;
	private List<Word> wordlist=new ArrayList<Word>();
	final List<String> searchlist=new ArrayList<String>();
	final Point point = new Point();
	
	//Making Menu for the system
	private JMenuItem mnitemabt;
	private JMenuItem mnitemneword;
	private JMenuItem mnlinkdata;
	
	
	public maincontroller(JFrame _frmdict,Panel _toppanel,JTextField _txtsearch,JList _lstword,JTextPane _textcontent,JTextPane _textword,JTextPane _texttype,
			JMenuItem _mnitemabt,JMenuItem _mnlink,JMenuItem _mnitemneword,JButton _btnstop,JButton _btnminimize,JButton _btnprev,JButton _btnnex,JButton _btneditword,JButton _btndel){
		
		this.frmdict=_frmdict;
		this.toppanel=_toppanel;
		
		this.txtsearch=_txtsearch;
		this.lstword=_lstword;
		
		this.txtcontent=_textcontent;
		this.txtword=_textword;
		this.txttype=_texttype;
		
		//Menuitems
		this.mnitemabt=_mnitemabt;
		this.mnitemneword=_mnitemneword;
		this.mnlinkdata=_mnlink;
		
		this.btnstop=_btnstop;
		this.btnminimize=_btnminimize;
		
		this.btnprev=_btnprev;
		this.btnnex=_btnnex;
		this.btn_editword=_btneditword;
		this.btn_del=_btndel;
		
	}
	
	
	
	
	
	
	
	/*
	 * This is deligate handler for the buttons
	 * */
	@Override
	public void actionPerformed(ActionEvent e){
			if(e.getSource()==mnitemabt){
				
				aboutform.instance().run();
				
			}
			if(e.getSource()==mnitemneword){
				newword.instance().run();
			}
			
			if(e.getSource()==mnlinkdata){
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    dbpath=selectedFile.getAbsolutePath().toString();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				
			}
			if(e.getSource()==btnstop){
				searchlist.clear();
				System.exit(0);
				
			}
			if(e.getSource()==btnminimize){
				frmdict.setState(Frame.ICONIFIED);
				
			}
			
			//------------Previous Next Algorithum
			int count=searchlist.size();
			if(e.getSource()==btnprev){
				int currentindex;
				int subtract;
				if(lstword.isSelectionEmpty()==false)//check whether List box is selected
				{
				 currentindex=searchlist.indexOf( lstword.getSelectedValue().toString());
				 subtract=currentindex-1;
				 btnnex.setVisible(true);
				}else{
					subtract=count-1;
					currentindex=subtract;
				}
				
				if(subtract>-1)
				{
					String prevword=searchlist.get(subtract);
					txtsearch.setText(prevword);
					
				}else if(subtract==-1 && currentindex==0){
					

						
						btnprev.setVisible(false);
						btnnex.setVisible(true);
					
				}
				
				
				
			}
			
			if(e.getSource()==btnnex){
				int currentindex;
				int sum;
				if(lstword.isSelectionEmpty()==false){
				 currentindex=searchlist.indexOf(lstword.getSelectedValue().toString());
				 sum=currentindex+1;
				 btnprev.setVisible(true);
				}else{
					
					currentindex=0;
					sum=currentindex;
				}
				
				if(sum<count){
					
					String nexword=searchlist.get(sum);
					txtsearch.setText(nexword);
				}
				else if(sum>=count)
				{
					
					btnnex.setVisible(false);
					btnprev.setVisible(true);
				}
			}
			
			//-----------Algorithum Ends-----------
			
			if(e.getSource()==btn_editword) {
				Dac dal=new Dac();
				Word o=new Word();
				com=new comfunction();
				Character firstchar=lstword.getSelectedValue().toString().charAt(0);
				
				if(firstchar.SIZE!=0){
					
					String tblname=gettableName(firstchar);//Get Table Name prefix by sensing first char
					
					o.setWord(lstword.getSelectedValue().toString());
					o= dal.getByword(o,tblname);
					
					
					Editword.instance(o).run(o);//passing selected values to edit form
				}else{
					com.infoBox("testing", "testing");
				}
						
				
			}
			
			if(e.getSource()==btn_del){
				Word delword=new Word();
				com=new comfunction();
				Dac dal=new Dac();
				Character firstchar=lstword.getSelectedValue().toString().charAt(0);
				String tblname=com.gettableName(firstchar);
				
				delword.setWord(lstword.getSelectedValue().toString());//make word to be deleted
				dal.DeleteWord(delword, tblname);
				
				
			}
		
	}
	
	

	/*
	 * Method that will fire if List of text is Selected
	 * 
	 * 
	 * */
	public void valueChanged(ListSelectionEvent e){
		
		if(lstword.isSelectionEmpty()){
			
			btn_editword.setVisible(false);
			btn_del.setVisible(false);
		}else{
			btn_editword.setVisible(true);
			btn_del.setVisible(true);
			
		}
		
			
			Dac dal=new Dac();
			Word o=new Word();
			try{
				Character firstchar=lstword.getSelectedValue().toString().charAt(0);
				String tblname=gettableName(firstchar);//Get Table Name prefix by sensing first char
				
				o.setWord(lstword.getSelectedValue().toString());
				o= dal.getByword(o,tblname);
				txtcontent.setText("\t"+o.getDesc()+"");
				txtword.setText(o.getWord());
				txttype.setText("("+o.getWtype()+")");
				
				
				
					
					int checker=searchlist.indexOf(lstword.getSelectedValue().toString());
					if(searchlist.size()==0){
						searchlist.add(lstword.getSelectedValue().toString());
					}else if(searchlist.size()>0 && checker==-1){
						
						searchlist.add(lstword.getSelectedValue().toString());
					}
			}catch(Exception ex){
				
				txtcontent.setText("");
				txtword.setText("");
				txttype.setText("");
			}
			
		
		
		
		
	}
	
	
	
	//method to make intellisense  & fills List
	/**
	 * Method to Get table name by starting word
	 * */
	public String gettableName(Character firstchar){
		String TableName="";
		switch(firstchar){
		 case 'a':TableName="A";break;
		 case 'A':TableName="A";break;
		 
		 case 'b':TableName="B";break;
		 case 'B':TableName="B";break;
		 
		 case 'c':TableName="C";break;
		 case 'C':TableName="C";break;
		 
		 case 'd':TableName="D";break;
		 case 'D':TableName="D";break;
		 
		 case 'e':TableName="E";break;
		 case 'E':TableName="E";break;
		 
		 case 'f':TableName="F";break;
		 case 'F':TableName="F";break;
		 
		 case 'g':TableName="G";break;
		 case 'G':TableName="G";break;
		 
		 case 'h':TableName="H";break;
		 case 'H':TableName="H";break;
		 
		 case 'i':TableName="I";break;
		 case 'I':TableName="I";break;
		 
		 case 'j':TableName="J";break;
		 case 'J':TableName="J";break;
		 
		 case 'k':TableName="K";break;
		 case 'K':TableName="K";break;
		 
		 case 'l':TableName="L";break;
		 case 'L':TableName="L";break;
		 
		 case 'm':TableName="M";break;
		 case 'M':TableName="M";break;
		 
		 case 'n':TableName="N";break;
		 case 'N':TableName="N";break;
		
		 case 'o':TableName="O";break;
		 case 'O':TableName="O";break;
		 
		 case 'p':TableName="P";break;
		 case 'P':TableName="P";break;
		 
		 case 'q':TableName="Q";break;
		 case 'Q':TableName="Q";break;
		 
		 case 'r':TableName="R";break;
		 case 'R':TableName="R";break;
		 
		 case 's':TableName="S";break;
		 case 'S':TableName="S";break;
		 
		 case 't':TableName="T";break;
		 case 'T':TableName="T";break;
		 
		 case 'u':TableName="U";break;
		 case 'U':TableName="U";break;
		 
		 case 'v':TableName="V";break;
		 case 'V':TableName="V";break;
		 
		 case 'w':TableName="W";break;
		 case 'W':TableName="W";break;
		 
		 case 'x':TableName="X";break;
		 case 'X':TableName="X";break;
		 
		//tablename switcher		 case 'y':System.out.println("y");break;
		 case 'Y':TableName="Y";break;
		 case 'y':TableName="Y";break;
		 case 'z':TableName="Z";break;
		 case 'Z':TableName="Z";break;
		 
		 default:TableName="";break;
		}
		return TableName;
	}
	
	public void insertUpdate(DocumentEvent e) {
			ArrayList<String> txtlist=new ArrayList<String>();
			
			
			
		 Character firstchar=txtsearch.getText().charAt(0);//get first character
		 
		 String tblname=gettableName(firstchar);
		 
		 Word w=new Word();
		 w.setWord(txtsearch.getText());
		 
		 //Declare DaC
		 Dac dal=new Dac();
		  List<Word> wlst=dal.getLikelywords(w, tblname);
		 
		  if(wlst.isEmpty()==false){
			  for(Word word:wlst){
				  txtlist.add(word.getWord().toString());
			  }		  
		  lstword.setListData(txtlist.toArray());//binding List of word to list
		  
		  
			  int checker=txtlist.indexOf(txtsearch.getText());//checking the user word is exist or not
			  if(checker!=-1){
				  String tmp=txtlist.get(checker);
				  
				  lstword.setSelectedValue(tmp,true);
			  }
		  }
	}
		 
		 
  
    public void removeUpdate(DocumentEvent e) {
    	ArrayList<String> txtlist=new ArrayList<String>();
		
		if(txtsearch.getText().length()!=0){
		
		 Character firstchar=txtsearch.getText().charAt(0);//get first character
		 
		 String tblname=gettableName(firstchar);
		 
		 Word w=new Word();
		 w.setWord(txtsearch.getText());
		 
		 //Declare DaC
		 Dac dal=new Dac();
		  List<Word> wlst=dal.getLikelywords(w, tblname);
		 
		  
		  for(Word word:wlst){
			  txtlist.add(word.getWord().toString());
		  }
		  
		  lstword.setListData(txtlist.toArray());//binding List of word to list
		}else{
			lstword.setListData(txtlist.toArray());
		}
    }
    public void changedUpdate(DocumentEvent e) {
        //Plain text components don't fire these events.
    }
//-------------------------------UI Controls-------------------------------------

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		toppanel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}







	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		point.x=e.getX();
		point.y=e.getY();
		toppanel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}







	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		toppanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}







	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Point tpoint = frmdict.getLocationOnScreen();
		frmdict.setLocation(tpoint.x + e.getX() - point.x, tpoint.y + e.getY() - point.y );
		
		
	}







	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
    //------------------------Intellisense Ends
}
