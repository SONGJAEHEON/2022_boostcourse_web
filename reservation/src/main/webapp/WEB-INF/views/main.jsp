<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>main</title>
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="stylesheet" href="src/main.css" type="text/css">
        <script src="src/main.js"></script>
    </head>
    <body>
        <div>
            <nav>
                <div id="home_icon" class="nav">N</div>
                <div id="home" class="nav">
                    예약
                </div>
                <c:choose>
                    <c:when test="${sessionScope.account != null}">
                        <div id="email" class="nav">${sessionScope.account}</div>
                    </c:when>
                    <c:otherwise>
                        <div id="email" class="nav">예약확인</div>
                    </c:otherwise>
                </c:choose>
            </nav>
            <div id="promo_wrap">
                <div id="promo_list">
                    <c:forEach items="${listPromotion}" var="item">
                        <div class="promo">
                            <img class="promoImg" src="${item.save_file_name}" alt="promo${item.id}">
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div id="cat">
                <div id="i0" class="cat">
                    전체리스트
                </div>
                <c:forEach items="${listCategory}" var="item">
                <div id="i${item.id}" class="cat">${item.name}</div>
                </c:forEach>
            </div>
            <div id="cat_num">
                바로 예매 가능한 전시, 공연, 행사가 <span id="total">${listProductCnt}</span><span id="cat_red">개</span> 있습니다.
            </div>
            <div id="product_list">
                <div id="product_list1" class="product_list">
                    <c:forEach items="${listProduct}" var="item">
                        <c:if test="${item.id mod 2 == 1}">
                            <div id="${item.id}" class="product">
                                <img class="product_img" src="${item.save_file_name}" alt="${item.id}">
                                <div class="product_title">${item.description}</div>
                                <div class="product_place">${item.place_name}</div>
                                <div class="product_line"></div>
                                <div class="product_content">${item.content}</div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="product_list2" class="product_list">
                    <c:forEach items="${listProduct}" var="item">
                        <c:if test="${item.id mod 2 == 0}">
                            <div id="${item.id}" class="product">
                                <img class="product_img" src="${item.save_file_name}" alt="${item.id}">
                                <div class="product_title">${item.description}</div>
                                <div class="product_place">${item.place_name}</div>
                                <div class="product_line"></div>
                                <div class="product_content">${item.content}</div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div id="c0" class="clear"></div>
            </div>
            <div id="more" class="4">
                더보기
            </div>
            <button id="top">&#8593; TOP</button>
        
            <footer>
                네이버(주)는 통신판매의 당사자가 아니며, 상품의 정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.
                <br><br>
                @ NAVER Corp.
            </footer>
        </div>
        <template id="productTemplate">
            <div id="{{id}}" class="product">
                <img class="product_img" src="{{src}}" alt="{{alt}}">
                <div class="product_title">{{title}}</div>
                <div class="product_place">{{place}}</div>
                <div class="product_line"></div>
                <div class="product_content">{{content}}</div>
            </div>
        </template>
    </body>
</html>