import com.xiyou.email.entities.InfoRecord;
import com.xiyou.email.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:dispatcherServlet-servlet.xml","classpath:applicationContext.xml","classpath:applicationContext-bean.xml"})
public class TestEmailService {

    @Autowired
    private EmailService emailService;

    @Test
    public void testAddInfoRecord(){
        InfoRecord infoRecord = new InfoRecord();
        infoRecord.setReceiver("haha");
        emailService.addInfoRecord(infoRecord);
    }

}
