package edu.acc.java3.login;

public class UserAuthenticator {

    public static boolean authenticate(User user, String validUsername,
			String validPassword, String validId) {
        if (user == null || user.getUsername() == null ||
                user.getPassword() == null) {
            return false;
        }
        if (user.getUsername().equals(validUsername) &&
                user.getPassword().equals(validPassword)) {
            user.setId(Integer.parseInt(validId));
            return true;
        }
        return false;
    }
}
