package config;

public class Config {

    private static final String ENV_PROPERTIES = PropertyReader.getProperties("common.properties").getProperty("env.properties.file");
    private static final String CRED_PROPERTIES = PropertyReader.getProperties("common.properties").getProperty("cred.properties.file");
    public static final int EXPLICIT_WAIT_SMALL = Integer.parseInt(PropertyReader.getProperties(ENV_PROPERTIES).getProperty("explicit.wait.small"));
    public static final int EXPLICIT_WAIT_LARGE = Integer.parseInt(PropertyReader.getProperties(ENV_PROPERTIES).getProperty("explicit.wait.large"));
    public static final int IMPLICIT_WAIT = Integer.parseInt(PropertyReader.getProperties(ENV_PROPERTIES).getProperty("implicit.wait"));
    public static final String USER_NAME = PropertyReader.getProperties(CRED_PROPERTIES).getProperty("username");
    public static final String PASSWORD = PropertyReader.getProperties(CRED_PROPERTIES).getProperty("password");
    public static final String BROWSER = PropertyReader.getProperties("common.properties").getProperty("browser");
    public static final String URL= PropertyReader.getProperties(ENV_PROPERTIES).getProperty("url");
    public static final String CHROME_DRIVER_PATH = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("chrome.driver.path");
    public static final String FIREFOX_DRIVER_PATH = PropertyReader.getProperties(ENV_PROPERTIES).getProperty("firefox.driver.path");

    public static final String CHROME_WEBDRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    public static final String FIREFOX_WEBDRIVER_SYSTEM_PROPERTY = "webdriver.gecko.driver";
    public static final int ZERO = 0;


    static{
        System.out.println("\n---------------------Config----------------------------------");
        System.out.println("   env properties file:        "+ ENV_PROPERTIES);
        System.out.println("   cred properties file:       "+ CRED_PROPERTIES);
        System.out.println("   small explicit wait sec :   "+ EXPLICIT_WAIT_SMALL);
        System.out.println("   large explicit wait sec :   "+ EXPLICIT_WAIT_LARGE);
        System.out.println("   implicit wait sec :         "+ IMPLICIT_WAIT);
        System.out.println("   url:                        "+ URL);
        System.out.println("   user:                       "+ USER_NAME);
        System.out.println("   password:                   "+ PASSWORD);
        System.out.println("   browser:                    "+ BROWSER);
        System.out.println("------------------------------------------------------------\n");

    }

}
