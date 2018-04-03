package com.imooc.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                                                .param("username", "job")
//                                .param("size", "2")
//                                .param("page", "3")
//                                .param("sort", "age,desc")
                                                .contentType(MediaType.APPLICATION_JSON_UTF8))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))//一个集合的长度为3
                                .andReturn().getResponse().getContentAsString();

//        mockMvc.perform(MockMvcRequestBuilders.get("/user/users")
//                                .param("username", "job")
//                                .param("age", "10")
//                                .param("ageTo", "30")
//                                .param("xxx", "what's fuck the box")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                // https://github.com/json-path/JsonPath  jsonPath 操作符
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));  //一个集合的长度为3

        System.out.println(result);
    }


    @Test
    public void whenGenInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                                                .contentType(MediaType.APPLICATION_JSON_UTF8))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.username")
                                                   .value("tom")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
                                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void whenCreateSuccess() throws Exception {
        String content = "{\"password\":null,\"username\":\"tom\",\"birthday\":\"1522649278608\"}";
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                                .content(content))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    @Test
    public void whenUpdateSuccess() throws Exception {
        //LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault())
        Date date = new Date();
        String content = "{\"password\":null,\"username\":\"tom\",\"birthday\":" + date.getTime() + 349 + "}";
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                                .content(content))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void getTime() throws Exception {
        //LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault())
        Date date = new Date();
        System.out.println(date.getTime() + 39040400);
    }



    /**
     * 测试文件上传服务
     * 模拟一个文件请求 上传服务器
     */
    @Test
    public void whenUploadSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file")
                                                .file(new MockMultipartFile("file", "text.txt", "multipart/form-data", "hello  upload".getBytes("UTF-8"))))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andReturn().getResponse().getContentAsString();
        System.out.println("file ：" + result);
    }

}
