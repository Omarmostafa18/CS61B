package gitlet;

// TODO: any imports you need here

import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class
import java.util.Map;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */



    /** The version or coomitID  of commit.
     i should use sha-1 here for version
     */
    private int version;

    /** The message of this Commit. */
    private String message;

    // TODO: search for java.util.Date.
    private Date timestamp;

    /** THE current branch */
    private String branch;

    /* TODO: fill in the rest of this class. */

    public Commit(){

        this.message = "initial commit";
        this.timestamp = new Date(0);

        /**
         * maybe i should i can make method for branch
         */
//        Map<String, String> branch; // branchName -> commitId
//        branch.put("master", "Id"); // master -> SHA-1 ID of first commit


    }
}
