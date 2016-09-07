package org.nzcn.landing.services.impl;

import org.springframework.core.io.Resource;

import java.io.File;

/**
 * Created by kinlin on 9/7/16.
 */
public class FileResponse {
    String fileName;
    File fileResource;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFileResource() {
        return fileResource;
    }

    public void setFileResource(File fileResource) {
        this.fileResource = fileResource;
    }

    public static class Builder{
        String fileName;
        File fileResource;

        public Builder withFileName(String fileName){
            this.fileName = fileName;
            return this;
        }

        public Builder withFileResource(File fileResource){
            this.fileResource = fileResource;
            return this;
        }

        public FileResponse build(){
            FileResponse ret = new FileResponse();
            ret.setFileName(fileName);
            ret.setFileResource(fileResource);
            return ret;
        }
    }
}
