package software.ulpgc.katas;

import software.ulpgc.katas.adapters.JsonReportWriter;
import software.ulpgc.katas.adapters.RandomUserReader;
import software.ulpgc.katas.domain.model.Report;
import software.ulpgc.katas.domain.model.User;
import software.ulpgc.katas.ports.UserReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        UserReader reader = new RandomUserReader();
        try (InputStream input = new URL("https://randomuser.me/api/?results=10").openStream();
             OutputStream output = new FileOutputStream("output.json")) {
            List<User> users = reader.read(input);
            Report report = new Report(users.size(), LocalDate.now().toString(), users);
            new JsonReportWriter().write(report, output);
        }
        System.out.println("JSON generado en output.json");
    }
}