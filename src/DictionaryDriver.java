//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: An interface of a Dictionary that allows words and their meanings to be added with other
//////////////////// sets of commands put to the users disposal
// Files: DictionaryDriver.java, DictionaryBST.java, DictionaryWord.java, Dictionary.java,
//////////////////// DictionaryTests.java
// Course: CS 300, Spring, 2019
//
// Author: Maxwell Johnson
// Email: mkjohnson9@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Driver for the Dictionary interface
 * 
 * @author Maxwell Johnson
 *
 */
public class DictionaryDriver {

  /**
   * Main method to run the interface
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DictionaryBST tree = new DictionaryBST();
    readCommand(sc, tree);
  }

  /**
   * The display menu for the dictionary interface
   */
  private static void displayMenu() {
    System.out.println("=========================== Dictionary ============================\r\n"
        + "Enter one of the following options:\r\n"
        + "[A <word> <meaning>] to add a new word and its definition in the dictionary\r\n"
        + "[L <word>] to search a word in the dictionary and display its definition\r\n"
        + "[G] to print all the words in the dictionary in sorted order\r\n"
        + "[S] to get the count of all words in the dictionary\r\n"
        + "[H] to get the height of this dictionary implemented as a binary search tree\r\n"
        + "[Q] to quit the program\r\n"
        + "======================================================================\r\n");
  }

  /**
   * The helper method for the dictionary interface that takes in commands
   * 
   * @param sc   Scanner that takes in user input
   * @param tree takes in the tree to be used
   */
  private static void readCommand(Scanner sc, DictionaryBST tree) {

    final String promptCommandLine = "Please enter your command: ";
    boolean quit = false;// the boolean to be used to check if the while loop should still work or
                         // not
    int counter = 0;// counter to count the number of loops
    displayMenu();// displays the subscriber menu
    System.out.print(promptCommandLine);// prints the command line
    String command = sc.nextLine();// makes the command string equal to the user input
    String[] commands = command.trim().split(" ");// creates a new array equal to each individual
                                                  // word in the user input
    while (!quit)// loops
                 // through the
                 // code as
                 // long as q
                 // is not
                 // pressed
    {
      if (counter != 0)// makes sure the first time through doesnt ask for commands twice
      {
        displayMenu();
        System.out.print(promptCommandLine);
        command = sc.nextLine(); // reads the user command line
        commands = command.trim().split(" "); // splits the users command
      }

      // checks if the input from the user command is a valid command
      if (checkInput(commands[0].trim().charAt(0))) {
        // switch key to track the user input cases
        switch (commands[0].trim().charAt(0)) {

          // if the user inputs the 'a' command:
          case 'A':
          case 'a':
            counter++;// counter always incremented
            boolean added;
            // checks if the commands input length was too short and prints an error if so
            if (commands.length < 2 || commands.length < 3) {
              System.out.println("WARNING: Syntax Error. Please enter another command.");
              break;
            }

            // try block to catch any bad input
            try {
              // attempts to add the word and checks if the word was added or not
              added = tree.addWord(commands[1].trim(), commands[2].trim());
              if (added == false) {
                System.out.println("ERROR: Word already exists in the dictionary.");
              }
              // if an exception is caught, the message is printed
            } catch (IllegalArgumentException e) {
              System.out.println(e.getMessage());
              break;
            }

            break;

          // case if the l key is pressed, to lookup a word in the dictionary
          case 'L':
          case 'l':
            counter++;
            // checks if the command is the correct length and prints an error if not
            if (commands.length < 2) {
              System.out.println("WARNING: Syntax Error. please enter another command.");
              break;
            }

            // try block to catch any exceptions
            try {
              // prints the word that is looked up
              System.out.println(tree.lookup(commands[1].trim()));
              break;
              // exception message printed if caught
            } catch (NoSuchElementException e) {
              System.out.println(e.getMessage());
              break;
            }

            // if the g key is pressed checks, prints a sorted array of the words in alphabetical
            // order
          case 'G':
          case 'g':
            counter++;
            // checks if the tree is empty and prints an error if so
            if (tree.isEmpty()) {
              System.out.println("ERROR: The dictionary is empty.");
              break;
            }

            // creates a new array list equal to the array list of words in the tree in alphabetical
            // order
            ArrayList<String> list = tree.getAllWords();
            System.out.println();

            // enhanced for loop that prints each word in the list
            for (String word : list) {
              System.out.print(word + ", ");
            }
            System.out.println();
            break;

          // is the s key is pressed, the number of words is printed in the dictionary
          case 's':
          case 'S':
            counter++;
            System.out.println("The size of this dictionary is " + tree.size() + " words.");
            break;

          // if the h key is pressed, the height of the tree is printed
          case 'H':
          case 'h':
            counter++;
            // checks if the tree is empty and prints the height as 0 if so
            if (tree.isEmpty()) {
              System.out.println("The height of the dictionary BST tree is 0");
              break;
            }
            // prints the height of the tree
            System.out.println("The height of the dictionary BST tree is " + tree.height());
            break;


          // if q is pressed, the program is exited and a message is printed
          case 'q':
          case 'Q':
            System.out
                .println("============================== END ===================================");
            quit = true;
            break;

        }
        // if none of the commands are correct, an error message is printed and the user is prompted
        // to input another command
      } else {
        System.out.println("ERROR: Improper command input. Input another command.");
        counter++;
      }
    }
  }

  /**
   * checks if the input matches the list of commands.
   * 
   * @param c char to be checked for correct input
   * @return boolean true if the command input is correct, and false otherwise
   */
  private static boolean checkInput(char c) {
    if (c == 'q' || c == 'Q' || c == 'a' || c == 'A' || c == 'l' || c == 'L' || c == 'g' || c == 'G'
        || c == 's' || c == 'S' || c == 'h' || c == 'H') {
      return true;
    }
    return false;
  }
}
