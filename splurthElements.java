// Nicholas Keen
// Assignment 1
// "Splurth Element"
// CIS 301

// Compares an elemental symbol to an element and decides if the user
// indicated symbol/element pair is valid, given the naming conventions
// of this particular periodic table.
public class splurthElements {
  public static void main(String [] args) {
    String element = args[0];
    String symbol = args[1];
    String s1 = element.toLowerCase();
    String s2 = symbol.toLowerCase();
    
    splurthElements valid = new splurthElements(); // Allows calling of a non-
    if(valid.validation(s1, s2) == true)           // static method.
      System.out.println(element+", "+symbol+" -> Valid.");  // Prints output.
    else
      System.out.println(element+", "+symbol+" -> Invalid.");
  }
  
  // Determines the validity of the chosen symbol for the chosen element.
  public boolean validation(String element, String symbol){
    if(symbol.length() != 2) // Checks for correct symbol length.
      return false;
    if(element.length() < 3){  // Checks to see if the desired element
      if(element.length() < 2) // name is long enough to support a symbol
        return false;          // and if so, checks that the symbol is
      if(element.equals(symbol)) // appropriate for the element name.
        return true;
      else
        return false;
    }
    char first = symbol.charAt(0); // Seperate the symbol into two characters.
    char sec = symbol.charAt(1);
    
    for(int i = 0; i < element.length(); i++){ // Ensures the first character
      if(first == element.charAt(i)){          // is present in the element
        element = element.substring(i+1);      // name.
        i = element.length();  // Character found, exit the loop.
      }  
    }
    
    for(int i = 0; i < element.length(); i++) // Ensures the second element is
      if(sec == element.charAt(i))            // present after the first.
        return true;
    return false;
  }
}