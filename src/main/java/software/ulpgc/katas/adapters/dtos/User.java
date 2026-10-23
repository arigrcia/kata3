package software.ulpgc.katas.adapters.dtos;

public class User {
    public String gender;
    public Name name;
    public Location location;
    public String email;
    public String phone;
    public Picture picture;

    public static class Name {
        public String title;
        public String first;
        public String last;

    }

    public static class Location {
        public Street street;
        public String city;
        public String state;
        public String country;
        public String postcode;

    }

    public static class Street {
        public int number;
        public String name;

    }

    public static class Picture {
        public String large;
        public String medium;
    }
}