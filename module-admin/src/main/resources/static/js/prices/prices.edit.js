document.addEventListener("DOMContentLoaded", () => {

    const deletePriceBtn = document.getElementById("delete-price-btn");
    const priceIdEl = document.querySelector("[name=priceId]");

    deletePriceBtn.addEventListener("click", () => {
        deletePriceBtn.disabled = true;


        if (confirm("정말로 삭제하시겠습니까?")) {
            $.ajax({
                type: "delete",
                url : "/api/prices/" + priceIdEl.value,
                success : (data) => {
                    location.href = "/prices";
                },
                error : (error) => {
                    const data = JSON.parse(error.responseText)
                    alert(data.errorMessage);
                },
                complete : () => {
                    priceIdEl.disabled = false;
                    location.href = "/prices";
                }
            })
        }



    })
});