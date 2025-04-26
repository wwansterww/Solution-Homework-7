package Part1;

//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;

public class SkipIntroIterator implements Iterator<Episode> {
    private Iterator<Episode> originalIterator;
    private int skipTime;

    public SkipIntroIterator(Iterator<Episode> originalIterator, int skipTime) {
        this.originalIterator = originalIterator;
        this.skipTime = skipTime;
    }

    @Override
    public boolean hasNext() {
        return originalIterator.hasNext();
    }

    @Override
    public Episode next() {
        Episode episode = originalIterator.next();
        return new Episode(episode.getTitle(), episode.getRuntimeSec() - skipTime);  // Пропускаем интро
    }
}
