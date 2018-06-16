package org.okky.share.domain;

import org.okky.share.execption.BadArgument;

public interface AssertionConcern {
    static void assertArgEquals(Object obj1, Object obj2, String message) {
        if (!obj1.equals(obj2))
            throw new BadArgument(message);
    }

    static void assertArgLength(String str, int maximum, String message) {
        int length = str.trim().length();
        if (length > maximum)
            throw new BadArgument(message);
    }

    static void assertArgLength(String str, int minimum, int maximum, String message) {
        int length = str.trim().length();
        if (length < minimum || length > maximum)
            throw new BadArgument(message);
    }

    static void assertArgLength(String str, long minimum, long maximum, String message) {
        int length = str.trim().length();
        if (length < minimum || length > maximum)
            throw new BadArgument(message);
    }

    static void assertArgNotEmpty(String str, String message) {
        if (str == null || str.trim().isEmpty())
            throw new BadArgument(message);
    }

    static void assertArgNotEquals(Object obj1, Object obj2, String message) {
        if (obj1.equals(obj2))
            throw new BadArgument(message);
    }

    static void assertArgNotNull(Object obj, String message) {
        if (obj == null)
            throw new BadArgument(message);
    }

    static void assertArgRange(double value, double minimum, double maximum, String message) {
        if (value < minimum || value > maximum)
            throw new BadArgument(message);
    }

    static void assertArgRange(float value, float minimum, float maximum, String message) {
        if (value < minimum || value > maximum)
            throw new BadArgument(message);
    }

    static void assertArgRange(int value, int minimum, int maximum, String message) {
        if (value < minimum || value > maximum)
            throw new BadArgument(message);
    }

    static void assertArgRange(long value, long minimum, long maximum, String message) {
        if (value < minimum || value > maximum)
            throw new BadArgument(message);
    }

    static void assertArgNonNegative(long value, String message) {
        if (value < 0)
            throw new BadArgument(message);
    }
}
