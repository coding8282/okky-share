package org.okky.share.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class JsonUtil {
    static Gson GSON = new Gson();
    static Gson GSON_PRETTY = new GsonBuilder().setPrettyPrinting().create();

    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    public static String toPrettyJson(Object source) {
        return GSON_PRETTY.toJson(source);
    }

    public static String toJson(Object source) {
        return GSON.toJson(source);
    }
}
