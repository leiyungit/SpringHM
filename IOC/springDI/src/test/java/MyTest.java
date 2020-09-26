import com.itcast.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){

        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService ser = (IAccountService) app.getBean("accountService");
        ser.savaAccount();
    }

    @Test
    public void test02(){
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService ser = (IAccountService) app.getBean("accountService2");
        ser.savaAccount();
    }

    @Test
    public void test03(){
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService ser = (IAccountService) app.getBean("accountService3");
        ser.savaAccount();
    }
}
