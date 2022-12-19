window.addEventListener("DOMContentLoaded", () => {

    const galleryForm = document.getElementById("gallery-edit-form");
    const gallerySubmitButton = document.getElementById("gallery-button");

    gallerySubmitButton.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.disabled = true;
        const formData = new FormData(galleryForm);

        const galleryId = formData.get("galleryId");

        if (galleryId) {
            $.ajax({
                type: "put",
                url : "/api/galleries/" + galleryId,
                data : formData,
                processData: false,
                contentType: false,
                success : (data) => {
                    console.log(data);
                    location.href = "/galleries/" + galleryId;
                },
                error : (error) => {
                    const data = JSON.parse(error.responseText)
                    alert(data.errorMessage);
                },
                complete : () => {
                    e.target.disabled = false;
                }
            })
        } else {
            $.ajax({
                type: "post",
                url : "/api/galleries",
                data : formData,
                processData: false,
                contentType: false,
                dataType : "json",
                success : (res) => {
                    console.log(res);
                    location.href = "/galleries/" + res.data;
                },
                error : (error, textStatus , a) => {
                    const data = JSON.parse(error.responseText)
                    alert(data.errorMessage);
                },
                complete : () => {
                    e.target.disabled = false;
                }
            })
        }

    })

    $('#year').datepicker({
        format: "yyyy",
        viewMode: "years",
        minViewMode: "years",
        autoclose:true //to close picker once year is selected
    })
});