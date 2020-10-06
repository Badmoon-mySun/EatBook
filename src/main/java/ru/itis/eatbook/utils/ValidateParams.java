package ru.itis.eatbook.utils;

import java.util.regex.Pattern;

public class ValidateParams {
    private static Pattern nameParent = Pattern.compile("^[А-Яа-яЁёA-Za-z]+$");
    private static Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static Pattern phoneParent = Pattern.compile("(\\+7)+[0-9]{10}");
    private static Pattern agePattern = Pattern.compile("[1-9]{1,2}|(1[1-2][1-9])");

    public static boolean phoneValid(String phoneNum) {
        return phoneParent.matcher(phoneNum).matches();
    }

    public static boolean usernameValid(String username) {
        return nameParent.matcher(username).matches();
    }

    public static boolean emailValid(String email) {
        return emailPattern.matcher(email).matches();
    }

    public static boolean ageValidate(String age) {
        return agePattern.matcher(age).matches();
    }

    public static boolean genderValidate(String gender) {
        return gender.equals("Man") || gender.equals("Woman");
    }
}
