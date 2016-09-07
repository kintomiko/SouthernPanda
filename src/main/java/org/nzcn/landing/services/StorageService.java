package org.nzcn.landing.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kinlin on 9/7/16.
 */
public interface StorageService {
    void store(String filePath, MultipartFile file) throws IOException;

    File loadAsResource(String path);

    String generateFileName(MultipartFile file);
}
