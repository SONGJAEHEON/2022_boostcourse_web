<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>상품 ${requestScope.id} 예약하기</title>
    <link rel="shortcut icon" href="img/favicon.ico">
    <link rel="stylesheet" href="src/makeReservation.css" type="text/css">
    <script src="src/makeReservation.js"></script>
</head>
<body id="${requestScope.id}"}>
    <div>
        <nav>
            <div id="back">&#8592;</div>
            <div id="name">${reservation.description}</div>
        </nav>
        <section id="image">
            <div id="gray_back"></div>
            <img src="${reservation.fileName}" alt="${reservation.fileName} image">
            <div id="title">${reservation.description}</div>
            <div id="krw">&#x20A9;${reservation.lowPrice}~</div>
            <div id="time_left">${reservation.openingHour1}, 잔여티켓 ${reservation.reservationCnt}매</div>
        </section>
        <section id="detail">
            <div class="bold">
                ${reservation.description}
            </div>
            <div class="normal">
                장소 : ${reservation.placeStreet}(${reservation.placeLot})<br>
                기간 : ${reservation.openingHour1}
            </div>
            <div class="bold">
                관람시간
            </div>
            <div class="normal">
                ${reservation.openingHour2}
            </div>
            <div class="bold">
                요금
            </div>
            <div class="normal">
                <c:forEach items="${list}" var="item" varStatus="status">
                    <c:choose>
                        <c:when test="${status.last}">
                            ${item.type}유형 ${item.discount_rate}%할인 ${item.price}원
                        </c:when>
                        <c:otherwise>
                            ${item.type}유형 ${item.discount_rate}%할인 ${item.price}원 /
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </section>
        <section>
            <c:forEach items="${list}" var="item">
                <div class="hidden">
                    ${item.price}
                </div>
                <div id="row_flex">
                    <div id="col_flex">
                        <div class="price_type">
                            ${item.type} 유형
                        </div>
                        <div class="price_price">
                            ${item.price} 원
                        </div>
                        <div class="price_discount">
                            ${item.price}원 (${item.discount_rate}% 할인가)
                        </div>
                    </div>
                    <div id="col_flex2">
                        <table>
                            <tr>
                                <td class="minus">-</td>
                                <td class="cnt">0</td>
                                <td class="plus">+</td>
                            </tr>
                        </table>
                        <div class="price_sum">
                            <span>0</span>원
                        </div>
                    </div>
                </div>
            </c:forEach>
        </section>
        <section id="user_info_form">
            <div id="user_info_form_flex">
                <div class="info_bold">예매자 정보</div>
                <div class="info_small_gray">&#9989;필수입력</div>
            </div>
            <form id="reservation_form" action="/makeReservation" method="POST">
                <div class="form_line_flex">
                    <div class="green_check_wrap">
                        <img class="green_check" src="img/spr_book.png" alt="green check">
                    </div>
                    <label for="name">예매자</label>
                    <input type="text" name="name" id="form_name" value="네이버" required>
                </div>
                <div class="form_line_flex">
                    <div class="green_check_wrap">
                        <img class="green_check" src="img/spr_book.png" alt="green check">
                    </div>
                    <label for="tel">연락처</label>
                    <input type="tel" name="tel" id="form_tel" value="휴대폰 입력 시 예매내용 문자발송"  pattern="01[0-9]-[0-9]{4}-[0-9]{4}" required>
                </div>
                <div class="form_line_flex">
                    <div class="green_check_wrap">
                        <img class="green_check" src="img/spr_book.png" alt="green check">
                    </div>
                    <label for="email">이메일</label>
                    <input type="email" name="email" id="form_email" value="crong@codesquad.kr" required>
                </div>
                <div class="form_line_flex">
                    <div class="green_check_wrap">
                        <img class="blank_check" src="img/spr_book.png" alt="green check">
                    </div>
                    <label>예매내용</label>
                </div>
            </form>
        </section>
        <section id="user_terms">
            <div>
                <div class="term_title_flex">
                    <div class="Bgreen_check_wrap">
                        <img class="Bgreen_check" src="img/spr_book2.png" alt="term check">
                    </div>
                    <div id="terms_check">&#10003;</div>
                    <div>이용자 약관 전체동의</div>
                </div>
                <div class="small_gray">필수동의</div>
            </div>
            <div>
                <div>&#9151; 개인정보 수집 및 이용 동의</div>
                <div>접기&#708;</div>
            </div>
            <div>
                <개인정보 수집 및 이용 동의>
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Accusantium possimus libero optio consequatur quae! Eligendi, incidunt placeat neque in voluptates minima laudantium doloremque totam eius inventore, est aperiam dignissimos voluptatum.
            </div>
            <div>
                <div>&#9151; 개인정보 제3자 제공 동의</div>
                <div>펴기&#709;</div>
            </div>
            <div>
                <개인정보 제3자 제공 동의>
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Voluptas cumque eos placeat repudiandae, perspiciatis perferendis nisi, ad cupiditate mollitia numquam eligendi officia velit dolorem, quaerat laudantium praesentium minus ex eum?
            </div>
        </section>

    </div>

    <script id="ticket-template" type="text/x-handlebars-template">
        <div class="one_ticket_chunk">
            <div>
                <div>성인</div>
                <div>10,000원</div>
                <div>10,000원(15% 할인가)</div>
            </div>
            <div>
                <div>
                    <div class="minus">-</div>
                    <div class="number"></div>
                    <div class="plus">+</div>
                </div>
                <div>70,000원</div>
            </div>
        </div>
    </script>
</body>
</html>