package sample.controller.educationUnit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.Controller;
import sample.controller.adminPanelController;
import sample.model.educationUnit.Cathedral;
import sample.model.educationUnit.Department;

/**
 * Created by Asus on 21.03.2016.
 */
public class addUnitController {
    public static String unit;
    public static String depName;
    @FXML
    TextField nameField, addressField, phoneField;

    @FXML
    public void addUnit(){
        if (unit.equals("D")) {
            Controller.allDepartments.add(new Department(Controller.ChNU,nameField.getText(),addressField.getText(),phoneField.getText()));
            Controller.ChNU.addDepartment(Controller.allDepartments.get(Controller.allDepartments.size()-1));
        } else {
            for (int i = 0; i < Controller.allDepartments.size(); i++) {
                if (depName.equals(Controller.allDepartments.get(i).getName())){
                    Controller.allCathedrals.add(new Cathedral(Controller.allDepartments.get(i),nameField.getText(),addressField.getText(),phoneField.getText()));
                    Controller.allDepartments.get(i).addCathedral(Controller.allCathedrals.get(Controller.allCathedrals.size()-1));
                }
            }
        }
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}
