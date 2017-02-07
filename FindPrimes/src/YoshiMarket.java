/*
 Created by Val Yuen, this program will be able to process purchases, show GST, total sale of the day, total customers, etc.
This is for CMPP269
 */
 
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
public class YoshiMarket
{
 
    public static void main(String[] args)
    {
        @SuppressWarnings("resource")
		Scanner in = new Scanner (System.in);
       
        final double WINE_COST = 13.99;
        final double BEER6_COST = 11.99;
        final double BEER12_COST = 19.99;
        final double BEER24_COST = 34.99;
        final double SPIRITS750_COST = 25.99;
        final double SPIRITS1000_COST = 32.99;
        final double BOTTLE_DEPOSIT = .10;
        final double BOTTLE_DEPOSITL = .25;
        final double GST = 0.05;
        double totalCostWine = 0, totalCostBeer6 = 0, totalCostBeer12 = 0, totalCostBeer24 = 0, totalCostSpirits750 = 0, totalCostSpirits1000 = 0, sizeOfPack, howManyPacks, howManyBottles,spiritBottleSize;
        double totalSaleDay = 0, howManyWineBottlesSold = 0, howManyPacks6Sold = 0, howManyPacks12Sold = 0, howManyPacks24Sold = 0, howManySpirit750Sold = 0, howManySpirit1000Sold = 0, currentCostCustomer;
        int customerCount = 0;
        //intialized customer count value to be accumulated
       
        /*should not get arguements about lossy conversion if I were to declare the above variables as float
        instead of double when I use them in an equation with the final double values.
        */
        String itemLetter, CompletedOrder,totalRevenue, totalWine, totalSpirits750, totalSpirits1000, totalBeer6, totalBeer12, totalBeer24, costOf, wineAndGST, Spirits750AndGST, Spirits1000AndGST, beerAndGST6, beerAndGST12, beerAndGST24, totalCostString, customerTodayString;
        String yoshiMarket = "      Welcome to Yoshi's Liquor Market";
        customerTodayString = "The total amount of customers today is";
        costOf = "The cost of";
        totalCostString = "Your total cost is $";
        totalWine = "The total bottles of wine sold today is";
        totalSpirits750 = "The total bottles of 750mL spirits sold today is";
        totalSpirits1000 = "The total bottles of 1000mL spirits sold today is";
        totalBeer6 = "The total cases of 6-pack beer sold today is";
        totalBeer12 = "The total cases of 12-pack beer sold today is";
        totalBeer24 = "The total cases of 24-pack beer sold today is";
        wineAndGST = "bottles of wine including GST and bottle deposit is $";
        Spirits750AndGST = "bottles of 750 mL spirits including GST and bottle deposit is $";
        Spirits1000AndGST = "bottles of 1000 mL spirits including GST and bottle deposit is $";
        beerAndGST6 = "six packs including GST and bottle deposit is $";
        beerAndGST12 = "twelve packs including GST and bottle deposit is $";
        beerAndGST24 = "twenty four packs including GST and bottle deposit is $";
        totalRevenue = "The total revenue for the day is $";
        //Strings to display to the user
       
        
        //Taking values of Y or N to is this customer's order and terminate the loop.
        DateFormat currentDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       //get current date time with currentDate()
       Date todaysDate = new Date();
           
        System.out.printf( "%20s\n", "=============================================");
        System.out.printf("%20s\n", yoshiMarket);
        System.out.printf( "%20s\n", "=============================================");
        System.out.printf("%32s\n", currentDate.format(todaysDate));
        System.out.printf( "%20s\n", "=============================================");
        do
        {    
        	totalCostWine = 0;
            totalCostBeer6= 0;
            totalCostBeer12 = 0;
            totalCostBeer24=0;
            boolean Complete = false;
        do
        {
            //the blank 1 char space print lines is for better clarity and reading between lines after a loop.
            System.out.println(" ");
            System.out.println("Wine is $13.99");
            System.out.println("Beer 6 pack is $ 11.99");
            System.out.println("Beer 12 pack is $ 19.99");
            System.out.println("Beer 24 pack is $ 34.99");
            System.out.println("Spirits 750mL is $ 25.99");
            System.out.println("Spirits 1000mL is $ 32.99");
            System.out.println("What is the item being purchased?");
            System.out.print("W for Wine, B for Beer and S for spirits, or X to quit: ");
            itemLetter = in.next();
            //used next() instead of nextLine to avoid an error.
            itemLetter = itemLetter.toLowerCase();
            switch (itemLetter.charAt(0))
            {
                case 'w': //Executes Wine scenario and ask for how many bottles, display total and ask user whether to continue day or terminate.
                {
                System.out.print ("How many bottles of wine is being purchased: ");
                howManyBottles = in.nextInt();
                totalCostWine = (WINE_COST * howManyBottles) + (BOTTLE_DEPOSIT * howManyBottles);
                totalCostWine = (totalCostWine * GST) + totalCostWine;
                //GST is accounted in total cost as 1.05 (1.05% of the original price)
                System.out.printf ("%1s %.0f %1s %.2f\n", costOf, howManyBottles, wineAndGST, totalCostWine);
                System.out.print ("Is this customer's order done? Y or N: ");
                howManyWineBottlesSold = howManyBottles + howManyWineBottlesSold;
                CompletedOrder = in.next();
                CompletedOrder = CompletedOrder.toLowerCase();
                if (CompletedOrder.charAt(0)=='y')
                    {
                        /*saying Yes terminates the loop, displays how much the purchase was, add 1 to customer count,
                        add how many bottles the customer purchased to the total wine bottles purchased,
                        adds the sale to the total amount of money earned for the day.
                        Same applies to the other scenarios if customer were to buy Beer or Spirits.
                        */
                        Complete = true;
                       
                        ++customerCount;
                    }
                break;
                }
                case 'b':
                //Executes Beer scenario and ask for what kind of pack (6,12,24), how many packs, display total and ask user whether to continue day or terminate.
                {
                    System.out.print ("What kind of beer pack is being purchased? 6, 12, 24: ");
                    sizeOfPack = in.nextDouble();
                    if (sizeOfPack == 6)
                    {
                        System.out.print ("How many six packs are being purchased: ");
                        howManyPacks = in.nextDouble();
                       
                        totalCostBeer6 = (BEER6_COST * howManyPacks) + (BOTTLE_DEPOSIT * sizeOfPack);
                        totalCostBeer6 = (totalCostBeer6 * GST) + totalCostBeer6;
                       
                        System.out.printf ("%1s %.0f %1s %.2f\n", costOf, howManyPacks, beerAndGST6, totalCostBeer6);
                        System.out.print ("Is this customer's order done? Y or N: ");
                        CompletedOrder = in.next();
                        CompletedOrder = CompletedOrder.toLowerCase();
                        howManyPacks6Sold = howManyPacks + howManyPacks6Sold;
                        if (CompletedOrder.charAt(0)=='y')
                            {
                                Complete = true;
                                ++customerCount;
                            }
                    }
                    else if (sizeOfPack == 12)
                    {
                        System.out.print ("How many twelve packs are being purchased: ");
                        howManyPacks = in.nextDouble();
                       
                        totalCostBeer12 = (BEER12_COST * howManyPacks) + (BOTTLE_DEPOSIT * sizeOfPack);
                        totalCostBeer12 = (totalCostBeer12 * GST) + totalCostBeer12;
                       
                        System.out.printf ("%1s %.0f %1s %.2f\n", costOf, howManyPacks, beerAndGST12, totalCostBeer12);
                        System.out.print ("Is this customer's order done? Y or N: ");
                        CompletedOrder = in.next();
                        CompletedOrder = CompletedOrder.toLowerCase();
                        howManyPacks12Sold = howManyPacks + howManyPacks12Sold;
                        if (CompletedOrder.charAt(0)=='y')
                            {
                                Complete = true;
                                ++customerCount;
                            }
                    }
                    else if (sizeOfPack == 24)
                    {
                        System.out.print ("How many twenty four packs are being purchased: ");
                        howManyPacks = in.nextDouble();
                       
                        totalCostBeer24 = (BEER24_COST * howManyPacks) + (BOTTLE_DEPOSIT * sizeOfPack);
                        totalCostBeer24 = (totalCostBeer24 * GST) + totalCostBeer24;
                       
                        System.out.printf ("%1s %.0f %1s %.2f\n", costOf, howManyPacks, beerAndGST24, totalCostBeer24);
                        System.out.print ("Is this customer's order done? Y or N: ");
                        CompletedOrder = in.next();
                        CompletedOrder = CompletedOrder.toLowerCase();
                        howManyPacks24Sold = howManyPacks + howManyPacks24Sold;
                        if (CompletedOrder.charAt(0)=='y')
                            {
                                Complete = true;
                                ++customerCount;
                            }
                    }
                    break;
                }
                case 's':
                //Executes Spirits scenario and ask for what kind of Spirit size do they want (In mL, 750, 1000), how many, display total and ask user whether to continue day or terminate.
                {
                    System.out.print("What kind of spirit bottle size is being bought? 750mL or 1000mL: ");
                    spiritBottleSize = in.nextDouble();
                   
                    if (spiritBottleSize == 750)
                    {
                        System.out.print ("How many 750mL spirit bottles are being purchased: ");
                        howManyBottles = in.nextDouble();
                       
                        totalCostSpirits750 = (SPIRITS750_COST * howManyBottles) + (BOTTLE_DEPOSIT * howManyBottles);
                        totalCostSpirits750 = (totalCostSpirits750 * GST) + totalCostSpirits750;
                       
                        System.out.printf ("%1s %.0f %1s %.2f\n", costOf, howManyBottles, Spirits750AndGST, totalCostSpirits750);
                        System.out.print ("Is this customer's order done? Y or N: ");
                        CompletedOrder = in.next();
                        CompletedOrder = CompletedOrder.toLowerCase();
                        howManySpirit750Sold = howManyBottles + howManySpirit750Sold;
                        if (CompletedOrder.charAt(0)=='y')
                            {
                                Complete = true;
                                ++customerCount;
                            }                        
                    }
                    else if (spiritBottleSize == 1000)
                          {
                              System.out.print ("How many 1000mL spirit bottles are being purchased: ");
                        howManyBottles = in.nextDouble();
                       
                        totalCostSpirits1000 = (SPIRITS1000_COST * howManyBottles) + (BOTTLE_DEPOSITL * howManyBottles);
                        totalCostSpirits1000 = (totalCostSpirits1000 * GST) + totalCostSpirits1000;
                       
                        System.out.printf ("%1s %.0f %1s %.2f\n", costOf, howManyBottles, Spirits1000AndGST, totalCostSpirits1000);
                        System.out.print ("Is this customer's order done? Y or N: ");
                        CompletedOrder = in.next();
                        CompletedOrder = CompletedOrder.toLowerCase();
                        howManySpirit1000Sold = howManyBottles + howManySpirit1000Sold;
                        if (CompletedOrder.charAt(0)=='y')
                            {
                                Complete = true;
                                ++customerCount;
                            }
                          }
                    break;
                }    
                case 'x':
                {
                	Complete = true;
                	break;
                }
            }
        }
        while (!Complete);
        	currentCostCustomer = totalCostWine + totalCostBeer6 + totalCostBeer12 + totalCostBeer24 + totalCostSpirits750 + totalCostSpirits1000;
        	System.out.printf ("%1s %.2f\n", totalCostString, currentCostCustomer);
        	totalSaleDay+=currentCostCustomer;
        }
        //X is outside of this do-while loop because X should terminate the program instead of looping from the start.
        while (itemLetter.charAt(0)!= 'x');
        {
            System.out.println (" ");
            //Comments are what will be displayed to the user.Clarification to understand printfs.
            System.out.printf ("%1s %.2f\n", totalRevenue, totalSaleDay);
            //The total revenue for the day is $ totalSaleDay
            System.out.printf ("%1s %1.0f\n", totalWine, howManyWineBottlesSold);
            //The total bottles of wine sold today is howManyWineBottlesSold
            System.out.printf ("%1s %1.0f\n", totalBeer6, howManyPacks6Sold);
            //the total cases of 6-pack beer sold today is howManyPacks6Sold
            System.out.printf ("%1s %1.0f\n", totalBeer12, howManyPacks12Sold);
            //the total cases of 12-pack beer sold today is howManyPacks12Sold
            System.out.printf ("%1s %1.0f\n", totalBeer24, howManyPacks24Sold);
            //the total cases of 24-pack beer sold today is howManyPacks24Sold
            System.out.printf ("%1s %1.0f\n", totalSpirits750,howManySpirit750Sold);
            //the total bottles of 750mL spirits sold today is howManySpirit750Sold
            System.out.printf ("%1s %1.0f\n", totalSpirits1000,howManySpirit1000Sold);
            //the total bottles of 1000mL spirits sold today is howManySpirit1000Sold
            System.out.printf ("%1s %1d\n", customerTodayString, customerCount);
            //The total amount of customers today is customerCount
            System.out.println ("Good night, your day is done!");
        }  
    }  
}