package org.springframework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author leellun
 * @date 2020/4/14 16:39
 * @desc
 */
public class PropertiesConfig {

    private Properties properties = new Properties();

    public PropertiesConfig() {
        initProperties();
    }

    public void initProperties(){
        //通过URL定位找到其所对应的文件，然后转换为文件流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        // 使用InPutStream流读取properties文件
        try {
            if (null != is){
                properties.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getPort(){
        try {
            if (properties.getProperty("server.port") != null){
                return Integer.valueOf(properties.getProperty("server.port")) ;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 8080;
    }

    public String getContextPath(){
        try {
            if (properties.getProperty("server.path") != null){
                return properties.getProperty("server.path");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/";
    }
}
