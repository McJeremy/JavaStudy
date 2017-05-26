import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by win10 on 2017/5/26.
 */
public class App {
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();
        System.out.println("服务已经启动...");
        try {
            System.in.read();
        }catch (IOException e){}
        
    }
}
