window.addEventListener('DOMContentLoaded', () => {
    document.getElementById("i0").style.borderColor = "#2db40d";

    var cnt = document.querySelector("#more").className;
    var total = document.querySelector("#total").innerText;
    if(cnt == total){
        document.querySelector("#more").style.display = "none";
    }

    document.querySelector("#top").addEventListener('click', () => window.scrollTo(0,0));
    // 'document.documentElement.scrollTop = 0' 도 가능

    var promoList = Array.from(document.querySelectorAll(".promoImg"));
    var len = promoList.length;
    var std = 0;
    var prev = len-1;
    var nxt = 1;
    var newNxt = 2;
    promoList[std].classList.add("std");
    promoList[prev].classList.add("prev");
    promoList[nxt].classList.add("nxt");
    promoList[newNxt].classList.add("newNxt");
    // document.querySelector("#promo_list").firstElementChild.classList.add("std");
    // document.querySelector("#promo_list").firstElementChild.nextElementSibling.classList.add("nxt");

    setInterval(runCarousel, 4000);
    
    function runCarousel(){
        promoList[std].className = "promoImg prev";
        promoList[prev].className = "promoImg";
        promoList[nxt].className = "promoImg std";
        promoList[newNxt].className = "promoImg nxt";
        std = ++std%len;
        prev = ++prev%len;
        nxt = ++nxt%len;
        newNxt = ++newNxt%len;
    }

    // let targetList = document.querySelector("#cat");
    // Array.from(targetList).forEach((target)=>{
    document.querySelector("#cat").addEventListener("click", (evt) => {
        // console.log(evt.target);
        var httpRequest;
        var cat = evt.target.id.substring(1,2);
        var pId = 0;
        var reqJson = new Object();
        reqJson.cat = cat;
        reqJson.pId = pId;
        httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () => {
            if(httpRequest.readyState === XMLHttpRequest.DONE){
                if(httpRequest.readyState == 4 && httpRequest.status === 200){
                    var box1 = document.getElementById("product_list1");
                    while(box1.firstElementChild){
                        box1.removeChild(box1.firstElementChild);
                    }
                    var box2 = document.getElementById("product_list2");
                    while(box2.firstElementChild){
                        box2.removeChild(box2.firstElementChild);
                    }
                    
                    // var obj = JSON.parse(httpRequest.responseText);
                    var obj = httpRequest.response;
                    var list = obj.list;
                    var i = 0;
                    var html = document.querySelector("#productTemplate");
                    for(i; i < list.length; i++){
                        var clone = html.cloneNode(true);
                        clone.innerHTML = clone.innerHTML.replace("{{id}}", list[i].id)
                                                        .replace("{{src}}", list[i].save_file_name)
                                                        .replace("{{alt}}", list[i].id)
                                                        .replace("{{title}}", list[i].description)
                                                        .replace("{{place}}", list[i].place_name)
                                                        .replace("{{content}}", list[i].content);
                        var fragment = document.importNode(clone.content, true);
                        if(i % 2 == 0)
                            box1.appendChild(fragment);
                        else
                            box2.appendChild(fragment);
                    }
                    (Array.from(document.querySelectorAll(".cat"))).forEach((box)=>{
                        box.style.borderColor = "white";
                    })
                    document.getElementById(evt.target.id).style.borderColor = "#2db40d";
                    document.querySelector("#more").className = i;
                    document.querySelector(".clear").id = "c"+cat;
                    document.querySelector("#more").style.display = "block";
                    ajax2(cat);
                    // if(document.querySelector("#total").textContent == document.querySelector("#more").className)
                    //     document.querySelector("#more").display = "none";
                }
            }
    }
    httpRequest.open('POST', 'http://localhost:8080/reservation/main/cat', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(reqJson));  
    })
    // })

    function ajax2(cat){
        var httpRequest;
        var reqJson = new Object();
        reqJson.cat = cat;
        httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () => {
            if(httpRequest.readyState === XMLHttpRequest.DONE){
                if(httpRequest.readyState == 4 && httpRequest.status === 200){
                    // var obj = JSON.parse(httpRequest.responseText);
                    var obj = httpRequest.response;
                    var cnt = obj.cnt;
                    document.querySelector("#total").innerText = cnt;

                    // if(document.querySelector("#total").textContent == document.querySelector("#more").className)
                    if(document.querySelector("#total").innerText == document.querySelector("#more").className)
                        document.querySelector("#more").display = "none";
                }
            }
    }
    httpRequest.open('POST', 'http://localhost:8080/reservation/main/cat_cnt', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(reqJson));
    }

    document.getElementById("product_list").addEventListener('click', (evt)=>{
        const product = evt.target.closest('.product');
        if(product){
            document.location.href = 'http://localhost:8080/reservation/product?id='+product.id;
        }
    })

    document.getElementById("more").addEventListener('click', ()=>{
        var httpRequest;
        var reqJson = new Object();
        reqJson.cat = document.querySelector(".clear").id.substring(1,2);
        var cnt = document.querySelector("#more").className;
        reqJson.pId = cnt;      // count value is inserted to pId to reuse the DTO named Id.
        httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () => {
            if(httpRequest.readyState === XMLHttpRequest.DONE){
                if(httpRequest.readyState == 4 && httpRequest.status === 200){
                    var box1 = document.getElementById("product_list1");
                    var box2 = document.getElementById("product_list2");
                    
                    // var obj = JSON.parse(httpRequest.responseText);
                    var obj = httpRequest.response;
                    var list = obj.list;
                    var i = 0;
                    var html = document.querySelector("#productTemplate");
                    for(i; i < list.length; i++){
                        var clone = html.cloneNode(true);
                        clone.innerHTML = clone.innerHTML.replace("{{id}}", list[i].id)
                                                        .replace("{{src}}", list[i].save_file_name)
                                                        .replace("{{alt}}", list[i].id)
                                                        .replace("{{title}}", list[i].description)
                                                        .replace("{{place}}", list[i].place_name)
                                                        .replace("{{content}}", list[i].content);
                        var fragment = document.importNode(clone.content, true);
                        if(i % 2 == 0)
                            box1.appendChild(fragment);
                        else
                            box2.appendChild(fragment);
                    }
                    var intCnt = parseInt(cnt) + i;
                    document.querySelector("#more").className = intCnt;
                    if(document.querySelector("#total").innerText == document.querySelector("#more").className)
                        document.querySelector("#more").style.display = "none";
                }
            }
        }
        httpRequest.open('POST', 'http://localhost:8080/reservation/main/cat_more', true);
        httpRequest.responseType = "json";
        httpRequest.setRequestHeader('Content-Type', 'application/json');
        httpRequest.send(JSON.stringify(reqJson));
    })
})