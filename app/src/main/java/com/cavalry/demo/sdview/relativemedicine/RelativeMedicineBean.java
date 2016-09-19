package com.cavalry.demo.sdview.relativemedicine;

import java.util.List;

/**
 * Created by Cavalry on 2016/6/19.
 * Description:
 */
public class RelativeMedicineBean {

        public String type;
        public String isMore;
        /**
         * recommStr :   桂利嗪片,  桂利嗪胶囊,  桂利嗪胶囊66
         * reason : 清除感冒并发症
         * commons : 复方鱼腥草、连花清瘟、银黄
         * symptom : 风热感冒，流黄涕，咽喉红肿，发热头痛
         */

        public List<ProductsBean> products;

        public static class ProductsBean {
            public String provider;
            public String recommStr;
            public String reason;
            public String commons;
            public String symptom;
        }
}
