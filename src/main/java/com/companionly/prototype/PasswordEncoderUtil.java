package com.companionly.prototype;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Scanner;

public class PasswordEncoderUtil {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter raw password:");
        String rawPassword = scanner.nextLine();

        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);

        scanner.close();
    }
}
