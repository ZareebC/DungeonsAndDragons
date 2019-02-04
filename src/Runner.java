import java.util.ArrayList;
public class Runner{
    ArrayList <Adventurer> holder =  new ArrayList <>();
    public Runner(){
        String name = "Mr.Joe";
        Adventurer guy = new Adventurer(name);
        Output output = new Output(guy);
        holder.add(guy);
        System.out.print(holder);

    }

    public static void main(String[]args){

        Runner app = new Runner();
    }
}