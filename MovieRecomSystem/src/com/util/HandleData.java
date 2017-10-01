package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class HandleData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Delete not existing data in predict.txt
		HandleData t = new HandleData();
		t.deleteLinePredict();
	}
	
	public void deleteLinePredict() throws IOException{
		DataGrabbing dg = new DataGrabbing();
		// the list of history
		Set<String> uSet = new HashSet<String>();
		Set<String> mSet = new HashSet<String>();
		
		// read the history.txt file
		dg.GetUDList(uSet, mSet);
		
		// read the predict.txt file
		deleOperation(uSet, mSet);

	}
	
	public void deleOperation(Set<String> userList, Set<String> movieList) throws IOException{
		//Store all the line matches the record.
		File file = new File("res/predictSource.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String tempString = null;
        while((tempString = reader.readLine())!=null){
        	//get the user and movie
        	StringTokenizer st = new StringTokenizer(tempString, "\t");
        	String userInfo = st.nextToken();
        	//System.out.println(userInfo);
        	String movieInfo = st.nextToken();
        	System.out.println(movieInfo);
        	
            if((!movieList.contains(movieInfo))||(!userList.contains(userInfo))){
                System.out.println("get the delete line");
                continue;
            }
            sb.append(tempString+"\r\n");
        }
        reader.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        	bw.write(sb.toString());
    
        bw.close();
        System.out.println("Delete Finish");
	}
}
