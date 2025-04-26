package Part1;
//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Episode ep1 = new Episode("The Boys", 45);
        Episode ep2 = new Episode("Episode 2", 47);
        Episode ep3 = new Episode("Season Finale", 60);

        Season season1 = new Season();
        season1.addEpisode(ep1);
        season1.addEpisode(ep2);
        season1.addEpisode(ep3);

        Episode ep4 = new Episode("The Boys", 46);
        Episode ep5 = new Episode("Episode 2", 48);
        Episode ep6 = new Episode("Season Finale", 59);

        Season season2 = new Season();
        season2.addEpisode(ep4);
        season2.addEpisode(ep5);
        season2.addEpisode(ep6);

        List<Season> seasons = new ArrayList<>();
        seasons.add(season1);
        seasons.add(season2);

        System.out.println("Binge mode:");
        BingeIterator bingeIterator = new BingeIterator(seasons);
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }

        Set<Episode> watched = new HashSet<>();
        watched.add(ep1);

        System.out.println("\nWatch history filter:");
        Iterator<Episode> filteredIterator = new WatchHistoryFilte(new SeasonIterator(season1.getEpisodes()), watched);
        while (filteredIterator.hasNext()) {
            System.out.println(filteredIterator.next().getTitle());
        }

        System.out.println("\nSkip intro:");
        Iterator<Episode> skipIntroIterator = new SkipIntroIterator(new SeasonIterator(season1.getEpisodes()), 10);
        while (skipIntroIterator.hasNext()) {
            System.out.println(skipIntroIterator.next().getTitle());
        }
    }
}
