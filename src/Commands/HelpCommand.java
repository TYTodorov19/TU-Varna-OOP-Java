package Commands;

/**
 * Prints information about all supported commands.
 */
public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file> - opens <file>");
        System.out.println("close - closes currently opened file");
        System.out.println("save - saves the currently open file");
        System.out.println("save as <file> - saves the currently open file in <file>");
        System.out.println("help - prints this information");
        System.out.println("exit - exits the program");
        System.out.println("add_planet <planet_name> - adds new planet");
        System.out.println("create_jedi <planet_name> <jedi_name> <jedi_rank> <jedi_age> <saber_color> <jedi_strength> - creates new jedi");
        System.out.println("removeJedi <jedi_name> <planet_name> - removes jedi from planet");
        System.out.println("promote_jedi <jedi_name> <multiplier> - promotes jedi and increases strength");
        System.out.println("demote_jedi <jedi_name> <multiplier> - demotes jedi and decreases strength");
        System.out.println("get_strongest_jedi <planet_name> - prints strongest jedi on planet");
        System.out.println("get_youngest_jedi <planet_name> <jedi_rank> - prints youngest jedi with given rank on planet");
        System.out.println("get_most_used_saber_color <planet_name> <jedi_rank> - prints most used saber color for rank on planet");
        System.out.println("get_most_used_saber_color <planet_name> - prints most used saber color by GRAND_MASTER jedis on planet");
        System.out.println("print <planet_name> - prints planet and its jedis");
        System.out.println("print <jedi_name> - prints jedi information");
        System.out.println("<planet_name> + <planet_name> - prints jedis from both planets sorted lexicographically");
    }
}
