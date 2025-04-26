package Part1;
//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private int currentIndex = 0;
    private Random random;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        this.episodes = episodes;
        this.random = new Random(seed);
        Collections.shuffle(episodes, random);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < episodes.size();
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more episodes");
        }
        return episodes.get(currentIndex++);
    }
}
