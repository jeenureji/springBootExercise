package com.collage.students.fouryearscollage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "college")
public class College {

    @Id
    @Column(name = "college_name")
    private String collegeName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Student_college")
    private List<Student> collegeStudentsDetails;

}
