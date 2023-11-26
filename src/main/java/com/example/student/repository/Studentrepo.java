package com.example.student.repository;

import com.example.student.entity.Address;
import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Studentrepo extends JpaRepository<Student,Integer> {
    List<Student>findByEmail(String email);
Student findByEmailAndRank(String email,String rank);

List<Student>findByRankOrName(String rank,String name);
List<Student>findByEmailIn(List<String>email);
List<Student>findByEmailContains(String email);
 @Query("from Student where email= ?1 and rank=?2")//,,,,native query//
Student getByEmailAndRank(String email,String rank);
 @Modifying
 @Transactional
 @Query("update Student set rank=:rank where id=:id")
 Integer updaterank(@Param("id")int id, @Param("rank")String rank);

     //List<Student>findByAddressCity(String city);//innerjoin
// @Query("from Student where address.city:=city")//native query for innerjoin
// List<Student>getByAddressCity(String city);

}
