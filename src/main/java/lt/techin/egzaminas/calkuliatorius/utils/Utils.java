package lt.techin.egzaminas.calkuliatorius.utils;

import java.util.Random;

public class Utils {
    private static final String[] FIRST_NAMES = {
            "Galva1", "Apuokas", "Audra1", "Mikis", "Joglis", "Chiukcia", "Gudzius", "Jessica1", "Vaiva", "Jurga", "Marius"
    };

    private static final Random RANDOM = new Random();

    public static String generateFistName() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    }


    public static String generatePassword() {
        int lenght = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder passowrd = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++) {
            passowrd.append(characters.charAt(RANDOM.nextInt(characters.length())));
        }
        return passowrd.toString();
    }
}