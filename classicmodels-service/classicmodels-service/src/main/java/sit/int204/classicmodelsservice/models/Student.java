package sit.int204.classicmodelsservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter

public class Student {

    private Integer id;
    private String name;
    private Integer score;
    private String grade;

    public Student calculateGrade() {
        if (score > 100) {
            this.grade = "Invalid";
        } else if (score >= 80) {
            this.grade = "A";
        } else if (score >= 70) {
            this.grade = "B";
        } else if (score >= 60) {
            this.grade = "C";
        } else if (score >= 50) {
            this.grade = "D";
        } else {
            this.grade = "F";
        }
        return this;
    }

}


