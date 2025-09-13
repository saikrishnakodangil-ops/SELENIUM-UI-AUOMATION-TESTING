package com.newberry.util;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Consts {
    /**
     * Date of Birth Format.
     */
    public static final String DOB_FORMAT = "MM/dd/yyyy";

    /**
     * Date of birth formatter.
     */
    public static final DateTimeFormatter DOB_FORMATTER = DateTimeFormat.forPattern(Consts.DOB_FORMAT);
}
