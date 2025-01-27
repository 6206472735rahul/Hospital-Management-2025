package com.SampleProject.Hospital_Management.Controller;

import com.SampleProject.Hospital_Management.Model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/Doctor/api")
public class DoctorController {
    // here we are using Hashmap in the place of database
    // 1--><1,Dr.Parmod,parmod@123,cardiologist>
    // 2--><2,Dr.parveen,parveen@123,dentist>
    // 3--><3,Dr.Aryan,Aryan@123,orthologist>
    HashMap<Integer, Doctor> map= new HashMap<>();
//print like this= 1--><1,Dr.Parmod,parmod@123,cardiologist>
    // use post http method to save the data in HashMap(database)
    @PostMapping("/save")
    //@RequestBody:- takes the Json input from postman and assign the value at doctor object
    public String savedoctor(@RequestBody Doctor doctorRequest){
        map.put(doctorRequest.getId(),doctorRequest);
        return "Doctor saved successfully";

    }

    // find a doctorById
    //@PathVariable used for single input
    @GetMapping("/find/{id}")
    public Doctor findById(@PathVariable int id){
      Doctor Docfound=  map.get(id);
      return Docfound;

    }

    // find all doctor
    @GetMapping("/findAll")
    public HashMap<Integer,Doctor> findAlldoctors(){
        return map;

    }
// if we wanna update/edit all the things through
    // id
    // step1-> firstly check id is present in HashMap(database)or not
    //step2--> it is present then update it using @putMapping
    @PutMapping("/updateAll/{id}")
    public String UpdateAlldoctors(@PathVariable int id,@RequestBody Doctor doctor){
        Doctor idPresent= map.get(id);
        if(idPresent==null){
            // id is not present in HashMap(db)
            return "We can't update  here";
        }
        else{
            // yes id is present in HashMap(db)
            map.put(doctor.getId(),doctor);
            return "We can update here";
            // internally update all the thing
            // because key should be always unique in hashmap
            // if we get duplicate key then it will update with current value
        }

    }
    // delete All the doctors through id using @DeleteMapping
    @DeleteMapping("/deleteAll/{id}")
    public String deleteAlldoctors(@PathVariable int id){
        map.remove(id);
        return"Doctors deleted successfully";

    }


}
