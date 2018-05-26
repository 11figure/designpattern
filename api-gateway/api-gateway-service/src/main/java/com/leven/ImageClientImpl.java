package com.leven;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 12:52 2018/5/19
 * @Modified By:
 */
@Service
public class ImageClientImpl implements ImageClient {

    @Override
    public String getImagePathClient() {
        String response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:50006/image-path");
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            response = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
