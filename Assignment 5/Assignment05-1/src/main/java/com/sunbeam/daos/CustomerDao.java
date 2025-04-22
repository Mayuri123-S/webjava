package com.sunbeam.daos;
import com.sunbeam.entities.Customer;

import java.util.*;

public interface CustomerDao {
    List<Customer> findAll();
}
