package com.example.vcet_cs;

import com.google.gson.annotations.SerializedName;

public class user {

    @SerializedName("response")
    private String Response;

    @SerializedName("name")
    private String Name;

    @SerializedName("usn")
    private String Usn;

    @SerializedName("email")
    private String Email;

    public String getResponse() {
        return Response;
    }

    public String getName() {
        return Name;
    }

    public String getUsn() {
        return Usn;
    }

    public String getEmail() {
        return Email;
    }

}
