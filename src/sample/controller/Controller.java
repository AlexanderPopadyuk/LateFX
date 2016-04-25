package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import sample.model.*;
import sample.model.educationUnit.*;
import sample.model.person.*;
import org.json.simple.JSONObject;

import java.net.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    public Button showButton;
    public TableView<Person> tableV;
    public TableColumn surnameCol;
    public TableColumn nameCol;
    public DatePicker lateDate;
    public static List<Late> lateList = new ArrayList<>();

    public static List<Department> allDepartments= new ArrayList<>();
    public static List<Cathedral> allCathedrals= new ArrayList<>();
    public static List<Professor> allProfessors= new ArrayList<>();
    public static List<Group> allGroups= new ArrayList<>();
    public static List<Student> allStudents= new ArrayList<>();

    public static EducationUnit ChNU = new EducationUnit("Чернівецький національний університет", "вулиця Коцюбинського 2","+380372526235");

    @FXML
    public void initialize() {
        allDepartments.add(new Department(ChNU,"Інститут біології, хімії та біоресурсів","вулиця Лесі Українки 25","0000000000000"));
        ChNU.addDepartment(allDepartments.get(0));
        allDepartments.add(new Department(ChNU,"Географічний факультет","вулиця Коцюбинського 2","+380372526235"));
        ChNU.addDepartment(allDepartments.get(1));
        allDepartments.add(new Department(ChNU,"Інститут фізико-технічних та комп’ютерних наук","вулиця Університетська 28","+380372547173"));
        ChNU.addDepartment(allDepartments.get(2));

        allCathedrals.add(new Cathedral(allDepartments.get(2),"Кафедра комп'ютерних систем та мереж", "вулиця Університетська 28", "+380372547173"));
        allCathedrals.add(new Cathedral(allDepartments.get(2),"Кафедра математичних проблем управління і кібернетики","вулиця Університетська 28","+380372547173"));
        allCathedrals.add(new Cathedral(allDepartments.get(2),"Кафедра програмного забезпечення комп’ютерних систем","вулиця Університетська 28","+380372547173"));

        allDepartments.get(2).addCathedral(allCathedrals.get(0));
        allDepartments.get(2).addCathedral(allCathedrals.get(1));
        allDepartments.get(2).addCathedral(allCathedrals.get(2));

        allProfessors.add(new Professor("4684984",allCathedrals.get(2),"Інесса","Залуцька"));

        allGroups.add(new Group(allCathedrals.get(2),"343sk"));
        allGroups.add(new Group(allCathedrals.get(2),"343"));
        allGroups.add(new Group(allCathedrals.get(2),"243"));

        allCathedrals.get(2).addGroup(allGroups.get(0));
        allCathedrals.get(2).addGroup(allGroups.get(1));
        allCathedrals.get(2).addGroup(allGroups.get(2));
        allCathedrals.get(2).addProfessor(allProfessors.get(0));

        allStudents.add(new Student("2184684321",allGroups.get(0),"Олександр","Попадюк"));
        allStudents.add(new Student("2184684322",allGroups.get(0),"Орест","Кравчук"));
        allStudents.add(new Student("2184684323",allGroups.get(0),"Юлія","Луканюк"));

        allGroups.get(0).addStudent(allStudents.get(0));
        allGroups.get(0).addStudent(allStudents.get(1));
        allGroups.get(0).addStudent(allStudents.get(2));
        allGroups.get(0).setCapitain(allStudents.get(2));
        allGroups.get(0).setCurator(allProfessors.get(0));
        //
        Late todayLate = new Late(2016,3,23);
        todayLate.addLate(allStudents.get(0));
        todayLate.addLate(allStudents.get(1));
        todayLate.addLate(allStudents.get(2));
        //
        lateList.add(todayLate);
    }

    @FXML
    public void writeTable() {
        if (lateList != null) {
            for (int i = 0; i < lateList.size(); i++) {
                if (lateList.get(i).getLateDate().toString().equals(lateDate.getValue().toString())) {
                    tableV.setItems(lateList.get(i).getList());
                    surnameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("Surname"));
                    nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));
                }
            }
        }
    }
    @FXML
    public void openAdminPanel() throws Exception {
        Stage stage = new Stage();
        Parent adminPanel = FXMLLoader.load(getClass().getResource("../view/adminPanel.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Адмін панель");
        stage.setScene(new Scene(adminPanel));
        stage.show();
    }
    public String getJSON(){
        JSONObject lateJSON = new JSONObject();

        for (int i = 0; i < lateList.size(); i++) {
            if (lateList.get(i).getLateDate().toString().equals(lateDate.getValue().toString())){
                lateJSON.put("date",lateList.get(i).getLateDate().toString());
                JSONArray ar = new JSONArray();
                for (int j = 0; j < lateList.get(i).getList().size(); j++) {
                    JSONObject obj = new JSONObject();
                    obj.put("surname",lateList.get(i).getList().get(j).getSurname());
                    obj.put("name",lateList.get(i).getList().get(j).getName());
                    ar.add(obj);
                }
                lateJSON.put("list",ar);
            }
        }
        /* Запис в файл
        try (FileWriter file = new FileWriter("/Users/Asus/Desktop/sample.json")) {
            file.write(lateJSON.toJSONString());
        }*/
        return lateJSON.toJSONString();
    }
    public String getXML(){
        String date = "", list = "";
        for (int i = 0; i < lateList.size(); i++) {
            if (lateList.get(i).getLateDate().toString().equals(lateDate.getValue().toString())){
                date = lateList.get(i).getLateDate().toString();
                for (int j = 0; j < lateList.get(i).getList().size(); j++) {
                    list += "<Surname>" + lateList.get(i).getList().get(j).getSurname() + "</Surname>";
                    list += "<Name>" + lateList.get(i).getList().get(j).getName() + "</Name>";
                }
            }
        }
        String xml = "<LateList>" +
                "<Date>" + date + "</Date>" +
                "<List>" + list + "</List>" +
                "</LateList>";
        /* Запис в файл
        try (FileWriter file = new FileWriter("/Users/Asus/Desktop/sample.xml")) {
            file.write(xml);
        }*/
        return xml;
    }
    @FXML
    public void importJSON() throws Exception{
        SendController.data = getJSON();
        Stage stage = new Stage();
        Parent sendPanel = FXMLLoader.load(getClass().getResource("../view/sendPanel.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Відправка даних на сервер");
        stage.setScene(new Scene(sendPanel));
        stage.show();
    }
    @FXML
    public void importXML() throws Exception{
        SendController.data = getXML();
        Stage stage = new Stage();
        Parent sendPanel = FXMLLoader.load(getClass().getResource("../view/sendPanel.fxml"));
        stage.getIcons().add(new Image("file:src/sample/logo_32x32.png"));
        stage.setTitle("Відправка даних на сервер");
        stage.setScene(new Scene(sendPanel));
        stage.show();
    }

}
