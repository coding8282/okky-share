package org.okky.share.execption;

import lombok.experimental.FieldDefaults;
import org.junit.Before;
import org.junit.Test;
import org.okky.share.TestMother;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;


@FieldDefaults(level = PRIVATE)
public class APIErrorTest extends TestMother {
    String message;

    @Before
    public void setUp() {
        message = "objc[68484]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_131." +
                "jdk/Contents/Home/bin/java (0x1065954c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/l" +
                "ibinstrument.dylib (0x1066854e0). One of the two will be used. Which one is undefined. objc[68484]: Class JavaLaunchHelper " +
                "is implemented in both /Library/JavaJavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/bin/java (0x1065954c0) and /Library/" +
                "Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/";

        assertThat("먼저 테스트할 메시지는 100자를 초과해야 한다.", message.length(), greaterThan(100));
    }

    @Test
    public void new_service명이_null이면_예외() {
        expect(BadArgument.class, "서비스명은 필수입니다. 어떤 오류를 내리는지 명확히 정의해주세요. ex) okky-finance");

        APIError error = new APIError(null, "10001", message);
    }

    @Test
    public void new_service명이_빈문자열이면_예외() {
        expect(BadArgument.class, "서비스명은 필수입니다. 어떤 오류를 내리는지 명확히 정의해주세요. ex) okky-finance");

        APIError error = new APIError(null, "10001", message);
    }

    @Test
    public void new_service명이_okky로_시작하지_않으면_예외() {
        expect(BadArgument.class, "서비스명은 접두사가 'okky-'로 시작해야 합니다 ex) okky-finance, okky-member, okky-notification");

        new APIError("AlsongDalsong-artist", "10001", message);
    }

    @Test
    public void new_code가_null이면_예외() {
        expect(BadArgument.class, "서비스 오류 코드는 필수입니다. ex) 10001");

        APIError error = new APIError("okky-finance", null, message);
    }

    @Test
    public void new_code가_빈문자열이면_예외() {
        expect(BadArgument.class, "서비스 오류 코드는 필수입니다. ex) 10001");

        APIError error = new APIError("okky-finance", "", message);
    }

    @Test
    public void new_message가_100자를_초과했을_때_100자까지만_잘리는지_확인() {
        APIError error = new APIError("okky-music", "10001", message);

        assertThat("아무리 길어도 최대 100자까지만 잘려야 한다.", error.getMessage().length(), equalTo(100));
        assertThat("아무리 길어도 최대 100자까지만 잘려야 한다.", error.getMessage(), equalTo("objc[68484]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8."));
    }

    @Test
    public void new_message가_null일_때_message는_빈문자열이여야_함() {
        APIError error = new APIError("okky-music", "10001", null);

        assertThat("null이면 빈문자열로 치환해야 한다.", error.getMessage(), equalTo(""));
    }

    @Test
    public void 값이_정확히_할당되는지_확인() {
        APIError error = new APIError("okky-finance", "10001", "더 이상 진행할 수 없습니다: java.lang.IllegalArguments...");

        assertThat("서비스명이 틀리다.", error.getService(), equalTo("okky-finance"));
        assertThat("오류 코드가 틀리다.", error.getCode(), equalTo("10001"));
        assertThat("오류 설명 호스트가 틀린다.", error.getMessage(), equalTo("더 이상 진행할 수 없습니다: java.lang.IllegalArguments..."));
    }
}