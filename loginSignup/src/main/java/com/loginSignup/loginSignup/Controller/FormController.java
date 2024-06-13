package com.loginSignup.loginSignup.Controller;

import com.loginSignup.loginSignup.Entity.Form;
import com.loginSignup.loginSignup.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class FormController {
    @Autowired
    FormService service;

    @PostMapping("/register")
    public ResponseEntity<Form> saveForm(@RequestBody Form form){
        Form existingUser = service.findByEmail(form.getEmail());
        if(existingUser != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Form savedForm = service.saveForm(form);
        return  ResponseEntity.ok(savedForm);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> loginUser(@RequestBody Form form){
        Form existingUser = service.findByEmail(form.getEmail());
        Map<String, Object> response = new HashMap<>();
        if (existingUser != null && existingUser.getPassword().equals(form.getPassword())) {
            response.put("success", true);
            response.put("message", "Login successful");
            response.put("user", existingUser);  // Optionally include user details
            return ResponseEntity.ok(response);
        }

        response.put("success", false);
        response.put("message", "Invalid email or password");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    }

