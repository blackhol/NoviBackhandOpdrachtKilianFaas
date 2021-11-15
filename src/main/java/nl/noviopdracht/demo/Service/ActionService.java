package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.ActionDTO;

import java.util.ArrayList;

public interface ActionService {

    public void saveAction(ActionDTO actionDTO);

    public ArrayList<ActionDTO> getAllActions();


}
