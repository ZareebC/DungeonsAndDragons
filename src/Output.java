public class Output{
    public Output(Adventurer guy){

        System.out.println("Name: " + guy.getName());
        System.out.println("Race: " + guy.getRace());
        System.out.println("Age: " + guy.getAge());
        System.out.println("Class: " + guy.ClassType());
        System.out.println("Level: " + guy.getLevel());
        System.out.println("Speed: " + guy.getSpeed());
        System.out.println("Sight: " + guy.getSight());
        System.out.println("Hit Points: " + guy.getHP());
        Line();
        System.out.println("Strength: " + guy.getAttribute(0) + "\tModifier: " + guy.getAttributeMods(0));
        System.out.println("Dexterity: " + guy.getAttribute(1) + "\tModifier: " + guy.getAttributeMods(1));
        System.out.println("Constitution: " + guy.getAttribute(2) + "\tModifier: " + guy.getAttributeMods(2));
        System.out.println("Intelligence: " + guy.getAttribute(3) + "\tModifier: " + guy.getAttributeMods(3));
        System.out.println("Wisdom: " + guy.getAttribute(4) + "\tModifier: " + guy.getAttributeMods(4));
        System.out.println("Charisma: " + guy.getAttribute(5) + "\tModifier: " + guy.getAttributeMods(5));
        Line();
        System.out.println("Weapon List:");
        System.out.println("Weapon One: " + guy.getWeapons(0) + "\tWeapon Two: " + guy.getWeapons(1));
    }
    public void Line(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    }
}

