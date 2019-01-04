package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OfferList {
    public static List<Offer> offerList = new ArrayList<>(Arrays.asList(
            new Offer(0, 1, 1 , 10.0f),
            new Offer(1, 2, 1, 13.0f),
            new Offer(2, 1, 2, 9.0f),
            new Offer(3, 4, 2, 13.0f),
            new Offer(4, 4, 3, 12.0f),
            new Offer(5, 2, 3, 12.0f),
            new Offer(6, 1, 3, 10.0f),
            new Offer(7, 2, 3, 17.0f),
            new Offer(8, 5, 4, 30.0f),
            new Offer(9, 4, 4, 13.0f),
            new Offer(10, 6, 4, 20.0f),
            new Offer(11, 6, 5, 21.0f),
            new Offer(12, 5, 5, 21.0f),
            new Offer(13, 2, 5, 14.0f),
            new Offer(14, 1, 5, 16.0f),
            new Offer(15, 1, 6, 10.0f),
            new Offer(16, 2, 6, 19.0f),
            new Offer(17, 6, 7, 19.0f),
            new Offer(18, 7, 3, 13.1f),
            new Offer(19, 7, 4, 17.5f)
    ));
    public static void increaseList(){
        offerList.addAll(new ArrayList<>(Arrays.asList(
                new Offer(0, 1, 1 , 10.0f),
                new Offer(1, 2, 1, 13.0f),
                new Offer(2, 1, 2, 9.0f),
                new Offer(3, 4, 2, 13.0f),
                new Offer(4, 4, 3, 12.0f),
                new Offer(5, 2, 3, 12.0f),
                new Offer(6, 1, 3, 10.0f),
                new Offer(7, 2, 3, 17.0f),
                new Offer(8, 5, 4, 30.0f),
                new Offer(9, 4, 4, 13.0f),
                new Offer(10, 6, 4, 20.0f),
                new Offer(11, 6, 5, 21.0f),
                new Offer(12, 5, 5, 21.0f),
                new Offer(13, 2, 5, 14.0f),
                new Offer(14, 1, 5, 16.0f),
                new Offer(15, 1, 6, 10.0f),
                new Offer(16, 2, 6, 19.0f),
                new Offer(17, 6, 7, 19.0f),
                new Offer(18, 7, 3, 13.1f),
                new Offer(19, 7, 4, 17.5f)
        )));
    }
    public static void increaseListRandom(){
        Random r = new Random();
        int i = 0;
        while(i < 20){
            offerList.add(new Offer(r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextFloat()));
            i++;
        }
    }
}
