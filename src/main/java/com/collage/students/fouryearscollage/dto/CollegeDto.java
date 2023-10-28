package com.collage.students.fouryearscollage.dto;

import com.collage.students.fouryearscollage.model.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@JsonInclude
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDto {

    private String collegeName;
    private List<Student> collegeStudentsDetails;

}
