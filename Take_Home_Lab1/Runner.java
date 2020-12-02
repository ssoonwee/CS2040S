//Name: Song Soon Wee
//Student No.: A0200378L

public class Runner {
    public String name;
    public double first_Time;
    public double sub_Time;
    public Runner(String name, double first_Time, double sub_Time){
        this.name = name;
        this.first_Time = first_Time;
        this.sub_Time = sub_Time;
    }

    public double getFirstTime(){
        return this.first_Time;
    }

    public double getSubTime(){
        return this.sub_Time;
    }

    public String getName(){
        return this.name;
    }
    
    @Override
    public boolean equals(Object obj){
        Runner object = (Runner) obj;
        return this.getName() == object.getName();
    }
}
