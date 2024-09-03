package com.algorithm.demo.math;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.zip.Inflater;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by wangyu on 2016/11/23.
 * 简单的ASE加密解密功能
 */
public class AESCrypt {
    /**
     * 算法/模式/填充
     **/
    private static final String CipherMode = "AES/CBC/PKCS5Padding";
    private static String coding = "keep考moving满forward分";

    /**
     * 创建密钥
     **/
    private static SecretKeySpec createKey(String key) {
//        byte[] data = null;
//        if (key == null) {
//            key = "";
//        }
//        StringBuffer sb = new StringBuffer(32);
//        sb.append(key);
//        while (sb.length() < 32) {
//            sb.append("0");
//        }
//        if (sb.length() > 32) {
//            sb.setLength(32);
//        }
//        try {
//            data = sb.toString().getBytes("UTF-8");
//            Log.i("tag--",data+"");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        return new SecretKeySpec(key.getBytes(), "AES");
    }


    private static IvParameterSpec createIV(String password) {
//        byte[] data = null;
//        if (password == null) {
//            password = "";
//        }
//        StringBuffer sb = new StringBuffer(16);
//        sb.append(password);
//        while (sb.length() < 16) {
//            sb.append("0");
//        }
//        if (sb.length() > 16) {
//            sb.setLength(16);
//        }
//
//
//        try {
//            data = sb.toString().getBytes("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        return new IvParameterSpec(password.getBytes());
    }


    /**
     * 加密字节数据
     **/
    public static byte[] encrypt(byte[] content) {
        String password = MD5(coding);
        String iv = MD5(coding).substring(16);
        try {
            SecretKeySpec key = createKey(password);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.ENCRYPT_MODE, key, createIV(iv));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 加密(结果为32进制字符串)
     **/
    public static String encrypt(String content) {
        byte[] data = null;
        try {
            data = content.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        data = encrypt(data);
        String result = byte2hex(data);
        return result;
    }


    /**
     * 解密字节数组
     **/
    public static byte[] decrypt1(byte[] content) {
        String password = MD5(coding);
        String iv = MD5(coding).substring(16);
//        AES aes = new AES();
//        try {
//            result = aes.decrypt(content,password,"CFB",iv.getBytes());
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (InvalidAlgorithmParameterException e) {
//            e.printStackTrace();
//        }
        try {
            SecretKeySpec key = createKey(password);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(Cipher.DECRYPT_MODE, key, createIV(iv));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解密(输出结果为字符串)
     **/
    public static String decrypt(byte[] content) {
        byte[] data = null;
        try {
         //   data = hex2byte(new String(content, "UTF-8"));  //16进制
            data = zilib(Base64.decode(content,Base64.NO_WRAP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        data = decrypt1(data);
        if (data == null)
            return null;
        String result = null;
        try {
            result = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 字节数组转成32进制字符串
     **/
    public static String byte2hex(byte[] b) { // 一个字节的数，
        StringBuffer sb = new StringBuffer(b.length * 2);
        String tmp = "";
        for (int n = 0; n < b.length; n++) {
            // 整数转成十六进制表示
            tmp = (Integer.toHexString(b[n] & 0XFF));
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return sb.toString().toUpperCase(); // 转成大写
    }


    /**
     * 将hex字符串转换成字节数组
     **/
    private static byte[] hex2byte(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return new byte[0];
        }
        inputString = inputString.toLowerCase();
        int l = inputString.length() / 2;
        byte[] result = new byte[l];
        for (int i = 0; i < l; ++i) {
            String tmp = inputString.substring(2 * i, 2 * i + 2);
            result[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
        }
        return result;
    }


    /**
     * md5加密字符串
     *
     * @param content 要加密的字符串
     * @return md5之后的字符串
     */
    public static String MD5(String content) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = content.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] zilib(byte[] data ){
        //定义byte数组用来放置解压后的数据
        byte[] output = new byte[0];
        Inflater decompresser = new Inflater();
        decompresser.reset();
        //设置当前输入解压
        decompresser.setInput(data, 0, data.length);
        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresser.finished()) {
                int i = decompresser.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        decompresser.end();
        return output;
    }

}
