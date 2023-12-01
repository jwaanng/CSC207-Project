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

public class CommonProfileDataAccessObject implements ProfilePictureDataAccessInterface{
    private final String userProfilebucketName = "userprofilepictu";
    private final String petProfilebucketName = "petprofilepictures";
    private final GoogleCredentials credentials;
    private final Storage storage;
    public CommonProfileDataAccessObject() {
        try{
        ArrayList<String> format = new ArrayList<>();
        format.add("https://www.googleapis.com/auth/cloud-platform");
        credentials = GoogleCredentials.fromStream(new FileInputStream("resources/GoogleCloudStorageKey/cscproject207-41491bda4aaa.json"))
                .createScoped(format);
        storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        }
        catch (IOException e){
            throw new RuntimeException("missing service account key file");
        }

    }
    public void uploadUserProfile(String username, File file){
        try {
            if (file.getPath().endsWith("/png")) {
                BlobId blobId = BlobId.of(userProfilebucketName, username);
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();
                storage.create(blobInfo, Files.readAllBytes(Paths.get(file.getPath())));
            } else {
                throw new IOException("File is not of type png");
            }
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public void uploadPetProfile(int id, File file){
        try{
        if (file.getPath().endsWith("png")) {
            BlobId blobId = BlobId.of(petProfilebucketName, String.valueOf(id));
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();
            storage.create(blobInfo, Files.readAllBytes(Paths.get(file.getPath())));
        }
        else {
            throw new RuntimeException("File is not of type png");
        }
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Image retrieveUserProfile(String username){
        try{
            Blob blob = storage.get(userProfilebucketName,username);
            if (blob == null){
                return null;
            }
            byte[] content = blob.getContent();
        return ImageIO.read(new ByteArrayInputStream(content));
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public Image retrievePetProfile(int petId){
        try{
        Blob blob = storage.get(petProfilebucketName, String.valueOf(petId));
        if (blob == null){
            return null;
        }
        byte[] content = blob.getContent();
        return ImageIO.read(new ByteArrayInputStream(content));
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

