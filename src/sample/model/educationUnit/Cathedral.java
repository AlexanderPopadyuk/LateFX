package sample.model.educationUnit;

import sample.model.person.Professor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 22.02.2016.
 */
public class Cathedral extends MinOsvitiUnit {

    private Department depatrment;
    private List<Group> groupsList = new ArrayList<>();
    private List<Professor> professorList = new ArrayList<>();

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public Department getDepatrment() {
        return depatrment;
    }

    public void setDepatrment(Department depatrment) {
        this.depatrment = depatrment;
    }

    public void addGroup(Group newGroup) {
        groupsList.add(newGroup);
    }
    public void removeGroup(Group group) { groupsList.remove(group); }
    public void removeProfessor(Professor professor) { professorList.remove(professor); }

    public void addProfessor(Professor newProfessor) {
        professorList.add(newProfessor);
    }

    public Cathedral(Department depatrment, String name, String address, String phone) {
        this.depatrment = depatrment;
        super.Name = name;
        super.Address = address;
        super.Phone = phone;
    }
    public String getName() {
        return super.Name;
    }

    @Override
    public void getInfo() {
        System.out.println("Department = " + depatrment.getName());
        System.out.println("Name = " + super.Name);
        System.out.println("Address = " + super.Address);
        System.out.println("Phone = " + super.Phone);
        if (groupsList != null) {
            System.out.println("Groups list: ");
            for (int i = 0; i < groupsList.size(); i++) {
                System.out.println(groupsList.get(i).getName());
            }
        } else {
            System.out.println("Group list is null!");
        }
        System.out.println();
    }

    public List<Group> getGroupsList() {
        return groupsList;
    }
}
