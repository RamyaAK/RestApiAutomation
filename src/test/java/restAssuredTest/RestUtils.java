package restAssuredTest;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

    public static String getName(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return("morpheus"+generatedString);
    }

    public static String getJob(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return("leader"+generatedString);
    }

    public static String getUpdatedName(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return("John"+generatedString);
    }

    public static String getUpdatedJob(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return("zion resident"+generatedString);
    }

    public static String getEmailId(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return("eve"+generatedString+".holt@reqres.in");
    }

    public static String getPassword(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return("pistol"+generatedString);
    }



}
