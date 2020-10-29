import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Binary Search Tree class of a dictionary that is used to sort words and their definitions
 * 
 * @author Maxwell Johnson
 *
 */
public class DictionaryBST implements Dictionary {
  // instance fields
  private DictionaryWord root;

  // constructor
  /**
   * Constructs a DictionaryBST with a null root.
   */
  public DictionaryBST() {
    this.root = null;
  }

  // Methods
  /**
   * Checks if the tree is empty or not
   */
  @Override
  public boolean isEmpty() {
    if (root == null) {
      return true;
    }
    return false;
  }

  @Override
  /**
   * Adds a word to the binary search tree in A to Z alphabetical order
   * 
   * @param String word the word to be added to the dictionary
   * @param String meaning the meaning of the word to be added
   */
  public boolean addWord(String word, String meaning) {
    // creates a new DictionaryWord object
    DictionaryWord add = new DictionaryWord(word, meaning);
    // checks if the BST is empty and sets the rood equal to the new node if so
    if (isEmpty()) {
      root = add;
      return true;
    }
    // uses the recursive helper method to add the object
    return addWordHelper(add, root);
  }

  @Override
  /**
   * Looks up a word if the word exists in the
   */
  public String lookup(String s) {
    if (isEmpty()) {
      return null;
    }
    return lookupHelper(s, root);
  }

  @Override
  /**
   * Returns the number of words in the dictionary
   */
  public int size() {
    if (isEmpty()) {
      return 0;
    }
    return sizeHelper(root);
  }

  // Public methods not defined in the Dictionary interface
  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from root to the
   * deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the ascendant
   *         order
   */
  public ArrayList<String> getAllWords() {
    return getAllWordsHelper(root);
  }

  // Recursive private helper methods
  // Each public method should make call to the recursive helper method with the
  // corresponding name

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where newWord
   *                    will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
    // checks if the current node is null or not
    if (current == null) {
      current = newWordNode;
      return true;// sets the current node to the new node if true and returns true for the new word
                  // being added
    }

    // creates two DictionaryWord objects, one for the left child and one for the right child of the
    // current node
    DictionaryWord left = current.getLeftChild();
    DictionaryWord right = current.getRightChild();

    // checks if the new word equals the current word and returns false if that case is true;
    if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) == 0) {
      return false;

      // checks if the new word is greater than the current word
    } else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) > 0) {
      // checks if the right child is null and sets the right child equal to the new node if so
      if (right == null) {
        current.setRightChild(newWordNode);
        return true;
      }
      // otherwise uses recursion to add the new word elsewhere
      return addWordHelper(newWordNode, right);

      // checks if the new word to be added is less than the current word
    } else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) {
      // if the left child is null, the left child is set equal to the new word
      if (left == null) {
        current.setLeftChild(newWordNode);
        return true;
      }
      // otherwise uses recursion for the new word to be added elsewhere
      return addWordHelper(newWordNode, left);
    }

    return false;
  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {
    // checks if the current node is null or not and throws an error if so
    if (current == null) {
      throw (new NoSuchElementException(
          "ERROR: The word" + s + " was not found in the dictionary."));

    }
    // creates two DictionaryWord objects,one of the current nodes left and one of the current nodes
    // right child
    DictionaryWord right = current.getRightChild();
    DictionaryWord left = current.getLeftChild();

    // checks if the current node matches the word being searched for and returns the current nodes
    // meaning if so
    if (s.compareToIgnoreCase(current.getWord()) == 0) {
      return current.getMeaning();

      // checks if the string being searched for is larger or smaller than the current node's word.
      // if greater than, it uses recursion on the right nodes word, otherwise the left nodes word
    } else if (s.compareToIgnoreCase(current.getWord()) > 0) {
      return lookupHelper(s, right);
    } else if (s.compareToIgnoreCase(current.getWord()) < 0) {
      return lookupHelper(s, left);
    }
    // returns null if none works
    return null;
  }


  /**
   * Recursive helper method that returns the number of dictionary words stored in the subtree
   * rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    // checks if the current node is null and returns 0 if so
    if (current == null) {
      return 0;
    }
    // uses recursion and adds up all the nodes on the right and left nodes of the root and returns
    // the recursive sum
    return (sizeHelper(current.getLeftChild()) + 1 + sizeHelper(current.getRightChild()));
  }


  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord nodes
   *         from the current node to the deepest leaf in the subtree rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    // checks if the input node is null and returns 0 if so
    if (current == null) {
      return 0;
    }

    // creates two int's, one using recursion on the left node and one on the right node
    int lHeight = heightHelper(current.getLeftChild());
    int rHeight = heightHelper(current.getRightChild());

    // checks if the height of the right or left side was larger
    if (lHeight > rHeight) {
      return lHeight + 1;// returns the left height if larger
    }
    return rHeight + 1;// returns the right height if larger
  }



  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree rooted at
   * current sorted alphabetically from A to Z
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    // creates a new list and checks if the input node is null
    ArrayList<String> list = new ArrayList<String>();
    if (current == null) {
      return new ArrayList<String>();// returns null if input is null
    }

    // checks if the left child is not null and uses the addAll method on the leftChild of the input
    // node
    if (current.getLeftChild() != null) {
      list.addAll(getAllWordsHelper(current.getLeftChild()));
    }

    // adds the current word to the list
    list.add(current.getWord());

    // checks if the rightChild of the node is not null and uses the addAll method on the rightChild
    if (current.getRightChild() != null) {
      list.addAll(getAllWordsHelper(current.getRightChild()));
    }

    // returns the list
    return list;
  }
}
