package com.springboot.demo.spring.boot.demo.Util;

import java.util.Objects;

public class UtilClass {

    public static boolean notNullAndEmpty(String string) {
        return Objects.nonNull(string) && !"".equalsIgnoreCase(string);
    }
}
