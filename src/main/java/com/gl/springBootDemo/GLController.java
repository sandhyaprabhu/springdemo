package com.gl.springBootDemo;

import com.gl.springBootDemo.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class GLController {

    HashMap<String, Object> response = new HashMap<>();

    @RequestMapping(value="/v0/getMessage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getMessage1(){
       return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Successful Message 1"));
    }
    @RequestMapping(value="/v0/sendMessage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object postMessage1(
            @RequestParam (required = true) String firstName,
            @RequestParam (required = false) String middleName,
            @RequestParam (required = true) String lastName){
        if(firstName.isEmpty() || lastName.isEmpty()){
            response.put("Error","First Name and Last Name is mandatorygit");
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
           // return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("First Name Required"));
        }
        response.put("Success","Send Message"+ " for " +firstName + " " +lastName);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
      //  return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Successful Post Message1"+ " for " +firstName + " " +lastName) );
    }
}
