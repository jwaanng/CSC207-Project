package dataAcessObject;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for handling profile pictures, both user and pet profiles.
 * This class interacts with Google Cloud Storage to upload and retrieve images.
 */
public class CommonProfileDataAccessObject implements ProfilePictureDataAccessInterface {
    private final String userProfilebucketName = "userprofilepictu";
    private final String petProfilebucketName = "petprofilepictures";
    private final GoogleCredentials credentials;
    private final Storage storage;

    /**
     * Initializes a new instance of CommonProfileDataAccessObject.
     * This constructor sets up the necessary credentials for accessing Google Cloud Storage.
     *
     * @throws RuntimeException if the service account key file is missing or there is an IO exception.
     */
    public CommonProfileDataAccessObject() {
        try {
            ArrayList<String> format = new ArrayList<>();
            format.add("https://www.googleapis.com/auth/cloud-platform");
            credentials = GoogleCredentials.fromStream(new FileInputStream("resources/GoogleCloudStorageKey/cscproject207-41491bda4aaa.json"))
                    .createScoped(format);
            storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        } catch (IOException e) {
            throw new RuntimeException("missing service account key file");
        }

    }

    /**
     * Uploads a user profile picture to Google Cloud Storage.
     *
     * @param username The username associated with the user profile picture.
     * @param file     The File object representing the user profile picture to be uploaded.
     * @throws RuntimeException if there is an issue with the file format or an IO exception occurs.
     */
    public void uploadUserProfile(String username, File file) {
        try {
            if (file.getPath().endsWith("/png")) {
                BlobId blobId = BlobId.of(userProfilebucketName, username);
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();
                storage.create(blobInfo, Files.readAllBytes(Paths.get(file.getPath())));
            } else {
                throw new IOException("File is not of type png");
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * Uploads a pet profile picture to Google Cloud Storage.
     *
     * @param id   The unique identifier associated with the pet profile picture.
     * @param file The File object representing the pet profile picture to be uploaded.
     * @throws RuntimeException if there is an issue with the file format or an IO exception occurs.
     */
    public void uploadPetProfile(int id, File file) {
        try {
            if (file.getPath().endsWith("png")) {
                BlobId blobId = BlobId.of(petProfilebucketName, String.valueOf(id));
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();
                storage.create(blobInfo, Files.readAllBytes(Paths.get(file.getPath())));
            } else {
                throw new RuntimeException("File is not of type png");
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * Retrieves a user profile picture from Google Cloud Storage.
     *
     * @param username The username associated with the user profile picture.
     * @return An Image object representing the retrieved user profile picture, or null if not found.
     * @throws RuntimeException if there is an IO exception during the retrieval process.
     */
    public Image retrieveUserProfile(String username) {
        try {
            Blob blob = storage.get(userProfilebucketName, username);
            if (blob == null) {
                return null;
            }
            byte[] content = blob.getContent();
            return ImageIO.read(new ByteArrayInputStream(content));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Retrieves a pet profile picture from Google Cloud Storage.
     *
     * @param petId The unique identifier associated with the pet profile picture.
     * @return An Image object representing the retrieved pet profile picture, or null if not found.
     * @throws RuntimeException if there is an IO exception during the retrieval process.
     */
    public Image retrievePetProfile(int petId) {
        try {
            Blob blob = storage.get(petProfilebucketName, String.valueOf(petId));
            if (blob == null) {
                return null;
            }
            byte[] content = blob.getContent();
            return ImageIO.read(new ByteArrayInputStream(content));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

