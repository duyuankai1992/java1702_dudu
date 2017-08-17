import com.sudojava.mockito.domain.Todos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-config.xml", "classpath:spring-mvc.xml"})
public class ApplicationTest {

    private Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testadd() throws Exception {
        //模拟表单对象
        Todos todos = new Todos();
        todos.setDescription("insert todo");
        todos.setTitle("todo title");
        todos.setVersion(1009);
        //执行表单的post请求
        mockMvc.perform(
                MockMvcRequestBuilders.post("/add")
                        .param("description", todos.getDescription())
                        .param("title", todos.getTitle())
                        .param("version", todos.getVersion() + "")
        ).andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void testDel() throws Exception {

        //执行get请求
        int result = mockMvc.perform(MockMvcRequestBuilders.get("/del/3"))
                .andReturn().getResponse().getStatus();
        Assert.assertEquals(200, result);
    }

    @Test
    public void find() throws Exception{
//       ModelAndView model =  mockMvc.perform(
//                 MockMvcRequestBuilders.post("/query")
//                 .param("title","WW")
//         ).andReturn().getModelAndView();
//       //日志的级别 按照从小到大顺序 info-->debug-->warn-->error
//        logger.info("--getViewName->>",model.getViewName());
//        logger.info("--->>",model.getModel().get("list"));
//        mockMvc.perform(MockMvcRequestBuilders.post("/query")
//        .param("title","laoluo")
//        ).andDo(MockMvcResultHandlers.print());

        mockMvc.perform(MockMvcRequestBuilders.post("/query")
                .param("title","laoluo")
        ).andExpect(MockMvcResultMatchers.status().is(200));

    }
}
