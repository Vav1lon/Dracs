package org.dracs.service.util

import org.apache.poi.hpsf.PropertySet
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.apache.poi.poifs.filesystem.DocumentInputStream
import org.apache.poi.hpsf.NoPropertySetStreamException
import org.apache.poi.hpsf.MarkUnsupportedException
import groovy.util.logging.Log4j
import org.dracs.entity.DrawingAttribute
import org.apache.poi.hpsf.Section
import org.apache.poi.hpsf.Property
import org.apache.poi.poifs.filesystem.DirectoryNode
import org.apache.poi.poifs.filesystem.DocumentEntry

@Log4j
class ReadDrawingHelperService {

    public PropertySet readDocumentNode(POIFSFileSystem poifsFileSystem, String documentName) {

        PropertySet result
        DocumentInputStream dis = poifsFileSystem.createDocumentInputStream(documentName)
        try {
            result = new PropertySet(dis)
        } catch (NoPropertySetStreamException e) {
            log.error(e)
        } catch (MarkUnsupportedException e) {
            log.error(e)
        } finally {
            dis.close()
        }
        result

    }

    List<DrawingAttribute> readPropertySet(PropertySet propertySet, String documentName) {

        List<DrawingAttribute> result = []

        DrawingAttribute attribute;
        for (Section section : propertySet.getSections()) {
            Map<Long, String> objects = section.getDictionary();
            Property[] properties = section.getProperties();

            Property property;
            for (int i = 0; i < objects.size(); i++) {
                property = properties[i];
                attribute = new DrawingAttribute(documentName: documentName
                        , index: i
                        , key: objects.get(property.getID())
                        , value: property.getValue().toString()
                        , type: property.getType()

                );
                result << attribute
            }
        }
        result;
    }

    public DocumentInputStream getDocumentInputStream(DirectoryNode directoryNode, String filedName) {
        DocumentEntry materials = null
        try {
            materials = directoryNode.getEntry(filedName)
        } catch (FileNotFoundException e) {
            log.error(e)
        }

        if (materials)
            new DocumentInputStream(materials);
        else
            null

    }

}
