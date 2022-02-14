window.addEventListener('DOMContentLoaded', () => {
    etcImageLoader();
    expandDescription();
    moreInfoControl();
    moveTop();
})

function etcImageLoader(){
    var httpRequest;
    var id = document.getElementById("carousel_1").id;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState === XMLHttpRequest.DONE){
            if(httpRequest.readyState == 4 && httpRequest.status === 200){
                var obj = httpRequest.response;
                if(obj.list.length){
                    document.getElementById("carousel_2").src = obj.list[0].save_file_name; 
                    document.getElementById("carousel_4").src = obj.list[0].save_file_name; 
                    document.getElementById("carousel_2").style.display = "block";
                    document.getElementById("carousel_4").style.display = "block";
                }
            }
        }
    }
    httpRequest.open('GET', 'http://localhost:8080/reservation/detail/etcImage?id='+id);
    httpRequest.responseType = 'json';
    httpRequest.send();
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