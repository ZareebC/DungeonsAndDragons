import com.sun.org.apache.xpath.internal.SourceTree;

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
    private int feet;
    private int inch;
    private String[] weapons ={"Longsword", "Mace", "Warhammer", "Shortsword", "Morningstar", "Greatsword", "Dagger", "Rapier", "Quarterstaff", "Light Crossbow", "Nunchaku", "Katana", "Shortbow", "Longbow", "Darts", "Sling", "Trident", "Scimitar"};
    private String[] characterWeapons = new String[2];
    private int Speed;
    private int sight;
    public Adventurer(String name){
        this.name = name;
        this.race = deterRace();
        AttributeArray();
        this.classType = deterClass(attribute);
        this.level = level;
        this.hp = DeterHP(attributeMods);
        this.age = DeterAge(race);
        DeterHeight();
        DeterSpeed();
        DeterSight();
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        AttributeModifs(attribute);
        pickWeapon();
    }
    public int Die(int n){
        int rand = (int)(Math.random()*n)+1;
        return rand;
    }
    public int randNumTwo(int a, int b){
        int rand = (int)(Math.random()*b)+ a;
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
            a[i] = a[a.length-1];
            a[a.length-1] = temp;
        }
        return a;
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
            case 9:
                race = "Elf";
                break;
        }
        return race;
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

    public String deterClass(int[] arr){
        int rand = randNumTwo(1, 12);
        String detClass = "";
        //0 - Strength
        //1 - Dexterity
        //2 - Constitution
        //3 - Intelligence
        //4 - Wisdom
        //5 - Charisma
        if((arr[0]> arr[1]) && (arr[0] > arr[2]) && (arr[0]> arr[3]) && (arr[0]> arr[4]) && (arr[0]> arr[5]) && (arr[2]> arr[1]) && (arr[2]> arr[3]) && (arr[2]> arr[4]) && (arr[2]> arr[5])){
            detClass = "Barbarian";
        }
        else if((arr[5]> arr[0]) && (arr[5]> arr[1]) && (arr[5]> arr[2]) && (arr[5]> arr[3]) && (arr[5]> arr[4]) && (arr[1]> arr[0]) && (arr[1]> arr[2]) && (arr[1]> arr[3]) && (arr[1] > arr[4])){
            detClass = "Bard";
        }
        else if((arr[4]> arr[0]) && (arr[4]> arr[1]) && (arr[4]> arr[2]) && (arr[4]> arr[3]) && (arr[4]> arr[5]) && (arr[3]> arr[0]) && (arr[3]> arr[2]) && (arr[3]> arr[4]) && (arr[3] > arr[5])){
            detClass = "Cleric";
        }
        else if((arr[4]> arr[0]) && (arr[4]> arr[1]) && (arr[4]> arr[2]) && (arr[4]> arr[3]) && (arr[4]> arr[5]) && (arr[3]> arr[0]) && (arr[3]> arr[2]) && (arr[3]> arr[4]) && (arr[3] > arr[5])){
            detClass = "Druid";
        }
        else if((arr[0]> arr[1]) && (arr[0]> arr[2]) && (arr[0]> arr[3]) && (arr[0]> arr[4]) && (arr[0]> arr[5]) && (arr[1]> arr[2]) && (arr[1]> arr[3]) && (arr[1]> arr[4]) && (arr[1] > arr[5])){
            detClass = "Fighter";
        }
        else if((arr[1]> arr[0]) && (arr[1]> arr[2]) && (arr[1]> arr[3]) && (arr[1]> arr[4]) && (arr[1]> arr[5]) && (arr[4]> arr[0]) && (arr[4]> arr[2]) && (arr[4]> arr[3]) && (arr[4] > arr[5])){
            detClass = "Monk";
        }
        else if((arr[0]> arr[1]) && (arr[0]> arr[2]) && (arr[0]> arr[3]) && (arr[0]> arr[4]) && (arr[0]> arr[5]) && (arr[5]> arr[1]) && (arr[5]> arr[2]) && (arr[5]> arr[3]) && (arr[5] > arr[4])){
            detClass = "Paladin";
        }
        else if((arr[4]> arr[0]) && (arr[4]> arr[1]) && (arr[4]> arr[2]) && (arr[4]> arr[3]) && (arr[4]> arr[5]) && (arr[1]> arr[0]) && (arr[1]> arr[2]) && (arr[1]> arr[3]) && (arr[1] > arr[5])) {
            detClass = "Ranger";
        }
        else if((arr[1]> arr[0]) && (arr[1]> arr[2]) && (arr[1]> arr[3]) && (arr[1]> arr[4]) && (arr[1]> arr[5]) && (arr[3]> arr[0]) && (arr[3]> arr[2]) && (arr[3]> arr[4]) && (arr[1] > arr[5])){
            detClass = "Rogue";
        }
        else if((arr[5]> arr[0]) && (arr[5]> arr[1]) && (arr[5]> arr[2]) && (arr[5]> arr[3]) && (arr[5]> arr[4]) && (arr[2]> arr[1]) && (arr[2]> arr[3]) && (arr[2]> arr[4]) && (arr[2] > arr[5])){
            detClass = "Sorceror";
        }
        else if((arr[5]> arr[0]) && (arr[5]> arr[1]) && (arr[5]> arr[2]) && (arr[5]> arr[3]) && (arr[5]> arr[4]) && (arr[4]> arr[0]) && (arr[4]> arr[1]) && (arr[4]> arr[2]) && (arr[4] > arr[3])){
            detClass = "Warlock";
        }
        else if((arr[3]> arr[0]) && (arr[3]> arr[1]) && (arr[3]> arr[2]) && (arr[3]> arr[4]) && (arr[3]> arr[5]) && (arr[4]> arr[0]) && (arr[4]> arr[1]) && (arr[4]> arr[2]) && (arr[4] > arr[5])){
            detClass = "Wizard";
        }
        else{
            switch(rand){
                case 1: detClass = "Barbarian"; break;
                case 2: detClass = "Bard"; break;
                case 3: detClass = "Cleric"; break;
                case 4: detClass = "Druid"; break;
                case 5: detClass = "Fighter"; break;
                case 6: detClass = "Monk"; break;
                case 7: detClass = "Paladin"; break;
                case 8: detClass = "Ranger"; break;
                case 9: detClass = "Rogue"; break;
                case 10: detClass = "Sorceror"; break;
                case 11: detClass = "Warlock"; break;
                default: detClass = "Wizard"; break;
            }
        }
        return detClass;
    }
    public void AttributeModifs(int[] arr){
        for(int i = 0; i < 6; i++){
            if(arr[i] == 1){
                attributeMods[i] = -5;
            }
            else if(arr[i] == 2 || arr[i] == 3){
                attributeMods[i] = -4;
            }
            else if(arr[i] == 4 || arr[i] == 5){
                attributeMods[i] = -3;
            }
            else if(arr[i] == 6 || arr[i] == 7){
                attributeMods[i] = -2;
            }
            else if(arr[i] == 8 || arr[i] == 9){
                attributeMods[i] = -1;
            }
            else if(arr[i] == 10 || arr[i] == 11){
                attributeMods[i] = 0;
            }
            else if(arr[i] == 12 || arr[i] == 13){
                attributeMods[i] = 1;
            }
            else if(arr[i] == 14 || arr[i] == 15){
                attributeMods[i] = 2;
            }
            else if(arr[i] == 16 || arr[i] == 17){
                attributeMods[i] = 3;
            }
            else if(arr[i] == 18 || arr[i] == 19){
                attributeMods[i] = 4;
            }
            else{
                attributeMods[i] = 5;
            }
        }
    }
    public int DeterHP(int[] arr){
        int hitpoint = 0;
        if(classType.equals("Barbarian")){
            hitpoint = 10 + Die(4) + arr[2];
        }
        else if(classType.equals("Fighters") || classType.equals("Paladin") || classType.equals("Rangers")){
           hitpoint = 8 + Die(4) + arr[2];
        }
        else if(classType.equals("Sorceror") || classType.equals("Wizard")){
            hitpoint = 4 + Die(4) + arr[2];
        }
        else{
            hitpoint = 6 + Die(4) + arr[2];
        }
        return hitpoint;
    }
    public int DeterAge(String raceAge){
        int age = 0;
        if(raceAge.equals("Dwarf")){
            age = randNumTwo(50, 250);
        }
        else if(raceAge.equals("Elf")){
            age = randNumTwo(100, 600);
        }
        else if(raceAge.equals("Halfling")){
            age = randNumTwo(20, 120);
        }
        else if(raceAge.equals("Human")){
            age = randNumTwo(17, 55);
        }
        else if(raceAge.equals("Dragonborn")){
            age = randNumTwo(15, 60);
        }
        else if(raceAge.equals("Gnome")){
            age = randNumTwo(40, 425);
        }
        else if(raceAge.equals("Half-Elf")){
            age = randNumTwo(19, 140);
        }
        else if(raceAge.equals("Half-Orc")){
            age = randNumTwo(14, 60);
        }
        else{               //Tiefling
           age = randNumTwo(17, 65);
        }
        return age;
    }
    public void DeterHeight(){
        if(race.equals("Dwarf")){
            feet = randNumTwo(4,5);
            if(feet == 4) {
                inch = randNumTwo(1, 11);
            }
        }
        else if(race.equals("Elf")){
            feet = randNumTwo(5, 6);
            if(feet == 5){
                inch = randNumTwo(1, 11);
            }
            else{
                inch = randNumTwo(1, 2);
            }
        }
        else if(race.equals("Halfling")){
            feet = randNumTwo(2, 3);
            if(feet ==2){
                inch = randNumTwo(6, 11);
            }
            else if(feet == 3){
                inch = randNumTwo(1, 6);
            }
        }
        else if(race.equals("Human")){
            feet = randNumTwo(5, 6);
            if(feet == 5){
                inch = randNumTwo(1, 11);
            }
            else{
                inch = randNumTwo(1, 6);
            }
        }
        else if(race.equals("Dragonborn")){
            feet = randNumTwo(6, 7);
            if(feet == 6){
                inch = randNumTwo(4, 11);
            }
            else{
                inch = randNumTwo(1, 6);
            }
        }
        else if(race.equals("Gnome")){
            feet = randNumTwo(3, 4);
            if(feet == 3){
                inch = randNumTwo(1,11);
            }
            else{
                inch = randNumTwo(1, 4);
            }
        }
        else if(race.equals("Half-Elf")){
            feet = randNumTwo(5, 6);
            if(feet == 5){
                inch = randNumTwo(1, 11);
            }
            else{
                inch = randNumTwo(1, 4);
            }
        }
        else if(race.equals("Half-Orc")){
            feet = randNumTwo(5, 6);
            if(feet == 5){
                inch = randNumTwo(5, 11);
            }
            else{
                inch = randNumTwo(1,10);
            }
        }
        else{         //Teifling
            feet = randNumTwo(5, 6);
            if(feet == 5){
                inch = randNumTwo(1, 11);
            }
            else{
                inch = randNumTwo(1,6);
            }
        }
    }
    public void pickWeapon(){

        /*
        0-Longsword
        1-Mace
        2-Warhammer
        3-Shortsword
        4-Morningstar
        5-Greatsword
        6-Dagger
        7-Rapier
        8-Quarterstaff
        9-Light Crossbow
        10-Nunchaku
        11-Katana
        12-Shortbow
        13-Longbow
        14-Darts
        15-Sling
        16-Trident
        17-Scimitar
         */
        int rand = 0;
        if(classType.equals(("Barbarian"))){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 6);
                if (rand == 1) {
                    characterWeapons[i] = weapons[0];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[1];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[2];
                }
                else if (rand == 4) {
                    characterWeapons[i] = weapons[3];
                }
                else if (rand == 5) {
                    characterWeapons[i] = weapons[4];
                }
                else {
                    characterWeapons[i] = weapons[5];
                }
            }
        }
        else if(classType.equals("Bard")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 7);
                if (rand == 1) {
                    characterWeapons[i] = weapons[6];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[7];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[3];
                }
                else if (rand == 4) {
                    characterWeapons[i] = weapons[0];
                }
                else if (rand == 5) {
                    characterWeapons[i] = weapons[8];
                }
                else {
                    characterWeapons[i] = weapons[9];
                }
            }
        }
        else if(classType.equals("Cleric")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 4);
                if (rand == 1) {
                    characterWeapons[i] = weapons[6];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[14];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[15];
                }
                else {
                    characterWeapons[i] = weapons[8];
                }
            }
        }
        else if(classType.equals("Druid")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 7);
                if (rand == 1) {
                    characterWeapons[i] = weapons[6];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[14];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[15];
                }
                else if(rand == 4){
                    characterWeapons[i] = weapons[8];
                }
                else if(rand == 5){
                    characterWeapons[i] = weapons[16];
                }
                else if(rand == 6){
                    characterWeapons[i] = weapons[1];
                }
                else{
                    characterWeapons[i] = weapons[17];
                }
            }
        }
        else if(classType.equals("Fighter")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 6);
                if (rand == 1) {
                    characterWeapons[i] = weapons[0];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[1];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[2];
                }
                else if(rand == 4){
                    characterWeapons[i] = weapons[3];
                }
                else if(rand == 5){
                    characterWeapons[i] = weapons[4];
                }
                else{
                    characterWeapons[i] = weapons[5];
                }
            }
        }
        else if(classType.equals("Monk")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 3);
                if (rand == 1) {
                    characterWeapons[i] = weapons[8];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[10];
                }
                else {
                    characterWeapons[i] = weapons[11];
                }
            }
        }
        else if(classType.equals("Paladin")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 4);
                if (rand == 1) {
                    characterWeapons[i] = weapons[0];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[1];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[2];
                }
                else {
                    characterWeapons[i] = weapons[3];
                }
            }
        }
        else if(classType.equals("Ranger")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 4);
                if (rand == 1) {
                    characterWeapons[i] = weapons[13];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[12];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[9];
                }
                else {
                    characterWeapons[i] = weapons[0];
                }
            }
        }
        else if(classType.equals("Rogue")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 4);
                if (rand == 1) {
                    characterWeapons[i] = weapons[6];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[7];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[3];
                }
                else {
                    characterWeapons[i] = weapons[0];
                }
            }
        }
        else if(classType.equals("Sorcerer")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 4);
                if (rand == 1) {
                    characterWeapons[i] = weapons[6];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[14];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[15];
                }
                else {
                    characterWeapons[i] = weapons[8];
                }
            }
        }
        else if(classType.equals("Warlock")){
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 5);
                if (rand == 1) {
                    characterWeapons[i] = weapons[6];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[14];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[15];
                }
                else if(rand == 4){
                    characterWeapons[i] = weapons[8];
                }
                else{
                    characterWeapons[i] = weapons[17];
                }
            }
        }
        else{   //Wizard
            for(int i = 0; i < 2; i++) {
                rand = randNumTwo(1, 4);
                if (rand == 1) {
                    characterWeapons[i] = weapons[6];   //Character weapons holds the two weapons
                }
                else if (rand == 2) {
                    characterWeapons[i] = weapons[14];
                }
                else if (rand == 3) {
                    characterWeapons[i] = weapons[15];
                }
                else {
                    characterWeapons[i] = weapons[8];
                }
            }
        }
    }
    public void DeterSpeed(){
        if(race.equals("Dwarf") || race.equals("Halfling") || race.equals("Gnome")){
            Speed = 25;
        }
        else if(race.equals("Elf")){
            Speed = 35;
        }
        else{
            Speed = 30;
        }
    }
    public void DeterSight(){
        if(race.equals("Halfling") || race.equals("Human") || race.equals("Half-Orc")){
            sight = 30;
        }
        else{
            sight = 60;
        }
    }
    public void ASCII(String c){
      System.out.println("iiiiii");
    }
    public String getName(){
        return name;
    }
    public String getRace(){
        return race;
    }
    public String ClassType(){
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
    public int getAttribute(int i){
        return attribute[i];
    }
    public int getAttributeMods(int i){
        return attributeMods[i];
    }
    public int getSpeed(){
        return Speed;
    }
    public int getSight(){
        return sight;
    }
    public String getWeapons(int i){
        return characterWeapons[i];
    }
    public int getFeet(){
       return feet;
    }
    public int getInch(){
        return inch;
    }
    public void getASCII(){
        ASCII(classType);
    }
}