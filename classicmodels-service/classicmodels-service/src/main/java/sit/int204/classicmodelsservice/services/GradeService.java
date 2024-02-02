package sit.int204.classicmodelsservice.services;

import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.models.Student;



@Service
public class GradeService {

    public Student gradeService(Student student) {
        return student.calculateGrade();
    }

//    public Student getAllStudent(Student student){
//
//    }
}