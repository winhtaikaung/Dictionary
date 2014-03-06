package db;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import controllers.maincontroller;

public class dbhelper {
	
	
	private static dbhelper _dbhelper;
	/*
	 * This is auto loader function
	 * 
	 * */
	String dburl="jdbc:sqlite:/Data/dict.db";
	public static dbhelper instance(){
		
			if(_dbhelper==null){
				
				_dbhelper=new dbhelper();
			}
			return _dbhelper;
		
	}
	
	
	
	private void makedbCon(){
		
		Connection c=null;
		try{
			Class.forName("org.sqlite.JDBC");
		 	c = DriverManager.getConnection(dburl);
		 	c.setAutoCommit(false);
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		
		System.out.println("connection opened");
	}
	
	public void CreateDB(){
		
		
	    try {
	     makedbCon();
	     System.out.println("DB OPENED");
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage());
	      System.exit(0);
	    }
		
	}
	
	public void simulatexecute(String path){
		
		System.out.println(path);
	}
	
	/*
	 * Method To EXECUTE DDL Query Like I,U,D 
	 * 
	 * */	
	public void Excute(String sql){
		
		Connection c=null;
		Statement stmt=null;
		try{
			
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig confg=new SQLiteConfig();
			confg.enableFullSync(true);
			confg.setReadOnly(false);
			
			SQLiteDataSource ds=new  SQLiteDataSource(confg);
			//ds.setUrl("jdbc:sqlite::resource:"+getClass().getResource("dict.db").toString());
			
			//Jar resource
//			URL url=getClass().getProtectionDomain().getCodeSource().getLocation();
//			
//			File myfile = new File(url.toURI());
//			File dir = myfile.getParentFile();
//			
//			String s=dir.getAbsolutePath();
			
			/*URL*/
			//ds.setUrl("jdbc:sqlite::resource:file:"+maincontroller.dbpath);
			/*dbpath*/
			
			ds.setUrl("jdbc:sqlite:"+maincontroller.dbpath);
			
			
			//System.out.println(s);
			//ds.setUrl("jdbc:sqlite::resource:"+"../Data/dict.db");
			//ds.setUrl("jdbc:sqlite::resource:jar:"+getClass().getResource("dict.db").toString());
			c=ds.getConnection();
		 	
		
		 	
		 	c.setAutoCommit(false);
		 	
		 	stmt=c.createStatement();
		 	stmt.executeUpdate(sql);
		 	
		 	
		 	stmt.close();
		 	c.commit();
		 	c.close();
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList getresultset(String sql)throws Exception {
		Connection c=null;
		Statement stmt=null;
		ArrayList rows=new ArrayList();
		try{
			Class.forName("org.sqlite.JDBC");
				SQLiteConfig confg=new SQLiteConfig();
				confg.enableFullSync(true);
				confg.setReadOnly(false);
				
				SQLiteDataSource ds=new  SQLiteDataSource(confg);
			      //c = DriverManager.getConnection(dburl);
				
				//ds.setUrl("jdbc:sqlite::resource:"+getClass().getResource("dict.db").toString());
				//ds.setUrl("jdbc:sqlite::resource:"+"../Data/dict.db");
				//ds.setUrl("jdbc:sqlite::resource:"+getClass().getResource("dict.db").toString());
//			URL url=getClass().getProtectionDomain().getCodeSource().getLocation();
//			String authority=url.getAuthority();	
//				File myfile = new File(url.toURI());
//				File dir = myfile.getParentFile();
//				String s=dir.getAbsolutePath();
				
//				InputStream input = getClass().getResourceAsStream("/dataFolder/Folder1/file.xml");
			/*This is url resource*/	
				//ds.setUrl("jdbc:sqlite::resource:file:"+maincontroller.dbpath);
			/*This is testing */	
				ds.setUrl("jdbc:sqlite:"+maincontroller.dbpath);
					c = ds.getConnection();
					c.setAutoCommit(false);
			     
		
			      stmt = c.createStatement();
			      ResultSet rs = stmt.executeQuery(sql);
			      
			      
			      ResultSetMetaData rsmd = rs.getMetaData(); 
					int columnCount = rsmd.getColumnCount(); 
					while (rs.next()) { 
					HashMap row = new HashMap(); 
					for (int i = 1; i <= columnCount; i++) { 
							String cname = rsmd.getColumnName(i); 
							row.put(cname, rs.getObject(i)); 
					} 
						rows.add(row); 
					}
			      
			      
			      rs.close();
			      stmt.close();
			      c.close();
			      return rows;
		}catch(Exception ex){
			
			return rows;
		}
	}
	
/*public  void Excute(String sql) throws Exception {
		
		// l����ݿ�
		
			// Load JDBC driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//pathString=pathString.replace("/", "\\");
			
		
			//String pathString="D:\\sores\\java\\ktv\\src\\db\\inventry.mdb";zz
			String dbUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+pathString;

			//String dbUrl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Documents and Settings\\chenyx\\workspace\\swing\\src\\access\\test.mdb";
			Connection con = DriverManager.getConnection(dbUrl, "",
					"");
			// SQL���
			
			Statement state = con.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// ִ��SQL���
			state.execute(sql);
			state.close();
			con.close();	
		
	}*/
	
	
	
	
	
}
