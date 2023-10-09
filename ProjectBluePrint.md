**Software Specification:**
-
**(Op) = (Optional)**

**Basic:**
-
- **Customer-Sign up Page Interactions:**
  - Customer can choose to create a user account or organization account
  - If choose user's account:
    - Prompt and create user account with account name, password, address, email, phone number.
    - Prompt user to reenter password
    - Ask user to Link email
    - Enter confirmation code that is sent to email and verify
    - (Op) Certify user using real life ID
    - Give user a unique id
    - (Op) reCAPTCHA check 
  - If choose organization's account:
    - Prompt to create an organization's account name, password, address, email, phone
    - Prompt and add organization account(special type of user) with government issue ids
    - Certify government issue id
    - Give organization a unique id
    - (Op) reCAPTCHA check
    - Organization is automatically registered as a pet owner
  - Once signup is successful, Customer will be redirected to the login page
- **Customer-Login Page interactions**
  - Ask for the customer(User/Org)'s email and password
  -successful log in will redirect to main page   


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
### **My Profile page**
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


### **Look for pet page**
- **View**
  - User/Org will see a pet profile
  - **with search category completed**: the pet profile with the highest score is the first
  - **without search category completed**: the pet profile in the closest geolocation will appear first
- **Action**
  - User can scroll up down to view the complete pet profile
  - User can swipe right to the next pet profile
  - User can not swipe left to view the previous profile
  - User can exit the look for pet page and enter other pages like "my profile", "favorite pet", "search", "my pets"
  - User can add pet profile to favorite pet page

### **User/Org Search Page**
  - System automatically put on a pet's profile with the closest geolocation 
  - **Categorical search**
    - Gender search
      - Can select female or male
    - Neuter(Sterilization) search
      - Can select neuter or not neuter
    - Species search
      - Can type in the interested pet species 
    - Age search(independent of species search?)
      - Can select desired age range
    - Vaccination search
      - Can select vaccinated or not vaccinated
  - User/Org after selecting the categories will be redirected to the "look for pet page" started with one pet's profile.
    - The user can perform regular actions on the "look for pet page".
    - When swiping, pets with the highest score calculated based on a categorical algorithm will appear first
    

### **Favorite pet page**

- **View**
  - User will see a list of their favorite pet profiles
  - User can see the status of their favorite pet as "taken away", "available", "temporarily unavailable" 
- **Action**
  - User can click on a favorite pet profile to open like a drop-down menu
  - User can swipe up and down to brose the list of favorite pets
  - User be redirected to the pet profile
  - User can unfavorite a pet profile
  - User can exit the favorite pet page and enter other pages
  
  - ** Chat box**
    - User can type words in the chat

  
### **My Pets page**

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
        - this will update the pet status for all user who has make the pet favoirte as "temporarily unavailable"
    - **Pet profile edit page**
      - **Required information** 
        - Name
        - Age
        - Sex
        - Size
        - Vaccination status
        - Sterilization state
        - Species
        - General Description
        - (Op) Profile title
        - Photo of the pet
        - **Optional information**
          - Description 1 Temperament with optional photos
          - Description 2 Likes/Dislikes with optional photos
          - Description 3 Other description with optional photos
          - More photos
### Look for pet finder page
- **User not registered as pet owner or pet owner that does not have any pet profile that is made public's View**
  - Display: "You are not a pet owner/You don't have any public pet profile" 
- **User registered as pet owner and have at least one pet profile's View**
  - A buyer profile who has favorited one of the owner's pet is automatically recommended on the page with random algorithm
  - A search icon is on the top
  - **Action**
    - User can scroll up and down to see user's profile
    - User can swipe right to see the next user profile
    - User can not swipe left to see the previous user profile
    - User can click the search icon that redirects them to pet finder search page
    - User can favorite a buyer which opens up a chat box between the buyer and the seller in the chat page
- **Pet finder search page**    
  - Category based on Pet 
    - User can select a pet he owned
  - Category based on user attributes(Elaborate later)
    - User can select user attributes
  - Finishing the selection redirect the user to the look for pet finder page
  - Search Algorithm
    - If specific pet is selected, user will only be recommended pet finders that make that pet favorite
    - If user attributes are selected, user are be recommended based on matching scores

