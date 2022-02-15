window.addEventListener('DOMContentLoaded', () => {
    document.getElementById("back").addEventListener('click', ()=>{
        window.history.back();
    })

    commentLoad();
})

function commentLoad(){
    var httpRequest;
    var id = document.getElementById("title").innerText;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState === XMLHttpRequest.DONE){
            if(httpRequest.readyState == 4 && httpRequest.status === 200){
                var obj = httpRequest.response;

                
            }
        }
    }
    httpRequest.open('GET', 'http://localhost:8080/reservation/product/commentList?id='+id);
    httpRequest.responseType = 'json';
    httpRequest.send();
}