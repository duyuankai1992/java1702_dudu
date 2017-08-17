import com.sudojava.spring.domain.Todos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = {"classpath:spring-config.xml", "classpath:spring-mvc.xml"})
public class ApplicationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void add() throws Exception {
        Todos todos = new Todos();
        todos.setDescription("guangxi");
        todos.setTitle("laoluo");
        todos.setVersion(1004);
//        int status = mockMvc.perform(MockMvcRequestBuilders.post("/add")
//        .param("title",todos.getTitle())
//        .param("description",todos.getDescription())
//        .param("version",todos.getVersion()+"")).andReturn()
//                .getResponse().getStatus();
//        Assert.assertEquals(200,status);
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .param("title", todos.getTitle())
                .param("description", todos.getDescription())
                .param("version", todos.getVersion() + ""))
                .andDo(MockMvcResultHandlers.print());


    }
}
