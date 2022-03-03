window.addEventListener('DOMContentLoaded', () => {
    webpageLoad();
})

function webpageLoad(){
    document.getElementById("check").addEventListener('click', ()=>{
        window.location.href = "http://localhost:8080/reservation/myPage"
    })
    // document.getElementById("red_white").addEventListener('click', ()=>{
    //     window.location.href = "logOut"
    // })
}