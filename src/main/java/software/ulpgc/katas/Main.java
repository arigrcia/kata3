package software.ulpgc.katas;

import software.ulpgc.katas.adapters.JsonReportWriter;
import software.ulpgc.katas.adapters.RandomUserReader;
import software.ulpgc.katas.domain.model.Report;
import software.ulpgc.katas.domain.model.User;
import software.ulpgc.katas.ports.UserReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        UserReader reader = new RandomUserReader();
        try (InputStream input = new URL("https://randomuser.me/api/?results=10").openStream()) {
            List<User> users = reader.read(input);
            Report report = new Report(users.size(), LocalDate.now().toString(), users);
            new JsonReportWriter().write(report, System.out);
        }
    }
}