package nl.noviopdracht.demo.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final FileDBRepository fileDBRepository;

    @Autowired
    public FileStorageServiceImpl(FileDBRepository fileDBRepository) {
        this.fileDBRepository = fileDBRepository;
    }

    @Override
    public Stream<FileDB> findAll() {return fileDBRepository.findAll().stream();}

    @Override
    public FileDB findOne(Integer id) {
        FileDB fileDb = fileDBRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("File not found"));
        return fileDb;
    }

    @Override
    public FileDB add(MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        FileDB fileDb = new FileDB(fileName,file.getContentType(), file.getBytes());
        fileDBRepository.save(fileDb);
        return fileDb;
    }
}
