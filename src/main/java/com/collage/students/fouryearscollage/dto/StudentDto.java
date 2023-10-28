package com.collage.students.fouryearscollage.dto;

import com.collage.students.fouryearscollage.model.College;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@JsonInclude
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private int studentId;
    private String studentName;

    private String studentBranch;
    private String studentCollege;

    private College college;

    private String student_subject;


}
