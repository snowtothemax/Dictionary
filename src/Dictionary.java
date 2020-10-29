
/**
 * The interface of a Dictionary
 * @author Instructor
 *
 */
public interface Dictionary {
//checks whether the dictionary is empty or not
 public boolean isEmpty();
 
 // adds this word definition (word and the provided meaning) to the dictionary
 // Returns true if the word was successfully added to this dictionary
 // Returns false if the word was already in the dictionary
 // Throws IllegalArgumentException if either word or meaning is null or an empty
 // String
 public boolean addWord(String word, String meaning);
 
 // Returns the meaning of the word s if it is present in this dictionary
 // Throws a NoSuchElementException if the word s was not found in this dictionary  
 public String lookup(String s);
 
 // Returns the number of words stored in this dictionary
 public int size();
}
