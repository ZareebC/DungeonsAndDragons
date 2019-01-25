public class Adventurer{
    private String name;
    private String race;
    private String classType;
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
    private int[] attributeMods = new int[6];
    public Adventurer(String name){
        this.name = name;
        AttributeArray();
        this.race = deterRace();
        this.classType = deterClass(attribute);
        this.level = level;
        this.hp = DeterHP(attributeMods);
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
        String detClass = "";
        if(arr[0]> arr[2]){
            detClass = "Barbarian";
        }
        if(arr[5] > arr[1]){
            detClass = "Bard";
        }
        if(arr[4] > arr[5]){
            detClass = "Cleric";
        }
        if(arr[4] > arr[3]){
            detClass = "Druid";
        }
        if(arr[0] > arr[1]){
            detClass = "Fighter";
        }
        if(arr[1] > arr[4]){
            detClass = "Monk";
        }
        if(arr[0] > arr[5]){
            detClass = "Paladin";
        }
        if(arr[4] > arr[1]) {
            detClass = "Ranger";
        }
        if(arr[1] > arr[3]){
            detClass = "Rogue";
        }
        if(arr[5] > arr[2]){
            detClass = "Sorceror";
        }
        if(arr[5] > arr[4]){
            detClass = "Warlock";
        }
        if(arr[3] > arr[4]){
            detClass = "Wizard";
        }
        return detClass;
    }
    public void AtrributeModifs(int[] arr){
        for(int i = 0; i < 6; i++){
            if(arr[i] == 1){
                attributeMods[i] = -5;
            }
            if(arr[i] == 2 || arr[i] == 3){
                attributeMods[i] = -4;
            }
            if(arr[i] == 4 || arr[i] == 5){
                attributeMods[i] = -3;
            }
            if(arr[i] == 6 || arr[i] == 7){
                attributeMods[i] = -2;
            }
            if(arr[i] == 8 || arr[i] == 9){
                attributeMods[i] = -1;
            }
            if(arr[i] == 10 || arr[i] == 11){
                attributeMods[i] = 0;
            }
            if(arr[i] == 12 || arr[i] == 13){
                attributeMods[i] = 1;
            }
            if(arr[i] == 14 || arr[i] == 15){
                attributeMods[i] = 2;
            }
            if(arr[i] == 16 || arr[i] == 17){
                attributeMods[i] = 3;
            }
            if(arr[i] == 18 || arr[i] == 19){
                attributeMods[i] = 4;
            }
            else{
                attributeMods[i] = 5;
            }
        }
    }
    public int DeterHP(int[] arr){
        if(classType.equals("Barbarian")){
            hp = 10 + Die(4) + arr[2];
        }
        else if(classType.equals("Fighters") || classType.equals("Paladin") || classType.equals("Rangers")){
           hp = 8 + Die(4) + arr[2];
        }
        else if(classType.equals("Sorceror") || classType.equals("Wizard")){
            hp = 4 + Die(4) + arr[2];
        }
        else{
            hp = 6 + Die(4) + arr[2];
        }
    }
    public String getName(){
        return name;
    }
    public String getRace(){
        return race;
    }
    public String classtype(){
        return classType;
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