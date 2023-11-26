package com.example.student.service;

import com.example.student.entity.Address;
import com.example.student.entity.Inqueryrequest;
import com.example.student.entity.Student;
import com.example.student.entity.Updatestudentrequest;
import com.example.student.repository.Addressrepo;
import com.example.student.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentservice {
    @Autowired
    Studentrepo studentrepo;

    @Autowired
    Addressrepo addressrepo;

    public List<Student> getallstudent(){
        return studentrepo.findAll();
    }
    public Student createStudent(Student student){
        return studentrepo.save(student);
    }
    public Student updateStudent(Updatestudentrequest updatestudentrequest){
        Student student=studentrepo.findById(updatestudentrequest.getId()).get();
        if (updatestudentrequest.getId()!=0&&updatestudentrequest.getName()!=null){
            student.setEmail(updatestudentrequest.getEmail());
            student.setName(updatestudentrequest.getName());
        }
        return studentrepo.save(student);
    }
    public List<Student> getbyemail(String email){
       return studentrepo.findByEmail(email);
    }
    public Student getbyemailandrank(String email,String rank){
     Student student= studentrepo.findByEmailAndRank(email, rank);
        System.out.println("student"+student);
        return student;
    }
    public List<Student>getbyrankandname(String rank,String name){
     return studentrepo.findByRankOrName(rank, name);
    }
    public List<Student>getbyemail(Inqueryrequest inqueryrequest){
        return studentrepo.findByEmailIn(inqueryrequest.getEmail());
    }
    public List<Student>getbylike(String email){
       return studentrepo.findByEmailContains(email);
    }
    public List<Student>getsorting(){
        Sort sort=Sort.by(Sort.Direction.DESC,"name");
        return studentrepo.findAll(sort);
    }
    public Student getbybyemailandrank(String email,String rank){
        Student student= studentrepo.getByEmailAndRank(email, rank);
        System.out.println("student"+student);
        return student;
    }
    public Integer updaterankjpl(int id,String rank){
     return  studentrepo.updaterank(id,rank);
    }

//    public Student createonetoone(Student student){...one to one mapping
//        //Student student1=new Student();
//        Address address=new Address();
//        address.setCity(student.getCity());
//        address.setStreet(student.getStreet());
//        address=addressrepo.save(address);
//        student.setAddress(address);
//        return studentrepo.save(student);
//    }
//    public List<Student> getjoinquery(String city){//inner join
//            return studentrepo.getByAddressCity(city);
//    }
}
