package sample.model.person;

import sample.model.educationUnit.Cathedral;

/**
 * Created by Asus on 22.02.2016.
 */
public class Professor extends Person {

    private Cathedral cathedral;

    public Cathedral getCathedral() {
        return cathedral;
    }

    public void setCathedral(Cathedral cathedral) {
        this.cathedral = cathedral;
    }

    public Professor(String id, Cathedral cathedral, String Name, String Surname) {
        super.id = id;
        this.cathedral = cathedral;
        super.Name = Name;
        super.Surname = Surname;
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
        System.out.println("Professor number = " + super.id);
        System.out.println("Cathedral name = "+cathedral.getName());
        System.out.println("Name = "+ super.Name);
        System.out.println("Surname = " + super.Surname);
        System.out.println();
    }

}
