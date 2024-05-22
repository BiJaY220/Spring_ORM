package com.spring.orm.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.SpringORM.dao.studentDao;
import com.spring.orm.SpringORM.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
      studentDao studentDao= context.getBean("studentDao",studentDao.class);
//      Student st = new Student(56,"bijay khanal","kathmandu");
//      int r = studentDao.insert(st);
//      System.out.println("result :"+r);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Boolean start = true;
      
      
      while(start) {
      System.out.println("insert a student in the database : PRESS 1");
      System.out.println("display a student in the database : PRESS 2");
      System.out.println("display all student in the database : PRESS 3");
      System.out.println("delete a  student from the database : PRESS 4");
      System.out.println("update details of  student in the database : PRESS 5");
      System.out.println("to exit : PRESS 6");
      
      try {
    	  int input= Integer.parseInt(br.readLine());
    	  if(input ==1) {
    		  //insert a student
    		  System.out.println("Enter the id of the Student:  ");
    		  int sid = Integer.parseInt(br.readLine());
    		  
    		  System.out.println("Enter the name of the Student: ");
    		  String sname = br.readLine();
    		  System.out.println("Enter the city of the Student: ");
    		  String scity = br.readLine();
    		  
    		  Student s = new Student();
    		  s.setStudentId(sid);
    		  s.setStudentName(sname);
    		  s.setStudentCity(scity);
    		  
    		  int r = studentDao.insert(s);
    		  System.out.println(r+"  student id added");
    		  
    	  }
    	  else if(input == 2) {
    		  //display
    		  System.out.println("+++++++++++++++++++++++++++++++++++");
    		  System.out.println("Enter user id :");
    		  int id = Integer.parseInt(br.readLine());
    		  Student student = studentDao.getStudent(id);
    		  System.out.println("ID :  "+student.getStudentId());
    		  System.out.println("NAME :  "+student.getStudentName());
    		  System.out.println("CITY :  "+student.getStudentCity());
    		  
    		  
    	  }
    	  else if(input == 3) {
    		  //display all
    		  System.out.println("------------------------------------");
    		  List<Student> allstu = studentDao.getallStudents();
    		  for(Student st: allstu) {
    			  System.out.println("ID :  "+st.getStudentId());
        		  System.out.println("NAME :  "+st.getStudentName());
        		  System.out.println("CITY :  "+st.getStudentCity());
        		  System.out.println("________________________________");
    			  
    		  }
    	  }
    	  else if(input == 4) {
    		  System.out.println("************************************");
    		  System.out.println("Enter the id to be deleted: ");
    		  int stdid = Integer.parseInt(br.readLine());
    		  studentDao.deleteStudent(stdid);
    		  System.out.println("the student is deleted from database");
    		  //delete
    	  }
    	  else if(input == 5) {
    		  //update
    	  }
    	  else {
    		  start = false;
    		  break;
    		  
    		  
    	  }
      }catch(Exception e){
    	  System.out.println("Invalid input brother !!");
    	  System.out.println(e.getMessage());
    	  
      }
      
      
      }
      System.out.println("DHANYAWADD");
    	
    	
    }
}// Spring MVC -> Model(data base interaction data manipulation) , view(user bata request, delegate request, rendering response )  , and controller(request ko response provide garxa) 
//user(request)-> front controller <-> delegate to controller(handle request and provide response)-> for data(model)
//user(response)<-front controller(disptcher serverlet) <->(model) view template(return garne render garne )view resolver