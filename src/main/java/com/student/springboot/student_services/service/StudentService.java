package com.student.springboot.student_services.service;

import com.student.springboot.student_services.model.Course;
import com.student.springboot.student_services.model.Student;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();
    
    private final SecureRandom secureRandom =new SecureRandom();

    static {
        //Initialize Data
        Course courseOne = new Course("Course1", "Spring", "10 Steps",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        Course courseTwo = new Course("Course2", "Spring MVC", "10 Examples",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        Course courseThree = new Course("Course3", "Spring Boot", "6K Students",
                List.of("Learn Maven", "Learn Spring", "Learn Spring MVC", "First Example", "Second Example"));

        Course courseFour = new Course("Course4", "Maven", "Most popular maven course on internet!",
                List.of("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse"));

        Student ranga = new Student("Student1", "Ranga Karanam", "Hiker, Programmer and Architect",
                new ArrayList<>(List.of(courseOne, courseTwo, courseThree, courseFour)));

        Student satish = new Student("Student2", "Satish T", "Hiker, Programmer and Architect",
                new ArrayList<>(List.of(courseOne, courseTwo, courseThree, courseFour)));

        //added students data into the student type list
        students.add(ranga);
        students.add(satish);
    }

    //get student function that will return student on the basis of asked studentId
    public Student getStudent(String studentId){
        return students.stream()
                .filter(s -> s.id().equals(studentId))
                .findAny()
                .orElse(null);
    }

    //here we are taking student details if matches the studentId we will get the courses under students name
    public List<Course> getCourses(String studentId){
        Student student = getStudent(studentId);

        return student == null ? null : student.courses();
    }

    //we are taking courseID and StudentID and then taking student specific to that studentID
    //returning the courses.stream() which is filtering on basis of courseId
    public Course getCourseDetails(String studentId, String courseId){
        Student student = getStudent(studentId);

        if(student == null)
            return null;

        return student.courses().stream()
                .filter(c -> c.id().equals(courseId))
                .findAny()
                .orElse(null);
    }

}
