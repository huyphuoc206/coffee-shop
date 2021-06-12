package main;

import model.Role;

public class Program {
    public static void main(String[] args) {
        System.out.println("hello coffee shop");
        String role = "USER";
        System.out.println(role == Role.USER.name());
    }
}
