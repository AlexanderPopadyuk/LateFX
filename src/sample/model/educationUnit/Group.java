package sample.model.educationUnit;

import sample.model.Information;
import sample.model.person.Professor;
import sample.model.person.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 22.02.2016.
 */
public class Group implements Information {

    private Cathedral cathedral;
    private String Name;
    private Student Capitain;
    private Professor Curator;
    private List<Student> studentsList = new ArrayList<>();

    public Cathedral getCathedral() {
        return cathedral;
    }

    public void setCathedral(Cathedral cathedral) {
        this.cathedral = cathedral;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Student getCapitain() {
        return Capitain;
    }

    public void setCapitain(Student capitain) {
        Capitain = capitain;
    }

    public Professor getCurator() {
        return Curator;
    }

    public void setCurator(Professor curator) {
        Curator = curator;
    }

    public void addStudent(Student newStudent) {
        studentsList.add(newStudent);
    }
    public void removeStudent(Student student) {
        studentsList.remove(student);
    }

    public Group(Cathedral cathedral, String name) {
        this.cathedral = cathedral;
        this.Name = name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    @Override
    public void getInfo() {
        System.out.println("Group name= " + Name);
        System.out.println("Cathedra = " + cathedral.getName());
        if (Capitain != null) {
            System.out.println("Starosta's surname = " + Capitain.Surname);
        } else {
            System.out.println("Starosty nema!");
        }
        if (Curator != null) {
            System.out.println("Curator's surname = " + Curator.Surname);
        } else {
            System.out.println("Carator ne prnznachenuy");
        }
        if (studentsList != null){
            System.out.println("Students list: ");
            for (int i = 0; i < studentsList.size(); i++) {
                System.out.println(studentsList.get(i).getSurname());
            }
        } else {
            System.out.println("Students list is null!");
        }
        System.out.println();
    }

}
