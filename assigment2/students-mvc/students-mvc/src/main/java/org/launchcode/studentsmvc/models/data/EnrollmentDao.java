package org.launchcode.studentsmvc.models.data;

import org.launchcode.studentsmvc.models.forms.Enrollment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface EnrollmentDao extends CrudRepository<Enrollment,Integer> {

}
