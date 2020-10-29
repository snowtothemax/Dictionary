/**
 * DictionaryWord object that represents a word in a dictionary with a word and its meaning
 * @author front
 *
 */
public class DictionaryWord {
  private final String word; // word that represents the search key for this dictionary word
  private final String meaning;   // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild;  // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode
   
  // The following should be the only constructor for this class
  // Creates a new dictionary word with the provided word and its meaning pair
  // Throws IllegalArgumentException when the word or meaning are either references to an empty
  // string or null references. The thrown exception should include a significant error message 
  // describing which of these problems was encountred.
  public DictionaryWord(String word, String meaning)  {
    if(word == null || word == "") {
      throw (new IllegalArgumentException("ERROR: The input string for word was null or empty."));
    }
    if(meaning == null || meaning =="") {
      throw (new IllegalArgumentException("ERROR: The input string for meaning was null or empty."));
    }
    this.word = word;
    this.meaning = meaning;
    leftChild = null;
    rightChild = null;
    
  }
   
   
  // Getter for the left child of this dictionary word
  public DictionaryWord getLeftChild() {
    return leftChild;
  }
   
  // Setter for the left child of this dictionary word
    public void setLeftChild(DictionaryWord leftChild) {
      this.leftChild = leftChild;
    }
   
  // Getter for the right child of this dictionary word
  public DictionaryWord getRightChild() {
    return rightChild;
  }
   
  // Getter for the right child of this dictionary word
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild;
  }
   
  // Getter for the word of this dictionary word
  public String getWord() {
    return word;
  }
   
  // Getter for the meaning of the word of this dictionary word
  public String getMeaning() {
    return meaning;
  } 
    
  // Returns a String representation of this DictionaryWord.
  // This String should be formatted as follows. "<word>: <meaning>"
  // For instance, for a dictionaryWord that has the String "Awesome"
  // for the instance field word and the String "adj. Inspiring awe; dreaded."
  // as value for meaning field, the String representing that dictionaryWord is
  // "Awesome: adj. Inspiring awe; dreaded."
  public String toString() {
    return word + ": " + meaning;
  }
}
