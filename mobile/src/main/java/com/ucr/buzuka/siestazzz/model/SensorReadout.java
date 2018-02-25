package com.ucr.buzuka.siestazzz.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.UUID;

/**
 * Created by jakex on 2/11/2018.
 */

/** new table for sensor readout */
public class SensorReadout implements Parcelable {

/*  ROOM */
    @PrimaryKey
    @NonNull
    private String readOutID;
    @ColumnInfo
    @NonNull
    private String sessionID;
    @ColumnInfo
    private long current_Time;
    @ColumnInfo
    private float speed;
    
/** Constructors */
    public SensorReadout() {
    }

    public SensorReadout(String sessionID, long curTime, float speed) {
        this.readOutID = UUID.randomUUID().toString();

        this.sessionID  = sessionID;
        this.current_Time = curTime;
        this.speed = speed;
    }
    
/** Setters and getters */
    @NonNull
    public String getReadOutID() { return readOutID; }

    public void setReadOutID(@NonNull String readOutID) { this.readOutID = readOutID;}

    @NonNull
    public String getSessionID() { return sessionID; }

    public void setSessionID(@NonNull String sessionID) { this.sessionID = sessionID;}

    public long getCurTime() {
        return current_Time;
    }

    public void setCurTime(long curTime) {
        this.current_Time = curTime;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


/** Convert all object in data container to a single string */
    @Override
    public String toString() {
        return "SensorReadout{" +
                " currentTime= " + current_Time +
                ", speed= " + speed +
                '}';
    }

/**Parcelables functionality for passing data(key value pairs) around activities
 * using Code -> generate -> parcelables
 * usage: start Intent  ->   intent.putExtra(key, value)
 *        in activity   ->   getIntent().getExtras().getParcelable(key)*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.readOutID);
        dest.writeString(this.sessionID);
        dest.writeLong(this.current_Time);
        dest.writeFloat(this.speed);
    }

    protected SensorReadout(Parcel in) {
        this.readOutID = in.readString();
        this.sessionID = in.readString();
        this.current_Time = in.readLong();
        this.speed = in.readFloat();
    }

    public static final Creator<SensorReadout> CREATOR = new Creator<SensorReadout>() {
        @Override
        public SensorReadout createFromParcel(Parcel source) {
            return new SensorReadout(source);
        }

        @Override
        public SensorReadout[] newArray(int size) {
            return new SensorReadout[size];
        }
    };
}
