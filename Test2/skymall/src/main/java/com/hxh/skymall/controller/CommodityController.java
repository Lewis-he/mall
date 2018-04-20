package com.hxh.skymall.controller;

import com.hxh.skymall.entity.Commodity;
import com.hxh.skymall.service.CommodityService;
import com.hxh.skymall.uitls.Constance;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("commodity")
public class CommodityController {
    @Resource
    public CommodityService cs;

    @Resource
    private FreeMarkerConfig freeMarkerConfig;

    @RequestMapping(value = "addCommodity",method = RequestMethod.POST)
    @ResponseBody
    public String addCommodity(@RequestParam MultipartFile file, @RequestParam Map<String,Object> param){

        cs.addCommodity(file,param);
        return Constance.RESULT_OK;
    }

    @RequestMapping(value = "findAllCommodity",method = RequestMethod.GET)
    @ResponseBody
    public List<Commodity> findAllCommodity(){
        return cs.findAllCommodity();
    }
    @RequestMapping("createHTML/{sku}")
    @ResponseBody
    public String createHTML(@PathVariable String sku) {

        try {
            Commodity comm = cs.findCommodityBySku(sku);
            Template template = freeMarkerConfig.getConfiguration().getTemplate("item.ftl");

            FileWriter out = new FileWriter("G:/"+sku+".html");
            template.process(comm,out);
            out.close();
        } catch (Exception e) {

            e.printStackTrace();
            return Constance.RESULT_FAILURE;
        }

        return Constance.RESULT_OK;
    }

}
