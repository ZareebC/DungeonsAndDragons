public class Runner{

    public Runner(){
        String name = "Mr.Joe";
        Adventurer guy = new Adventurer(name);
        Output output = new Output(guy);

    }

    public static void main(String[]args){
        Runner app = new Runner();
    }
}