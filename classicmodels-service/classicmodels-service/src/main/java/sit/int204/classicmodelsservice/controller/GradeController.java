package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sit.int204.classicmodelsservice.models.Student;
import sit.int204.classicmodelsservice.services.GradeService;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    private GradeService service;

    @PostMapping("")
    public Student addNewStudent(@RequestBody Student student) {
        return service.gradeService(student);
    }

//    @GetMapping("")
//    public Student getStudent(@RequestBody Student student){
//        return
//    }
}
