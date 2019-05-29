import java.util.Random;

import java.util.Scanner;

 

public class MemoryGame {

 

   private static int[][] TABELA = new int[4][4];//krijimi i tabeles se tipit 4*4


   private static boolean[][] SHFAQ = new boolean[4][4];

 

   public static void main(String[] args) {
   
      initDeck();
   
      shuffleDeck();
   
      showDeck();
   
      Scanner s = new Scanner(System.in);//krijimi i objektit Scanner
   
      int a, b, c, d;
   
      int opsioni = 0;
   
      do {
      
         System.out.println("Zgjedhni nje opsion");
      
         System.out.println("1. Vazhdo lojen");
      
         System.out.println("2. Perfundo");
      
         opsioni = s.nextInt();
      
         switch (opsioni) {//perdorimi i switch per te shqyrtuar tri raste te ndryshme
         
            case 1:
            
               System.out.println("Shenoni koordinatat per letren e pare");
            
               System.out.print("a:");
            
               a = s.nextInt() -1;
            
               if(!isValidCoordinate(a)) {
               
                  System.out.println("Ju lutem, shenoni koordinaten e pershtatshme.");
               
                  break;
               
               }
            
               System.out.print("b:");
            
               b= s.nextInt() -1;
            
               if(!isValidCoordinate(b)) {
               
                  System.out.println("Ju lutem,shenoni koordinaten e pershtatshme.");
               
                  break;//perfundimi i switch permes break
               
               }
            
               System.out.println("Shenoni koordinatat per letren e dyte");
            
               System.out.print("a:");
            
               c = s.nextInt() -1;
            
               if(!isValidCoordinate(c)) {
               
                  System.out.println("Ju lutem ,shenoni koordinaten e pershtatshme.");
               
                  break;
               
               }
            
               System.out.print("b:");
            
               d = s.nextInt() -1;
            
               if(!isValidCoordinate(d)) {
               
                  System.out.println("Ju lutem, shenoni koordinaten e pershtatshme.");
               
                  break;
               
               }
            
               System.out.println("Letrat ne tabele");
            
               showCardOnBoard(a, b);
            
               showCardOnBoard(a, b);
            
               showDeck();
            
               if (compareCards(a, b, c, d)) {//krahasimi i letrave
               
                  System.out.println("Urime...! Letrat jane te njejta.");
               
               } else {
               
                  System.out.println("Letrat nuk perputhen. Fsheh letrat ne tabele.Provoni perseri ...!");
               
                  hideCardOnBoard(a, b);
               
                  hideCardOnBoard(c, d);
               
                  showDeck();
               
               }
            
                
            
               break;
         
            case 2:
            
               s.close();
            
               System.exit(1);//perfundimi i lojes
            
               break;
         
            default://nese zgjidhet opsioni default kemi dale jashte rregullave
            
               System.out.println("Ju lutem,zgjedhni opsionin e pershtatshem");
         
         }
      
      } while (opsioni != 2);
   
      s.close();
   
   }

 

   private static boolean isValidCoordinate(int hyrja){
   
      if(hyrja < TABELA.length) {//gjithmone inputi duhet te jete me i vogel se gjatesia e tabeles
      
         return true;//kurse tipi i kthimit te te dhenave eshte boolean
      
      }
   
      return false;//nese hyrja eshte me e madhe se gjatesia e tabeles
   
   }

    // metoda që e merr një letër në një pike(vend) të caktuar në tabelë
   private static int getCardOnBoard(int x, int y) {
   
      return TABELA[x][y];
   
   }

 

    // metoda që i krahason dy letra ne tabelë

   private static boolean compareCards(int a, int b, int c, int d) {
   
      if (getCardOnBoard(a, b) == getCardOnBoard(c, d)) {
      
         return true;
      
      }
   
      return false;//nese letrat nuk pershtaten kthen false
   
   }

 

   private static void showCardOnBoard(int a, int b) {//metoda qe i tregon letrat ne tabele
   
      SHFAQ[a][b] = true;
   
   }

 

   private static void hideCardOnBoard(int a, int b) {//metoda qe i fsheh letrat ne tabele
   
      SHFAQ[a][b] = false;
   
   }

 

    // inicializimi i tabelës(kuvertës)

   private static void initDeck() {
   
      int letra = 0;
   
      for (int a = 0; a < TABELA.length; a++) {
      
         for (int b = 0; b < TABELA.length; b++) {
         
            if (letra == TABELA.length * 2) {
            
               letra = 1;
            
            }
         
            TABELA[a][b] = ++letra;
         
            hideCardOnBoard(a,b);
         
         }
      
      }
   
   }

 

    // Shuffle Deck

   private static void shuffleDeck() {
   
      System.out.println("Gjatesia e tabeles:" + TABELA.length);
   
      for (int a = 0; a < TABELA.length * 2; a++) {
      
         swapCards(getRandom(), getRandom(), getRandom(), getRandom());
      
      }
   
   }

 

   private static int getRandom() {
   
      Random r = new Random();
   
      return r.nextInt(3);
   
   }

 

   private static void swapCards(int a, int b, int c, int d) {
   
      int tmp = TABELA[a][b];
   
      TABELA[a][b] = TABELA[c][d];
   
      TABELA[c][d] = tmp;
   
   }

 

    // Shfaq tabelën

   private static void showDeck() {
   
      for (int a = 0; a < TABELA.length; a++) {
      
         for (int b = 0; b < TABELA.length; b++) {
         
            System.out.print(" ");
         
            if (SHFAQ[a][b]) {
            
               System.out.print(TABELA[a][b]);
            
            } else {
            
               System.out.print("*");
            
            }
         
            System.out.print(" ");
         
         }
      
         System.out.println();
      
      }
   
   }

}