package nl.noviopdracht.demo.files;

import nl.noviopdracht.demo.message.ResponseMessage;
import nl.noviopdracht.demo.payload.response.ResponseFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/cardocuments")
public class FileController {
    private final FileStorageServiceImpl fileStorageServiceImpl;

    @Autowired
    public FileController(FileStorageServiceImpl fileStorageServiceImpl) {
        this.fileStorageServiceImpl = fileStorageServiceImpl;
    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) {
        String message = "";
        try{
            fileStorageServiceImpl.add(file);
            message = "upload carpaper succesvol: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e) {
            message = "Can't upload document:" + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @RequestMapping(path = "")
    public ResponseEntity<List<ResponseFile>> getAll() {
        List<ResponseFile> files = fileStorageServiceImpl.findAll().map(dbFile -> {
                    //Build Uri strings from all files retrieved.
                    String fileDownloadUri = ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/cardocuments/")
                            .path(dbFile.getId().toString())
                            .toUriString();

                    return new ResponseFile(
                            dbFile.getName(),
                            fileDownloadUri,
                            dbFile.getType(),
                            dbFile.getData().length
                    );
                }
        ).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping( path = "/{id}")
    public ResponseEntity<byte[]> getSingle(@PathVariable("id") Integer id){
        FileDB fileDb = fileStorageServiceImpl.findOne(id);
        if(fileDb == null) {
            throw new IllegalStateException("Bestand niet gevonden");
        }else {
            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename= \" " + fileDb.getName() + "\" "
                    )
                    .body(fileDb.getData());
        }
    }
}