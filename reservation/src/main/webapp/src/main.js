window.addEventListener('DOMContentLoaded', () => {
    document.getElementById("i0").style.borderColor = "#2db40d";

	// Move to the login page.
    document.getElementById("email").addEventListener('click', ()=>{
        window.location.href = "account";
    })

	// Hide the button to load more content if all the contents are loaded.
	let cnt, total;
    cnt = document.querySelector("#more").className;
    total = document.querySelector("#total").innerText;
    if(cnt == total){
        document.querySelector("#more").style.display = "none";
    }

    // 'document.documentElement.scrollTop = 0' is possible too.
    document.querySelector("#top").addEventListener('click', () => window.scrollTo(0,0));

	// Promotion image carousel.
    let promoList = Array.from(document.querySelectorAll(".promoImg"));
    let len = promoList.length;
    let std = 0;
    let prev = len-1;
    let nxt = 1;
    let newNxt = 2;
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
	// Event delegation.
	let httpRequest, cat, pId, reqJson;
	let box1, box2, obj, list, i, html, clone, fragment;
    document.querySelector("#cat").addEventListener("click", (evt) => {
        // var httpRequest;
		// Substring the number from the id. (ex. i1, i2, ... -> 1, 2, ...)
        cat = evt.target.id.substring(1,2);
        pId = 0;
        reqJson = new Object();
        reqJson.cat = cat;
        reqJson.pId = pId;
        httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () => {
            if(httpRequest.readyState === XMLHttpRequest.DONE){	// XMLHttpRequest.DONE = 4
                if(httpRequest.status === 200){
                    box1 = document.getElementById("product_list1");
                    while(box1.firstElementChild){
                        box1.removeChild(box1.firstElementChild);
                    }
                    box2 = document.getElementById("product_list2");
                    while(box2.firstElementChild){
                        box2.removeChild(box2.firstElementChild);
                    }
                    
                    // var obj = JSON.parse(httpRequest.responseText);
					// RestController returns in the json form.
                    obj = httpRequest.response;
                    list = obj.list;
                    i = 0;
                    html = document.querySelector("#productTemplate");
                    for(i; i < list.length; i++){
						// The argument inside the parenthesis is optional. Copying children(true) is the default value.
                        clone = html.cloneNode(true);
						// String is the immutable type.
                        clone.innerHTML = clone.innerHTML.replace("{{id}}", list[i].id)
                                                        .replace("{{src}}", list[i].save_file_name)
                                                        .replace("{{alt}}", list[i].id)
                                                        .replace("{{title}}", list[i].description)
                                                        .replace("{{place}}", list[i].place_name)
                                                        .replace("{{content}}", list[i].content);
						// Select left or right.
                        if(i % 2 == 0)
                            box1.appendChild(clone.content);
                        else
                            box2.appendChild(clone.content);
                    }
                    (Array.from(document.querySelectorAll(".cat"))).forEach((box)=>{
						if(box.style.borderColor !== "white"){
							box.style.borderColor = "white";
						}
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

	let ajx2HttpRequest, ajx2ReqJson, ajx2Obj, ajx2Cnt;
    function ajax2(cat){
        // var httpRequest;
        ajx2ReqJson = new Object();
        ajx2ReqJson.cat = cat;
        ajx2HttpRequest = new XMLHttpRequest();
        ajx2HttpRequest.onreadystatechange = () => {
            if(ajx2HttpRequest.readyState === XMLHttpRequest.DONE){	// Same with '=== 4'.
                if(ajx2HttpRequest.status === 200){
                    // var obj = JSON.parse(httpRequest.responseText);
                    ajx2Obj = ajx2HttpRequest.response;
                    ajx2Cnt = ajx2Obj.cnt;
                    document.querySelector("#total").innerText = ajx2Cnt;

                    // if(document.querySelector("#total").textContent == document.querySelector("#more").className)
                    if(document.querySelector("#total").innerText == document.querySelector("#more").className)
                        document.querySelector("#more").display = "none";
                }
            }
    }
    ajx2HttpRequest.open('POST', 'http://localhost:8080/reservation/main/cat_cnt', true);
    ajx2HttpRequest.responseType = "json";
    ajx2HttpRequest.setRequestHeader('Content-Type', 'application/json');
    ajx2HttpRequest.send(JSON.stringify(ajx2ReqJson));
    }

    document.getElementById("product_list").addEventListener('click', (evt)=>{
		// Unchangable const value is ok.
        const product = evt.target.closest('.product');
        if(product){
            window.location.href = 'http://localhost:8080/reservation/product?id='+product.id;
        }
    })

	// let httpRequest, reqJson, box1, box2, obj, list, i, html, clone, fragment;
	let intCnt;
    document.getElementById("more").addEventListener('click', ()=>{
        // var httpRequest;
        reqJson = new Object();
        reqJson.cat = document.querySelector(".clear").id.substring(1,2);
        cnt = document.querySelector("#more").className; // let cnt is declared in the line 10.
        reqJson.pId = cnt;      // count value is inserted to pId to reuse the DTO named Id.
        httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () => {
            if(httpRequest.readyState === XMLHttpRequest.DONE){
                if(httpRequest.readyState == 4 && httpRequest.status === 200){
                    box1 = document.getElementById("product_list1");
                    box2 = document.getElementById("product_list2");
                    
                    // var obj = JSON.parse(httpRequest.responseText);
                    obj = httpRequest.response;
                    list = obj.list;
                    i = 0;
					html = document.querySelector("#productTemplate");
                    for(i; i < list.length; i++){
						// The argument inside the parenthesis is optional. Copying children(true) is the default value.
                        clone = html.cloneNode(true);
						// String is the immutable type.
                        clone.innerHTML = clone.innerHTML.replace("{{id}}", list[i].id)
                                                        .replace("{{src}}", list[i].save_file_name)
                                                        .replace("{{alt}}", list[i].id)
                                                        .replace("{{title}}", list[i].description)
                                                        .replace("{{place}}", list[i].place_name)
                                                        .replace("{{content}}", list[i].content);
						// Select left or right.
                        if(i % 2 == 0)
                            box1.appendChild(clone.content);
                        else
                            box2.appendChild(clone.content);
                    }
                    intCnt = parseInt(cnt) + i;
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