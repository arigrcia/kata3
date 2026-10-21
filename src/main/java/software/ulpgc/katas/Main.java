package software.ulpgc.katas;

import software.ulpgc.katas.adapters.RandomUserBuilder;
import software.ulpgc.katas.domain.model.User;
import software.ulpgc.katas.ports.UserBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        UserBuilder builder = new RandomUserBuilder();
        List<User> users = builder.build(10);
        for (User user : users) {
            System.out.println(user);
        }
    }
}