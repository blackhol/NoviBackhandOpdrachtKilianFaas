package nl.noviopdracht.demo.Service;

import java.io.File;

public interface UploadPathService {
    File getFilePath(String modifiedFileName, String path);
}
