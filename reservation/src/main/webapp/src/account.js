window.addEventListener('DOMContentLoaded', () => {
	emailBoxClick();
    webpageLoad();
})

function emailBoxClick(){
	document.getElementById("email_form").addEventListener('click', ()=>{
		if(event.target.value === "예약자 이메일 입력"){
			event.target.value = "";
		}
	})
}

function webpageLoad(){
    document.getElementById("check").addEventListener('click', ()=>{
        window.location.href = "http://localhost:8080/reservation/myPage"
    })
    // document.getElementById("red_white").addEventListener('click', ()=>{
    //     window.location.href = "logOut"
    // })
}