package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.ActionDTO;
import nl.noviopdracht.demo.Model.Action;
import nl.noviopdracht.demo.Repository.ActionRepository;
import org.springframework.stereotype.Service;

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

}
