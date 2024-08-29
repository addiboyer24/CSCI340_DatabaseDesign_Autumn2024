public class Student {
    private int id;
    private String name;
    private int age;
    private String email;

    public Student(){
    }

    public Student(int id, String name, int age, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String toString(){
        return "StudentId: " + id
                + "\nName: " + name
                + "\nAge: " + age
                + "\nEmail: " + email
                + "\n";
    }
}
