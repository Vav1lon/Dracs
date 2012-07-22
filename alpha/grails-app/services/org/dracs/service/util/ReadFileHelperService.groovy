package org.dracs.service.util

import org.apache.poi.poifs.filesystem.POIFSFileSystem

class ReadFileHelperService {

    public POIFSFileSystem getPoiFSFileSystem(File file) {
        FileInputStream fis = new FileInputStream(file)
        POIFSFileSystem result = new POIFSFileSystem(fis)
        fis.close()
        result
    }

}
