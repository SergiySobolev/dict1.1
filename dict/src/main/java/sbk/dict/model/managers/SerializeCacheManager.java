package sbk.dict.model.managers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sbk.dict.model.beans.DictReqForm;
import sbk.dict.model.beans.Subscriber;

public class SerializeCacheManager implements ICacheManager {	
	public void backup(ArrayList<Subscriber>  list) {
		String pathToSerializeFile;
		Context ctx;
		try {
			ctx = new InitialContext();
			pathToSerializeFile = (String) ctx
					.lookup("java:comp/env/backup.path");
		} catch (NamingException ne) {
			return;
		}
		try(FileOutputStream fileout 	= new FileOutputStream(pathToSerializeFile); 
			ObjectOutputStream out 		= new ObjectOutputStream(fileout);)
		{			
			out.writeObject(list);			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public ArrayList<Subscriber> restore() {
		String pathToSerializeFile;
		ArrayList<Subscriber> list;
		Context ctx;
		try {
			ctx = new InitialContext();
			pathToSerializeFile = (String) ctx
					.lookup("java:comp/env/backup.path");
		} catch (NamingException ne) {
			return null;
		}
		try(FileInputStream fileIn	 	= new FileInputStream(pathToSerializeFile); 
			ObjectInputStream in  		= new ObjectInputStream(fileIn);)
		{			
			list	= (ArrayList<Subscriber>) in.readObject();				
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
