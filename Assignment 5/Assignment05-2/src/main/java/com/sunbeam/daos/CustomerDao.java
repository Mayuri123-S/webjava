package com.sunbeam.daos;

import com.sunbeam.entities.Customer;

public interface CustomerDao {
    Customer findByEmailAndPassword(String email, String password);
}
