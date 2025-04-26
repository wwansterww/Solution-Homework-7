package Part1;

//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;
import java.util.Set;

public class WatchHistoryFilte implements Iterator<Episode> {
    private Iterator<Episode> originalIterator;
    private Set<Episode> watchedEpisodes;
    private Episode nextEpisode;

    public WatchHistoryFilte(Iterator<Episode> originalIterator, Set<Episode> watchedEpisodes) {
        this.originalIterator = originalIterator;
        this.watchedEpisodes = watchedEpisodes;
        advance(); // подготовка первого доступного эпизода
    }

    private void advance() {
        nextEpisode = null;
        while (originalIterator.hasNext()) {
            Episode episode = originalIterator.next();
            if (!watchedEpisodes.contains(episode)) {
                nextEpisode = episode;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextEpisode != null;
    }

    @Override
    public Episode next() {
        if (nextEpisode == null) {
            throw new IllegalStateException("No more episodes.");
        }
        Episode current = nextEpisode;
        advance(); // готовим следующий эпизод после возврата текущего
        return current;
    }
}
