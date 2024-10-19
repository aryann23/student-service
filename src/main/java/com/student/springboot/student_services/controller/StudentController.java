package com.student.springboot.student_services.controller;

import com.student.springboot.student_services.model.Course;
import com.student.springboot.student_services.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}/courses")
    public List<Course> getCoursesForStudent(
            @PathVariable String studentId
    ){
        return studentService.getCourses(studentId);
    }

    @GetMapping("/students/{studentId}/courses/{courseId}")
    public Course getDetailsOfCourse(
            @PathVariable String studentId,
            @PathVariable String courseId
    ){
        return studentService.getCourseDetails(studentId, courseId);
    }

}
