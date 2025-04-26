package Part1;//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.List;

public class ReverseSeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private int currentIndex;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.currentIndex = episodes.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more episodes");
        }
        return episodes.get(currentIndex--);
    }
}
