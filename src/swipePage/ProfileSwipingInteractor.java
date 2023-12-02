package swipePage;
import entity.petProfile.PetProfile;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * The {@code ProfileSwipingInteractor} class handles the swiping of pet profiles.
 */
public class ProfileSwipingInteractor {

    /** The queue of pet profiles available for swiping. */
    private final Queue<PetProfile> profiles;

    /**
     * Constructs a {@code ProfileSwipingInteractor} with the provided list of pet profiles.
     *
     * @param profiles The list of pet profiles to initialize the swiping queue.
     */
    public ProfileSwipingInteractor(List<PetProfile> profiles) {
        // Initialize the swiping queue with the provided list of pet profiles.
        this.profiles = new LinkedList<>(profiles);
    }

    /**
     * Gets the next pet profile for swiping.
     *
     * @return The next pet profile, or {@code null} if there are no more profiles.
     */
    public PetProfile getNextProfile() {
        // Poll the next pet profile from the queue.
        // Returns null if the queue is empty.
        return profiles.poll();
    }
}