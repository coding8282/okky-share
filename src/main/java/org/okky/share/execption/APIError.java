package org.okky.share.execption;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static java.lang.String.format;
import static lombok.AccessLevel.PRIVATE;
import static org.okky.share.domain.AssertionConcern.assertArgNotEmpty;
import static org.okky.share.util.JsonUtil.toPrettyJson;

@FieldDefaults(level = PRIVATE)
@Getter
public class APIError {
    String service;
    String code;
    String message;
    String moreInfo;

    public APIError(String service, String code, String message) {
        setService(service);
        setCode(code);
        setMessage(message);
        setMoreInfo();
    }

    public static void main(String[] args) {
        System.out.println(toPrettyJson(sample()));
    }

    public static APIError sample() {
        return new APIError("okky-finance", "10001", "더 이상 진행할 수 없습니다: java.lang.IllegalArguments...");
    }

    // -----------------------------------------------
    private void setService(String service) {
        assertArgNotEmpty(service, "서비스명은 필수입니다. 어떤 오류를 내리는지 명확히 정의해주세요. ex) okky-finance");
        String trimed = service.trim();
        if (!trimed.startsWith("okky-"))
            throw new BadArgument("서비스명은 접두사가 'okky-'로 시작해야 합니다 ex) okky-finance, okky-member, okky-notification");
        this.service = trimed;
    }

    private void setCode(String code) {
        assertArgNotEmpty(code, "서비스 오류 코드는 필수입니다. ex) 10001");
        String trimed = code.trim();
        this.code = trimed;
    }

    private void setMessage(String message) {
        if (message == null) {
            this.message = "";
        } else {
            String trimed = message.trim();
            this.message = format("%1.100s", trimed).trim();
        }
    }

    private void setMoreInfo() {
        this.moreInfo = format("http://dev.okky.org/errors/%s", code);
    }
}
