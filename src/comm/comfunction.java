package comm;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javax.swing.JOptionPane;



public class comfunction {

	private static comfunction _comfunction;
	
	public static comfunction instance() {
		if(_comfunction==null)
			_comfunction=new comfunction();
		
		return _comfunction;
	}
	
	public  void gourl(URI uri) {
	    if (Desktop.isDesktopSupported()) {
	      try {
	        Desktop.getDesktop().browse(uri);
	      } catch (IOException e) { /* TODO: error handling */ }
	    } else { /* TODO: error handling */ }
	  }
	
	
public boolean isnullorEmpty(String s){
		
		if(s.equals(null)||s.isEmpty())
		{
			return false;
		}else{
			return true;
			
		}
		
	}
	

	

	public static void infoBox(String infoMessage, String location)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
	    }
	
	
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
}
