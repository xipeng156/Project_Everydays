package day0503;

public class Solution {
//
    public static boolean hasAlternatingBits(int n){
//        if (n==1||ntrue;
        int pre = n&1;
        n>>>=1;
        while (n!=0){
            if ((n&1)==pre)
                return false;
            pre = n&1;
            n>>>=1;
        }
        return true;
    }
    //535. TinyURL 的加密与解密
    public class Codec {

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            return new StringBuffer(longUrl).reverse().toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return new StringBuffer(shortUrl).reverse().toString();
        }
    }
}
