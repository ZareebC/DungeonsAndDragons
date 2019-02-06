import java.util.ArrayList;
public class Runner{
    public Runner(){
        ArrayList <Adventurer> holder =  new ArrayList <>();
        for(int i = 0; i < 10; i++){
            holder.add(new Adventurer(determineName()));
        }
        for(int i = 0; i < 10; i++){
            System.out.println("Adventerur #" + i);
            Output output = new Output(holder.get(i));
        }

    }

    public String determineName(){
        String[] name = {"Boi", "Kevin", "Ursa", "Belvor", "Iorth", "Mr.Beast", "Aceter", "Thorus", "Hordun", "Jagster"};
        int rand = (int)(Math.random()*10);
        return name[rand];
    }

    public static void main(String[]args){

        Runner app = new Runner();
    }
}