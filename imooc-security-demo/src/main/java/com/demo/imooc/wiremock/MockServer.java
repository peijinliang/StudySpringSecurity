package com.demo.imooc.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

/**
 * Crete by Marlon
 * Create Date: 2018/4/4
 * Class Describe
 **/

public class MockServer {

    public static void main(String[] args) throws IOException {
        WireMock.configureFor(8062);
        WireMock.removeAllMappings();
        mock("/order/1", "01");
    }

    private static void mock(String url, String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/reponse/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8"), "\n");
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url)).willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }

}
