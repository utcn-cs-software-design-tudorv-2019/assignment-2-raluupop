package org.launchcode.studentsmvc.BLL;

import java.util.List;

import org.launchcode.studentsmvc.DAO.StudentDao;
import org.launchcode.studentsmvc.enitites.StudentEntity;



public class StudentBLL {
	private StudentDao studentDAO;
	
	public StudentBLL()
	{
		studentDAO=new StudentDao();
	}
	
	public int insert(StudentEntity student)
	{
		return studentDAO.insert(student);
	}
	
	public StudentEntity getByID(int id)
	{
		return studentDAO.getByID(id);
	}
	
	public StudentEntity getByName(String Name)
	{
		return studentDAO.getByName(Name);
	}
	
	/*public boolean update(StudentEntity student)
	{
		return studentDAO.update(student);
	}*/
	
	public boolean delete(int ID)
	{
		return studentDAO.delete(ID);
	}
	
	public List<StudentEntity> getAll()
	{
		return studentDAO.getAll();
	}
}