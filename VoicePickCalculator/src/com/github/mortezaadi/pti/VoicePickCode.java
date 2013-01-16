package com.github.mortezaadi.pti;

import java.io.Serializable;

public class VoicePickCode implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final int small;
    private final int large;
    
    public int getSmall() {
        return small;
    }

    public int getLarge() {
        return large;
    }

    public VoicePickCode(int small, int large) {
        super();
        this.small = small;
        this.large = large;
    }

    @Override
    public String toString() {
        return "VoicePickCose [minor=" + small + ", major=" + large + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + large;
        result = prime * result + small;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VoicePickCode other = (VoicePickCode) obj;
        if (large != other.large)
            return false;
        if (small != other.small)
            return false;
        return true;
    }
    
    
    
}
