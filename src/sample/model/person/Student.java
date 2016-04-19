package sample.model.person;

import sample.model.educationUnit.Group;

/**
 * Created by Asus on 22.02.2016.
 */
public class Student extends Person {

    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student(String id, Group group, String Name, String SurName) {
        super.id = id;
        this.group = group;
        super.Name = Name;
        super.Surname = SurName;
    }

    @Override
    public String getSurname() {
        return super.Surname;
    }

    @Override
    public String getName() {
        return super.Name;
    }

    @Override
    public void getInfo() {
        System.out.println("Student ticket number = " + super.id);
        System.out.println("Group name = "+group.getName());
        System.out.println("Name = "+ super.Name);
        System.out.println("Surname = " + super.Surname);
        System.out.println();
    }

}
