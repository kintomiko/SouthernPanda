package org.nzcn.landing.rest;

import org.nzcn.landing.models.FileEntity;
import org.nzcn.landing.services.FileService;
import org.nzcn.landing.services.impl.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kinlin on 9/7/16.
 */
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/{fileId}", method = RequestMethod.GET)
    public void serveFile(@PathVariable String fileId, HttpServletResponse response) {

        FileResponse fileResponse = fileService.loadAsResource(fileId);
        if(fileResponse == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }

        try {
            InputStream is = new FileInputStream(fileResponse.getFileResource());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename="+ fileResponse.getFileName());
            ServletOutputStream out = response.getOutputStream();

            byte[] outputByte = new byte[(int)fileResponse.getFileResource().length()];
            //copy binary contect to output stream
            while(is.read(outputByte, 0, (int)fileResponse.getFileResource().length()) != -1)
            {
                out.write(outputByte, 0, (int)fileResponse.getFileResource().length());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public FileEntity handleFileUpload(@RequestParam("uploadedFile") MultipartFile file) {
        return fileService.store(file);
    }
}