### Chat page      
- Once pet owner favorites a pet finder, a chat will be open in both the pet owner and pet finder's chat page
- **Pet finder's Find pet chat page**
  -  A new chat titled the pet's name is created
- **Pet owner's view of Sell pet chat page**
  - If no other chats exist with the specific pet that the pet finder is looking for, a new dropdown list is created titled the pet name, and a chat titled the pet finder's name is added to the list 
  - If the dropdown list with the specific pet exists, a chat titled the pet finder's name is added under the list
  - Pet finder can click on the pet finder name to open up individual chat box

- **General actions**
  - User can select find pet icon or sell pet icon, this redirect them to the corresponding sub-chat pages
  - find pet chat page contains a list of favorite pets
  - sell pet chat page contains a dropdown list of pet names, under each name are lists of pet finders.
- **Pet owner specific action**
  - Pet owner can delete a chat with a pet finder, this will remove the chat and force the pet finder to unfavorite the pet

# User stories
- Team user story
  - Tiffany wants to create an account in the  [APP_NAME_HERE] app. After opening the app, Tiffany selects the sign up 
  option and is prompt to sign up as an organization or as an user. Tiffany selects the user option and is redirected
  to the user sign up page. In the username textbox, she types in Tiffany, she filled in her address, 
  enter her password, and reenter her password. Lastly, she enters her email tiffany200@gmail.com 
  and clicks send verification code. The system notifies her that the email she has entered 
  is already registered. She realizes the typo and corrects it. She clicks again and get a verification
  code send to the mailbox. She enter the verification code and clicks sign up. However,
  the system notifies her that her username is taken. She changes her name to Tiffany233 
  and successfully sign up this time. She is redirected to the main menu where this time she clicks
  the login in option instead of sign up. She is redirected to the login page where she is prompted to
  enter her email address and password. After successfully signing up, she is directed to the “Look for pet page” with
  bottom of her screen showing other page options.


- User story by Mingyoung Lai
  -  The HOM adoption center has one of its employee Mike just created an organization in the [APP_NAME_HERE] app. 
  Mike clicks on the “my pet” icon and is redirected into the my pets page.
  He clicks on “+” icon to add create a new profile. 
  He is redirected into a page that contains text boxes for him to fill in some required pet 
  information which all have a red star beside the box. He fills in the following information for a pet named
  Cookie in the adoption center. He types in the following:  Name: Cookie , Species: dog. 
  He selects the following: sex: Female, age: 10, sterilization state: Yes, vaccination status: Yes, size: medium. 
  Afterward, Mike uploads a photo of Cookie into the picture box and scroll done to the bottom where he clicks save.
  This exists the editing page and redirects mike back to the my pet page,
  where he can now see the profile of Cookie with its private status below. 


- User story by Hanh Hieu Dao
  - Harley is seeking to adopt a pet and she has successfully registered as an user of the [APP_NAME_HERE]. 
  After logging in the app, she is directed to the finder page where she can select pet categories,
  each has a drop-down menu for sub-categories. Harley carefully selects her
  preferred categories to narrow down her search: gender: female, neuter:
  neuter, species: dog, age range: 5-10 years, vaccination status: vaccinated.
  After selecting the categories, Harley clicked on “Apply” button on the top right corner,
  and she is redirected to the "Look for Pet" page, which displays pet profiles that align with her selected criteria.
  The app’s algorithms ensure that pet profiles are ranked based on her selected categories and makes
  her search more efficient. However, the filter does not impose limitations: as she continues to swipe through them,
  more profiles with other categories would eventually show up. She can enter back the “Search” page
  by clicking on the gear-shaped icon in the top right corner whenever she wants to modify the categories or delete
  all the filters applied. If she chooses to reset the filter, she observes a change in the order of pet profiles. 
  They appear based on proximity to her location, with pets nearest to her will show up first.


- User story by Tony Kai Wang
  - Emma has been contemplating the idea of adopting another dog to accompany her current dog Luna. 
  She signs up as a pet finder on [APP_NAME_HERE]. Emma swipes right on a dog named Max from pet breeder Josh.
  Later that day, Josh favorites Emma from his favorites list and a chat box titled “Max” pops up for 
  the two to communicate. After chatting about logistics and details involving Max,
  they decide to negotiate and confirm a price to sell Max to Emma. Josh then goes to his My Pets page to set
  Max’s profile as private and then selects the delete pet profile option. 
  This then updates the status of Max for the pet buyers that have favorited him as “taken away”.


