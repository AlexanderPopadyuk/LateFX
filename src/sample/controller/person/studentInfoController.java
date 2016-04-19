package sample.controller.person;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.model.person.Student;

/**
 * Created by Asus on 14.03.2016.
 */
public class studentInfoController {

    public static void setStudent(Student student) {
        studentInfoController.student = student;
    }

    private static Student student;
    @FXML
    Label ticketID, Surname, Name, Group;

    @FXML
    public void initialize() {
        ticketID.setText(student.id);
        Surname.setText(student.getSurname());
        Name.setText(student.getName());
        Group.setText(student.getGroup().getName());
    }
}
