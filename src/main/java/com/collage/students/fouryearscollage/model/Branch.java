package com.collage.students.fouryearscollage.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch {

    private String mech;
    private String civil;
    private String eee;

    public Branch(String mech, String civil, String eee){
        this.mech = mech;
        this.civil = civil;
        this.eee = eee;
    }

}
