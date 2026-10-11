package com.mcnz.jdbc.sqlserver;
import java.util.Scanner;

/**
 * Sign Up store the new user in the database and the OTP Message not connecting with email or mobile phone we standarized the OTP as 123456
 * @author abdallah kareem
 * @version 1.0
 */

public class SignUp {

    private final AccountController signUpService;
    private final SignUpUserRepository userRepository;

    public SignUp() {
        this.signUpService = new AccountController();
        this.userRepository = new SignUpUserRepository();
    }

    public void startSignUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!signUpService.validateCredentials(email, username, password)) {
            System.out.println(" Invalid input. Try again.");
            return;
        }

        String otp = signUpService.sendOTP(email);

        System.out.print("Enter OTP received: ");
        String inputOtp = scanner.nextLine();

        if (signUpService.verifyOTP(inputOtp, otp)) {
            User user = signUpService.registerUser(email, username, password);
            userRepository.save(user);
            UserContext.getInstance().setCurrentUser(user);
            System.out.println(" Sign up successful! Welcome, " + user.getUserName());
        } else {
            System.out.println(" Incorrect OTP. Registration failed.");
        }
    }
}
