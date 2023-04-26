package com.collage.students.fouryearscollage.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_branch")
    private String studentBranch;
    @Column(name = "student_college")
    private String studentCollege;
    @Column(name = "student_subject")
    private String student_subject;

    public Student(int studentId, String studentName, String studentBranch, String studentCollege, String student_subject) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentBranch = studentBranch;
        this.studentCollege = studentCollege;
        this.student_subject = student_subject;
    }

}
