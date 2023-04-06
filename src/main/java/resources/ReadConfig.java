package resources;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    public ReadConfig(){
        File src=new File("./configuration/config.properties");
        try{
            FileInputStream _file=new FileInputStream(src);
            properties=new Properties();
            properties.load(_file);
        }catch(Exception e){System.out.println("sorry file not uploaded"+e.getMessage());}

    }
    public String getBaseUrl(){
        String baseUrl=properties.getProperty("baseUrl");
        return baseUrl;
    }
    public String lunchBrowser(){
        String browser=properties.getProperty("driver");
        return browser;
    }
    public String getEmail(){
       String email = properties.getProperty("email");
       return email;
    }
    public String getPassword(){
        String password=properties.getProperty("password");
        return password;
    }

}
