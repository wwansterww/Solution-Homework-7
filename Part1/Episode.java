package Part1;
//----------------------------------------------------------------------------------------------------------------------
//Part1
//----------------------------------------------------------------------------------------------------------------------

//episode presentations in a series

public class Episode {
    private String title;
    private int runtimeSec;

    //creating an episode
    public Episode(String title, int runtimeSec) {
        this.title = title;
        this.runtimeSec = runtimeSec;
    }

    //Get episode title
    public String getTitle() {
        return title;
    }

    //episode duration
    public int getRuntimeSec() {
        return runtimeSec;
    }
}
