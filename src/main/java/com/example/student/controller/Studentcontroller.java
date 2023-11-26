package com.example.student.controller;

import com.example.student.entity.Inqueryrequest;
import com.example.student.entity.Student;
import com.example.student.entity.Updatestudentrequest;
import com.example.student.service.Studentservice;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/api")
public class Studentcontroller {
    Logger logger= LoggerFactory.getLogger(Studentcontroller.class);//sl4j
    @Autowired
    Studentservice studentservice;
    @Value("${app.name}")
    private String appName;
    @GetMapping("/get")
    public Student getmapping(){
        Student student=new Student(1,"gok","www","a@email",null);
        return student;
    }
    //log levels error<warn<info<debug<trace
@GetMapping("/getall")
    public List<Student> getallstudents(){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
        return studentservice.getallstudent();
}

@PostMapping("/post")
    public Student cretestudent(@Valid @RequestBody Student student){
        return studentservice.createStudent(student);
}
@PutMapping("/put")
    public Student updatestudent(@RequestBody Updatestudentrequest updatestudentrequest){
      return studentservice.updateStudent(updatestudentrequest);
}
@GetMapping("getbyfirstemail/{email}")
    public List<Student> getstudentbyemail(@PathVariable String email){
     return studentservice.getbyemail(email);
}
@GetMapping("/getbyemailandrank/{email}/{rank}")
    public Student getbyemailandrank(@PathVariable String email,@PathVariable String rank){
     return studentservice.getbyemailandrank(email, rank);
}

    @GetMapping("/getbyrankandname/{rank}/{name}")
        public List<Student>getbyrankandname(@PathVariable String rank,@PathVariable String name){
        return studentservice.getbyrankandname(rank, name);
    }
    @GetMapping("/getbyemail")
    public List<Student>getbyemail(@RequestBody Inqueryrequest inqueryrequest){
      return studentservice.getbyemail(inqueryrequest);
    }

    @GetMapping("/like/{email}")
    public List<Student>getbylike(@PathVariable String email){
     return studentservice.getbylike(email);
    }
    @GetMapping("/getallsorting")
    public List<Student>getallsorting( ){
        return studentservice.getsorting();
    }
    @GetMapping("/byemailandrank/{email}/{rank}")
    public Student getbybyemailandrank(@PathVariable String email,@PathVariable String rank){
        return studentservice.getbybyemailandrank(email, rank);
    }

    @PutMapping("/updaterank/{id}/{rank}")
    public String updaterank(@PathVariable int id,@PathVariable String rank){
        return studentservice.updaterankjpl(id,rank)+"student updated";
    }
//  @PostMapping("creates")
//    public Student createonetoone(@RequestBody Student student){..one to one mapping
//        return studentservice.createonetoone(student);
//  }

//  @GetMapping("getbycity/{city}")
//    public List<Student> getjoinquery(@PathVariable String city){//inner join
//        return studentservice.getjoinquery(city);
//  }
}
