<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>${reservation.id} 예약하기</title>
    <link rel="shortcut icon" href="img/favicon.ico">
    <link rel="stylesheet" href="src/makeReservation.css" type="text/css">
    <script src="src/makeReservation.js"></script>
</head>
<body id="${reservation.id}"}>
    <div>
        <nav>
            <span id="back">&#8592;</span>
            <span id="name">${reservation.description}</span>
        </nav>
        <section id="image">
            <img src="${reservation.save_file_name}" alt="${reservation.save_file_name} image">
            <div id="title">${reservation.description}</div>
        </section>
        <section id="user_info_form">
            <div id="user_info_form_flex">
                <div>예매자 정보</div>
                <div class="small_gray">&#9989;필수입력</div>
            </div>
            <form id="reservation_form" action="/makeReservation" method="POST">
                <div class="form_line_flex">
                    <label for="name">&#9989;예매자</label>
                    <input type="text" name="name" id="form_name" value="네이버" required>
                </div>
                <div class="form_line_flex">
                    <label for="tel">&#9989;연락처</label>
                    <input type="tel" name="tel" id="form_tel" value="휴대폰 입력 시 예매내용 문자발송"  pattern="01[0-9]-[0-9]{4}-[0-9]{4}" required>
                </div>
                <div class="form_line_flex">
                    <label for="email">&#9989;이메일</label>
                    <input type="email" name="email" id="form_email" value="crong@codesquad.kr" required>
                </div>
            </form>
        </section>
        <section id="user_terms">
            <div>
                <span>예매내용</span>
                <div>
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
                개인정보 수집 및 이용 동의
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Accusantium possimus libero optio consequatur quae! Eligendi, incidunt placeat neque in voluptates minima laudantium doloremque totam eius inventore, est aperiam dignissimos voluptatum.
            </div>
            <div>
                <div>&#9151; 개인정보 제3자 제공 동의</div>
                <div>펴기&#709;</div>
            </div>
            <div>
                개인정보 제3자 제공 동의
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