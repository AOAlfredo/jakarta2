/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itspa.courses.jakarta2.controller;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import mx.edu.itspa.courses.jakarta2.beans.StudentBean;
import mx.edu.itspa.courses.jakarta2.entity.Student;

/**
 *
 * @author pfarfan
 */
@Named
@RequestScoped
public class StudentController implements Serializable{
    @Inject
    private Student student;
    
    @EJB
    private StudentBean studentBean;
     
    private
    List<Student> studentList;
    
    public Student getStudent() {
        return student;
    }
   
    public List<Student> getStudentList() {
        return this.studentList;
    }
    
    public String  saveStudent() {
        try {
            System.out.println("saveStudent()---------------------------------------");
            System.out.println("id:" + student.getId());
            System.out.println("fn:" + student.getFirstName());
            System.out.println("ln:" + student.getLastName());
            System.out.println("em:" + student.getEmail());
            
            
            studentBean.saveStudent(student);
        } catch (Exception e){
            return "error";
        }
        return getStudents();
    }
            
   
    public String getStudents() {
        studentList = studentBean.getStudents();
        
        return "information";
    }    
    
}
