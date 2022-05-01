package _DS.Hash;

import java.util.Objects;

/**
 * @author Green写代码
 * @date 2022-05-01 15:05
 */
class Person{
    int age;
    float height;
    String name;
    Person(int age, float height, String name){
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Float.compare(person.height, height) == 0 && Objects.equals(name, person.name);
    }


    @Override
    public int hashCode() {
//        return Objects.hash(age, height, name);
        int hashcode = Integer.hashCode(age);
        hashcode = hashcode * 31 + Float.hashCode(height);
        hashcode = hashcode * 31 + (name != null ? name.hashCode() : 0);
        return hashcode;
    }
}
public class Main {
    public static void main(String[] args) {
        String string  = "jack";
        System.out.println(string.hashCode());
        int len = string.length();
        int hascode= 0;
        for(int i = 0; i < len; i++){
            char c = string.charAt(i);
            hascode = hascode * 31 + c;
            //(hascode << 5) - hascode + c;
            //((j*31 + a) * 31 + c) * 31 + k
        }
        System.out.println(hascode);
    }
}
