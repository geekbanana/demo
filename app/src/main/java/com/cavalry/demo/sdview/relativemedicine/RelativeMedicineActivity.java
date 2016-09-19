package com.cavalry.demo.sdview.relativemedicine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cavalry.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RelativeMedicineActivity extends AppCompatActivity {

    @Bind(R.id.relative_medicine_view)
    RelativeMedicineView relativeMedicineView;
    private List<RelativeMedicineBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_medicine);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    private void initView() {
        relativeMedicineView.setData(data);
    }

    private void initData() {
        data = new ArrayList<RelativeMedicineBean>();
        RelativeMedicineBean bean1 = new RelativeMedicineBean();
        bean1.type = "1";
        bean1.isMore = "1";
        RelativeMedicineBean.ProductsBean product1 = new RelativeMedicineBean.ProductsBean();
        product1.commons = "mmmmmmmmm";
        product1.provider = "provider";
        product1.reason = "11111";
        product1.symptom = "症状1111";
        product1.recommStr = "主推";
        List<RelativeMedicineBean.ProductsBean> productsBeanList1 = new ArrayList<RelativeMedicineBean.ProductsBean>();
        productsBeanList1.add(product1);
        bean1.products = productsBeanList1;
        data.add(bean1);


        RelativeMedicineBean bean2 = new RelativeMedicineBean();
        bean2.type = "2";
        bean2.isMore = "0";
        RelativeMedicineBean.ProductsBean product2 = new RelativeMedicineBean.ProductsBean();
        product2.commons = "mmmmmmmmm";
        product2.provider = "provider";
        product2.reason = "2222";
        product2.symptom = "症状222";
        product2.recommStr = "主推";
        List<RelativeMedicineBean.ProductsBean> productsBeanList2 = new ArrayList<RelativeMedicineBean.ProductsBean>();
        productsBeanList2.add(product2);
        bean2.products = productsBeanList2;
        data.add(bean2);
    }
}
