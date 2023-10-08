Entities

Pets:

- -name: string
- -sex : boolean
- -age : int
- -species : string
- -neuter : boolean
- 


Users:
- -username : String
- -id: String
- -password : String
- -address : String
- -email : String
- -isOwner : boolean
- -isOrganization : boolean
- -isBuyer: boolean
- -bio: string

Profile: 
- -petName : String
- -petAge : int
- -petSex : bool
- -petSpecies : bool
- -petNeuter : bool
- -BackgroundDescription : String
- -photos : list
- -petID: string

Profile:
- -preferences: list
- -conversations: list
- -notifications: list
- -locationLatitude: float
- -locationLongtitude: float
- -likes : list<userLikes>
- -swipeHistory : list<swipeHistory>
- -notifications : list

Buyer
- -preferences: list
- -conversations: list
- -notifications: list
- -locationLatitude: float
- -locationLongtitude: float
- -likes : list<userLikes>
- -swipeHistory : list<swipeHistory>
- -notifications : list

SwipeHistory
- -swipeID: string
- -userID: string
- -petID: string

Match
- -matchID: string
- -buyerID: string
- -ownerID: string

Preferences:
- -petType: Set<String>
- -ageRange: Set
- -sexPreference: Set<String>
- -speciesPreference: Set<String>




