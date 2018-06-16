package org.okky.share.util;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.okky.share.TestMother;

import java.util.List;

import static java.util.Arrays.asList;
import static lombok.AccessLevel.PUBLIC;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JsonUtilTest extends TestMother {
    @Test
    public void fromJson() {
        String json = "{\"name\":\"현수\",\"email\":\"coding8282@gmail.com\",\"description\":\"구직 중입니다. 연락주세요.\",\"skills\":[\"Java\",\"Spring\",\"DDD\"]}";

        Person p = JsonUtil.fromJson(json, Person.class);
        assertEquals("", p.name, "현수");
        assertEquals("", p.email, "coding8282@gmail.com");
        assertEquals("", p.description, "구직 중입니다. 연락주세요.");
        assertThat("", p.skills, contains("Java", "Spring", "DDD"));
    }

    @Test
    public void toJson() {
        Person person = new Person("현수", "coding8282@gmail.com", "구직 중입니다. 연락주세요.", asList("Java", "Spring", "DDD"));
        String s = JsonUtil.toJson(person);

        assertEquals("Json 표현이 틀림", s, "{\"name\":\"현수\",\"email\":\"coding8282@gmail.com\",\"description\":\"구직 중입니다. 연락주세요.\",\"skills\":[\"Java\",\"Spring\",\"DDD\"]}");
    }

    @Test
    public void toPrettyJson() {
        Person person = new Person("현수", "coding8282@gmail.com", "구직 중입니다. 연락주세요.", asList("Java", "Spring", "DDD"));
        String s = JsonUtil.toPrettyJson(person);

        assertEquals("Json 표현이 틀림", s, "{\n" +
                "  \"name\": \"현수\",\n" +
                "  \"email\": \"coding8282@gmail.com\",\n" +
                "  \"description\": \"구직 중입니다. 연락주세요.\",\n" +
                "  \"skills\": [\n" +
                "    \"Java\",\n" +
                "    \"Spring\",\n" +
                "    \"DDD\"\n" +
                "  ]\n" +
                "}");
    }
}

@AllArgsConstructor
@FieldDefaults(level = PUBLIC)
class Person {
    String name;
    String email;
    String description;
    List<String> skills;
}
