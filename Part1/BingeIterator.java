package Part1;
//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;
import java.util.List;

public class BingeIterator implements Iterator<Episode> {
    private Iterator<Season> seasonIterator;
    private Iterator<Episode> episodeIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasonIterator = seasons.iterator();
        if (seasonIterator.hasNext()) {
            this.episodeIterator = seasonIterator.next().iterator();
        }
    }

    @Override
    public boolean hasNext() {
        // Move on to the next season if the season is over
        while (episodeIterator != null && !episodeIterator.hasNext() && seasonIterator.hasNext()) {
            episodeIterator = seasonIterator.next().iterator();
        }
        return episodeIterator != null && episodeIterator.hasNext();
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more episodes");
        }
        return episodeIterator.next();
    }
}
