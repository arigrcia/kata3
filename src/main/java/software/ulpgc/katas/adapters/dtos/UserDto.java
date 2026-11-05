package software.ulpgc.katas.adapters.dtos;

public class UserDto {
    public String gender;
    public Name name;
    public String email;

    public static class Name {
        public String first;
        public String last;
    }
}