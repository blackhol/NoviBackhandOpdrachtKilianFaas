package nl.noviopdracht.demo.files;

import nl.noviopdracht.demo.Model.Car;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_files")
public class Carfiles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "file_name")
    private String filename;
    @Column(name = "modified_file_name")
    private String modifiedFileName;
    @Column(name = "file_extension")
    private String fileExtension;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getModifiedFileName() {
        return modifiedFileName;
    }

    public void setModifiedFileName(String modifiedFileName) {
        this.modifiedFileName = modifiedFileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
