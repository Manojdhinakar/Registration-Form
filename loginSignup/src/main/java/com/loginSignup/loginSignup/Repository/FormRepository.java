package com.loginSignup.loginSignup.Repository;

import com.loginSignup.loginSignup.Entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form,Integer> {
    Form findByEmail(String email);
}
