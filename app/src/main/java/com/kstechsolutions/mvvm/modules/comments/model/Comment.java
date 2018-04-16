package com.kstechsolutions.mvvm.modules.comments.model;

import java.io.Serializable;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class Comment implements Serializable {
    private String name;
    private String email;
    private String body;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
