package sample.Employee;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class CollectionEmployee {
    private ObservableList<Person> personList = FXCollections.observableArrayList();


    public void add(Person person){personList.add(person);}

    public void update(Person person) {
        //в этом методе нужно прописать обновление в БД
    }

    public void delete(Person person){
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList(){
        return personList;
    }
    public void fillTestData(){
        personList.add(new Person("Менеджер","Иванов Олег Андреевич","Норм. мужик","8.08.1987","1.01.2003","м"));
        personList.add(new Person("Токарь","Сидоров Олег Андреевич","5-го розряда","8.08.1985","5.05.2005","м"));
        personList.add(new Person("Лесоруб","Козлов Олег Андреевич","бухает","8.08.1984","2.02.2002","м"));
        personList.add(new Person("Строитель","Павлов Олег Андреевич","жестко бухает","8.08.1976","18.01.2013","м"));
        personList.add(new Person("Повар","Никищенко Олег Андреевич","так себе","8.08.1983","1.01.2003","м"));
        personList.add(new Person("Повар","Никищенко Олег Андреевич","так себе","8.08.1983","1.01.2003","м"));
        personList.add(new Person("Повар","Никищенко Олег Андреевич","так себе","8.08.1983","1.01.2003","м"));
        personList.add(new Person("Повар","Никищенко Олег Андреевич","так себе","8.08.1983","1.01.2003","м"));

    }
}
