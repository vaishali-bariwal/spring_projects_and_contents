package com.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;


	public Course(String title) {
		super();
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public Course() {
		super();
	}


	public String getTitle() {
		return title;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	

}
