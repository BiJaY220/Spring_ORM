package com.spring.orm.SpringORM.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.SpringORM.entities.Student;

public class studentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	//geting a data from database
	public Student getStudent(int studentId) {
		Student st= this.hibernateTemplate.get(Student.class, studentId);
		return st;
	}
	//many data from database 
	public List<Student> getallStudents(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	//delete the data from data base
	@Transactional
	public void deleteStudent(int studentId) {
		Student student= this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	//update operation
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
