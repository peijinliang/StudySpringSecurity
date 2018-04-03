package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Crete by Marlon
 * Create Date: 2018/4/3
 * Class Describe
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 可用文件服务
     **/
    private String folder = "F:\\GitHub\\StudySpringSecurity\\imooc-security-demo\\src\\main\\java\\com\\imooc\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println("文件名：" + file.getName());
        System.out.println("原始文件名：" + file.getOriginalFilename());
        System.out.println("文件大小" + file.getSize());


//      file.getInputStream(); 如果使用第三方的 例如 阿里云的文件服务器

        //重新起一个文件名
        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }


    /**
     * 文件的下载  这个地方其实我不太明白 我想以后看完了在回顾一下这方面的知识
     */
    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // jdk 1.7新语法  写在这个地方就不用自己手动的去关闭流了
        try (
                    InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                    OutputStream outputStream = response.getOutputStream()
        ) {
            //类型
            response.setContentType("application/x-download");

            //下载之后文件的名字
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        } catch (Exception e) {

        }
    }


}
