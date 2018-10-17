/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmac;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;



/**
 *
 * @author sieberath
 */
public class cTools {



    
 
    
    public String byteArrayToHex(byte[] a) {
       StringBuilder sb = new StringBuilder(a.length * 2);
       for(byte b: a)
          sb.append(String.format("%02x ", b));
       return sb.toString();
    }    
    public String byteToHex(byte a) {
       StringBuilder sb = new StringBuilder(8*2);
       sb.append(String.format("%02x ", a));
       return sb.toString();
    }        
    public void print(String header, Object ... b){
        
        System.out.println(header);
        for(int i=0;i<b.length;i++){
            System.out.println(String.valueOf(b[i]));    
        }
    }
    public byte[] clearLeadingZeros(byte data[]){
        byte clean_array[] = null;
        int cleanArrayLen =0;
        for(int i=0;i<data.length;i++){
            if((data[i]!=0)&&(cleanArrayLen==0)){
                cleanArrayLen = i;
            }
        }
        clean_array = new byte[data.length-cleanArrayLen+1];
        for(int j=cleanArrayLen;j<data.length;j++){
            clean_array[j-cleanArrayLen] = data[j];
        }        
        return clean_array;
    }
    public byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    public long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(bytes);
        buffer.flip();//need flip 
        return buffer.getLong();
    }    
    
    public byte[] concatenate(byte[] a, byte[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        byte c[] = new byte[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }    
    
}
