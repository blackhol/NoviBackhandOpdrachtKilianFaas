package nl.noviopdracht.demo.Service;


import nl.noviopdracht.demo.DTO.PartDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Part;
import nl.noviopdracht.demo.Model.User;
import nl.noviopdracht.demo.Repository.PartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class PartServiceImpl implements PartService {
    private final PartRepository repos;

    public PartServiceImpl(PartRepository repos) {
        this.repos = repos;
    }

    @Override
    public void savePart(PartDTO partDTO) {
        Part part = new Part(partDTO.getPartname(), partDTO.getPrice(),partDTO.getAmount());
        repos.save(part);
    }

    @Override
    public ArrayList<PartDTO> getAllParts() {
        List<Part> partList = repos.findAll();
        ArrayList<PartDTO> partDTOList = new ArrayList<PartDTO>();

        for
        (
                Part part:partList
        )
        {
            PartDTO partconver = new PartDTO();
            partconver.setId(part.getId());
            partconver.setPartname(part.getPartname());
            partconver.setPrice(part.getPrice());
            partDTOList.add(partconver);
        }

        return partDTOList;
    }
}