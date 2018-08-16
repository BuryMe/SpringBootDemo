package com.example.httpClient;



import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟客户端
 */
public class Client {

    /**
     * 本地地址
     */
    private static final String LOCAL_URL = "http://127.0.0.1/8080/";

    /**
     * 测试地址
     */
    private static final String TEST_URL = "https://test.mobile.mandofin.com:8443/";

    /**
     * 参数容器
     */
    private Map<String,String> reqMap = Collections.synchronizedMap(new HashMap<>());

    /**
     * 获得秘钥
     * @param encodedKey
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static PrivateKey getRsaPkcs8PrivateKey(byte[] encodedKey)
            throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    /** 加密
     * 通过请求参数json格式获取签名
     * @param reqData
     * @return
     * @throws Exception
     */
//    public static String getSignByRespData(String reqData,LoanApplyConfig config) {
//
//        try {
//            if (config==null) {
//                config = LoanApplyConfig.getConfig();
//            }
//            String privateStr = config.getPrivateKey();
//            PrivateKey privateKey = getRsaPkcs8PrivateKey(Base64
//                    .decodeBase64(privateStr));
//            byte[] sign;
//            sign = sign("SHA1WithRSA",
//                    privateKey, reqData);
//            return Base64.encodeBase64String(sign);
//        } catch (GeneralSecurityException e) {
//
//            e.printStackTrace();
//        }
//        return null;
//    }
}
