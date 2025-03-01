package com.hcl.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public class EmployeePKId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int empId;
	private int deptId;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empid) {
		this.empId = empid;
	}
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public EmployeePKId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeePKId(int empid, int deptId) {
		super();
		this.empId = empid;
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "EmployeePKId [empId=" + empId + ", deptId=" + deptId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptId, empId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePKId other = (EmployeePKId) obj;
		return deptId == other.deptId && empId == other.empId;
	}

}
