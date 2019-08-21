package org.taru.vo.two;

import java.io.Serializable;

/**
 * 类别表
 */
public class Style implements Serializable {
    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public int getStyleStatus() {
        return styleStatus;
    }

    public void setStyleStatus(int styleStatus) {
        this.styleStatus = styleStatus;
    }

    private int styleId;
    private String styleName;
    private int  styleStatus;
}
