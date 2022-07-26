window.addEventListener('DOMContentLoaded', () => {
	goBack();
    commentLoad();
})

function goBack(){
	document.getElementById("back").addEventListener('click', ()=>{
        window.history.back();
    })
}

let httpRequest, id, obj, div, innerHtml = "";
function commentLoad(){
    // var httpRequest;
    id = document.getElementById("whole_wrap").parentElement.id;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState === XMLHttpRequest.DONE){	// === 4
            if(httpRequest.status === 200){
                obj = httpRequest.response;
                div = document.createElement("div");
                obj.forEach(function(item){
                    innerHtml += bindTemplate(item);
                })
				div.innerHTML = innerHtml;
				document.querySelector("#comment_notice").before(div);
            }
        }
    }
    httpRequest.open('GET', 'http://localhost:8080/reservation/product/commentList?id='+id);
    httpRequest.responseType = 'json';
    httpRequest.send();
}