public class Output{
    private String classT;
    public Output(Adventurer guy){
        classT = guy.ClassType();
        ASCII();
        System.out.println("Name: " + guy.getName());
        System.out.println("Race: " + guy.getRace());
        System.out.println("Age: " + guy.getAge());
        System.out.println("Class: " + guy.ClassType());
        System.out.println("Level: " + guy.getLevel());
        System.out.println("Speed: " + guy.getSpeed());
        System.out.println("Sight: " + guy.getSight());
        System.out.println("Hit Points: " + guy.getHP());
        System.out.println("Height: " + guy.getFeet() + "'" + " " + guy.getInch() + "\"");
        ASCII();
        System.out.println("Strength: " + guy.getAttribute(0) + "   \t\tModifier: " + guy.getAttributeMods(0));
        System.out.println("Dexterity: " + guy.getAttribute(1) + "\t\tModifier: " + guy.getAttributeMods(1));
        System.out.println("Constitution: " + guy.getAttribute(2) + "\tModifier: " + guy.getAttributeMods(2));
        System.out.println("Intelligence: " + guy.getAttribute(3) + "\t\tModifier: " + guy.getAttributeMods(3));
        System.out.println("Wisdom: " + guy.getAttribute(4) + "\t\t\tModifier: " + guy.getAttributeMods(4));
        System.out.println("Charisma: " + guy.getAttribute(5) + "\t\tModifier: " + guy.getAttributeMods(5));
        ASCII();
        System.out.println("Weapon List:");
        System.out.println("Weapon One: " + guy.getWeapons(0) + "\tWeapon Two: " + guy.getWeapons(1));
        //System.out.println(guy.getASCII());
    }
    public void Line(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    }
    public void ASCII(){
        if(classT.equals("Barabarian")) {
            System.out.println("         />_________________________________");
            System.out.println("[########[]_________________________________>");
            System.out.println("         \\>");
        }
        else if(classT.equals("Bard"))
            System.out.println("=={==========-");
        else if(classT.equals("Cleric")) {
            System.out.println("____");
            System.out.println("\\___\\_.:::::::.___");
            System.out.println("/___/ ':::::::'");
        }
        else if(classT.equals("Druid"))
            System.out.println("=={==========-");
        else if(classT.equals("Fighter")) {
            System.out.println("|`-._/\\_.-`|");
            System.out.println("|    ||    |");
            System.out.println("|___o()o___|");
            System.out.println("|__((<>))__|");
            System.out.println("\\   o\\/o   /");
            System.out.println(" \\   ||   /");
            System.out.println("  \\  ||  /");
            System.out.println("   '.||.'");
            System.out.println("     ``");
        }
        else if(classT.equals("Monk")){
            System.out.println("__-----_________________{]__________________________________________________");
            System.out.println("{&&&&&&&#%%&#%&%&%&%&%#%&|]__________________________________________________\\");
            System.out.println("                         {]");
        }
        else if(classT.equals("Paladin")){
            System.out.println("               <>");
            System.out.println("             //");
            System.out.println("           //");
            System.out.println("<>(((((((({@}::::::::::::::::::::::::::::::::::::::::::::::::::::======-");
            System.out.println("           \\\\");
            System.out.println("             \\\\");
            System.out.println("              <>");
        }
        else if(classT.equals("Ranger")){
            System.out.println(">>>>>>>_____________________\\`-._");
            System.out.println(">>>>>>>                     /.-'");
        }
        else if(classT.equals("Rogue")){
            System.out.println(" ___________ ____________  ");
            System.out.println("|           )._______.-'");
            System.out.println("`----------'  ");
        }
        else if(classT.equals("Sorceror")){
            System.out.println("      _____");
            System.out.println("     `.___,'");
            System.out.println("      (___)");
            System.out.println("      <   >");
            System.out.println("       ) (");
            System.out.println("      /`-.\\");
            System.out.println("     /     \\");
            System.out.println("    / _    _\\");
            System.out.println("   :,' `-.' `:");
            System.out.println("   |         |");
            System.out.println("   :         ;");
            System.out.println("    \\       /");
            System.out.println("     `.___.'");
        }
        else if(classT.equals("Warlock")){
            System.out.println(" _________________.---.______");
            System.out.println("(_(______________(_o o_(____()");
            System.out.println("             .___.'. .'.___.");
            System.out.println("             \\ o    Y    o /");
            System.out.println("              \\ \\__   __/ /");
            System.out.println("               '.__'-'__.'");
            System.out.println("                  '''");
        }
        else{
            System.out.println("     __/\\__");
            System.out.println(". _  \\\\''//");
            System.out.println("-( )-/_||_\\");
            System.out.println(" .'. \\_()_/");
            System.out.println("  |   | . \\");
            System.out.println("  |   | .  \\");
            System.out.println(" .'. ,\\_____'.");
        }
    }
}

