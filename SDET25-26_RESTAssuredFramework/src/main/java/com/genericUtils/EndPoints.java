package com.genericUtils;
/**
 * This class 
 * @author LENOVO
 *
 */
public interface EndPoints {

	String DB_URL = "jdbc:mysql://localhost:3306/projects";
	
	String ADD_PROJECT = "/addProject";
	String GET_ALLPROJECTS = "/projects";
	String GET_SINGLEPROJECT = "/projects/{projectid}";
	String DELETE_PROJECT = "/projects/{projectid}";
	String UPDATE_PROJECT = "/projects/{projectid}";
	
	String ADD_USER = "/employees";
	String GET_ALLUSERS = "/employees";
	String GET_SINGLEUSER_BYusername = "/employee/{userName}";
	String GET_SINGLEUSER_BYEmp= "/employees/{empId}";
	String DELETE_USER = "/employees/{empId}";
	String UPDATE_USER = "/employees/{empId}";
	
}
