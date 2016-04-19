package sample.model.educationUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 22.02.2016.
 */
public class EducationUnit extends MinOsvitiUnit {

    private List<Department> departmentsList = new ArrayList<>();

    public List<Department> getDepartmentsList() {
        return departmentsList;
    }

    public void addDepartment(Department newDepartment) {
        departmentsList.add(newDepartment);
    }
    public void removeDepartment(Department department) {departmentsList.remove(department);}

    public EducationUnit(String name, String address, String phone) {
        super.Name = name;
        super.Address = address;
        super.Phone = phone;
    }
    public String getName() {
        return super.Name;
    }

    @Override
    public void getInfo() {
        System.out.println("Name = " + super.Name);
        System.out.println("Address = " + super.Address);
        System.out.println("Phone = " + super.Phone);
        if (departmentsList != null) {
            System.out.println("Departments list: ");
            for (int i = 0; i < departmentsList.size(); i++) {
                System.out.println(departmentsList.get(i).getName());
            }
        } else {
            System.out.println("Departments list is null!");
        }
        System.out.println();
    }

}
