package com.gl.springBootDemo;

import com.gl.springBootDemo.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GLController {

    @RequestMapping(value="/v0/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getMessage1(){
       return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Successful Message 1"));
    }
    @RequestMapping(value="/v1/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object postMessage1(
            @RequestParam (required = true, defaultValue = "Smith") String firstName,
            @RequestParam (required = false) String lastName){
        if(firstName.isEmpty()){
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("First Name Required"));
        }
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("Successful Post Message1"+ " for " +firstName + " " +lastName) );
    }
}
