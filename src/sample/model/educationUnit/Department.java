package sample.model.educationUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 22.02.2016.
 */
public class Department extends MinOsvitiUnit{

    private EducationUnit educationUnit;
    private List<Cathedral> cathedralsList = new ArrayList<>();

    public EducationUnit getEducationUnit() {
        return educationUnit;
    }

    public List<Cathedral> getCathedralsList() {
        return cathedralsList;
    }


    public void setEducationUnitID(EducationUnit education) {
        educationUnit = education;
    }

    public void addCathedral(Cathedral newCathedral) {
        cathedralsList.add(newCathedral);
    }
    public void removeCathedral(Cathedral cathedral) {cathedralsList.remove(cathedral);}

    public Department(EducationUnit educationUnit, String name, String address, String phone){
        this.educationUnit = educationUnit;
        super.Name = name;
        super.Address = address;
        super.Phone = phone;
    }
    public String getName() {
        return super.Name;
    }

    @Override
    public void getInfo() {
        System.out.println("Education unit name = " + educationUnit.Name);
        System.out.println("Department name = " + super.Name);
        System.out.println("Address = " + super.Address);
        System.out.println("Phone = " + super.Phone);
        if (cathedralsList != null) {
            System.out.println("Cathedrals list: ");
            for (int i = 0; i < cathedralsList.size(); i++) {
                System.out.println(cathedralsList.get(i).getName());
            }
        } else {
            System.out.println("Cathedrals list is null!");
        }
        System.out.println();
    }

}
