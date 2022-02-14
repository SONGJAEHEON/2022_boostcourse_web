window.addEventListener('DOMContentLoaded', () => {
    etcImageLoader();
    expandDescription();
    moreInfoControl();
    moveTop();
})

function etcImageLoader(){
    var httpRequest;
    var id = document.getElementById("carousel_1").parentElement.id;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState === XMLHttpRequest.DONE){
            if(httpRequest.readyState == 4 && httpRequest.status === 200){
                var obj = httpRequest.response;
				console.log(obj);
                //if(obj.img.length){
                    document.getElementById("order").style.display = "block";
                    document.querySelectorAll(".move").forEach((item)=>{
                        item.style.display = "block";
                    })
                    document.getElementById("carousel_2").src = obj.img.save_file_name; 
                    document.getElementById("carousel_4").src = obj.img.save_file_name; 
                    // document.getElementById("carousel_2").style.display = "block";
                    // document.getElementById("carousel_4").style.display = "block";
                    runCarousel();
                //}
            }
        }
    }
    httpRequest.open('GET', 'http://localhost:8080/reservation/product/etcImage?id='+id);
    httpRequest.responseType = 'json';
    httpRequest.send();
}

function runCarousel(){
    var std = 0, next = 1, prev = 3, other = 2;
    const array = Array.from(document.querySelectorAll(".carousel"));
    document.getElementById("move_left").addEventListener('click', ()=>{
        var order = document.getElementById("order");

        array[std].className = "carousel img_right";
        array[next].className = "carousel";
        array[prev].className = "carousel img_mid";
        array[other].className = "carousel img_left";
        std = minusOne(std);
        next = minusOne(next);
        prev = minusOne(prev);
        other = minusOne(other);

        setTimeout(() => {
            if(order.value == 1){
                order.value = 2;
                order.innerText = "2/2";
            }
            else{
                order.value = 1;
                order.innerText = "1/2";
            }
        }, 1000);
    })
    document.getElementById("move_right").addEventListener('click', ()=>{
        var order = document.getElementById("order");

        array[std].className = "carousel img_left";
        array[next].className = "carousel img_mid";
        array[prev].className = "carousel";
        array[other].className = "carousel img_right";
        std = plusOne(std);
        next = plusOne(next);
        prev = plusOne(prev);
        other = plusOne(other);

        setTimeout(() => {
            if(order.value == 1){
                order.value = 2;
                order.innerText = "2/2";
            }
            else{
                order.value = 1;
                order.innerText = "1/2";
            }
        }, 1000);
    })
}

function minusOne(arg){
    if(arg == 0)
        return 3;
    return --arg;
}

function plusOne(arg){
    return ++arg%4;
}

function expandDescription(){
    document.getElementById("expansion").addEventListener('click', ()=>{
        var style = document.getElementById("description").style;
        style.overflow = "visible";
        style.height = "auto";
    })
}

function moreInfoControl(){       // Whether to show or not 'more_info_tab'
    document.getElementById("more_info_tab_1").addEventListener('click', ()=>{
        document.getElementById("more_info_tab_details").style.display = "block";
        document.getElementById("more_info_tab_route").style.display = "none";
        document.getElementById("more_info_tab_1").style.borderColor = "#2dc40d";
        document.getElementById("more_info_tab_2").style.borderColor = "white";
        
    })
    document.getElementById("more_info_tab_2").addEventListener('click', ()=>{
        document.getElementById("more_info_tab_details").style.display = "none";
        document.getElementById("more_info_tab_route").style.display = "block";
        document.getElementById("more_info_tab_1").style.borderColor = "white";
        document.getElementById("more_info_tab_2").style.borderColor = "#2dc40d";
    })
}

function moveTop(){
    document.querySelector("#top").addEventListener('click', () => window.scrollTo(0,0));
}