import java.util.Scanner;

public class Generator
{
   public static void main(String[] args) 
   { 
    /** Program som slumpar fram tal
     * 1: Användaren anger hur många slumptal som skall anges
     * 2: Programmet slumpar fram de angivna talen
     * 3: Programmet skriver ut de slumpade talen
     * 4: Programmet ordnar slumptalen efter minsta jämna heltal till största jämna heltal
     * 5: Programmet ordnar slumptalen från minsta udda heltal till störta udda heltal
     * 6: Programmet skriver ut de jämna talen
     * 7: Programmet skriver ut de udda talen
     * 
     * @author Jessika Gyllström
     */
      
     //skapar variabler
     final int MIN_VALUE = 0;
     final int MAX_VALUE = 999;
     final int MAX_MEM = Integer.MAX_VALUE;
     final int MIN_MEM = Integer.MIN_VALUE;

     
     int randomNumber = 0;
     int size = 0;
     int evenNumbers = 0;
     int oddNumbers = 0;
     int max = 0;
     int temp = 0;
     int len = 0;
     int number1 = 0;
     int modulus1 = 0;
     int number3 = 0;
     int modulus3 = 0;
     int temporary = 0; 
     
     boolean validInput = false;
     boolean run = false;
       
     //skapar en scanner 
     Scanner keyboard = new Scanner(System.in);
     
     //ber användaren om input
     System.out.println("Hur många slumptal i intervallet 0 - 999 önskas?");
   
     while(validInput==false)
     {
       //om input är ett heltal
       while(!keyboard.hasNextInt())
       { 
         System.out.println("Skriv ett heltal mellan 0-999");
         keyboard.next();        
       }      
       //om input är ett heltal
       while(keyboard.hasNextInt())
       { 
          //sparar input till variabel
          size = keyboard.nextInt();
          
          keyboard.nextLine();
          //om size är större än eller lika med integer min integer och mindre än eller lika med max integer
          if(size>=MIN_MEM&&size<=MAX_MEM)
          {              
             validInput=true;
          }
          //om size är inom gränsvärdena för min och max & mellan 0 & 999
          if(validInput=true&&size>=MIN_VALUE&&size<=MAX_VALUE)
          {
             run=true;
          }  
          else
          {
             System.out.println("Skriv ett heltal mellan 0-999!");          
          }
                
     if(run==true)
     {
     //skapar tomma arrayer
     int[]unorderedArray = new int[size];
     int[]sortedArray = new int[size];
     int[]oddNumbersArray = new int[size];     

     System.out.println("Här är de slumpade talen: ");
     
     //loopar igenom array
     for(int i = 0; i < unorderedArray.length; i++)
     {  
        //slumpar fram värdet      
        randomNumber = (int) (Math.random()*(MAX_VALUE-MIN_VALUE+1)+MIN_VALUE);
        
        //sparar värdet till array
        unorderedArray[i] = randomNumber;
        System.out.print(randomNumber + "  ");    

     }
     System.out.println();  
     
     len = sortedArray.length;
     
     //Sorterar värden i array i storleksordning        
     for(int i = 0;i<len-1;i++)        
     {            
        max = i;            
        for(int l=i+1;l<len;l++)            
        {                
           if(unorderedArray[l] < unorderedArray[max])                
           {                    
              max = l;                
           }           
        }                   
        temp = unorderedArray[i];            
        unorderedArray[i] = unorderedArray[max];            
        unorderedArray[max] = temp;       
     }
     //går igenom array och uppdaterar värden för jämna och udda nummer
     for(int i=0; i < len; i++)      
     {  
        number1 = unorderedArray[i];
        modulus1 = number1%2;
        if(modulus1 == 0)
        {
           sortedArray[i] = unorderedArray[i];
           evenNumbers ++;
        } else if(modulus1 != 0)  
        {
           sortedArray[i] = unorderedArray[i];
           oddNumbers ++;
        }
     }   
     //lägger till udda nummer i oddnumbersarray    
     for(int i=0; i<sortedArray.length; i++)      
     {  
        number3 = sortedArray[i];
        modulus3 = number3%2;
        if(modulus3 != 0)  
        {
           oddNumbersArray[i] = sortedArray[i];
        }     
     }   
     //sorterar oddnumbers array men största värdet först
     for (int i=0; i<oddNumbersArray.length; i++)   
     {     
        for (int m = i+1;m<oddNumbersArray.length; m++)   
        {     
           if(oddNumbersArray[i] < oddNumbersArray[m]) 
           {    
              temporary = oddNumbersArray[i];    
              oddNumbersArray[i] = oddNumbersArray[m];    
              oddNumbersArray[m] = temporary;    
           }     
        }     
     }    
     //skriver ut jämna nummer
     for(int i=0;i<sortedArray.length;i++)
     {  
        if(sortedArray[i]%2==0)
        {  
           System.out.print(sortedArray[i] + " ");  
        }  
     }
     System.out.print(" - ");
     //skriver ut udda nummer
     for (int i = 0; i < oddNumbersArray.length; ++i) 
     {
        if (oddNumbersArray[i]!=0) 
        {
           System.out.print(oddNumbersArray[i] + " "); 
        }
      }
      System.out.println();   
      System.out.println("Av ovanstående tal var " + evenNumbers + " jämna och " + oddNumbers + " udda" );    
     }
   }
  }
 }
}





 
