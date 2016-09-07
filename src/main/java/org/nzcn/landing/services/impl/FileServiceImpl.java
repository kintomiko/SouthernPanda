package org.nzcn.landing.services.impl;

import org.nzcn.landing.models.FileEntity;
import org.nzcn.landing.repositories.FileRepository;
import org.nzcn.landing.services.FileService;
import org.nzcn.landing.services.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by kinlin on 9/7/16.
 */
@Service
public class FileServiceImpl implements FileService {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private StorageService storageService;

    @Override
    public FileEntity store(MultipartFile file) {
        FileEntity fileEntityEntity = new FileEntity();

        fileEntityEntity.setName(file.getOriginalFilename());
        String filePath = storageService.generateFileName(file);
        fileEntityEntity.setPath(filePath);
        fileRepository.save(fileEntityEntity);
        int i=0;
        while(true) {
            try {
                storageService.store(filePath, file);
                return fileEntityEntity;
            } catch (IOException e) {
                i++;
                if (i == 3)
                    throw new RuntimeException(e);
            }
        }
    }

    @Override
    public FileResponse loadAsResource(String fileId) {
        FileEntity fileEntity = fileRepository.findOne(fileId);
        if(fileEntity == null)
            return null;

        return new FileResponse.Builder().withFileName(fileEntity.getName())
                        .withFileResource(storageService.loadAsResource(fileEntity.getPath())).build();
    }

}
