package org.launchcode.studentsmvc.BLL;
import java.util.List;

import org.launchcode.studentsmvc.DAO.CourseDao;
import org.launchcode.studentsmvc.enitites.CourseEntity;



public class CourseBLL {
	
private CourseDao courseDAO;
	
	public CourseBLL()
	{
		courseDAO = new CourseDao();
	}
	
	public int insert(CourseEntity course)
	{
		return courseDAO.insert(course);
	}
	
	public List<CourseEntity> getAll()
	{
		return courseDAO.getAll();
	}
	
	public List<CourseEntity> getByidAdmin(int id)
	{
		return courseDAO.getByidAdmin(id);
	}
}
