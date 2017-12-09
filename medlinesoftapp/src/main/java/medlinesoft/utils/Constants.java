package medlinesoft.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Constant items used in project
 */
public class Constants {
    public static final String MAIN_SERVLET_URL = "/main";
    public static final String PATH_TO_PART_JSP = "/WEB-INF/views/part.jsp";

    public static final String SQL_ERROR_MESSAGE = "SQL error occurred while accessing database:";
    public static final String PARSER_ERROR_MESSAGE = "error while parsing date, use pattern MMM dd, yyyy: ";

    public static SimpleDateFormat getDateFormatter(){
        return new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
    }
}
