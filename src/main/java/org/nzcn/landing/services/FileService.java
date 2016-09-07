package org.nzcn.landing.services;

import org.nzcn.landing.models.FileEntity;
import org.nzcn.landing.services.impl.FileResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kinlin on 9/7/16.
 */
public interface FileService {
    FileEntity store(MultipartFile file);

    FileResponse loadAsResource(String fileId);
}
