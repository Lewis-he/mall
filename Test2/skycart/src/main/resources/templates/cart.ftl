<!DOCTYPE html>
<html><head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的购物车 - 京东商城</title>
    <link rel="stylesheet" href="/css/base.css">
    <link href="/css/purchase.2012.css?v=201410141639" rel="stylesheet" type="text/css">

    <#--<script type="text/javascript" src="/js/base-v1.js" charset="utf-8"></script>-->


    <#--<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>-->
    <#--<script type="text/javascript" src="/js/jquery-extend.js"></script>-->
    <#--<script type="text/javascript" src="/js/lib-v1.js"></script>-->

    <#--<script type="text/javascript" src="/js/jd2.js" charset="utf-8"></script>-->


    <#--<script type="text/javascript" src="/js/cart.js"></script>-->
    <#--<script type="text/javascript" src="/js/jquery.price_format.2.0.min.js"></script>-->

    <script>
        var pageConfig  = {};

    </script>
</head>
<body>
<!--shortcut start-->

<#include "commons/shortcut.ftl" />
<!--shortcut end-->
<div class="w w1 header clearfix">
    <div id="logo"><a href="/"><img clstag="clickcart|keycount|xincart|logo" src="/images/jd2-logo.gif" title="返回京东商城首页" alt="返回京东商城首页"></a></div>
    <div class="language"><a href="javascript:void(0);" onclick="toEnCart()"></a></div>
    <div class="progress clearfix">
        <ul class="progress-1">
            <li class="step-1"><b></b>1.我的购物车</li>
            <li class="step-2"><b></b>2.填写核对订单信息</li>
            <li class="step-3">3.成功提交订单</li>
        </ul>
    </div>
</div>
<div class="w cart">
    <div class="cart-hd group">
        <h2>我的购物车</h2>
    </div>
    <div id="show">

        <div class="cart-frame">
            <div class="tl"></div>
            <div class="tr"></div>
        </div>
        <div class="cart-inner">
            <div class="cart-thead clearfix">
                <div class="column t-checkbox form"><input data-cart="toggle-cb" name="toggle-checkboxes" id="toggle-checkboxes_up" type="checkbox" checked="" value=""><label for="toggle-checkboxes_up">全选</label></div>
                <div class="column t-goods">商品</div>
                <div class="column t-price">京东价</div>
                <div class="column t-promotion">优惠</div>
                <div class="column t-inventory">库存</div>
                <div class="column t-quantity">数量</div>
                <div class="column t-action">操作</div>
            </div>
            <div id="product-list" class="cart-tbody">
                <!-- ************************商品开始********************* -->
                <#if car?exists>
              <#list car as item>
                <div id="product_11345721" data-bind="rowid:1" class="item item_selected ">
                    <div class="item_form clearfix">
                        <div class="cell p-checkbox"><input data-bind="cbid:1" class="checkbox" type="checkbox" name="checkItem" checked="" value="11345721-1"></div>
                        <div class="cell p-goods">
                            <div class="p-img">
                                <a href="http://localhost:8082/${item.sku}.html" target="_blank">
                                    <img clstag="clickcart|keycount|xincart|p-imglistcart" src="/images/543b4d75N686689d7.jpg" alt="${item.name}" width="52" height="52">
                                </a>
                            </div>
                            <div class="p-name">
                                <a href="http://localhost:8082/${item.sku}.html" clstag="clickcart|keycount|xincart|productnamelink" target="_blank">
                                <span class="promise411 promise411_11345721" id="promise411_11345721">${item.name}</span>
                                </a>
                            </div>
                        </div>
                        <div class="cell p-price"><span class="price">¥${item.price}  </span></div>
                        <div class="cell p-promotion">
                        </div>
                        <div class="cell p-inventory stock-11345721">有货</div>
                        <div class="cell p-quantity" for-stock="for-stock-11345721">
                            <div class="quantity-form" data-bind="">
                                <a href="javascript:void(0);" class="decrement" clstag="clickcart|keycount|xincart|diminish1" id="decrement">-</a>
                                <input type="text" class="quantity-text" itemPrice="${item.price}" itemId="${item.sku}"  value="${item.buy_num}" id="changeQuantity-11345721-1-1-0">
                                <a href="javascript:void(0);" class="increment" clstag="clickcart|keycount|xincart|add1" id="increment">+</a>
                            </div>
                        </div>
                        <div class="cell p-remove"><a id="remove-11345721-1" data-more="removed-87.20-1" clstag="clickcart|keycount|xincart|btndel318558" class="cart-remove" href="/cart/delete/${item.sku}">删除</a>
                        </div>
                    </div>
                </div>
              </#list>
                </#if>
            </div><!-- product-list结束 -->
            <div class="cart-toolbar clearfix">
                <div class="total fr">
                    <p>总计：¥<span class="totalSkuPrice">
${total}
                    </span></p>
                    <p><span id="totalRePrice">- ¥</span>优惠：</p>
                </div>
                <div class="amout fr"><span id="selectedCount">1</span> 件商品</div>
            </div>
            <div class="ui-ceilinglamp-1" style="width: 988px; height: 49px;"><div class="cart-dibu ui-ceilinglamp-current" style="width: 988px; height: 49px;">
                <div class="control fdibu fdibucurrent">
              <span class="column t-checkbox form">
                  <input data-cart="toggle-cb" name="toggle-checkboxes" id="toggle-checkboxes_down" type="checkbox" checked="" value="" class="jdcheckbox">
                  <label for="toggle-checkboxes_down">
                          全选
                  </label>
              </span>
                    <span class="delete">
                  <b>
                  </b>
                  <a href="javascript:void(0);" clstag="clickcart|keycount|xincart|clearcartlink" id="remove-batch">
                          删除选中的商品
                  </a>
              </span>
                    <span class="shopping">
                  <b>
                  </b>
                  <a href="/" target="_blank" clstag="clickcart|keycount|xincart|coudanlink" id="continue">继续购物</a>
              </span>
                </div>
                <div class="cart-total-2014">
                    <div class="cart-button">
                  <span class="check-comm-btns" id="checkout-jd">
                      <a class="checkout" href="/order/saveOrder" clstag="clickcart|keycount|xincart|gotoOrderInfo" id="toSettlement">去结算<b></b></a>
                  </span>
                        <span class="combine-btns" style="display:none">
                        <span class="fore1" style="display: none;">
                          <a href="" class="combine-btn">不支持合并付款</a>
                      </span>
                      <span class="fore2 hide" style="display: inline;">
                          <a href="javascript:goToOverseaOrder();" class="checkout-jdInt">去京东国际结算<b></b></a>
                          <a href="javascript:goToOrder();" class="checkout-jd">去京东结算<b></b></a>
                      </span>
                  </span>
                    </div>
                    <div class="total fr">
                        总计（不含运费）：
                        <span class="totalSkuPrice">¥</span>
                    </div>
                </div>
            </div></div>
        </div><!-- cart-inner结束 -->
    </div>
</div>
<!--推荐位html修改处-->


<script type="text/javascript" src="/js/base-v1.js"></script>
<!-- footer start -->
<#include  "commons/footer.ftl" />
<!-- footer end -->

<!-- 购物车相关业务 -->
<script type="text/javascript" src="/js/cart.js"></script>
<script type="text/javascript" src="/js/jquery.price_format.2.0.min.js"></script>
</body>
</html>