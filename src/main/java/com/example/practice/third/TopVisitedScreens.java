package com.example.practice.third;

public class TopVisitedScreens {
    String screenname,views;
    public TopVisitedScreens(String screenname, int views){
        this.screenname = screenname;
        this.views = String.valueOf(views);
    }

    public String getScreen_name() {
        return screenname;
    }

    public void setScreen_name(String screen_name) {
        this.screenname = screen_name;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}
