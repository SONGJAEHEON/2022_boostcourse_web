window.addEventListener('DOMContentLoaded', () => {

})

function ticketMinus() {
    Array.from(document.querySelectorAll(".minus")).forEach((item) => {
        item.addEventListener('click', (evt)=>{
            var block = evt.currentTarget.previousElementSibling;
            var text = parseInt(block.textContent);
            if(text == 0){
                return;
            }
            if(text == 1){
                block.style.borderColor = "gray";
                block.style.color = "gray";
                block.previousElementSibling.style.borderColor = "gray";
                block.previousElementSibling.style.color = "gray";
            }
            block.textContent = ++text;
            var sum = parseInt(document.querySelector("#price_sum > span").textContent);
            var price = parseInt(block.parentElement.parentElement.parentElement.parentElement.previousElementSibling.textContent);
            document.querySelector("#price_sum > span").textContent = sum + price;
        })
    })
}

function ticketPlus() {
    Array.from(document.querySelectorAll(".plus")).forEach((item) => {
        item.addEventListener('click', (evt)=>{
            var block = evt.currentTarget.previousElementSibling;
            var text = parseInt(block.textContent);
            if(text == 0){
                block.style.borderColor = "#2db40d";
                block.style.color = "#2db40d";
                block.previousElementSibling.style.borderColor = "#2db40d";
                block.previousElementSibling.style.color = "#2db40d";
            }
            block.textContent = ++text;
            var sum = parseInt(document.querySelector("#price_sum > span").textContent);
            var price = parseInt(block.parentElement.parentElement.parentElement.parentElement.previousElementSibling.textContent);
            document.querySelector("#price_sum > span").textContent = sum + price;
        })
    })
}