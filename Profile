      /*
      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. Melanie Dauber
      */

package project;
import java.util.ArrayList;


public class Profile {
	String name;
	String password;
	ArrayList<Profile> friends = new ArrayList<Profile>();
	
	public Profile(String namex, String passwordx){
		name = namex;
		password = passwordx;
	}
	
	//prints profile
	public void printProfile(){
		Profile temp;
		System.out.println(this.name);
		System.out.print("friends: ");
		for(int x = 0; x < this.friends.size(); x++){
			temp = this.friends.get(x);
			System.out.print(temp.name + " ");
		}
		System.out.print("\n");
	}
	
	//checks if a friend is on a friends list
	private boolean checkFriends(Profile friendInfo){
		for(int x = 0; x < friendInfo.friends.size(); x++){
			if (friendInfo.friends.get(x) == this){
				//friend exists on friends list
				return false;
			}
		}
		//friend does not exist on friends list
		return true;
	}
	
	//adds friend
	public void addFriend(Profile friendInfo){
		if(this.checkFriends(friendInfo) && !this.name.equals(friendInfo.name)){
			this.friends.add(friendInfo);
			friendInfo.friends.add(this);
			System.out.println("Added friend");
		} else if (this.name.equals(friendInfo.name)){
			System.out.println("Cannot add yourself to friends.");
        } else {
			System.out.println("Friend already added.");
		}
	}
	
	//removes friend
	public void removeFriend(Profile friendInfo){
		if(!this.checkFriends(friendInfo)){
			int x = 0;
			int y = 0;
			for(; x < friendInfo.friends.size(); x++){
				if (friendInfo.friends.get(x) == this) break;
			}
			for(; y < this.friends.size(); y++){
				if (this.friends.get(y) == friendInfo) break;
			}		
			friendInfo.friends.remove(x);
			this.friends.remove(y);
			System.out.println("Removed friend");
		} else {
			System.out.println("Friend does not exist on friends list.");
		}
	}
}
