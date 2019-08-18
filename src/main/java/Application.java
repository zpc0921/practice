import utils.FileUtil;

import java.util.TimeZone;

public class Application {
    public static final String TIME_ZONE_ID = "GMT+8";

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(TIME_ZONE_ID));


    }
}
