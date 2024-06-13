package com.loginSignup.loginSignup.Dao;

import com.loginSignup.loginSignup.Entity.Form;
import com.loginSignup.loginSignup.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FormDao {
    @Autowired
    FormRepository repo;

    public Form saveForm(Form form){
        return repo.save(form);
    }
    public Form findByEmail(String email){
        return repo.findByEmail(email);
    }
}
