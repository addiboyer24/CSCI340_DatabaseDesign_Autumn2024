package App.Domain;

public class Department {
    private int number;
    private String name;
    private String managerSsn;
    private String startDate;

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setManagerSsn(String managerSsn){
        this.managerSsn = managerSsn;
    }

    public String getManagerSsn(){
        return this.managerSsn;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public String getStartDate(){
        return this.startDate;
    }
}
