package org.okky.share.domain;

import org.junit.Test;
import org.okky.share.TestMother;
import org.okky.share.execption.BadArgument;

public class AssertionConcernTest extends TestMother {
    @Test
    public void assertArgLength_max를_초과했을_때_예외() {
        expect(BadArgument.class, "예외");

        AssertionConcern.assertArgLength("12345", 4, "예외");
    }

    @Test
    public void assertArgLength_공백을_무시하는지_확인() {
        AssertionConcern.assertArgLength(" 1234 ", 4, "예외");
    }

    @Test
    public void assertArgLength_너무_짧을_때_예외() {
        expect(BadArgument.class, "예외");

        AssertionConcern.assertArgLength("1234", 5, 10, "예외");
    }

    @Test
    public void assertArgLength_너무_길_때_예외() {
        expect(BadArgument.class, "예외");

        AssertionConcern.assertArgLength("12345678901", 5, 10, "예외");
    }

    @Test
    public void assertArgNotNull_null이면_예외() {
        expect(BadArgument.class, "예외");

        AssertionConcern.assertArgNotNull(null, "예외");
    }

    @Test
    public void assertArgNonNegative_음수이면_예외() {
        expect(BadArgument.class, "예외");

        AssertionConcern.assertArgNonNegative(-1L, "예외");
    }
}
