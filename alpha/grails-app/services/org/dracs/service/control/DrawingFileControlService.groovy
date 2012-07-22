package org.dracs.service.control

import org.apache.poi.hpsf.DocumentSummaryInformation
import org.apache.poi.hpsf.PropertySet
import org.apache.poi.hpsf.SummaryInformation
import org.apache.poi.poifs.filesystem.DirectoryNode
import org.apache.poi.poifs.filesystem.DocumentInputStream
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.dracs.entity.DrawingAttribute
import org.dracs.entity.DrawingFile
import org.dracs.entity.DrawingMaterial

class DrawingFileControlService {

    def readDrawingHelperService
    def readFileHelperService

    public DrawingFile createDrawing(File file) {

        DrawingFile drawingFile = new DrawingFile()
        drawingFile.file = file
        drawingFile.size = file.size()

        int endPoint = calcDrawingName(file.getName())

        drawingFile.name = file.name.substring(0, endPoint)
        drawingFile.extension = file.name.substring(++endPoint)
        drawingFile.hash = file.encodeAsMD5()
        drawingFile

    }

    private int calcDrawingName(String name) {
        int endPoint
        char[] tmp = name.chars
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == ".") {
                endPoint = i
            }
        }
        endPoint
    }

    public void readInfo(DrawingFile drawingFile) {
        POIFSFileSystem poifsFileSystem = readFileHelperService.getPoiFSFileSystem(drawingFile.file);

        PropertySet documentSummaryInformation = readDrawingHelperService.readDocumentNode(poifsFileSystem, DocumentSummaryInformation.DEFAULT_STREAM_NAME);
        PropertySet summaryInformation = readDrawingHelperService.readDocumentNode(poifsFileSystem, SummaryInformation.DEFAULT_STREAM_NAME);

        List<DrawingAttribute> drawingAttributes = []
        drawingAttributes.addAll(readDrawingHelperService.readPropertySet(documentSummaryInformation, DocumentSummaryInformation.DEFAULT_STREAM_NAME))
        drawingAttributes.addAll(readDrawingHelperService.readPropertySet(summaryInformation, SummaryInformation.DEFAULT_STREAM_NAME))

        drawingAttributes.each { it ->
            drawingFile.addToAttributes(it)
        }

        DirectoryNode swXmlContentsDir = (DirectoryNode) poifsFileSystem.getRoot().getEntry("swXmlContents");

        DocumentInputStream dis = readDrawingHelperService.getDocumentInputStream(swXmlContentsDir, "MATERIALTREE");

        if (dis) {
            def items = new XmlParser()
            Node node = items.parse(dis)

            List<Node> configurationsList = node.get("configurationslist")
            configurationsList.each {it ->
                it.children().each { cildIt ->
                    DrawingMaterial material = new DrawingMaterial(name: ((Node) cildIt).attribute("name")
                            , description: ((Node) cildIt).attribute("material"))
                    drawingFile.addToMaterials(material)
                }
            }
        }

        drawingFile.save()
    }
}
