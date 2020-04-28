package com.cg.sprint.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="classdetails")
public class Class 
{
    @Id
    @Column(name="class_id")
    int classId;
    @Column(name="class_name")
    String className;
    @Column(name="class_rows")
    int rows;
    @Column(name="class_cols")
    int cols;
    double fare;
    public Class() {}
	public Class(int classId, String className, int rows, int cols, double fare) 
	{
		this.classId = classId;		this.className = className;		this.rows = rows;
		this.cols = cols;		this.fare = fare;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
}
