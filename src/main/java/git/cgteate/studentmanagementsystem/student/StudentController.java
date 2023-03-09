package git.cgteate.studentmanagementsystem.student;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@CrossOrigin("*")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = Arrays.asList(
                new Student(
                        1L,
                        "Emma",
                        "emma@washburn.edu",
                        Gender.FEMALE),
                new Student(
                        2L,
                        "Calvin",
                        "calvin@washburn.edu",
                        Gender.MALE)
        );
        return students;
    }
}
