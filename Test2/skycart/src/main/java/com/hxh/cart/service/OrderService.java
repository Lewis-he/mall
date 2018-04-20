package com.hxh.cart.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.hxh.cart.config.AlipayConfig2;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String pay(String json) {

        DefaultAlipayClient client = new DefaultAlipayClient(AlipayConfig2.gatewayUrl,
                AlipayConfig2.app_id,
                AlipayConfig2.merchant_private_key,
                "json",
                AlipayConfig2.charset,
                AlipayConfig2.alipay_public_key,
                AlipayConfig2.sign_type);


        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        alipayRequest.setReturnUrl(AlipayConfig2.return_url);

        alipayRequest.setNotifyUrl(AlipayConfig2.notify_url);


        alipayRequest.setBizContent(json);

        try {
            String  result = client.pageExecute(alipayRequest).getBody();
            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return null;


    }
}
