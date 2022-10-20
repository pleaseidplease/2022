package Morning20221014;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class UserDAO {
	
	

	//유저 집어넣기
	public void adduser(String userid,String username,int userpoint) {
		try {
			
			OutputStream output=new FileOutputStream("c:/Temp/memberList.txt");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
