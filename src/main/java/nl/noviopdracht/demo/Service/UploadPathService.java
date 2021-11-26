package nl.noviopdracht.demo.Service;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface UploadPathService {
    File getFilePath(String modifiedFileName, String path);

    public Resource load(String filename);

    public Stream<Path> loadAll();

    public void init();

}
