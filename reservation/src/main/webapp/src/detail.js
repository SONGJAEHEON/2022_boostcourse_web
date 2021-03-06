window.addEventListener('DOMContentLoaded', () => { 
    etcImageLoader();
    goHome();
    expandDescription();
	makeReservation();
	moreReviews();
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
                if(obj.img.length){
                    document.getElementById("orderFlex").style.display = "flex";
					// document.getElementById("titleFlex").style.justifyContent = "space-between";
                    document.querySelectorAll(".move").forEach((item)=>{
                        item.style.display = "block";
                    })
					document.getElementById("title").style.width = "500px";
                    document.getElementById("carousel_2").src = obj.img[0].save_file_name; 
                    document.getElementById("carousel_4").src = obj.img[0].save_file_name; 
                    // document.getElementById("carousel_2").style.display = "block";
                    // document.getElementById("carousel_4").style.display = "block";
                    runCarousel();
                }
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
        array[next].className = "carousel img_other";
        array[prev].className = "carousel img_mid";
        array[other].className = "carousel img_left";
        std = minusOne(std);
        next = minusOne(next);
        prev = minusOne(prev);
        other = minusOne(other);

        setTimeout(() => {
            if(order.className == "1"){
                order.className = "2";
                order.innerText = "2/2";
            }
            else{
                order.className = "1";
                order.innerText = "1/2";
            }
        }, 1000);
    })
    document.getElementById("move_right").addEventListener('click', ()=>{
        var order = document.getElementById("order");

        array[std].className = "carousel img_left";
        array[next].className = "carousel img_mid";
        array[prev].className = "carousel img_other";
        array[other].className = "carousel img_right";
        std = plusOne(std);
        next = plusOne(next);
        prev = plusOne(prev);
        other = plusOne(other);

        setTimeout(() => {
            if(order.className == "1"){
                order.className = "2";
                order.innerText = "2/2";
            }
            else{
                order.className = "1";
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

function goHome(){
    document.getElementById("home").addEventListener('click', ()=>{
        window.location.href = "http://localhost:8080/reservation/main";
    })
    document.getElementById("home_icon").addEventListener('click', ()=>{
        window.location.href = "http://localhost:8080/reservation/main";
    })
}

function expandDescription(){
    document.getElementById("expansion").addEventListener('click', ()=>{
        let descStyle = window.getComputedStyle(document.getElementById("description"));
		let realStyle = document.getElementById("description").style;
		if(descStyle.overflow === "hidden"){
			realStyle.overflow = "visible";
			realStyle.height = "auto";	
		}else{
			realStyle.overflow = "hidden";
			realStyle.height = "5em"	
		}
    })
}

function makeReservation(){
    document.getElementById("make_reservation").addEventListener('click', ()=>{
        var id = document.getElementById("carousel_1").parentElement.id;
        window.location.href = "http://localhost:8080/reservation/makingReservation?id=" + id;
    })
}

function moreReviews(){
    document.getElementById("more_reviews").addEventListener('click', ()=>{
        window.location.href = "http://localhost:8080/reservation/product/commentInfo?id="+document.getElementById("carousel_1").parentElement.id;
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