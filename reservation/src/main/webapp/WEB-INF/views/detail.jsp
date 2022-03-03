<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>${detail.id}</title>
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="stylesheet" href="src/detail.css" type="text/css">
        <link rel="stylesheet" href="src/comment.css" type="text/css">
        <script src="src/detail.js"></script>
    </head>
    <body>
        <div>
        	<div id="carousel_wrap">
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
            <section id="${detail.id}">
                <div id="order" class="1">1/2</div>
                <img id="carousel_1" class="carousel img_mid" src="${detail.save_file_name}" alt="main image ${detail.id}">
                <img id="carousel_2" class="carousel img_right" src="" alt="sub image ${detail.id}">
                <img id="carousel_3" class="carousel img_other" src="${detail.save_file_name}" alt="main image ${detail.id}">
                <img id="carousel_4" class="carousel img_left" src="" alt="sub image ${detail.id}">
                <div id="move_left" class="move">&lt;</div>
                <div id="move_right" class="move">&gt;</div>
                <div id="title">${detail.description}</div>
            </section>
            </div>
            <div id="description">${detail.content}</div>
            <button id="expansion">펼쳐보기</button>
            <section id="event">
                <div id="event_tile" class="event_txt">&#127873; 이벤트 정보</div>
                <div class="division_slim"></div>
                <div id="event_info" class="event_txt">
                <c:forEach items="${discountA}" var="current" varStatus="status">
                	<c:choose>
                		<c:when test="${fn:length(discountA) == status.count}">
                			${current.price_type_name}석 ${current.discount_rate}% 할인<br>
                		</c:when>
                		<c:otherwise>
                			${current.price_type_name}석 ${current.discount_rate}%,
                		</c:otherwise>
                	</c:choose>
                </c:forEach>
                <c:forEach items="${discountB}" var="current" varStatus="status">
                	<c:choose>
                		<c:when test="${fn:length(discountB) == status.count}">
                			${current.price_type_name}유형 ${current.discount_rate}% 할인
                		</c:when>
                		<c:otherwise>
                			${current.price_type_name}유형 ${current.discount_rate}%,
                		</c:otherwise>
                	</c:choose>
                </c:forEach>
                </div>
                <div id="make_reservation">&#128197;예매하기</div>
            </section>
            <section id="review">
                <div id="score">
                    <div id="comment_score_title">예매자 한줄평</div>
                    <div id="comment_wrap">
                        <div id="star_wrap1">
                            <div id="star_wrap2">
                                <img id="star_gray" src="img/spr_comment.png" alt="comment ratings">
                                <div id="star_red_wrap" style="width:calc(${detail.score}/5.0*100%)">
                                    <img id="star_red" src="img/spr_comment.png" alt="comment ratings">
                                </div>
                            </div>
                        </div>
                        <div id="score_flex">
                            <div>
                                <span id="score_bold">${detail.score}</span><span id="score_gray">/ 5.0</span>
                            </div>
                            <div>
                                <span id="count_green">${detail.count}</span><span id="count_gray">건 등록</span>
                            </div>
                        </div>
                    </div>
                    <div class="division_medium"></div>
                    <c:forEach items="${commentList}" var="item">
                        <div class="one_comment">
                            <div>
                                <div class="comment_title">${item.description}</div>
                                <div class="comment_quote">${item.comment}</div>
                                <span class="comment_user_score">${item.score}</span>
                                <span class="comment_user_id">| ${item.reservation_email}</span>
                                <span class="comment_user_time">| ${item.modify_date}</span>
                            </div>
                            <div>
                            	<c:if test="${not empty item.save_file_name}">
                                	<img src="${item.save_file_name}" alt="comment image ${item.reservation_email}">
                                </c:if>
                            </div>
                        </div>
                        <div class="division_slim"></div>
                    </c:forEach>
                    <div id="comment_notice">&#x1F514; 네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</div>
                </div>
                <button id="more_reviews">예매자 한줄평 더보기 &#x2192;</button>
            </section>
            <section id="more_info">
                <div id="more_info_tab" class="container">
                    <div id="more_info_tab_1" class="flex_item">상세정보</div>
                    <div id="more_info_tab_2" class="flex_item">오시는길</div>
                </div>
                <div id="more_info_tab_details">
                    <div id="introduction">
                        [소개]
                    </div>
                    <div>
                        ${detail.content}
                    </div>
                    <div id="notice">
                        [공지사항]
                    </div>
                    <img id="img_notice" src="${detail.save_file_name}" alt="notice image ${detail.id}">
                </div>
                <div id="more_info_tab_route">
                    <img id="route_map" src="${route.save_file_name}" alt="${route.place_name} map">
                    <div id="route_title">${detail.description}</div>
                    <div id="route_street">&#x1F4CD; ${route.place_street}</div>
                    <div id="route_lot"><span id="route_lot_span">지번 </span>${route.place_lot}</div>
                    <div id="route_place_name">${route.place_name}</div>
                    <div id="route_tel">&#x1F4DE; ${route.tel}</div>
                </div>
            </section>
            <div>
                <button id="top">&#8593; TOP</button>
            </div>     
            <footer>
                네이버(주)는 통신판매의 당사자가 아니며, 상품의 정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.
                <br><br>
                @ NAVER Corp.
            </footer>
        </div>
    </body>
</html>