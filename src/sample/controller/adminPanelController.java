package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.controller.educationUnit.addGroupController;
import sample.controller.educationUnit.addUnitController;
import sample.controller.educationUnit.groupInfoController;
import sample.controller.person.addPersonController;
import sample.controller.person.studentInfoController;
import sample.model.Late;
import sample.model.educationUnit.*;
import sample.model.person.Professor;
import sample.model.person.Student;

import java.util.List;

/**
 * Created by Asus on 13.03.2016.
 */
public class adminPanelController {
    @FXML
    ComboBox departmentsCB,cathedralsCB,professorsCB,groupsCB,studentsCB;
    @FXML
    DatePicker lateDate;

    List<Department> departmentList;
    List<Cathedral> cathedralList;
    List<Group> groupsList;
    List<Professor> professorsList;
    List<Student> studentsList;
    Student chekedStudent;

    @FXML
    public void initialize(){
        init();
    }

    public void init(){
        ObservableList<String> items = FXCollections.observableArrayList();
        departmentList = Controller.ChNU.getDepartmentsList();
        if (departmentList!=null) {
            for (int i = 0; i < departmentList.size(); i++) {
                items.add(departmentList.get(i).getName());
            }
            departmentsCB.setItems(items);
        }
    }
    //
    public void onDepartmentsCBClick(){
        ObservableList<String> items = FXCollections.observableArrayList();
        if (departmentsCB.getValue()!=null && !departmentsCB.getValue().toString().isEmpty()) {
            for (int i = 0; i < departmentList.size(); i++) {
                if (departmentList.get(i).getName().equals(departmentsCB.getValue().toString())) {
                    cathedralList = departmentList.get(i).getCathedralsList();
                    for (int j = 0; j < departmentList.get(i).getCathedralsList().size(); j++) {
                        items.add(cathedralList.get(j).getName());
                    }
                }
            }
        cathedralsCB.setItems(items);
        }
    }
    public void onCathedralsCBClick(){
        ObservableList<String> professors = FXCollections.observableArrayList();
        ObservableList<String> groups = FXCollections.observableArrayList();
        if (cathedralsCB.getValue()!=null && !cathedralsCB.getValue().toString().isEmpty()) {
            for (int i = 0; i < cathedralList.size(); i++) {
                if (cathedralList.get(i).getName().equals(cathedralsCB.getValue().toString())) {
                    groupsList = cathedralList.get(i).getGroupsList();
                    professorsList = cathedralList.get(i).getProfessorList();
                    for (int j = 0; j < professorsList.size(); j++) {
                        professors.add(professorsList.get(j).getSurname()+" "+professorsList.get(j).getName());
                    }
                    for (int j = 0; j < groupsList.size(); j++) {
                        groups.add(groupsList.get(j).getName());
                    }
                }
            }
            professorsCB.setItems(professors);
            groupsCB.setItems(groups);
        }
    }
    public void onGroupsCBClick() {
        ObservableList<String> items = FXCollections.observableArrayList();
        if (groupsCB.getValue()!=null && !groupsCB.getValue().toString().isEmpty()) {
            for (int i = 0; i < groupsList.size(); i++) {
                if (groupsList.get(i).getName().equals(groupsCB.getValue().toString())) {
                    //
                    groupInfoController.setGroup(groupsList.get(i));
                    //
                    studentsList = groupsList.get(i).getStudentsList();
                    for (int j = 0; j < studentsList.size(); j++) {
                        items.add(studentsList.get(j).getSurname()+" "+studentsList.get(j).getName());
                    }
                }
            }
            studentsCB.setItems(items);
        }
    }
    public void openGroupInfo() throws Exception {
        Stage stage = new Stage();
        Parent form = FXMLLoader.load(getClass().getResource("../view/educationUnit/groupInfo.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Інформація про групу");
        stage.setScene(new Scene(form));
        stage.show();
    }
    public void studentChek(){
        if (studentsCB.getValue()!=null && !studentsCB.getValue().toString().isEmpty()) {
            for (int i = 0; i < studentsList.size(); i++) {
                if (studentsCB.getValue().toString().equals(studentsList.get(i).getSurname()+" "+studentsList.get(i).getName())) {
                    chekedStudent = studentsList.get(i);
                }
            }
        }
    }
    public void openStudentInfo() throws Exception {
        studentInfoController.setStudent(chekedStudent);
        Stage stage2 = new Stage();
        Parent form2 = FXMLLoader.load(getClass().getResource("../view/person/studentInfo.fxml"));
        stage2.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage2.setTitle("Інформація про студента");
        stage2.setScene(new Scene(form2));
        stage2.show();
    }
    //
    public void addLate(){
        int n = 0;
        for (int i = 0; i < Controller.lateList.size(); i++) {
            if (lateDate.getValue() == Controller.lateList.get(i).getLateDate()) {
                Controller.lateList.get(i).addLate(chekedStudent);
                n++;
            }
        }
        if (n == 0) {
            Controller.lateList.add(new Late(lateDate.getValue().getYear(),lateDate.getValue().getMonth().getValue(),lateDate.getValue().getDayOfMonth()));
            Controller.lateList.get(Controller.lateList.size()-1).addLate(chekedStudent);
        }
    }
    //
    public void addNewDepartment() throws Exception {
        addUnitController.unit = "D";
        Stage stage = new Stage();
        Parent form = FXMLLoader.load(getClass().getResource("../view/educationUnit/addUnit.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Додавання підрозділу");
        stage.setScene(new Scene(form));
        stage.show();
    }
    public void addNewCathedra() throws Exception {
        addUnitController.unit = "C";
        addUnitController.depName = departmentsCB.getValue().toString();
        Stage stage = new Stage();
        Parent form = FXMLLoader.load(getClass().getResource("../view/educationUnit/addUnit.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Додавання підрозділу");
        stage.setScene(new Scene(form));
        stage.show();
    }
    public void addNewProfessor() throws Exception {
        addPersonController.person = "P";
        addPersonController.cath = cathedralsCB.getValue().toString();
        Stage stage = new Stage();
        Parent form = FXMLLoader.load(getClass().getResource("../view/person/addPerson.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Додавання нової особи");
        stage.setScene(new Scene(form));
        stage.show();
    }
    public void addNewStudent() throws Exception {
        addPersonController.person = "S";
        addPersonController.group = groupsCB.getValue().toString();
        Stage stage = new Stage();
        Parent form = FXMLLoader.load(getClass().getResource("../view/person/addPerson.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Додавання нової особи");
        stage.setScene(new Scene(form));
        stage.show();
    }
        public void addNewGroup() throws Exception {
        addGroupController.cath = cathedralsCB.getValue().toString();
        Stage stage = new Stage();
        Parent form = FXMLLoader.load(getClass().getResource("../view/educationUnit/addGroup.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Додавання нової групи");
        stage.setScene(new Scene(form));
        stage.show();
    }
    public void deleteDepartment() {
        for (int i = 0; i < Controller.allDepartments.size(); i++) {
            if (Controller.allDepartments.get(i).getName().equals(departmentsCB.getValue().toString())) {
                Controller.ChNU.removeDepartment(Controller.allDepartments.get(i));
                Controller.allDepartments.remove(i);
            }
        }
        init();
    }
    public void deleteCathedra() {
        for (int i = 0; i < Controller.allCathedrals.size(); i++) {
            if (Controller.allCathedrals.get(i).getName().equals(cathedralsCB.getValue().toString())) {
                for (int j = 0; j < Controller.allDepartments.size(); j++) {
                    if (Controller.allDepartments.get(j).getName().equals(departmentsCB.getValue().toString())){
                        Controller.allDepartments.get(j).removeCathedral(Controller.allCathedrals.get(i));
                    }
                }
                Controller.allCathedrals.remove(i);
            }
        }
        init();
    }
    public void deleteProfessor() {
        for (int i = 0; i < Controller.allProfessors.size(); i++) {
            if (Controller.allProfessors.get(i).getName().equals(professorsCB.getValue().toString())) {
                for (int j = 0; j < Controller.allCathedrals.size(); j++) {
                    if (Controller.allCathedrals.get(j).getName().equals(cathedralsCB.getValue().toString())){
                        Controller.allCathedrals.get(j).removeProfessor(Controller.allProfessors.get(i));
                    }
                }
                Controller.allProfessors.remove(i);
            }
        }
        init();
    }
    public void deleteGroup() {
        for (int i = 0; i < Controller.allGroups.size(); i++) {
            if (Controller.allGroups.get(i).getName().equals(groupsCB.getValue().toString())) {
                for (int j = 0; j < Controller.allCathedrals.size(); j++) {
                    if (Controller.allCathedrals.get(j).getName().equals(cathedralsCB.getValue().toString())){
                        Controller.allCathedrals.get(j).removeGroup(Controller.allGroups.get(i));
                    }
                }
                Controller.allGroups.remove(i);
            }
        }
        init();
    }
    public void deleteStudent() {
        for (int i = 0; i < Controller.allStudents.size(); i++) {
            if (Controller.allStudents.get(i).getName().equals(studentsCB.getValue().toString())) {
                for (int j = 0; j < Controller.allGroups.size(); j++) {
                    if (Controller.allGroups.get(j).getName().equals(groupsCB.getValue().toString())){
                        Controller.allGroups.get(j).removeStudent(Controller.allStudents.get(i));
                    }
                }
                Controller.allStudents.remove(i);
            }
        }
        init();
    }

}