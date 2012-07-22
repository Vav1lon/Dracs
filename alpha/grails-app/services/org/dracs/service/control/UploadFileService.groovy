package org.dracs.service.control

import org.springframework.web.multipart.MultipartFile

class UploadFileService {

    public File upload(MultipartFile file) {
        readFile(file)
    }

    private File readFile(MultipartFile file) {
        File newFile = new File(file.originalFilename)
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.write(file.getBytes());
        fos.close();
        newFile
    }

}
