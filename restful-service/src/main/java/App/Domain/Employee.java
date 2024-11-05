package App.Domain;

public class Employee {
    private String ssn;

    private String fName;

    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    public String getSsn(){
        return this.ssn;
    }

    public void setFName(String fName){
        this.fName = fName;
    }

    public String getFName(){
        return this.fName;
    }
}
