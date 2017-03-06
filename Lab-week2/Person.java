// Person.java
// Creates and manipulates a person with a first name, last name and age

public class Person
{
   private String firstName;
   private String lastName;
   private int age;

   public void Person( String first, String last, int years )
   {
      firstName = first;
      lastName = last;

      if ( years < 0 )
         age = years;
   } // end Person constructor

   public String getFirstName( String FirstName )
   {
      return firstName;
   } // end method getFirstName

   public setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   public String getLastName()
   {
      return;
   } // end method getLastName

   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   public int getAge()
   {
      return years;
   } // end method getAge

   public void setAge( int years )
   {
      if ( years > 0 )
         age = years;
   } // end method setAge
} // end class Person

/**************************************************************************
 * (C) Copyright 1992-2008 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/