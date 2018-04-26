package com.demo.imooc.dto;

/**
 * Crete by Marlon
 * Create Date: 2018/4/3
 * Class Describe
 **/

public class FileInfo {

    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileInfo{" + "path='" + path + '\'' + '}';
    }

}
