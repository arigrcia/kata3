package software.ulpgc.katas.domain.model;

import java.util.List;

public record Report(int total, String generatedAt, List<User> users) {
}