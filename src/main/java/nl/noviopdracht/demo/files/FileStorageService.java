package nl.noviopdracht.demo.files;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileStorageService {
    Stream<FileDB> findAll();

    FileDB findOne(Integer id);

    FileDB add(MultipartFile file) throws IOException;
}
