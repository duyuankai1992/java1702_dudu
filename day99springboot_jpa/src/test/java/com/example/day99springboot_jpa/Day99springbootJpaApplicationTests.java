package com.example.day99springboot_jpa;

import com.example.day99springboot_jpa.domain.Employee;
import com.example.day99springboot_jpa.domain.Product;
import com.example.day99springboot_jpa.repository.EmployeeRepository;
import com.example.day99springboot_jpa.repository.ProductPageAndSortRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
@SpringBootTest
/*@RunWith(SpringRunner.class)*/
public class Day99springbootJpaApplicationTests {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void query() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/find"))
                .andDo(MockMvcResultHandlers.print());
    }



    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ProductPageAndSortRepository productPageAndSortRepository;

    @Test
    public void contextLoads() {
        Employee employee = repository.findOne(1);
        System.out.println(employee);
    }

    @Test
    public void save() {
        Employee employee = new Employee();
        employee.setName("111");
        repository.save(employee);
    }

    @Test
    public void update(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("xxx");
        repository.saveAndFlush(employee);
    }

    @Test
    public void findPageAndSort() {
        Page<Product> list = productPageAndSortRepository.findAll(new PageRequest(0,6));
        for (Product product:list){
            System.out.println(product);
        }
        System.out.println("======");
        System.out.println("totalPages=="+list.getTotalPages());
        System.out.println("numberOfElements=="+list.getNumberOfElements());
        System.out.println("number=="+list.getNumber());
        System.out.println("size=="+list.getSize());
    }

    @Test
    public void findSort(){
        //Sring类型，排序失效
        Sort sort = new Sort(Sort.Direction.ASC,"price");
        Iterable<Product> list = productPageAndSortRepository.findAll(sort);
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
