package org.dracs.service.boundary

import org.dracs.entity.DrawingFile
import org.springframework.web.multipart.MultipartFile

class FileBoundaryService {

    def uploadFileService
    def drawingFileControlService
    def drawingControlService


    public void uploadFile(MultipartFile file) {
        File uploadFile = uploadFileService.upload(file)
        DrawingFile drawingFile = drawingFileControlService.createDrawing(uploadFile)
        drawingFileControlService.readInfo(drawingFile)
//        drawingControlService.create(drawingFile)
    }

}
