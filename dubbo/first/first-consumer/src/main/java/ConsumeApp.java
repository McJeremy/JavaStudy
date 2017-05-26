import com.sun.xml.internal.bind.v2.model.core.ID;
import com.xuzz.study.dubbo.first.api.service.IDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by win10 on 2017/5/26.
 */
public class ConsumeApp {
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();
        IDemoService service=(IDemoService)context.getBean("demoService");
        System.out.println("consumer");
        System.out.println(service.getPermissions(1L));
    }
}
