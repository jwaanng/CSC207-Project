**Software Specification:**
-
**(Op) = (Optional)**

**Basic:**
-
- **User-Sign up Page Interactions:**
  - User can choose to create a user account or organization account
  - If choose user's account:
    - Prompt and create user account with account name, password, address, email, phone number.
    - Prompt user to reenter password
    - Ask user to Link email
    - Enter confirmation code that is send to email and verify
    - (Op) Certify user using reallife ID
    - Give user a unique id
    - (Op) reCAPTCHA check 
  - If choose organization's account:
    - Prompt to create an organization's account name, password, address, email, phone
    - Prompt and add organization account(special type of user) with government issue ids
    - Certify government issue id
    - Give organization a unique id
    - (Op) reCAPTCHA check
    - Organization is automatically registered as a pet owner
     
  


**Main pages**
-
**A newly registered User or organization is automatically a Pet Finder**
- **User/Organization Pet Finder-Main page interaction**
  - Allow pet finder to click on favorite pets icon and redirect him/her to the favorite pet page
  - Allow pet finder to click on the "look for pet" icon and redirect him/her to the "look for pet page"
  - Allow pet finder to click on search icon and redirect into a search page
  - Allow pet finder to click on my profile icon and redirect into the "my profile" page
  - Allow pet finder to click on my pets icon and redirect into the "my pets" page
  - Allow pet finder to exit from application
  
- 
**My Profile page**
  - **View information**
  - **Edit information**
      - **User/Org edit their account name**
        - Prompt User to enter new name
      - **User/Org edit their password**
        - Prompt User to enter password and reenter passport agian
        - Send password change notice and confirmation code to user's linked email
        - Allow user to enter confirmation code
      - **User/Org edit email address**
        - Prompt User to enter new email address
        - Send confirmation code to new email address
        - Allow user to enter confirmation code
      - **User/Org edit address**
        - Prompt User to enter new address
      - **User/Org edit phone number**
        - Prompt User to enter new phone number
        - Send verification message to new phone number
        - Enter verification code
      - **User ONLY-My Profile edit interaction**
        - **(Op)User edit their id**
          - Prompt User to enter new id
          - Systematic confirmation
    
      - **Organization ONLY-My Profile edit interaction**
        - **(OP)Org edit their government id** 
          - Prompt Organization to enter new id
          - Systematic confirmation


**Look for pet page**
- **View**
  - User/Org will see a pet profile
  - **with search category completed**: the pet profile with the highest score is the first
  - **without search category completed**: a random pet profile will appear first
- **Action**
  - User can scroll up down to view the complete pet profile
  - User can swipe right to the next pet profile
  - User can not swipe left to view the previous profile
  - User can exit the look for pet page and enter other pages like "my profile", "favorite pet", "search", "my pets"
  - User can add pet profile to favorite pet page

**User/Org Search Page**
  - System automatically (random) put on a pet's profile 
  - **Categorical search**
    - Gender search
      - Can select female or male
    - Neuter search
      - Can select neuter or not neuter
    - Species search
      - Can type in the species interested
    - Age search(independent of species search?)
      - Can select desired age range
  - User/Org after selecting the categories will be redirected to the "look for pet page" started with one pet's profile.
    - The user can perform regular actions on the "look for pet page".
    - When swiping, pets with highest score calculated based on a categorical algorithm will appear first
    

**Favorite pet page**

- **View**
  - User will see a list of their favorite pet profiles
  - User can see the status of their favorite pet as "taken away", "available", "temporarily unavailable" 
- **Action**
  - User can click on a favorite pet profile to open like a drop-down menu
  - User can swipe up and down to brose the list of favorite pets
  - User be redirected to the pet profile 
  - User can open chat box with the pet owner of the favorite pet profile
  - User can unfavorite a pet profile
  - User can exit the favorite pet page and enter other pages
  
  - ** Chat box**
    - User can type words in the chat
    - 
  
        

-

- **Pet Owner(include Organization)-Pet Interaction**
  - Allow pet owner to add a private pet profile
  - Allow pet owner to edit a private pet profile
  - Allow pet owner to make a private pet profile public if the pet profile is complete
  - Allow pet owner to delete a private pet profile
  - Allow pet owner to edit a public profile
  - Allow pet owner to make a public pet profile private


  **My Pets page**
  - **User not registered as a pet owner's view**
    - Display Register as pet owner
    - Allow user to click on the register button and redirect them to pet owner registration page
  - **User registered as pet owner/Org's view**
    - Display a list of all created pet profiles
    - Display public, private status of the pet profiles(public status is viewed by others, private status is not)
    - **Actions**
    - User can scroll up and down to brose through the pets
    - User can click on + icon to create a new pet profile and redirect to the pet profile edit page
    - **Private profiles**
            - User can click on a private pet profile to set it public if and only if all required pet information is completed, this will update the pet status for  all user who has favorited the pet as "available"
            - User can select to delete the private pet profile, this will update the pet status for all user who has favorited the pet as "taken away""
            - User can select to edit the private pet profile
    - **Public profiles**
      - User can click on a public pet profile to set it as private 
        - this will update the pet status for all user who has favorited the pet as "temporarily unavailable"
    - **Pet profile edit page**
                  




