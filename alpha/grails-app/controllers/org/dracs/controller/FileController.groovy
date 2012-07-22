package org.dracs.controller

import org.dracs.entity.DrawingFile
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

class FileController {

    def fileBoundaryService

    def index() {
        render view: "/index", model: [files: DrawingFile.findAll()]
    }

    def preUpload() {
        render view: "/upload"
    }

    def upload() {
        MultipartHttpServletRequest mpr = (MultipartHttpServletRequest) request;
        MultipartFile f = mpr.getFile("drawingFile");

        fileBoundaryService.uploadFile(f)
        redirect action: index()
    }

    def info(Long id) {
        if (id) {
            render view: '/fileInfo', model: [fileInfo: DrawingFile.findById(id)]
        } else {
            render status: 500, message(error: "Не удалось найти указанный фаил")
        }
    }

}
