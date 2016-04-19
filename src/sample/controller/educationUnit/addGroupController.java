package sample.controller.educationUnit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.Controller;
import sample.model.educationUnit.Group;

/**
 * Created by Asus on 22.03.2016.
 */
public class addGroupController {
    public static String cath;
    @FXML
    TextField nameField;

    public void addNewGroup(){
        for (int i = 0; i < Controller.allCathedrals.size(); i++) {
            if (cath.equals(Controller.allCathedrals.get(i).getName())) {
                Controller.allGroups.add(new Group(Controller.allCathedrals.get(i), nameField.getText()));
                Controller.allCathedrals.get(i).addGroup(Controller.allGroups.get(Controller.allGroups.size()-1));
            }
        }
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}
