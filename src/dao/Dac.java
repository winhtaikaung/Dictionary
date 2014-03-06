package dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.TableView.TableRow;

import db.*;
import entity.*;


public class Dac {
	private List<Word> lstword=new ArrayList<Word>();
	private dbhelper dbhelp;
	
	private static Dac dac;
	public static Dac instance(){
			
		if(dac==null){
			
			dac=new Dac();
		}
		return dac;
	}
	
	public List<Word> getListofword(String dbpath){
		dbhelp=new dbhelper();
		String sql="SELECT word FROM A";
		ArrayList alist;
		
		try{
			
			alist=dbhelp.getresultset(sql);
			for(int i=0;i<alist.size();i++){
				HashMap tablerow=new HashMap();
				tablerow=(HashMap)alist.get(i);
				Word w=new Word();
				 w.setWord(tablerow.get("word").toString().toLowerCase());
				
				
				lstword.add(w);
				
			} 
			return lstword;
		}catch(Exception e){
			return lstword;
			
		}
		
		
	}
	
	public List<Word> getLikelywords(Word o,String TableName){
		dbhelp=new dbhelper();
		String comma=",";
		String sql="SELECT word,desc,type FROM "+TableName +" WHERE word LIKE '"+o.getWord().toString()+"%'";
		ArrayList alist;
		
		try{
			
			alist=dbhelp.getresultset(sql);
			for(int i=0;i<alist.size();i++){
				HashMap tablerow=new HashMap();
				tablerow=(HashMap)alist.get(i);
				Word w=new Word();				
				 w.setWord(tablerow.get("word").toString().toLowerCase());
				 w.setDesc(tablerow.get("desc").toString().toLowerCase());
				 if(!w.getDesc().equals(null)){
				
				
					 lstword.add(w);
				 }else{
					 
				 }
				
			} 
			return lstword;
		}catch(Exception e){
			return lstword;
			
		}
		
		
	}
	
	public boolean InsertWord(Word o,String Tablename){
		
		dbhelper db=new dbhelper();
		String sql="INSERT INTO "+Tablename+" (word,type,desc) values ('"+o.getWord().toLowerCase()+"','"+o.getWtype()+"','"+o.getDesc()+"');";
		try{
			db.Excute(sql);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	public boolean UpdateWord(Word o,String Tablename){
		
		dbhelper db=new dbhelper();
		String sql="UPDATE  "+Tablename+" SET word='"+o.getWord().toLowerCase()+"',type='"+o.getWtype()+"',desc='"+o.getDesc()+"'WHERE word='"+o.getWord()+"';";
		try{
			db.Excute(sql);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	public boolean DeleteWord(Word o,String Tablename){
		
		dbhelper db=new dbhelper();
		String sql="DELETE FROM "+Tablename+" WHERE word='"+o.getWord()+"';";
		try{
			db.Excute(sql);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	
	public Word getByword(Word o,String Tablename){
		
		dbhelper db=new dbhelper();
		String test=o.getWord();
		String sql="SELECT word,desc,type from "+Tablename+" where word='"+o.getWord()+"'";
		ArrayList dataset;
		Word word= new Word();
		try{
			dataset=db.getresultset(sql);
			if(dataset.size()!=0){
				
				HashMap tablerow=new HashMap();
				tablerow=(HashMap)dataset.get(0);
				
				word.setWord(tablerow.get("word").toString());
				word.setDesc(tablerow.get("desc").toString());
				word.setWtype(tablerow.get("type").toString());
				
				return word;
			}else{
				word.setWord("Invalid Word");
				word.setDesc("Invalid Word");
				word.setWtype("Invalid Word");
				return word;
			}
			
		}catch(Exception ex){
			return word;
		}
		
	}
	
}
