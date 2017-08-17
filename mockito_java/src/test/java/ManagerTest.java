import com.sudojava.mockito.domain.Manager;
import com.sudojava.mockito.service.ManagerService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManagerTest {

    ManagerService managerService;

    @Before
    public void setup() {
        //构建mock的假对象ManagerService.class
        managerService = mock(ManagerService.class);
    }

    @Test
    public void queryManager() {
        Manager manager1 = new Manager("1001", "jack", 10011);
        Manager manager2 = new Manager("1002", "tom", 10012);
        Manager manager3 = new Manager("1003", "rose", 10013);
        List<Manager> list = new ArrayList<Manager>();
        list.add(manager1);
        list.add(manager2);
        list.add(manager3);
        managerService.setManagers(list);
        //假设条件成立，就返回jack
        when(managerService.findManagerNameByID("1001")).thenReturn("laoluo");
        when(managerService.findManagerNameByID("1004")).thenThrow(new RuntimeException("找不到指定的对象"));
        //String name = managerService.findManagerNameByID("1001");

        //System.out.println("name--->>" + name);
        managerService.findManagerNameByID("1004");
    }


}
