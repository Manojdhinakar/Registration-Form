package com.loginSignup.loginSignup.Service;

import com.loginSignup.loginSignup.Dao.FormDao;
import com.loginSignup.loginSignup.Entity.Form;
import com.loginSignup.loginSignup.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    FormDao dao;

    public Form saveForm(Form form){
        return dao.saveForm(form);
    }
    public Form findByEmail(String email){
        return dao.findByEmail(email);
    }
}
