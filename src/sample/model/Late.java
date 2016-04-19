package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.person.Person;

import java.text.DateFormat;
import java.time.LocalDate;

/**
 * Created by Asus on 22.02.2016.
 */
public class Late implements Information {
    private LocalDate lateDate;
    private ObservableList<Person> list = FXCollections.observableArrayList();

    public Late(int year, int month, int day) {
        lateDate = LocalDate.of(year, month, day);
    }

    public void addLate(Person person) {
        list.add(person);
    }

    public ObservableList<Person> getList() {
        return list;
    }

    public LocalDate getLateDate() {
        return lateDate;
    }

    @Override
    public void getInfo() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        String str = lateDate.toString();
        if (list != null) {
            System.out.println("Late list on " + str + ":");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getSurname()+" "+list.get(i).getName());
            }
        } else {
            System.out.println("Late list on "+str+" is null!");
        }
        System.out.println();
    }
}
