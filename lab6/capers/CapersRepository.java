package capers;

import java.io.File;
import java.io.IOException;

import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join(CWD, ".capers"); // TODO Hint: look at the `join`
       //将CAPERS_FOLDER变量名，转移到当前目录下的capers位置，或者将capers与当前目录路径相关联                                     //      function in Utils

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    //创建文件夹与文件,基础框架
    public static void setupPersistence() {
        // TODO

            CAPERS_FOLDER.mkdir();
        File dogs_Folder = Utils.join(CAPERS_FOLDER, "dogs");
        if(!dogs_Folder.exists()){
            dogs_Folder.mkdir();
        }
        File story = Utils.join(CAPERS_FOLDER, "story");
        if(!story.exists()){
            try {
                story.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        File f1 = Utils.join(CAPERS_FOLDER, "story");
        String current = Utils.readContentsAsString(f1);
        String newcurrent = current + text + "\n";
        Utils.writeContents(f1, newcurrent);
        System.out.print(newcurrent);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
       setupPersistence();
       Dog temp = new Dog(name, breed, age);
       temp.saveDog();
       System.out.println(temp.toString());
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
        Dog temp = Dog.fromFile(name);
        temp.haveBirthday();
        temp.saveDog();
    }
}
