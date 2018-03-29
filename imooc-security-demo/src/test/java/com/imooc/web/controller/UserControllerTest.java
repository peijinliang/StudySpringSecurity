package com.imooc.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Crete by Marlon
 * Create Date: 2018/3/29
 * Class Describe  模拟MVC的请求
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    //Expect  期望 指望
    //404 并没有该请求
    //java.lang.AssertionError: No value at JSON path "$.length()", exception: json can not be null or empty
    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                                .param("username", "job")
//                                .param("size", "2")
//                                .param("page", "3")
//                                .param("sort", "age,desc")
                                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));  //一个集合的长度为3

        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                                .param("username", "job")
                                .param("age", "10")
                                .param("ageTo", "30")
                                .param("xxx", "what's fuck the box")
                                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // https://github.com/json-path/JsonPath  jsonPath 操作符
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));  //一个集合的长度为3
    }


}
