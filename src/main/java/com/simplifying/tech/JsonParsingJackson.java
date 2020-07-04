package com.simplifying.tech;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplifying.tech.vo.EmployeeParent;
import com.simplifying.tech.vo.Skills;

public class JsonParsingJackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            EmployeeParent empParentObj = objectMapper.readValue(new File("C:\\AppData\\sample2.json"), EmployeeParent.class);
            //Print info directly
            System.out.println("###### Emp Info Jackson############");
            System.out.println("Emp Name     : " + empParentObj.getEmpInfo().getName());
            System.out.println("Emp Age      : " + empParentObj.getEmpInfo().getAge());
             
            System.out.println("Emp Position : " + empParentObj.getEmpInfo().getPosition());
            System.out.println("Emp Salary   : " + empParentObj.getEmpInfo().getSalary());
             
            //parsing nested list
            System.out.println("###### Emp Skills ###########");
            for(Skills skill : empParentObj.getSkills()) {
                System.out.println("Promrammming : " + skill.getProgramming());
                System.out.println("Scripting    : " + skill.getScripting());
                System.out.println("MI           : " + skill.getMl());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
}
