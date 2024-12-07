package objectHierarchy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Record {
    public static final String RESET = "\u001B[0m";

    public static final String YELLOW_HIGH_INTENSITY = "\u001B[1;93m";
    public static final String BLUE_HIGH_INTENSITY = "\u001B[1;94m";
    public static final String RED_HIGH_INTENSITY = "\u001B[1;91m";

    private String name;
    private String style;
    private LocalTime duration;

    public Record(String name, String style, LocalTime duration){
        this.name = name;
        this.style = style;
        this.duration = duration;
    }

    public Record() {}

    public String getName() {return name;}
    public LocalTime getDuration() {return duration;}
    public String getStyle() {return this.style;}

    public DateTimeFormatter getTimeFormat(){
        return DateTimeFormatter.ofPattern("H:mm:ss");
    }

    public void setName(String name) {this.name = name;}
    public void setDuration(LocalTime duration) {this.duration = duration;}

    @Override
    public String toString() {
        return BLUE_HIGH_INTENSITY + "Name: " + RESET + name
                + RED_HIGH_INTENSITY + " Style: " + RESET + style
                + YELLOW_HIGH_INTENSITY + " Duration: " + RESET + duration + RESET;
    }

}
