package software.ulpgc.katas.domain.model;

public record User(String name, Gender gender, String email) {

    public enum Gender {
        male, female
    }
}