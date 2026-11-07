package software.ulpgc.katas.adapters;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import software.ulpgc.katas.adapters.dtos.UserDto;
import software.ulpgc.katas.domain.model.User;
import software.ulpgc.katas.ports.UserReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RandomUserReader implements UserReader {
    private final Gson gson = new Gson();

    @Override
    public List<User> read(InputStream input) {
        try {
            JsonObject json = gson.fromJson(new InputStreamReader(input, StandardCharsets.UTF_8), JsonObject.class);
            if (json == null || !json.has("results")) return List.of();
            List<User> users = new ArrayList<>();
            for (JsonElement element : json.getAsJsonArray("results")) {
                UserDto dto = gson.fromJson(element, UserDto.class);
                if (isValid(dto)) users.add(toUser(dto));
            }
            return users;
        } catch (JsonParseException e) {
            return List.of();
        }
    }

    private boolean isValid(UserDto dto) {
        return dto.name != null
                && !isEmpty(dto.name.first)
                && !isEmpty(dto.name.last)
                && ("male".equals(dto.gender) || "female".equals(dto.gender))
                && !isEmpty(dto.email);
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }

    private User toUser(UserDto dto) {
        return new User(
                dto.name.first + " " + dto.name.last,
                User.Gender.valueOf(dto.gender),
                dto.email
        );
    }
}