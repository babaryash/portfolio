package com.yash.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yash.portfolio.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}