package sit.int204.classicmodelsservice.services;

import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Student;

import java.util.List;

@Service
public class GradeService {
//    @Autowired
//    private GradeController controller;


    public Student calculateGrade(Student student) {
        if (student.getScore() > 100) {
            student.setGrade("invalid");
        } else if (student.getScore() >= 80) {
            student.setGrade("A");
        } else if (student.getScore() >= 70) {
            student.setGrade("B");
        } else if (student.getScore() >= 60) {
            student.setGrade("C");
        } else if (student.getScore() >= 50) {
            student.setGrade("D");
        } else {
            student.setGrade("F");
        }
        return student;
    }

//    public List<Student> getAllStudent(){
//        return
//    }
}