package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.ActionDTO;
import nl.noviopdracht.demo.Model.Action;
import nl.noviopdracht.demo.Repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {
    private final ActionRepository repos;

    public ActionServiceImpl(ActionRepository repos) {
        this.repos = repos;
    }

    @Override
    public void saveAction(ActionDTO actionDTO) {

        Action action = new Action (actionDTO.getActionId(),actionDTO.getName(), actionDTO.getPrice());
        repos.save(action);

    }

    @Override
    public ArrayList<ActionDTO> getAllActions() {
        List<Action> actionList = repos.findAll();
        ArrayList<ActionDTO> actionDTOList = new ArrayList<ActionDTO>();

        for (
                Action action: actionList
             )
        {
            ActionDTO actionconver = new ActionDTO();
            actionconver.setActionId(action.getActionInt());
            actionconver.setPrice(action.getPrice());
            actionconver.setName(action.getName());
            actionDTOList.add(actionconver);
        }
        return actionDTOList;
    }

}
