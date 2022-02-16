window.addEventListener('DOMContentLoaded', () => {
    document.getElementById("back").addEventListener('click', ()=>{
        window.history.back();
    })

    commentLoad();
})

function commentLoad(){
    var httpRequest;
    var id = document.getElementById("whole_wrap").parentElement.id;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState === XMLHttpRequest.DONE){
            if(httpRequest.readyState == 4 && httpRequest.status === 200){
                var obj = httpRequest.response;
                var div = document.createElement("div");
				var innerHtml = "";
				//innerHtml += bindTemplate(obj);
				//console.log(innerHtml);
                //div.innerHTML = innerHtml;
                obj.forEach(function(item, index){
                    innerHtml += bindTemplate(item);
                })
				div.innerHTML = innerHtml;
				var node = document.querySelector("#comment_notice");
        		node.parentNode.insertBefore(div, node);
            }
        }
    }
    httpRequest.open('GET', 'http://localhost:8080/reservation/product/commentList?id='+id);
    httpRequest.responseType = 'json';
    httpRequest.send();
}