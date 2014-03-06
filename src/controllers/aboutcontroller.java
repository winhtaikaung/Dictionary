package controllers;

import java.awt.Cursor;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import comm.*;

public class aboutcontroller implements ActionListener,MouseMotionListener,MouseListener {

	private static aboutcontroller _aboutcontroller;
	
	private JFrame frmabt;
	private JButton btnepic;
	private JButton btnstop;
	private Panel toppanel;
	private JButton btngoepic;
	final Point point= new Point();
	
	public aboutcontroller(JFrame _frmabt,JButton _btnepic,JButton _btnstop,Panel _toppanel,JButton _goepic){
		
		this.btnepic=_btnepic;
		this.btnstop=_btnstop;
		this.frmabt=_frmabt;
		this.toppanel=_toppanel;
		this.btngoepic=_goepic;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==btnstop){
			
			frmabt.dispose();
		}
		if(e.getSource()==btnepic){
			URI uri;
			try {
				uri = new URI("http://www.epicmyanmar.com");
				comfunction c=new comfunction();
				c.instance().gourl(uri);
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point tpoint = frmabt.getLocation();
		frmabt.setLocation(tpoint.x + e.getX() - point.x, tpoint.y + e.getY() - point.y );
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
