package vo;

public class UserVO {
   private int userNumber;
   private String userId;
   private String userPw;
   private String userName;
   private int userAge;
   private String userPhoneNumber;
   private int status;
   
   public UserVO() {;}

   public int getUserNumber() {
      return userNumber;
   }

   public void setUserNumber(int userNumber) {
      this.userNumber = userNumber;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getUserPw() {
      return userPw;
   }

   public void setUserPw(String userPw) {
      this.userPw = userPw;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public int getUserAge() {
      return userAge;
   }

   public void setUserAge(int userAge) {
      this.userAge = userAge;
   }

   public String getUserPhoneNumber() {
      return userPhoneNumber;
   }

   public void setUserPhoneNumber(String userPhoneNumber) {
      this.userPhoneNumber = userPhoneNumber;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }
}