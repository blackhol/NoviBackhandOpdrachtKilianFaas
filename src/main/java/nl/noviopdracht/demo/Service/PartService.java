package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.PartDTO;

import java.util.ArrayList;

public interface PartService {

    public void savePart(PartDTO partDTO);

    public ArrayList<PartDTO> getAllParts();

}
