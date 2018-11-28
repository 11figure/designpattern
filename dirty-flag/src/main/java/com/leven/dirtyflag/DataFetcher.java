package com.leven.dirtyflag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * @Author: LevenLiu
 * @Description: A mock database manager -Feches data from a raw file;
 * @Date: Create 2:47 2018/9/2
 * @Modified By:
 */
public class DataFetcher {

    private final String FILENAME = "world.txt";

    private long lastFectched;

    /**
     * Fetches data/content from raw file
     * @return
     */
    public List<String> fetch(){
        List<String> data = new ArrayList<>();
        ClassLoader classLoader = DataFetcher.class.getClassLoader();
        String decodedURL = "";
        try {
            URL resource = classLoader.getResource(FILENAME);
            decodedURL = URLDecoder.decode(resource.getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        File file = FileUtils.getFile(decodedURL);

        if(isDirty(file.lastModified())) {
            System.out.println("isDirty");
            try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line =bf.readLine()) != null) {
                    data.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
        return new ArrayList<>();
    }

    private Boolean isDirty(long fileLastModified) {
        System.out.println((lastFectched != fileLastModified) + ":::" + lastFectched + "\\=\\=" + fileLastModified);
        if (lastFectched != fileLastModified) {
            lastFectched = fileLastModified;
            return true;
        } else {
            return false;
        }
    }
}
