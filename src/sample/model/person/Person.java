package sample.model.person;

import sample.model.Information;

/**
 * Created by Asus on 22.02.2016.
 */

public abstract class Person implements Information {

    public String id;
    public String Name;
    public String Surname;

    public abstract String getSurname();
    public abstract String getName();

}