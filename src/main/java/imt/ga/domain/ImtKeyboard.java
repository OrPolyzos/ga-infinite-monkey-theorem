package imt.ga.domain;

import java.util.Random;

public class ImtKeyboard {

    private static final char[] KEYBOARD = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ ,.?:;'-—\n".toCharArray();

    public static Character getRandomCharacterFromKeyboard() {
        return KEYBOARD[new Random().nextInt(KEYBOARD.length)];
    }

    public static String getRandomPhrase(int phraseSize) {
        StringBuilder newPhrase = new StringBuilder();
        for (int i = 0; i < phraseSize; i++) {
            newPhrase.append(getRandomCharacterFromKeyboard());
        }
        return newPhrase.toString();
    }
}
