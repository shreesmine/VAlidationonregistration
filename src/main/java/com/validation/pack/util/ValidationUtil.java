package com.validation.pack.util;


public class ValidationUtil {

    public static boolean validateName(String name) {
        // Implement name validation
        // Example: Assuming name should contain first name, last name, and surname separated by spaces
    	return name.matches("^[a-zA-Z]{3,}\\s+[a-zA-Z]{3,}\\s+[a-zA-Z]{3,}$");
    }

    public static boolean validateContactNumber(String contactNumber) {
        // Implement contact number validation
        // Example: Assuming contact number should start with 7, 8, or 9 and be 10 digits long
        return contactNumber.matches("^[7-9]\\d{9}$");
    }

    public static boolean validateUsername(String username) {
        // Implement username validation
        // Example: Assuming username should have at least one uppercase letter and be 8 characters long
        return username.matches("^(?=.*[A-Z]).{8,}$");
    }

    public static boolean validatePassword(String password) {
        // Implement password validation
        // Example: Password should have at least one uppercase, one lowercase, one digit, one special character, and be 8 characters long
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

}

