package sample.controller.person;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.Controller;
import sample.model.educationUnit.Cathedral;
import sample.model.person.Professor;
import sample.model.person.Student;

/**
 * Created by Asus on 21.03.2016.
 */
public class addPersonController {
    public static String person;
    public static String group;
    public static String cath;

    @FXML
    TextField idField,surnameField,nameField;

    @FXML
    public void addPerson(){
        if (person.equals("P")){
            for (int i = 0; i < Controller.allCathedrals.size(); i++) {
                if (cath.equals(Controller.allCathedrals.get(i).getName())){
                    Controller.allProfessors.add(new Professor(idField.getText(),Controller.allCathedrals.get(i),surnameField.getText(),nameField.getText()));
                    Controller.allCathedrals.get(i).addProfessor(Controller.allProfessors.get(Controller.allProfessors.size()-1));
                }
            }
        } else {
            for (int i = 0; i < Controller.allGroups.size(); i++) {
                if (group.equals(Controller.allGroups.get(i).getName())){
                    Controller.allStudents.add(new Student(idField.getText(),Controller.allGroups.get(i),surnameField.getText(),nameField.getText()));
                    Controller.allGroups.get(i).addStudent(Controller.allStudents.get(Controller.allStudents.size()-1));
                }
            }
        }
        Stage stage = (Stage) idField.getScene().getWindow();
        stage.close();
    }
}
