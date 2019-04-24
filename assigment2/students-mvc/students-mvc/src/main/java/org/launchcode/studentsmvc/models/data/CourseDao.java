package org.launchcode.studentsmvc.models.data;

import org.launchcode.studentsmvc.models.forms.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface CourseDao extends CrudRepository<Course, Integer>{

}
