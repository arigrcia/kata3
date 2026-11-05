package software.ulpgc.katas.ports;

import software.ulpgc.katas.domain.model.User;

import java.io.InputStream;
import java.util.List;

public interface UserReader {
    List<User> read(InputStream input);
}