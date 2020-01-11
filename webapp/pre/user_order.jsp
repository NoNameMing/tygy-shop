<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
        isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>电商平台订单页面</title>
    <meta charset="utf-8"/>
    <!--js-->
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/ddsmoothmenu.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/jquery.elastislide.js"></script>
    <script src="js/jquery.jcarousel.min.js"></script>
    <script src="js/jquery.accordion.js"></script>
    <script src="js/light_box.js"></script>

    <script type="text/javascript">
        function getUrlParam(name){
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r!=null) return unescape(r[2]); return null;
        };
    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".inline").colorbox({
                inline: true,
                width: "50%"
            });
        });
    </script>
    <!--end js-->

    <!-- Mobile Specific Metas ================================================== -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS ================================================== -->

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/orange.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ddsmoothmenu.css"/>
    <link rel="stylesheet" href="css/elastislide.css"/>
    <link rel="stylesheet" href="css/home_flexslider.css"/>
    <link rel="stylesheet" href="css/tasp.css"/>
    <link rel="stylesheet" href="css/orderconfirm.css"/>
    <link rel="stylesheet" href="css/light_box.css"/>

    <style>
        #page {
            width: auto;
        }

        #comm-header-inner, #content {
            width: 950px;
            margin: auto;
        }

        #logo {
            padding-top: 26px;
            padding-bottom: 12px;
        }

        #header .wrap-box {
            margin-top: -67px;
        }

        #logo .logo {
            position: relative;
            overflow: hidden;
            display: inline-block;
            width: 140px;
            height: 35px;
            font-size: 35px;
            line-height: 35px;
            color: #f40;
        }

        #logo .logo .i {
            position: absolute;
            width: 140px;
            height: 35px;
            top: 0;
            left: 0;
            background: url(http://a.tbcdn.cn/tbsp/img/header/logo.png);
        }
    </style>

</head>
<body data-spm="1">
<div id="page">
    <!--Header Block-->

    <%@include file="header.jsp" %>

    <div id="content" class="grid-c">
        <div id="address" class="address" style="margin-top: 20px;"
             data-spm="2">
            <form name="addrForm" id="addrForm" action="">
                <h3>
                    确认收货地址 <span class="manage-address"> <a href="#"
                                                            title="管理我的收货地址" class="J_MakePoint">管理收货地址</a>
						</span>
                </h3>
                <ul id="address-list" class="address-list">
                    <li class="J_Addr J_MakePoint clearfix  J_DefaultAddr ">
                        <s class="J_Marker marker"></s> <span class="marker-tip">寄送至</span>
                        <div class="address-info">
                            <a href="#" class="J_Modify modify J_MakePoint">修改本地址</a>
                            <input name="address" class="J_MakePoint " type="radio" value=""
                                   id="addrId_674944241" checked="checked">
                            <label class="user-address">${order.addr } <em>${user.phone }</em> </label>
                            <em class="tip" style="display: none">默认地址</em>
                            <a class="J_DefaultHandle set-default J_MakePoint" href="#"
                               style="display: none">设置为默认收货地址</a>
                        </div>
                    </li>
                    <li class="J_Addr J_MakePoint clearfix">
                        <s class="J_Marker marker"></s> <span class="marker-tip">寄送至</span>
                    </li>
                </ul>
                <ul id="J_MoreAddress" class="address-list hidden">
                </ul>
                <div class="address-bar">
                    <a href="#" class="new J_MakePoint" id="J_NewAddressBtn">使用新地址</a>
                </div>
            </form>
        </div>
        <form id="J_Form" name="J_Form" action="" method="post">
            <div>
                <h3 class="dib">确认订单信息</h3>
                <table cellspacing="0" cellpadding="0" class="order-table"
                       id="J_OrderTable" summary="统一下单订单信息区域">
                    <caption style="display: none">统一下单订单信息区域</caption>
                    <thead>
                    <tr>
                        <th class="s-title">店铺宝贝
                            <hr/>
                        </th>
                        <th class="s-price">单价(元)
                            <hr/>
                        </th>
                        <th class="s-amount">数量
                            <hr/>
                        </th>
                        <th class="s-agio">优惠方式(元)
                            <hr/>
                        </th>
                        <th class="s-total">小计(元)
                            <hr/>
                        </th>
                    </tr>
                    </thead>
                    <tbody data-spm="3" class="J_Shop" data-tbcbid="0"
                           data-outorderid="47285539868" data-isb2c="false"
                           data-postMode="2" data-sellerid="1704508670">
                    <tr class="first">
                        <td colspan="5"></td>
                    </tr>
                    <c:forEach items="${items}" var="items">
                    <tr class="item">

                            <td class="s-title">
                                <a href="#" target="_blank" title="${items.product.name }" class="J_MakePoint">
                                    <span class="title J_MakePoint">${items.product.name }</span>
                                </a>

                                <div class="props">
                                    <span>${items.product.desc }</span>
                                </div>
                                <a title="消费者保障服务，卖家承诺商品如实描述" href="#" target="_blank"> <img
                                        src="http://img03.taobaocdn.com/tps/i3/T1bnR4XEBhXXcQVo..-14-16.png"/>
                                </a>
                                <div>
                                    <span style="color: gray;">2小时内发货</span>
                                </div>
                            </td>
                            <td class="s-price" value=""><span class='price '> <em
                                    class="style-normal-small-black J_ItemPrice">${items.memberprice }</em>
                                    </span></td>
                            <td class="s-amount" data-point-url="" id="csing" value="${items.pcount }">${items.pcount }</td>
                            <td class="s-agio">
                                <div class="J_Promotion promotion" data-point-url="">无优惠</div>
                            </td>
                            <td class="s-total"><span class='price '>
                                <em class="style-normal-bold-red J_ItemTotal ">${items.memberprice } * ${items.pcount }</em>
                                    </span></td>
                    </tr>
                    </c:forEach>
                    <tr class="item-service">
                        <td colspan="5" class="servicearea" style="display: none"></td>
                    </tr>
                    <tr class="blue-line" style="height: 2px;">
                        <td colspan="5"></td>
                    </tr>

                    <tr class="other other-line">
                        <td colspan="5">
                            <ul class="dib-wrap">
                                <li class="dib user-info">
                                    <ul class="wrap">
                                        <li>
                                            <div class="field gbook">
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dib extra-info">
                                    <div class="shoparea">
                                        <ul class="dib-wrap">
                                            <li class="dib title">新人优惠：</li>
                                            <li class="dib sel">
                                                <div
                                                        class="J_ShopPromo J_Promotion promotion clearfix"
                                                        data-point-url="http://log.mmstat.com/buy.1.16"></div>
                                            </li>
                                            <li class="dib fee"><span class='price '> -<em
                                                    class="style-normal-bold-black J_ShopPromo_Result">30.00</em>
													</span></li>
                                        </ul>
                                    </div>
                                    <div class="shoppointarea"></div>
                                    <div class="farearea">
                                        <ul class="dib-wrap J_farearea">
                                            <li class="dib title">运送方式：</li>
                                            <li class="dib sel"
                                                data-point-url="http://log.mmstat.com/jsclick?cache=*&tyxd=wlysfs">
