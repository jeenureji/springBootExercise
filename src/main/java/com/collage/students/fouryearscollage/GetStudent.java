package com.collage.students.fouryearscollage;

import com.collage.students.fouryearscollage.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

@WebServlet(description = " students and there details", urlPatterns = {"/api/students"})
public class GetStudent extends HttpServlet {
    private StudentHib studentHib;
    String version;


private  static  final  long serialVersionUID = 1L;

    public GetStudent(StudentHib studentHib) throws IOException {
        this.studentHib = studentHib;
        loadProperty();
    }

        private void loadProperty() throws IOException {
            Properties pro = new Properties();
            try(InputStream input = getClass().getClassLoader().getResourceAsStream("content.properties")){
                if(input !=null){
                    pro.load(input);
                }
            }
            version = pro.getProperty("version");

        }

    protected void getAllStudents(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SerialException, IOException{

//        String requestedVersion = httpServletRequest.getParameter("version");
//        if (!requestedVersion.matches("\\d+")) {
//            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//
//        if (!requestedVersion.equals(version)) {
//            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }
    List<Student>  stu =  studentHib.getAllStudent();

    JSONArray jsonArray = new JSONArray();

    Iterator<Student> iterator = stu.iterator();
    while (iterator.hasNext()) {
        Student student = iterator.next();
        JSONObject studentJson = new JSONObject();
        studentJson.put("studnet name", student.getStudentName());
        studentJson.put("student Id", student.getStudentId());
        studentJson.put("student branch", student.getStudentBranch());
        studentJson.put("studnet college", student.getCollege());

        jsonArray.put(studentJson);
    }
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("success", true);
    jsonObject.put("msg_body", jsonArray);
    jsonObject.put("resultCount", jsonArray.length());
    httpServletResponse.setContentType("application/json");
    httpServletResponse.getWriter().append(jsonObject.toString());


    }




}















