package Main;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.net.URL;

import Frames.Splash;
import Frames.mainform;
import dao.Dac;
import db.dbhelper;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dac _do=new Dac();
		

		Splash s=new Splash();
		
		mainform t=new mainform();
		
		s.instance().run();
	try {
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			t.instance().run();
			
	}
		
		
		
		/*dbhelper dbhelp=new dbhelper();
		try{
			dbhelp.makedbCon("SELECT * FROM A");
		}catch(Exception e){
			System.out.println("sss");
			
		}*/
		
		
	}

}
