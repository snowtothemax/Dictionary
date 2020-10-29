/**
 * Tests all methods of the DictionaryBST class
 * @author Max Johnson
 *
 */
public class DictionaryTests {
  //main method
  public static void main(String[] args) {
    System.out.println("testDictionaryBSTAdd():" + testDictionaryBSTAdd());
    System.out.println("testDictionaryBSTLookup():" + testDictionaryBSTLookup());
    System.out.println("testDictionaryBSTHeight():" + testDictionaryBSTHeight());
    System.out.println("testDictionaryBSTGetAllWords():" + testDictionaryBSTGetAllWords());
    System.out.println("testDictionaryBSTSize():" + testDictionaryBSTSize());
  }
  
  /**
   * Tests the addWord() method of the DictionaryBST class.
   * @return boolean true if the method works as expected, false otherwise.
   */
  public static boolean testDictionaryBSTAdd() {
    //creates a new tree and adds the words in order
    DictionaryBST tree = new DictionaryBST();
    tree.addWord("c", "an animal.");
    tree.addWord("b", "a fruit.");
    tree.addWord("a", "an animal.");
    
    //tests to see if the tree is empty
    if(tree.isEmpty()) {
      System.out.println("ERROR: No words were added to the tree.");
      return false;
    }
    
    //tests to see if the size is correct
    if(tree.size() != 3){
      System.out.println("ERROR: The words were not added correctly to the tree");
      return false;
    }
    //System.out.println(tree.getAllWords());
    return true;
  }
  
  /**
   * Tests the lookup() method of the DictionaryBST class
   * @return boolean true if the expected word was found, false otherwise.
   */
  public static boolean testDictionaryBSTLookup() {
    //creates a new tree and adds random words
    DictionaryBST tree = new DictionaryBST();
    tree.addWord("Bear", "an animal.");
    tree.addWord("Apple", "a fruit.");
    tree.addWord("Cat", "an animal.");
    tree.addWord("Rag", "a");
    tree.addWord("Day", "b");
    tree.addWord("Air", "c");
    
    //tests if the word is found by matching the meaning with the expected meaning.
    if(!tree.lookup("Air").contentEquals("c")) {
      System.out.println("ERROR: The string 'Air' could not be found in the tree.");
      return false;
    }
    return true;
  }
  
  /**
   * Tests the height() method of the DictionaryBST class
   * @return boolean true if the expected height is correct, false otherwise.
   */
  public static boolean testDictionaryBSTHeight() {
    //creates a new tree and adds them in order
    DictionaryBST tree = new DictionaryBST();
    tree.addWord("Apple","a");
    tree.addWord("Butt", "b");
    tree.addWord("Cat", "c");
    tree.addWord("Dog", "d");
    tree.addWord("Ent", "e");
    
    //tests if the tree is the correct height
    if(tree.height() != 5) {
      System.out.println("ERROR: The tree was not the correct height.");
      return false;
    }
    return true;
  }
  
  /**
   * Tests the getAllWords() method from the DictionaryBST class
   * @return boolean true if the correct array is returned, false otherwise.
   */
  public static boolean testDictionaryBSTGetAllWords() {
    //creates a new tree and adds the words not in order
    DictionaryBST tree = new DictionaryBST();
    tree.addWord("Bear", "an animal.");
    tree.addWord("Apple", "a fruit.");
    tree.addWord("Cat", "an animal.");
    
    //tests if the output string is correct for printing the list
    if(!tree.getAllWords().toString().contentEquals("[Apple, Bear, Cat]")) {
      System.out.println("ERROR: The getAllWords() method did not print everything as expected.");
      return false;
    }
    return true;
  }
  
  /**
   * tests the size() of the DictionaryBST class
   * @return boolean true if the size is correct, false otherwise.
   */
  public static boolean testDictionaryBSTSize() {
    //creates a new tree and adds random words
    DictionaryBST tree = new DictionaryBST();
    tree.addWord("Bear", "an animal.");
    tree.addWord("Apple", "a fruit.");
    tree.addWord("Cat", "an animal.");
    tree.addWord("Rag", "a");
    tree.addWord("Day", "b");
    tree.addWord("Air", "c");
    
    //tests if the size of the array is correct
    if(tree.size() != 6) {
      System.out.println("ERROR: The size() of the bst tree returned was incorrect.");
      return false;
    }
    return true;
  }
}
