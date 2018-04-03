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
     * �����ļ�����
     **/
    private String folder = "F:\\GitHub\\StudySpringSecurity\\imooc-security-demo\\src\\main\\java\\com\\imooc\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println("�ļ�����" + file.getName());
        System.out.println("ԭʼ�ļ�����" + file.getOriginalFilename());
        System.out.println("�ļ���С" + file.getSize());


//      file.getInputStream(); ���ʹ�õ������� ���� �����Ƶ��ļ�������

        //������һ���ļ���
        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }


    /**
     * �ļ�������  ����ط���ʵ�Ҳ�̫���� �����Ժ������ڻع�һ���ⷽ���֪ʶ
     */
    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // jdk 1.7���﷨  д������ط��Ͳ����Լ��ֶ���ȥ�ر�����
        try (
                    InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                    OutputStream outputStream = response.getOutputStream()
        ) {
            //����
            response.setContentType("application/x-download");

            //����֮���ļ�������
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        } catch (Exception e) {

        }
    }


}
