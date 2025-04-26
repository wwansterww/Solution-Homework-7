package Part1;

//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes;

    public Season() {
        episodes = new ArrayList<>();
    }

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(episodes);
    }

}