<%--                                                <select name="1704508670:2|post" class="J_Fare">--%>
<%--                                                    <option value="" selected="selected">快递 15.00元</option>--%>
<%--                                                    <option value="">EMS 25.00元</option>--%>
<%--                                                    <option value="">平邮 15.00元</option>--%>
<%--                                                </select><em tabindex="0" class="J_FareFree"--%>
<%--                                                             style="display: none">免邮费</em>--%>
                                                平台包邮
                                            </li>
<%--                                            <li class="dib fee"><span class='price '> <em--%>
<%--                                                    class="style-normal-bold-red J_FareSum">30.00</em>--%>
<%--													</span></li>--%>
                                        </ul>
                                    </div>
                                    <div class="extra-area">
                                        <ul class="dib-wrap">
                                            <li class="dib title">发货时间：</li>
                                            <li class="dib content">平台承诺订单在买家付款后，2小时内<a href="#">发货</a></li>
                                        </ul>
                                    </div>

                                    <div class="servicearea" style="display: none"></div>
                                </li>
                            </ul>
                        </td>
                    </tr>

                    <tr class="shop-total blue-line">
                        <td colspan="5">合计(<span class="J_Exclude"
                                                   style="display: none">不</span>含运费<span class="J_ServiceText"
                                                                                          style="display: none">，服务费</span>)：
                            <span
                                    class='price g_price '> <span>&yen;</span><em
                                    class="style-middle-bold-red J_ShopTotal">${amount }</em>
								</span> <input type="hidden" name="1704508670:2|creditcard"
                                               value="false"/> <input type="hidden" id="J_IsLadderGroup"
                                                                      name="isLadderGroup" value="false"/>

                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="5">
                            <div class="order-go" data-spm="4">
                                <div class="J_AddressConfirm address-confirm">
                                    <div class="kd-popup pop-back" style="margin-bottom: 40px;">
                                        <div class="box">
                                            <div class="bd">
                                                <div class="point-in">
                                                    <em class="t">实付款：</em> <span class='price g_price '>
																<span>&yen;</span><em class="style-large-bold-red"
                                                                                      id="J_ActualFee">${amount - 30}</em>
															</span>
                                                </div>

                                                <ul>
                                                    <li><em>寄送至:</em><span id="J_AddrConfirm"
                                                                           style="word-break: break-all;">${order.addr } </span>
                                                    </li>
                                                    <li><em>收货人:</em><span id="J_AddrNameConfirm">明子哥
																	${user.phone } </span></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <a href="" class="back J_MakePoint" target="_top"
                                           data-point-url="">返回购物车</a>
                                        <a id="J_Go" class=" btn-go" data-point-url="" tabindex="0" title="点击此按钮，提交订单。" href="pay.order?order_id=${order.oid }&amount=${amount - 30.0} ">提交订单<b
                                            class="dpl-button" href="pay.order"></b></a>
                                    </div>
                                </div>

                                <div class="J_confirmError confirm-error">
                                    <div class="msg J_shopPointError" style="display: none;">
                                        <p class="error">积分点数必须为大于0的整数</p>
                                    </div>
                                </div>


                                <div class="msg" style="clear: both;">
                                    <p class="tips naked" style="float: right; padding-right: 0">
                                        本平台包您吃的放心，买的满意！！！</p>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </form>
    </div>


</div>
<!--页脚开始-->
<%--<%@include file="footer.jsp"%>--%>
<!--页脚结束-->
</body>
</html>
