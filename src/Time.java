import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Time {
    NumberFormat formatter = new DecimalFormat("#00");
    private int hour;
    private int minute;
    private int second;

    public Time(int hr, int min, int s){
        hour = hr;
        minute = min;
        second = s;
    }

    public void tick(){
        second++;
        if(second==60){
            minute++;
            second = 0;
        }
        if(minute==60){
            hour++;
            minute = 0;
            second = 0;
        }
        if(hour == 24){
            hour = 0;
            minute = 0;
            second = 0;
        }
    }

    public void add(Time time){
        //adding seconds
        if(time.second + second < 60){
            second += time.second;
        }
        else{
            minute++;
            second = second -(60-time.second);
        }

        //adding minutes
        if(time.minute + minute < 60){
            minute += time.minute;
        }
        else{
            hour++;
            minute = minute - (60-time.minute);
        }

        //adding hours
        if(time.hour + hour < 24){
            hour+= time.hour;
        }
        else {
            hour = hour - (24 - time.hour);
        }

    }


    public String toString(){
        return formatter.format(hour) + ":" + formatter.format(minute) + ":" + formatter.format(second);
    }


}
