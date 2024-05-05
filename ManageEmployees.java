// Kyle Morgan
// The added methods print the names and positions of the people provided in the main method
// The added methods also prints out what programming language they prefer respective to their catagories.

// Creates lists of employees in a company, grouping them by category.
// Then creates a list of all employees from the aforementioned lists.
// Also creates a list of rather arbitrary objects.
// Prints these lists out.
// Demonstrates the use of wildcards in Java.
import java.util.ArrayList;
public class ManageEmployees {
public static void main(String[] args) {
ArrayList<WebDeveloper> webDevs = new ArrayList<>();
webDevs.add(new WebDeveloper("Sir Timothy Berners-Lee"));
webDevs.add(new WebDeveloper("Brendan Eich"));
ArrayList<SystemsProgrammer> sysDevs = new ArrayList<>();
sysDevs.add(new SystemsProgrammer("Grace Hopper"));
sysDevs.add(new SystemsProgrammer("Donald Knuth"));
ArrayList<Designer> designers = new ArrayList<>();
designers.add(new Designer("Roberta Williams"));
designers.add(new Designer("Sid Meier"));
ArrayList<Theorist> theorists = new ArrayList<>();
theorists.add(new Theorist("Shafrira Goldwasser"));
theorists.add(new Theorist("Stephen Cook"));
ArrayList<Programmer> devs = new ArrayList<>();
devs.add(new Programmer("Richard Stallman"));
devs.add(new Programmer("Bill Joy"));
ArrayList<Object> objects = new ArrayList<>();
objects.add(42);
objects.add("Hello");
objects.add(new Programmer("Linda Liukas"));
System.out.println("Web devs: "); printNames(webDevs);
System.out.println("Sys devs: "); printNames(sysDevs);
System.out.println("Designers: "); printNames(designers);
System.out.println("Theorists: "); printNames(theorists);
System.out.println("General devs: "); printNames(devs);
ArrayList<Employee> employees = new ArrayList<>();
addElements(webDevs, employees);
addElements(sysDevs, employees);
addElements(designers, employees);
addElements(theorists, employees);
addElements(devs, employees);
System.out.println("All employees: "); printNames(employees);
System.out.println("Web devs (using toString):"); printAll(webDevs);
System.out.println("Objects (using toString):"); printAll(objects);
System.out.println("Among web developers: ");
printFavoriteLanguages(webDevs);
addElements(webDevs, devs);
addElements(sysDevs, devs);
System.out.println("Among all developers: ");
printFavoriteLanguages(devs);
}
// INSERT THE MISSING METHODS HERE ...
public static void printNames(ArrayList<? extends Employee> employees) {
    for (Employee employee : employees) {
        System.out.println(employee.name());
    }
    System.out.println();
}

public static <T extends Employee> void addElements(ArrayList<T> source, ArrayList<? super T> destination) {
    destination.addAll(source);
}

public static void printAll(ArrayList<?> objects) {
    for (Object object : objects) {
        System.out.println(object.toString());
    }
    System.out.println();
}

public static void printFavoriteLanguages(ArrayList<? extends Programmer> programmers) {
    for (Programmer programmer : programmers) {
        System.out.println(programmer.name() + " prefers " + programmer.favoriteLanguage());
    }
    System.out.println();
}

}
class Employee {
private String name;
public Employee (String name) {
this.name = name;
}
public String name() {
return name;
}
}
class Programmer extends Employee {
public Programmer(String name) {
super(name);
}
public String favoriteLanguage() {
return "Java";
}
}
class WebDeveloper extends Programmer {
public WebDeveloper(String name) {
super(name);
}
public String favoriteLanguage() {
return "JavaScript";
}
}
class SystemsProgrammer extends Programmer {
public SystemsProgrammer(String name) {
super(name);
}
public String favoriteLanguage() {
return "C";
}
}
class Theorist extends Employee {
public Theorist(String name) {
super(name);
}
}
class Designer extends Employee {
public Designer(String name) {
super(name);
}
}