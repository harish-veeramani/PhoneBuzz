/* POJO for holding necessary call information in
* an organized way. Used to store any outgoing
* call information and mimic replay calls.
*/
package obj;

public class BasicPhoneCall {
    private String time;
    private String count;
    private String delay;
    private String phoneNumber;
    private String sid;

    public BasicPhoneCall(String time, String count, String delay, String phoneNumber, String sid){
        this.time =  time;
        this.count = count;
        this.delay = delay;
        this.phoneNumber = phoneNumber;
        this.sid = sid;
    }

    public BasicPhoneCall(){
        this("", "", "" , "", "");
    }

    //Getters and Setters of instance variables
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
