package com.supinfo.supsms.utils;

/**
 *
 * @author ___Cid___
 */
public class Pair <U, V> {
    
    private final U first;
    
    private final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
    
    public U getFirst() {
        return first;
    }
    
    public V getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Pair)) {
            return false;
        }
        
        Pair objPair = (Pair)obj;
        if(!objPair.getFirst().equals(first) || !objPair.getSecond().equals(second)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "[" + first.toString() + " : " + second.toString() + "]";
    }
}
