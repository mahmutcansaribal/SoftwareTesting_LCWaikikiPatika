import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    private String email;
    private String password;

    public TestConfig() {
        Properties properties = new Properties();
        try {
            // config.properties dosyasını oku
            FileInputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);

            // email ve şifreyi al
            email = properties.getProperty("email");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
