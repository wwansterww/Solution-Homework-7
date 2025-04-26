package Part1;

//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;
import java.util.List;

class SeasonIterator implements Iterator<Episode> {
    private List<Episode> episodes;
    private int index = 0;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean hasNext() {
        return index < episodes.size();
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more episodes.");
        }
        return episodes.get(index++);
    }
}
