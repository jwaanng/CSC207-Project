package usecase.changeMyPetProfilePublicStatus;

/**
 * The {@code InputBound} interface defines a method for executing an operation with public status input data.
 */
public interface InputBound {

    /**
     * Executes an operation with public status input data.
     *
     * @param data The input data for changing the public status.
     * */
    void execute(PublicStatusInputData data);
}