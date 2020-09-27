
import com.itcast.dao.IAccountDao;
import com.itcast.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UiTest {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(app);
        IAccountService ser = (IAccountService) app.getBean("accountServiceImpl");

        //System.out.println(ser);
        //IAccountDao dao = app.getBean("accountDao", IAccountDao.class);
        //System.out.println(dao);
        ser.savaAccount();
        app.close();
    }
}
