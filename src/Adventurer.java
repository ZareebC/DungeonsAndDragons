public class Adventurer{
    private String name;
    private String race;
    private String classtype;
    private int level;
    private int hp;
    private int age;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int[] attribute=new int[6];
    public Adventurer(String name){
        this.name = name;
        AttributeArray();
        this.race = deterRace();
        this.classtype = classtype;
        this.level = level;
        this.hp = hp;
        this.age = age;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }
    public int Die(int n){
        int rand = (int)(Math.random()*n)+1;
        return rand;
    }
    public int randNumTwo(int a, int b){
        int rand = (int)(Math.random()*b)+	a;
        return rand;
    }
    public int Sum(int x, int y, int z){
        int sum = x+y+z;
        return sum;
    }
    public int[] sortArr(int[] a){
        int temp = 0;
        for(int i = 0; i < a.length/2; i++){
            temp = a[i];
            a[i] = a[a.length+1];
            a[a.length+1] = temp;
        }
        return a;
    }
    public void AttributeArray(){

        for(int i=0;i<6;i++)
            attribute[i] = attributeBuilder();
        //0 - Strength
        //1 - Dexterity
        //2 - Constitution
        //3 - Intelligence
        //4 - Wisdom
        //5 - Charisma
        if(race.equals("Human")){
            for(int i = 0; i < attribute.length; i++)
                attribute[i] += 1;
        }
        if(race.equals("Elf")){
            attribute[1] += 2;
        }
        if(race.equals("Dwarf")){
            attribute[2] += 2;
        }
        if(race.equals("Halfling")){
            attribute[1] += 2;
        }
        if(race.equals("Dragonborn")){
            attribute[0] += 2;
            attribute[5] += 1;
        }
        if(race.equals("Gnome")){
            attribute[3] += 2;
        }
        if(race.equals("Half-Elf")){
            attribute[5] += 2;
            attribute[3] += 1;
            attribute[1] += 1;
        }
        if(race.equals("Half-Orc")){
            attribute[0] += 2;
            attribute[2] += 1;
        }
        if(race.equals("Teifling")){
            attribute[3] += 1;
            attribute[5] += 2;
        }
    }
    public int attributeBuilder(){
        int[] randDie = new int[4];
        for(int i = 0; i < randDie.length; i++){
            randDie[i] = Die(6);
        }
        sortArr(randDie);
        return Sum(randDie[0], randDie[1], randDie[2]);
    }
    public String deterRace(){
        int select = Die(9);
        String race = "";
        switch(select){
            case 1:
                race = "Human";
                break;
            case 2:
                race = "Dwarf";
                break;
            case 3:
                race = "Halfling";
                break;
            case 4:
                race = "Dragonborn";
                break;
            case 5:
                race = "Gnome";
                break;
            case 6:
                race = "Half-Elf";
                break;
            case 7:
                race = "Half-Orc";
                break;
            case 8:
                race = "Teifling";
                break;
        }
        return race;
    }
    public String deterClass(int[] arr){
        if()
    }
    public String getName(){
        return name;
    }
    public String getRace(){
        return race;
    }
    public String classtype(){
        return classtype;
    }
    public int getLevel(){
        return level;
    }
    public int getHP(){
        return hp;
    }
    public int getAge(){
        return age;
    }
    public int getStrength(){
        return strength;
    }
    public int getDexterity(){
        return dexterity;
    }
    public int getConstitution(){
        return constitution;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public int getWisdom(){
        return wisdom;
    }
    public int getCharisma(){
        return charisma;
    }
}