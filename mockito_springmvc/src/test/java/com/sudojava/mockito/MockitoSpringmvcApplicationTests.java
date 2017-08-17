package com.sudojava.mockito;

import com.sudojava.mockito.controller.UserController;
import com.sudojava.mockito.domain.User;
import com.sudojava.mockito.service.UserService;
import com.sudojava.mockito.service.UserServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MockitoSpringmvcApplication.class)
public class MockitoSpringmvcApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;



    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    public void login() throws Exception {

//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        when(userService.login(user)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("username", "admin")
                .param("password", "admin"))
                //.andReturn().getModelAndView();
                .andDo(MockMvcResultHandlers.print());
        //String name = modelAndView.getViewName();
        //System.out.println("---->>" + name);
    }

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .param("username", user.getUsername())
                .param("password", user.getPassword())
        )
                .andDo(MockMvcResultHandlers.print());
    }

}
