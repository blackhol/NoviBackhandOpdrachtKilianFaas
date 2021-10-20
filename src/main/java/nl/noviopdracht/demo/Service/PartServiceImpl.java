package nl.noviopdracht.demo.Service;


import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.Model.Part;
import nl.noviopdracht.demo.Repository.PartRepository;
import org.springframework.stereotype.Service;

@Service
    public class PartServiceImpl implements PartService {
    private final PartRepository repos;

    public PartServiceImpl(PartRepository repos) {
        this.repos = repos;
    }

    @Override
    public void savePart(PartDTO partDTO) {
        Part part = new Part(partDTO.getPartname(), partDTO.getPrice());
        repos.save(part);
    }
}