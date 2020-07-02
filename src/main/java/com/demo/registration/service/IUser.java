package com.demo.registration.service;

import com.demo.registration.model.Customer;

public interface IUser {
    public Customer setSession(String userName, String password);
    public int setData(String userName, String address, String password, String emailId);
}
