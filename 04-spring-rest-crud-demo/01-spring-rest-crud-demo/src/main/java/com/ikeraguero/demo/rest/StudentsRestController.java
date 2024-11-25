package com.ikeraguero.demo.rest;

import com.ikeraguero.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsRestController {

    private List<Student> studentList;

    @PostConstruct
    public void loadData() {
        Student student1 = new Student("Max", "Verstappen");
        Student student2 = new Student("Lewis", "Hamilton");
        Student student3 = new Student("Nico", "Hulkenberg");
        studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    @ResponseBody
    public Student getStudent(@PathVariable int studentId) {


        if(studentId < 0 || studentId > studentList.size()-1) {
            throw new StudentNotFoundException("ID not found - " + studentId);
        }

        return studentList.get(studentId);
    }


}
