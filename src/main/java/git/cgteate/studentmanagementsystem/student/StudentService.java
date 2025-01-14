package git.cgteate.studentmanagementsystem.student;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import git.cgteate.studentmanagementsystem.student.exception.BadRequestException;
import git.cgteate.studentmanagementsystem.student.exception.StudentNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository
                .selectExistsEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmail() + " taken");
        }
        studentRepository.save(student);
    }
    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(
                    "Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
    public void editStudent(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new StudentNotFoundException(
                    "Student with id " + student.getId() + " does not exists");
        }
        studentRepository.save(student);
    }
    
}
