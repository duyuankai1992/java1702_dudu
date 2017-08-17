import com.sudojava.mockito.application.MathService;
import com.sudojava.mockito.service.CalService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static  org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    @InjectMocks
    MathService mathService = new MathService();

    @Mock
    CalService calService;

    //使用Mock可以模拟任何的假对象
    private List<String> list;

    @Before
    public void init(){
        list = mock(List.class);
        list.add("jack");
    }

    @Test
    public void testadd(){
     when(calService.add(12,10)).thenReturn(22);
     int result = mathService.add(12,10);
     //断言
        Assert.assertEquals(23,result);
    }
    @Test
    public void testlist(){
        when(list.get(0)).thenReturn("rose");
        String result = list.get(0);
        System.out.println(result);

    }
}
