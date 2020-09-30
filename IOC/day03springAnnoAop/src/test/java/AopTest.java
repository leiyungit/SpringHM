import com.itcast.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void testSaveAccount(){
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:bean.xml");
        IAccountService accountService = (IAccountService) app.getBean("accountService");
        //accountService.updateAccount(1f);
        //accountService.saveAccount();

        accountService.countAccount();
    }
}
