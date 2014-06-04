package com.ouchadam.jogame.api;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CookieParserTest {

    private CookieParser cookieParser;

    String[] cookieHeaders = new String[]{
            "language=en; expires=Fri, 16-May-2014 11:46:59 GMT",
            "login_100217=U_en125%3AUSERNAME%3A480ae6e6d4b950624bcce133816a5726; expires=Sat, 19-Apr-2014 11:46:59 GMT; path=/",
            "prsess_100217=63498ae3fbae81e7433964cddb47ffbf; expires=Sat, 19-Apr-2014 11:46:59 GMT; path=/",
            "PHPSESSID=b4ed5c147131decd19253fis908a2ead6f402"
    };

    @Before
    public void setUp() throws Exception {
        cookieParser = new CookieParser();
    }

    @Test
    public void should_parse_the_correct_expiry() {
        Cookie parse = cookieParser.parse(cookieHeaders);

        assertThat(parse.expires()).isGreaterThan(0);
    }


    @Test
    public void should_parse_the_correct_fields() {
        Cookie parse = cookieParser.parse(cookieHeaders);

        assertThat(parse.export()).isEqualTo("PHPSESSID=b4ed5c147131decd19253fis908a2ead6f402; prsess_100217=63498ae3fbae81e7433964cddb47ffbf; login_100217=U_en125%3AUSERNAME%3A480ae6e6d4b950624bcce133816a5726;");
    }
}
