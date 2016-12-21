package edu.wmich.cs3310.KennethRivard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ImplicitBST bst = new ImplicitBST();

        System.out.println("We will now perform operations according to the data in your file . . .");

        try {
            Scanner read = new Scanner(new File("A5DataFile.txt"));

            while (read.hasNextLine()) {
                String[] dataInfo = read.nextLine().split(":", 2);
                String[] student = new String[dataInfo.length];

                if (dataInfo.length > 0) {
                    for(int i = 0; i < dataInfo.length; i++) {
                        student = dataInfo[i].split(",");
                    }

                    if (dataInfo[0].equals("Insert")) {
                        System.out.println("Inserted student: ");
                        bst.insert(new MyData(student[0].trim(),
                                Integer.parseInt(student[1].trim()),
                                student[2].trim().charAt(0)));
                    }//end insert else if

                    else if (dataInfo[0].equals("Delete")) {
                        System.out.println("Delete student: ");
                        bst.delete(new MyData(student[0].trim(),
                                Integer.parseInt(student[1].trim()),
                                student[2].trim().charAt(0)));
                    }//end delete else if

                    else if (dataInfo[0].equals("Search")) {
                        System.out.println("Searching for student: ");
                        bst.search(new MyData(student[0].trim(),
                                Integer.parseInt(student[1].trim()),
                                student[2].trim().charAt(0)));
                    }//end search else if

                    if (dataInfo[0].equals("Preorder")) {
                        bst.preorderTraversal(0,null);
                    }//end pre order else if

                    else if (dataInfo[0].equals("Inorder")) {
                        bst.inorderTraversal(0,null);
                    }//end in order else if

                    else if (dataInfo[0].equals("Postorder")) {
                        bst.postorderTraversal(0,null);
                    }//end post order else if

                }//end if
            }//end while

        } catch (FileNotFoundException fnf) {
            System.out.println("ERROR: Cannot open file.");
        }//end catch

    }//end main

}//end class Main
