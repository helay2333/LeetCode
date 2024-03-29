package _DS.arrrayList;

import _DS.Tree.Comparable;

import java.util.Objects;

/**
 * @author Green写代码
 * @date 2022-04-15 09:54
 */
public class Person implements Comparable<Person> {

    public int age;
    public String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    public void finalize() throws Throwable{
        super.finalize();
        System.out.println("Person销毁了");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int compareTo(Person person) {
        return age - person.age;
    }
}
