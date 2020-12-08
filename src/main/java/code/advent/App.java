package code.advent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        DayOne dayOne = new DayOne();
        System.out.println("Day 1 Answers");
        System.out.println(dayOne.getProduct());
        System.out.println(dayOne.getProductOfThree());

        System.out.println("Day 2 Answers");

        DayThree dayThree = new DayThree();
        System.out.println("Day 3 Answers");
        System.out.println(dayThree.treesHit());
        System.out.println(dayThree.treesHit(1, 1)
                * dayThree.treesHit(1, 3)
                * dayThree.treesHit(1, 5)
                * dayThree.treesHit(1, 7)
                * dayThree.treesHit(2, 1)
        );
    }
}
