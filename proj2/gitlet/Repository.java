package gitlet;

import java.io.File;
import java.io.Serializable;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");


    /* TODO: fill in the rest of this class.
    *  TODO: we want to make init, first make folder .gitlet and all file in .gitlet
    *   TODO: handel error and all thing init do
    */
    public static void init() {
        GITLET_DIR.mkdir();


        Commit initCommit = new Commit();
        File initCommitFile = Utils.join(GITLET_DIR, "initCommit");
        Utils.writeObject(initCommitFile, initCommit);


        if(GITLET_DIR.exists()){
            System.out.println("A Gitlet version-control system already exists in the current directory.");
        }
    }


    /**
     * add copy of file to staging area(index) TODO: we need to make file
     * .gitlet/objects/
     * .gitlet/index
     * when we add file we need to
     * 1 takes copy of file
     * If the current working version of the file is identical to the version in the current commit, do not stage it to be added
     * 2 we need to fetch @fileName and hash to sha-1 and save it to index file
     * 3 we need to know the place and the sha
     * Failure cases: If the file does not exist, print the error message File does not exist. and exit without changing anything.
     * @param fileName
     */
    public static void add(String fileName) {
        File indexFile = Utils.join(GITLET_DIR, "index");// .git/index
        File addFile = new File(fileName);
        String sha = Utils.sha1(Utils.readContentsAsString(addFile));
        String path = addFile.getPath();
        Utils.writeContents(indexFile, sha, path);
    }
}
