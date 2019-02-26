package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties get(String fileName) {
        Properties prop = new Properties();
        InputStream input = getInputStream(fileName);
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        return prop;
    }


        private static InputStream getInputStream(String path){
            try{
                InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(path);
                if(input==null){
                    throw new IOException();
                }
                return input;
            } catch (IOException ex) {
                throw new RuntimeException("can not read file:" + path);
            }
        }



    public static Properties getProperties(String path){
        return get(path);
    }

}