- User story by Xiang Sheng Kong
  - Bob is looking to adopt a dog. He has just made an account with  [APP_NAME_HERE]app. He clicks on the "my profile" 
icon and is redirected to his profile page. He is unsatisfied with his profile picture being the default picture, so he
clicks on the edit button next to the profile picture which prompts him to upload a photo. He uploads his selfie, 
the change is soon shown. He also edits under the pet preference box in the bottom. He writes some past histories with 
pets and specifies his preference in detail. After an hour, bob favorites a pet named Shrimp. The owner of the pet Jake is 
onlined after 2 hours. When Jake goes to the Look for pet finder page, Bob is the first user shown up on the page 
because their address are the closest. Jake is able to see his selfie and his detailed description of pet preference. 
Jake thinks that Bob's house is Shrimp's best shelter, so he favoirtes Bob's profile. This opens up a chat between Jake and Bob.
The two of them  come to an agreement few weeks later and Bob takes Shrimp home.

   
- User story by Ninjie Wang
  - Nathan is a manager at a local pet shelter that is often overwhelmed with pets looking for homes, 
  so he decides to use [APP_NAME_HERE] in order to try to reach more people who wish to adopt animals.
  Nathan hasn't open up the app for 2 weeks. He goes to the Look for pet finder page and clicks on the top search icon.
  This redirects him to a pet finder search page. He selects his favorite pet's name Doodle in the search tab.
  After clicking apply, he is redirected to the Look for pet finder page. He swipes past the first user profile because 
 he doesn't like the look of the user's photo. He marks the second a favorite because he feels that the second user has 
a pet preference description that best matches Doodle. So on so on, he marks 5 pet finders. Finally, he decides to click
 on the chat icon in the bottom and this redirects him to the chat page. He clicks on the dropdown folder name Doodle 
  and clicks on the name James, the named of the first user. A chatbox with James is open up to his right.
  He types and send Hi, then click on the second user's name in the left dropdown menu, Michael. He says hi again and 
  repeats the following for all user's name under Doodle. 


# Entities
(Op) = optional, decide later
### Entities: Accounts related

**UserAcc:**
- -username : String
- -id : String (Op)
- -password : String
- -address : String
- -email : String
- -isOwner : boolean
- -photo : jpg
- -bio: string
- -MyPetPREF : PetPreference

**OrgAcc extends UserAcc**
- -government id ： String

**CommonUserAccFactory**
- -government id ：String
- -password : String
- -username : String
- -address : String
- -email : String
- -id : String(Op)
### Entities: Pet Profile related
**Profile:**
- -petName : String
- -petAge : int
- -petSex : bool (true = male, false = female)
- -petSpecies : String
- -petSterilized : bool
- -petVaccined : bool
- -petSize : char (big = 'B', medium = 'M', small = 'S'')
- -petPhoto : jpg
- -MorePhotos: Arraylist
- -profileID: string
- -GeneralDescr : String
- -LikeDescr : String
- -TemperDescr : String
- -public : bool

**ProfileFactory**
- -name : String
- -age : int
- -sex : bool (true = male, false = female)
- -species : String
- -sterilized : bool
- -vaccined : bool
- -size : char (big = 'B', medium = 'M', small = 'S'')
- -photo : jpg
- -MorePhotos: Arraylist
- -GeneralDescr : String
- -LikeDescr : String
- -TemperDescr : String

**MyFavProfiles:**
- ArrayList< FinderStateProfilem >

**FinderStateProfile**
- -petPF :
- -pfStatus : char  # pfStatus = "S"(Taken/Sell away), "Y"(Available), "U"(Unavailable)


### Entities: SelectingUserProfile Related
**PetPreference**
-  description: String

### Entities: Chat Related
**PetOwnerChats**
petNameToConversations: Map
- -notifications: list
  **PetFinderChats**
- -petNameToConversation: Map
- -notifications: list
  **Conversation**
- petOwner: UserAcc
- petFinder UserAcc


Future consideration:

- SwipeHistory
    - -swipeID: string
    - -userID: string
    - -petID: string


- Preferences:
    - -petType: Set<String>
    - -ageRange: Set
    - -sexPreference: Set<String>
    - -speciesPreference: Set<String>


