/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lai.dev.data.faker;

import java.util.Random;

public class UserFaker {
    private String email;
    private String password;
    private String role;

    public UserFaker() {
        this.email = getRandomEmail();
        this.password = getRandomPassword();
        this.role = getRandomRole();
    }

    // Hàm tạo email ngẫu nhiên
    private String getRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder email = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            email.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return email.toString() + "@example.com";
    }

    // Hàm tạo password ngẫu nhiên
    private String getRandomPassword() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder password = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return password.toString();
    }

    // Hàm tạo role ngẫu nhiên
    private String getRandomRole() {
        String[] roles = {"user", "admin", "guest"};
        Random rand = new Random();
        return roles[rand.nextInt(roles.length)];
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}


