package com.simplifying.tech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToJavaUsingOrgJson {
    
    public static void main(String[] args) throws IOException {
        
    	//Reading JSON from file system   
        BufferedReader br=new BufferedReader(new FileReader("C:\\AppData\\sample2.json"));            
        String line;  
        StringBuilder sbuilderObj = new StringBuilder();
        while((line=br.readLine()) !=null){
            sbuilderObj.append(line);
        }
        System.out.println("Original Json :: "+sbuilderObj.toString());
        //Using JSONObject 
        JSONObject jsonObj = new JSONObject(sbuilderObj.toString());
         
        String name = jsonObj.getJSONObject("empInfo").getString("name");
        String position = jsonObj.getJSONObject("empInfo").getString("position");
        String age = jsonObj.getJSONObject("empInfo").getString("age");
        System.out.println("###### Emp Info ############");
        System.out.println("Name     : "+name);
        System.out.println("Position : "+position);
        System.out.println("Age      : "+age);
        
        //Fetching nested Json using JSONArray
        JSONArray arrObj = jsonObj.getJSONArray("skills");
        for (int i = 0; i < arrObj .length(); i++) {
            String programming = arrObj .getJSONObject(i).getString("programming");
            String scripting = arrObj .getJSONObject(i).getString("scripting");
            String ml = arrObj .getJSONObject(i).getString("ml");
            System.out.println("###### Emp Skills (nested) ###########");
            System.out.println("Programming : "+programming);
            System.out.println("Scripting   : "+scripting);
            System.out.println("Ml          : "+ml);
        }
    }
}
