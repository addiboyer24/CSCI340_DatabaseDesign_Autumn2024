package App.Domain;

public class Student {
    private int studentId;

    private String name;

    private String email;

    private String address;

    public int getStudentId(){
        return this.studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
