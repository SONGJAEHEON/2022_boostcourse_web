<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>${detail.id}</title>
    <link rel="shortcut icon" href="../img/favicon.ico">
    <link rel="stylesheet" href="../src/detailComment.css" type="text/css">
    <link rel="stylesheet" href="../src/comment.css" type="text/css">
    <script src="../src/detailComment.js"></script>
</head>
<body id="${detail.id}"}>
    <div id="whole_wrap">
        <nav>
            <span id="back">&#8592;</span>
            <span id="name">${detail.description}</span>
        </nav>
        <section id="review">
            <div id="score">
                <div id="comment_score_title">예매자 한줄평</div>
                <div id="comment_wrap">
                    <div id="star_wrap1">
                        <div id="star_wrap2">
                            <img id="star_gray" src="../img/spr_comment.png" alt="comment ratings">
                            <div id="star_red_wrap" style="width:calc(${detail.score}/5.0*100%)">
                                <img id="star_red" src="../img/spr_comment.png" alt="comment ratings">
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
                <div id="comment_notice">&#x1F514; 네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</div>
            </div>
        </section>
    </div>

    <script id="comment-template" type="text/x-handlebars-template">
        <div class="one_comment">
            <div>
                <div class="comment_title">{{description}}</div>
                <div class="comment_quote">{{comment}}</div>
                <span class="comment_user_score">{{score}}</span>
                <span class="comment_user_id">| {{reservation_email}}</span>
                <span class="comment_user_time">| {{modify_date}}</span>
            </div>
            <div>
                {{#if save_file_name}}
                <img src="../{{save_file_name}}" alt="comment image {{item.reservation_email}}">
				{{/if}}
            </div>
        </div>
        <div class="division_slim"></div>
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" integrity="sha512-RNLkV3d+aLtfcpEyFG8jRbnWHxUqVZozacROI4J2F1sTaDqo1dPQYs01OMi1t1w9Y2FdbSCDSQ2ZVdAC8bzgAg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script>
        var template = document.querySelector("#comment-template").innerText;
        var bindTemplate = Handlebars.compile(template);
        //var resultHtml = "";
        //var obj = "${commentList}";
        // <c:forEach items="${commentList}" var="item">
        // 	console.log(item);
		// 	resultHtml += bindTemplate(item);
        // </c:forEach>

        //var obj2 = "${detail.description}";
        //obj.forEach(function(item, index){
        //resultHtml += bindTemplate(item);
        //})
        //var div = document.createElement("div");
        //div.innerHTML = resultHtml;
        //var node = document.querySelector("#comment_notice");
        //node.parentNode.insertBefore(div, node);
        //document.querySelector("#comment_notice").insertBefore(resultHtml);
    </script>
</body>
</html>