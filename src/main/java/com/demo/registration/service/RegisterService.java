package com.demo.registration.service;

import com.demo.registration.interfaces.ICustomerOperation;
import com.demo.registration.model.Customer;
import com.demo.registration.repository.CustomerOperationImplementation;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    static String NAME_PATTERN = "^[A-Z][a-z]{2,}$";
    static String ADDRESS_PATTERN = "^[A-Z][a-z]{1,}$";
    static String REGEX_PASSWORD = "^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9\\W\\_]{8,})$";
    static String EMAIL_ID = "^\\w{3,}([-._+]\\w+)?@\\w+.[a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$";

    ICustomerOperation cd = new CustomerOperationImplementation();

    Customer customer = new Customer();

    public int setData(String userName, String address, String password, String emailId) {
        System.out.println("Inside setdata");
        customer.setUserName(userName);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setEmailId(emailId);
        int i = checkValidationPattern(userName, password, address, emailId);
        return i;
    }

    public int checkValidationPattern(String userName, String password, String address, String emailId) {
        System.out.println("Inside validation");
        boolean nameMatch = userName.matches(NAME_PATTERN);
        boolean passwordMatch = password.matches(REGEX_PASSWORD);
        boolean addressMatch = address.matches(ADDRESS_PATTERN);
        boolean emailMatch = emailId.matches(EMAIL_ID);

        if (nameMatch && passwordMatch && addressMatch && emailMatch){
            int result = cd.insertCustomer(customer);
            return result;
        }
        return 0;
    }
}
