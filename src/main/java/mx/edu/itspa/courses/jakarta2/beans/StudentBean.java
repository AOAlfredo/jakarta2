/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itspa.courses.jakarta2.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;
import mx.edu.itspa.courses.jakarta2.entity.Student;

/**
 *
 * @author pfarfan
 */
@Stateless
public class StudentBean implements Serializable{
    @PersistenceContext
    private EntityManager entityManager;
    
    public void saveStudent(Student student) {        
        if (student.getId() == null) {
            saveNewStudent(student);
        } else {
            updateStudent(student);
        }      
    }

    private void saveNewStudent(Student student) {
        entityManager.persist(student);
    }

    private void updateStudent(Student student) {
        entityManager.merge(student);
    }
    
    public Student getStudent(Long studentId) {
        Student student;

        student = entityManager.find(Student.class, studentId);

        return student;
    }
            
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }
    
    public List<Student> getStudents(){
        List<Student> students = null;
        try{
            Query query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
            students = query.getResultList();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return students;
    }
}
