package com.collage.students.fouryearscollage;

import com.collage.students.fouryearscollage.dto.StudentDto;
import com.collage.students.fouryearscollage.model.Student;
import org.hibernate.Session;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentHib {
    private Student student;
    private HibernateUtility hibernateUtility;

    public StudentHib(Student student1, HibernateUtility hibernateUtility) {
        this.student = student1;
        this.hibernateUtility = hibernateUtility;

    }

    public List<Student> getAllStudent() {
        Session session = hibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Student");
        List<?> student = query.getResultList();

        ArrayList<Student> result = new ArrayList<>();
        Iterator<?> iterator = student.iterator();
        while (iterator.hasNext()) {
            Student student1 = (Student) iterator.next();
            result.add(student1);
        }

        session.close();
        return result;
    }












}
