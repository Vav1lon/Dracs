package org.dracs.service.control

import org.apache.commons.io.IOUtils
import org.apache.poi.poifs.filesystem.DocumentInputStream
import org.dracs.entity.Drawing
import org.dracs.entity.DrawingFile

class DrawingControlService {

    def readFileHelperService

    public void create(DrawingFile drawingFile) {
        Drawing drawing = new Drawing()
        drawing.files = [drawingFile]
        drawing.author = 'me'

        DocumentInputStream disa = readFileHelperService.getPoiFSFileSystem(drawingFile.file).createDocumentInputStream("PreviewPNG")
        drawing.preview = IOUtils.toByteArray(disa)

        drawing.save()
    }
}
