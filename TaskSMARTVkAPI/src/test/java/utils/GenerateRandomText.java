package utils;

public class GenerateRandomText {
    public String generatingLetters(int Letters) {
        RandomTextUtil passwordGenerator = new RandomTextUtil.PasswordGeneratorBuilder()
                .useLower(true)
                .useUpper(true)
                .useDigits(true)
                .build();
        return passwordGenerator.generate(Letters);
    }
}
