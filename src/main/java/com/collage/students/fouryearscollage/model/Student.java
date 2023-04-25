package com.collage.students.fouryearscollage.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {

    private int student_id;
    private String student_name;
    private String student_branch;
    private String student_college;
    private String student_subject;

    public Student(int student_id, String student_name, String student_branch, String student_college, String student_subject) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_branch = student_branch;
        this.student_college = student_college;
        this.student_subject = student_subject;
    }

}
