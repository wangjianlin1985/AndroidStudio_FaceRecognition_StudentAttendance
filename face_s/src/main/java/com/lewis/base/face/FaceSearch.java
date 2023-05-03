package com.lewis.base.face;





import com.lewis.base.face.util.Base64Util;
import com.lewis.base.face.util.FileUtil;
import com.lewis.base.face.util.GsonUtils;
import com.lewis.base.face.util.HttpUtil;
import sun.rmi.runtime.Log;

import java.util.*;

/**
 * 人脸搜索
 */
public class FaceSearch {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String faceSearch(String path) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            byte[] bytes = FileUtil.readFileByBytes(path);
            String img = Base64Util.encode(bytes);
            map.put("image", img);
            map.put("face_field", "faceshape,facetype");
            map.put("image_type", "BASE64");
            //map.put("liveness_control", "NORMAL");
            map.put("liveness_control", "LOW");
            map.put("group_id_list", "group_repeat,11"); //tan： 这里要添加人脸库的用户组
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken = "24.40e4986ffb4349b6e3a1650f12156933.2592000.1608456299.282335-23017066";
            String accessToken =AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
//            Log.e("result",result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
