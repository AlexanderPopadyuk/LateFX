package sample.controller.educationUnit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sample.model.educationUnit.Group;

/**
 * Created by Asus on 14.03.2016.
 */
public class groupInfoController {
    private static Group group;
    @FXML
    Label groupName, cathedraName, kuratorName, starostaName;
    @FXML
    ListView studentsList;

    public static void setGroup(Group group) {
        groupInfoController.group = group;
    }

    @FXML
    public void initialize(){
        ObservableList<String> students = FXCollections.observableArrayList();
        cathedraName.setText(group.getCathedral().getName());
        groupName.setText(group.getName());
        if (group.getCurator() != null) {
            kuratorName.setText(group.getCurator().getSurname()+" "+group.getCurator().getName());
        } else {
            kuratorName.setText("Не призначений");
        }
        if (group.getCapitain() != null) {
            starostaName.setText(group.getCapitain().getSurname() + " " + group.getCapitain().getName());
        } else {
            starostaName.setText("Не призначений");
        }
        for (int i = 0; i < group.getStudentsList().size(); i++) {
            students.add(group.getStudentsList().get(i).getSurname()+" "+group.getStudentsList().get(i).getName());
        }
        studentsList.setItems(students);
    }
}
