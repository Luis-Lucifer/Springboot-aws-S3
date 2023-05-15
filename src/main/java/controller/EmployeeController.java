package controller;


import dto.EmployeeDto;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.EmployeeService;
import service.S3Service;

import java.io.IOException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private S3Service s3Service;

    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@ModelAttribute EmployeeDto employeeDto,
//                                                   @RequestParam("resume")MultipartFile resume) throws IOException {
//
//        String resumeLink = s3Service.uploadResume(resume);
//        employeeDto.setResumeLink(resumeLink);

    public ResponseEntity<Employee> createEmployee(@ModelAttribute EmployeeDto employeeDto) throws IOException{
        Employee savedEmployee = employeeService.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }


}
