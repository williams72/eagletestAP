package com.dilatoit.eagletest.util;

/**
 * Created by Salt on 2017/9/13.
 */
public class SysConvert {
    public static String hexToString(String hex){
        String str = "";
        if(hex == null || hex.equals("")){
            return null;
        }
        hex = hex.replace(" ", "");
        byte[] bakeyword = new byte[hex.length() / 2];
        for (int i = 0; i < bakeyword.length; i++){
            try{
                bakeyword[i] = (byte)(0xff & Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return new String(bakeyword);
    }
}
