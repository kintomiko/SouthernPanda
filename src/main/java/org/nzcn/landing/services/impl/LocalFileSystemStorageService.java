package org.nzcn.landing.services.impl;

import org.nzcn.landing.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kinlin on 9/7/16.
 */
@Service
public class LocalFileSystemStorageService implements StorageService {

    @Value("${storage.path}")
    String localStoragePath;

    @Override
    public void store(String filePath, MultipartFile file) throws IOException {
        FileOutputStream stream = new FileOutputStream(localStoragePath+filePath);
        try {
            stream.write(file.getBytes());
        } finally {
            stream.close();
        }
    }

    @Override
    public File loadAsResource(String path) {
        return new File(localStoragePath+path);
    }

    @Override
    public String generateFileName(MultipartFile file) {
        int i=0;
        while(i<3){
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                return String.valueOf(md.digest(file.getBytes()));
            } catch (IOException e) {
                i++;
                if(i==3)
                    throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
