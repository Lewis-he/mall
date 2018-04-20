package com.hxh.skymall.service;

import com.hxh.skymall.dao.CommodityDao;
import com.hxh.skymall.entity.Commodity;
import com.hxh.skymall.uitls.KeyCreator;
import com.hxh.skymall.uitls.ThreadUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class CommodityService {
    @Resource
    public CommodityDao cd;

    @Transactional
    public void addCommodity(MultipartFile file, Map<String, Object> param) {


        //保存文件，开启一个线程
        ThreadUtil.execute(new Runnable() {
            @Override
            public void run() {
                File file1 = new File("G:/", file.getOriginalFilename());

                try {
                    file.transferTo(file1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        String sku = KeyCreator.getKey();
        param.put("sku",sku);
        //保存商品
        addCommodityInfo(param);
        param.put("imgName",file.getOriginalFilename());
        param.put("imgId",KeyCreator.getKey());

        //保存图片
        addCommodityImg(param);


    }

    private void addCommodityImg(Map<String, Object> param) {
        cd.addCommodityImg(param);
    }

    private void addCommodityInfo(Map<String, Object> param) {
        cd.addCommodityInfo(param);
    }

    public List<Commodity> findAllCommodity() {
        return cd.findAllCommodity();
    }

    public Commodity findCommodityBySku(String sku) {

        return cd.findCommodityBySku(sku);
    }
}
