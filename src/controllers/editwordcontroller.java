package controllers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextField;

import comm.comfunction;

import dao.Dac;
import entity.Word;

public class editwordcontroller implements ActionListener,MouseMotionListener,MouseListener {
private static editwordcontroller _editwordcontrol;
	
	private JFrame frmedit;
	
	private JComboBox cbotypelst;
	private JEditorPane txtdesc;
	private JTextField txtword;
	private JButton btnadd;
	private JButton btncancel;
	private JButton btnclose;
	
	
	private Panel toppanel;
	//Declaring Ready made functions
	private Dac dal;
	private comfunction comfnc;
	private JButton btnsubscript;
	private JButton btnsuperscript;
	private JButton btnbold;
	private JButton btnitalic;
	
	final Point point= new Point();
	
	
	public editwordcontroller(JFrame _frmedit,JButton _btnbold,JButton _btnitalic,JButton _btnclose,Panel _panel,JTextField _txtword,JButton _btnsubscript,JButton _btnsuper,JComboBox _cbotypelst,JEditorPane _txtdesc,JButton _btnadd,JButton _btncancel){
		this.cbotypelst=_cbotypelst;
		this.txtword=_txtword;
		this.txtdesc=_txtdesc;
		this.btnadd=_btnadd;
		this.btncancel=_btncancel;
		this.frmedit=_frmedit;
		this.btnsubscript=_btnsubscript;
		this.toppanel=_panel;
		this.btnsuperscript=_btnsuper;
		this.btnclose=_btnclose;
		this.btnbold=_btnbold;
		this.btnitalic=_btnitalic;
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		comfnc=new comfunction();
		if(e.getSource()==btnadd){
				if(txtword.getText().length()==0||cbotypelst.getSelectedIndex()==0 || txtdesc.getText().length()==0){
					
					if(txtword.getText().length()==0){
						txtword.setBackground(new Color(248,77,77));
						txtword.requestFocus();
					}
					if(cbotypelst.getSelectedIndex()==0){
						cbotypelst.setBackground(new Color(248,77,77));
						cbotypelst.requestFocus();
					}
					if(txtdesc.getText().length()==0){
						txtdesc.setBackground(new Color(248,77,77));
						txtdesc.requestFocus();
					}
				}
				else
				{
					dal=new Dac();
					Word o=new Word();
					
					Character ch=txtword.getText().charAt(0);
					
					String tblname=comfnc.gettableName(ch);
					if(tblname!=""){
							o.setWord(txtword.getText());
							o.setWtype(cbotypelst.getSelectedItem().toString());
						String temp=	txtdesc.getText().replaceAll("'", "");
							o.setDesc(temp);
							
							
							Boolean b=dal.UpdateWord(o, tblname);
							
							frmedit.dispose();
					
					
					}else{
						//if it fails
					}
					
				}
		}
		else if(e.getSource()==btncancel||e.getSource()==btnclose)
		{
			
			frmedit.dispose();
			
		}
		else if(e.getSource()==btnsubscript)
		{			 
			 try{
				 if(comfnc.isnullorEmpty(txtdesc.getSelectedText())){
				 
					 txtdesc.replaceSelection("<sub>"+txtdesc.getSelectedText()+"</sub>");
				 }else{
					 
					 
				 }
			 }
			 catch(Exception t)
			 {
				 
			 }
			
		}
		else if(e.getSource()==btnsuperscript)
		{
			
			try{
				if(comfnc.isnullorEmpty(txtdesc.getSelectedText())){
					
				txtdesc.replaceSelection("<sup>"+txtdesc.getSelectedText()+"</sup>");
				}else{
					
					
				}
			}
			catch(Exception t){
				
				
			}
		}else if(e.getSource()==btnbold){
			
			try{
				if(comfnc.isnullorEmpty(txtdesc.getSelectedText())){
					txtdesc.replaceSelection("<b>"+txtdesc.getSelectedText()+"</b>");
				}else{
					
					
				}
				
			}catch(Exception t){
				
				
			}
		}
		else if(e.getSource()==btnitalic){
			
			try{
				if(comfnc.isnullorEmpty(txtdesc.getSelectedText())){					
					txtdesc.replaceSelection("<i>"+txtdesc.getSelectedText()+"</i>");
				}else{					
					
				}
				
			}catch(Exception t){
				
				
			}
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point tpoint = frmedit.getLocation();
		frmedit.setLocation(tpoint.x + e.getX() - point.x, tpoint.y + e.getY() - point.y );
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		toppanel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		point.x=arg0.getX();
		point.y=arg0.getY();
		toppanel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		toppanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

}
